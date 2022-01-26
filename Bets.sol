// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.0;

import "@chainlink/contracts/src/v0.8/interfaces/AggregatorV3Interface.sol";
import "@chainlink/contracts/src/v0.8/VRFConsumerBase.sol";


contract Bets is VRFConsumerBase {
    AggregatorV3Interface internal priceFeed;

    address private owner;
    uint256 public minimumEntrance = 1000000000000000; // 0.001 Ether

    bytes32 internal keyHash;
    uint256 internal fee;
    address aggregatorV3InterfaceRinkeby = 0x8A753747A1Fa494EC906cE90E9f37563A8AF630e;
    address VRFCoordinatorRinkeby = 0xb3dCcb4Cf7a26f6cf6B120Cf5A73875B7BBc655B;
    address linkTokenRinkeby = 0x01BE23585060835E02B77ef475b0Cc51aA1e0709;
    bytes32 keyHashRinkeby = 0x2ed0feb3e7fd2022120aa84fab1945545a9f2ffc9076fd6156fa96eaff4c1311;
    address[] winnersList;


    string betToResolve;

    struct Bet {
        string name;
        string[] options;
        mapping (address => uint256) contributions;
        mapping (address => string) pickedOptions;
        address[] contributors;
        uint256 totalRewardPool;
        string winOption;
        bool resolved;
        uint256 reward;
    }
    Bet[] bets;
    string[] betNames;

    modifier onlyOwner() {
        require(msg.sender == owner, "You're not the owner!");
        _;
    }

    modifier minimumEther() {
        require(msg.value > minimumEntrance, "You have to enter minimum 0.001 Ether");
        _;
    }

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

    function addBet(string memory name, string[] memory options) public onlyOwner {
        uint256 idx = bets.length;
        bets.push();
        Bet storage bet = bets[idx];
        bet.name = name;
        bet.options = options;
        bet.resolved = false;
        bet.reward = 0;
        betNames.push(name);
    }

    function getBets() public view returns (string[] memory) {
        return betNames;
    }

    function getWinOption(string memory betName) public view returns (string memory) {
        for (uint256 i = 0; i < bets.length; i++) {
            if (keccak256(bytes(bets[i].name)) == keccak256(bytes(betName))) {
                return bets[i].winOption;
            }
        }
        return "";
    }

    function isResolved(string memory betName) public view returns (bool) {
        for (uint256 i = 0; i < bets.length; i++) {
            if (keccak256(bytes(bets[i].name)) == keccak256(bytes(betName))) {
                return bets[i].resolved;
            }
        }
        return false;
    }

    function getBetOptions(string memory betName) public view returns (string[] memory) {
        for (uint256 i = 0; i < bets.length; i++) {
            if (keccak256(bytes(bets[i].name)) == keccak256(bytes(betName))) {
                return bets[i].options;
            }
        }
        return new string[](5);
    }

    function isAddressParticipating(address _address, string memory betName) public view returns (bool) {
        for (uint256 i = 0; i < bets.length; i++) {
            if (keccak256(bytes(bets[i].name)) == keccak256(bytes(betName))) {
               return bets[i].contributions[_address] != 0;
            }
        }
        return false;
    }

    function getContributionForAddress(address _address, string memory betName) public view returns (uint256) {
        for (uint256 i = 0; i < bets.length; i++) {
            if (keccak256(bytes(bets[i].name)) == keccak256(bytes(betName))) {
               return bets[i].contributions[_address];
            }
        }
        return 0;
    }

    function getRewardForAddress(address _address, string memory betName) public view returns (uint256) {
        for (uint256 i = 0; i < bets.length; i++) {
            if (keccak256(bytes(bets[i].name)) == keccak256(bytes(betName))) {
               if (didAddressWin(_address, bets[i].name)) {
                   return bets[i].reward;
               }
            }
        }
        return 0;
    }

    function getPickedOptionForAddress(address _address, string memory betName) public view returns (string memory) {
        for (uint256 i = 0; i < bets.length; i++) {
            if (keccak256(bytes(bets[i].name)) == keccak256(bytes(betName))) {
               return bets[i].pickedOptions[_address];
            }
        }
        return "";
    }

    function didAddressWin(address _address, string memory betName) public view returns (bool) {
        string memory option = getPickedOptionForAddress(_address, betName);
        for (uint256 i = 0; i < bets.length; i++) {
            if (keccak256(bytes(bets[i].name)) == keccak256(bytes(betName))) {
               return keccak256(bytes(bets[i].winOption)) == keccak256(bytes(option));
            }
        }
        return false;
    }

    function enter(string memory _option, string memory betName) public payable minimumEther {
        for (uint256 i = 0; i < bets.length; i++) {
            if (keccak256(bytes(bets[i].name)) == keccak256(bytes(betName))) {
                bets[i].contributors.push(msg.sender);
                bets[i].totalRewardPool += msg.value;
                bets[i].pickedOptions[msg.sender] = _option;
                bets[i].contributions[msg.sender] = msg.value;
            }
        }
    }

    function resolve(string memory betName) public payable onlyOwner {
        betToResolve = betName;
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
        for (uint256 i = 0; i < bets.length; i++) {
            if (keccak256(bytes(bets[i].name)) == keccak256(bytes(betToResolve))) {
                uint256 winOptionIndex = randomness % bets[i].options.length;
                bets[i].winOption = bets[i].options[winOptionIndex];
                bets[i].resolved = true;
            }
        }
        giveOutMoney();
    }

    function giveOutMoney() private {
        for (uint256 i = 0; i < bets.length; i++) {
            if (keccak256(bytes(bets[i].name)) == keccak256(bytes(betToResolve))) {
                for (uint256 j = 0; j < bets[i].contributors.length; j++) {
                    address adr = bets[i].contributors[j];
                    if (didAddressWin(adr, bets[i].name)) {
                        winnersList.push(adr);
                    }
                }
                if (winnersList.length > 0) {
                    uint256 reward = bets[i].totalRewardPool / winnersList.length;
                    for (uint256 j = 0; j < winnersList.length; j++) {
                        payable(winnersList[j]).transfer(reward);
                    }
                } else {
                    // For now, not won money stays within contract forever
                }
                bets[i].totalRewardPool = 0;
                delete winnersList;
            }
        }
    }

    function withdrawBalance() external onlyOwner {
        uint balance = LINK.balanceOf(address(this));
        LINK.transfer(owner, balance);
    }
}
