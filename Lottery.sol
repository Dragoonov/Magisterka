// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.0;

import "@chainlink/contracts/src/v0.8/interfaces/AggregatorV3Interface.sol";
import "@chainlink/contracts/src/v0.8/VRFConsumerBase.sol";

//RULES
//Player can enter only once - he cannot add more to his bet
//Player must enter at least minimum entrance value
//Lottery is resolved once and then smart contract is unusable apart from withdrawing any remaining balance to owner
//

contract Lottery is VRFConsumerBase {
    AggregatorV3Interface internal priceFeed;
    mapping (address => bool) public wallets;
    address[] public addresses;
    mapping (address => bool) public winners;
    mapping (address => uint256) public winnersRewards;
    address[] public winnersList;
    mapping (address => Option) public pickedOptions;
    mapping (address => uint256) public contributions;
    address private owner;
    uint256 public totalContributions;
    bool public resolved;
    uint256 public minimumEntrance = 10000000000000000;

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

    modifier isResolved() {
        require(resolved == true, "This contract is not resolved yet!");
        _;
    }

    modifier minimumEther() {
        require(msg.value > minimumEntrance, "You have to enter minimum 0.01 Ether"); // 0.01 Ether
        _;
    }

    /**
     * Returns the latest price
     */
    function getLatestPrice() public view returns (int) {
        (,int price,,,) = priceFeed.latestRoundData();
        return price;
    }

    function isAddressParticipating(address _address) public view returns (bool) {
        return wallets[_address];
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

    function getOptions() public pure returns (Option[4] memory) {
        return [Option.One, Option.Two, Option.Three, Option.Four];
    }

    function getContributionForAddress(address _address) public view returns (uint256) {
        return contributions[_address];
    }

    function getRewardForAddress(address _address) public view returns (uint256) {
        return winnersRewards[_address];
    }

    function getPickedOptionForAddress(address _address) public view returns (string memory) {
        return getStringRepresentation(pickedOptions[_address]);
    }

    function didAddressWin(address _address) public view isResolved returns (bool) {
        return winners[_address];
    }

    function enter(Option _option) public payable minimumEther notResolved {
        if (wallets[msg.sender] == false) {
            addresses.push(msg.sender);
        }
        wallets[msg.sender] = true;
        pickedOptions[msg.sender] = _option;
        contributions[msg.sender] += msg.value;
        totalContributions += msg.value;
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
       // giveOutMoney();
    }

    function giveOutMoney() private notResolved {
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
                winnersRewards[winnersList[i]] = reward;
            }
        } else {
            for (uint256 i = 0; i < addresses.length; i++) {
                payable(addresses[i]).transfer(contributions[addresses[i]]);
            }
        }
        resolved = true;
    }

    function withdrawBalance() external onlyOwner isResolved {
        uint balance = LINK.balanceOf(address(this));
        LINK.transfer(owner, balance);
    }
}
