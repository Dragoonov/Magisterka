// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.0;

import "@chainlink/contracts/src/v0.8/interfaces/AggregatorV3Interface.sol";

contract Lottery {
    AggregatorV3Interface internal priceFeed;
    mapping (address => bool) public wallets;
    address[] public addresses;
    address[] public winners;
    mapping (address => Option) public pickedOptions;
    mapping (address => uint256) public contributions;
    address private owner;
    uint256 public totalContributions;
    // 0x8A753747A1Fa494EC906cE90E9f37563A8AF630e - address for rinkeby chainlink

    enum Option { One, Two, Three, Four }

    constructor(address _priceFeedAddress) {
        priceFeed = AggregatorV3Interface(_priceFeedAddress);
        owner = msg.sender;
    }

    modifier onlyOwner() {
        require(msg.sender == owner, "You're not the owner!");
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

    function resolve() public payable onlyOwner {
        Option winOption = getWinningOption();
        for (uint256 i = 0; i < addresses.length; i++) {
            address adr = addresses[i];
            if (pickedOptions[adr] == winOption) {
                winners.push(adr);
            }
            wallets[adr] = false;
            contributions[adr] = 0;
        }
        if (winners.length > 0) {
            uint256 reward = totalContributions / winners.length;
            for (uint256 i = 0; i < winners.length; i++) {
                payable(winners[i]).transfer(reward);
            }
        }
        addresses = new address[](0);
        winners = new address[](0);
        totalContributions = 0;
    }

    function getBalance() public view returns (uint256) {
        return address(this).balance;
    }
}
