package com.moonlightbutterfly.testapp;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.5.
 */
@SuppressWarnings("rawtypes")
public class Test extends Contract {
    private static final String BINARY = "66038d7ea4c68000600090815560a0604081905260808290526100259160019190610038565b5034801561003257600080fd5b5061010c565b828054610044906100d1565b90600052602060002090601f01602090048101928261006657600085556100ac565b82601f1061007f57805160ff19168380011785556100ac565b828001600101855582156100ac579182015b828111156100ac578251825591602001919060010190610091565b506100b89291506100bc565b5090565b5b808211156100b857600081556001016100bd565b600181811c908216806100e557607f821691505b6020821081141561010657634e487b7160e01b600052602260045260246000fd5b50919050565b6102e18061011b6000396000f3fe6080604052600436106100345760003560e01c806324cf4feb1461003957806337b136b214610061578063919f97dc14610083575b600080fd5b34801561004557600080fd5b5061004f60005481565b60405190815260200160405180910390f35b34801561006d57600080fd5b5061008161007c3660046101bf565b610096565b005b6100816100913660046101bf565b6100ad565b80516100a9906001906020840190610110565b5050565b60005434116100965760405162461bcd60e51b815260206004820152602560248201527f596f75206861766520746f20656e746572206d696e696d756d20302e3030312060448201526422ba3432b960d91b606482015260840160405180910390fd5b82805461011c90610270565b90600052602060002090601f01602090048101928261013e5760008555610184565b82601f1061015757805160ff1916838001178555610184565b82800160010185558215610184579182015b82811115610184578251825591602001919060010190610169565b50610190929150610194565b5090565b5b808211156101905760008155600101610195565b634e487b7160e01b600052604160045260246000fd5b6000602082840312156101d157600080fd5b813567ffffffffffffffff808211156101e957600080fd5b818401915084601f8301126101fd57600080fd5b81358181111561020f5761020f6101a9565b604051601f8201601f19908116603f01168101908382118183101715610237576102376101a9565b8160405282815287602084870101111561025057600080fd5b826020860160208301376000928101602001929092525095945050505050565b600181811c9082168061028457607f821691505b602082108114156102a557634e487b7160e01b600052602260045260246000fd5b5091905056fea26469706673582212200aef9da61a41edf1df1d580c9b44098db1757a3b6f398af725081702c5d3e68a64736f6c634300080b0033";

    public static final String FUNC_ENTERNOTPAYABLE = "enterNotPayable";

    public static final String FUNC_ENTERPAYABLE = "enterPayable";

    public static final String FUNC_MINIMUMENTRANCE = "minimumEntrance";

    @Deprecated
    protected Test(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Test(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Test(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Test(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> enterNotPayable(String bet) {
        final Function function = new Function(
                FUNC_ENTERNOTPAYABLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(bet)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> enterPayable(String bet) {
        final Function function = new Function(
                FUNC_ENTERPAYABLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(bet)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> minimumEntrance() {
        final Function function = new Function(
                FUNC_MINIMUMENTRANCE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Test load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Test(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Test load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Test(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Test load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Test(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Test load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Test(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Test> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Test.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Test> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Test.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Test> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Test.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Test> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Test.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
