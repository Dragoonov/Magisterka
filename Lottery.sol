// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.0;

import "@chainlink/contracts/src/v0.8/interfaces/AggregatorV3Interface.sol";
import "@chainlink/contracts/src/v0.8/VRFConsumerBase.sol";

contract Lottery is VRFConsumerBase {
    AggregatorV3Interface internal priceFeed;
    mapping (address => bool) public wallets;
    address[] public addresses;
    mapping (address => bool) public winners;
    address[] public winnersList;
    mapping (address => Option) public pickedOptions;
    mapping (address => uint256) public contributions;
    address private owner;
    uint256 public totalContributions;
    bool public resolved;

    bytes32 internal keyHash;
    uint256 internal fee;
    Option public winOption;


    address aggregatorV3InterfaceRinkeby = 0x8A753747A1Fa494EC906cE90E9f37563A8AF630e;
    address VRFCoordinatorRinkeby = 0xb3dCcb4Cf7a26f6cf6B120Cf5A73875B7BBc655B;
    address linkTokenRinkeby = 0x01BE23585060835E02B77ef475b0Cc51aA1e0709;
    bytes32 keyHashRinkeby = 0x2ed0feb3e7fd2022120aa84fab1945545a9f2ffc9076fd6156fa96eaff4c1311;

    enum Option { One, Two, Three, Four }

    constructor() 
    VRFConsumerBase(
            VRFCoordinatorRinkeby, // VRF Coordinator
            linkTokenRinkeby  // LINK Token
        )
    {
        priceFeed = AggregatorV3Interface(aggregatorV3InterfaceRinkeby);
        owner = msg.sender;
        keyHash = keyHashRinkeby;
        fee = 0.1 * 10 ** 18; // 0.1 LINK (Varies by network)
    }

    modifier onlyOwner() {
        require(msg.sender == owner, "You're not the owner!");
        _;
    }

    modifier notResolved() {
        require(resolved == false, "This contract was already resolved!");
        _;
    }

    modifier minimumEther() {
        require(msg.value > 10000000000000000, "You have to enter minimum 0.01 Ether"); // 0.01 Ether
        _;
    }

    /**
     * Returns the latest price
     */
    function getLatestPrice() public view returns (int) {
        (,int price,,,) = priceFeed.latestRoundData();
        return price;
    }

    function getStringRepresentation(Option _option) public pure returns (string memory) {
        if (_option == Option.One) {
            return "One";
        } else if (_option == Option.Two) {
            return "Two";
        } else if (_option == Option.Three) {
            return "Three";
        } else {
            return "Four";
        }
    }

    function getContributionForAddress(address _address) public view returns (uint256) {
        return contributions[_address];
    }

    function getPickedOptionForAddress(address _address) public view returns (string memory) {
        return getStringRepresentation(pickedOptions[_address]);
    }

    function didAddressWin(address _address) public view returns (bool) {
        return winners[_address];
    }

    function enter(Option _option) public payable minimumEther {
        if (wallets[msg.sender] == false) {
            addresses.push(msg.sender);
        }
        wallets[msg.sender] = true;
        pickedOptions[msg.sender] = _option;
        contributions[msg.sender] += msg.value;
        totalContributions += msg.value;
    }

    function getWinningOption() public pure returns (Option) {
        return Option.One;
    }

    function resolve() public payable onlyOwner notResolved {
        getRandomNumber();
    }

    function getBalance() public view returns (uint256) {
        return address(this).balance;
    }

    /** 
     * Requests randomness 
     */
    function getRandomNumber() public returns (bytes32 requestId) {
        require(LINK.balanceOf(address(this)) >= fee, "Not enough LINK - fill contract with faucet");
        return requestRandomness(keyHash, fee);
    }

    /**
     * Callback function used by VRF Coordinator
     */
    function fulfillRandomness(bytes32 requestId, uint256 randomness) internal override {
        winOption = Option(randomness % 4);
        giveOutMoney();
    }

    function giveOutMoney() private {
        for (uint256 i = 0; i < addresses.length; i++) {
            address adr = addresses[i];
            if (pickedOptions[adr] == winOption) {
                winnersList.push(adr);
                winners[adr] = true;
            }
        }
        if (winnersList.length > 0) {
            uint256 reward = totalContributions / winnersList.length;
            for (uint256 i = 0; i < winnersList.length; i++) {
                payable(winnersList[i]).transfer(reward);
            }
        } else {
            for (uint256 i = 0; i < addresses.length; i++) {
                payable(addresses[i]).transfer(contributions[addresses[i]]);
            }
        }
        resolved = true;
    }

    function withdrawBalance() external onlyOwner {
        uint balance = LINK.balanceOf(address(this));
        LINK.transfer(owner, balance);
    }
}
