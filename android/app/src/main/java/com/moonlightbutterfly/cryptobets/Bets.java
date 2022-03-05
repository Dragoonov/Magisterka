package com.moonlightbutterfly.cryptobets;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
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
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class Bets extends Contract {
    public static final String BINARY = "60c060405266038d7ea4c68000600355600680546001600160a01b0319908116738a753747a1fa494ec906ce90e9f37563a8af630e1790915560078054821673b3dccb4cf7a26f6cf6b120cf5a73875b7bbc655b179055600880549091167301be23585060835e02b77ef475b0cc51aa1e07091790557f2ed0feb3e7fd2022120aa84fab1945545a9f2ffc9076fd6156fa96eaff4c13116009553480156100a557600080fd5b506007546008546001600160a01b0391821660a0528116608052600654600180546001600160a01b031990811692909316919091179055600280549091163317905560095460045567016345785d8a000060055560805160a051611eee61013a60003960008181610bd101526113a401526000818161066d0152818161070c01528181610e1001526113750152611eee6000f3fe6080604052600436106100fe5760003560e01c80636f7837ae11610095578063abd4b04711610064578063abd4b04714610288578063dbdff2c1146102a8578063e68d46d3146102bd578063ec5cc2ab146102dd578063eebdda1b146102fd57600080fd5b80636f7837ae14610206578063901824da1461022657806394985ddd14610246578063a6afd5fd1461026657600080fd5b8063461a4478116100d1578063461a44781461018c5780634be17f84146101ae5780635fd8c710146101de5780636f215923146101f357600080fd5b806310a7196a1461010357806312065fe01461013957806324cf4feb1461015657806327512f821461016c575b600080fd5b34801561010f57600080fd5b5061012361011e3660046119ed565b61031d565b6040516101309190611a96565b60405180910390f35b34801561014557600080fd5b50475b604051908152602001610130565b34801561016257600080fd5b5061014860035481565b34801561017857600080fd5b506101486101873660046119ed565b610469565b34801561019857600080fd5b506101ac6101a7366004611ab0565b61052a565b005b3480156101ba57600080fd5b506101ce6101c93660046119ed565b61057d565b6040519015158152602001610130565b3480156101ea57600080fd5b506101ac61062b565b6101ac610201366004611ae5565b610779565b34801561021257600080fd5b506101486102213660046119ed565b610944565b34801561023257600080fd5b50610123610241366004611ab0565b610a93565b34801561025257600080fd5b506101ac610261366004611b3f565b610bc6565b34801561027257600080fd5b5061027b610c48565b6040516101309190611b61565b34801561029457600080fd5b506101ce6102a33660046119ed565b610d21565b3480156102b457600080fd5b50610148610dec565b3480156102c957600080fd5b506101ac6102d8366004611bc3565b610ef0565b3480156102e957600080fd5b5061027b6102f8366004611ab0565b610fd3565b34801561030957600080fd5b506101ce610318366004611ab0565b611169565b606060005b600c54811015610451578280519060200120600c828154811061034757610347611caa565b90600052602060002090600902016000016040516103659190611cfb565b6040518091039020141561043f57600c818154811061038657610386611caa565b600091825260208083206001600160a01b038816845260036009909302019190910190526040902080546103b990611cc0565b80601f01602080910402602001604051908101604052809291908181526020018280546103e590611cc0565b80156104325780601f1061040757610100808354040283529160200191610432565b820191906000526020600020905b81548152906001019060200180831161041557829003601f168201915b5050505050915050610463565b8061044981611dad565b915050610322565b50506040805160208101909152600081525b92915050565b6000805b600c54811015610520578280519060200120600c828154811061049257610492611caa565b90600052602060002090600902016000016040516104b09190611cfb565b6040518091039020141561050e57600c81815481106104d1576104d1611caa565b90600052602060002090600902016002016000856001600160a01b03166001600160a01b0316815260200190815260200160002054915050610463565b8061051881611dad565b91505061046d565b5060009392505050565b6002546001600160a01b0316331461055d5760405162461bcd60e51b815260040161055490611dc8565b60405180910390fd5b805161057090600b906020840190611758565b50610579610dec565b5050565b6000805b600c54811015610520578280519060200120600c82815481106105a6576105a6611caa565b90600052602060002090600902016000016040516105c49190611cfb565b6040518091039020141561061957600c81815481106105e5576105e5611caa565b600091825260208083206001600160a01b038816845260026009909302019190910190526040902054151591506104639050565b8061062381611dad565b915050610581565b6002546001600160a01b031633146106555760405162461bcd60e51b815260040161055490611dc8565b6040516370a0823160e01b81523060048201526000907f00000000000000000000000000000000000000000000000000000000000000006001600160a01b0316906370a0823190602401602060405180830381865afa1580156106bc573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906106e09190611df7565b60025460405163a9059cbb60e01b81526001600160a01b039182166004820152602481018390529192507f0000000000000000000000000000000000000000000000000000000000000000169063a9059cbb906044016020604051808303816000875af1158015610755573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906105799190611e10565b60035434116107d85760405162461bcd60e51b815260206004820152602560248201527f596f75206861766520746f20656e746572206d696e696d756d20302e3030312060448201526422ba3432b960d91b6064820152608401610554565b60005b600c5481101561093f578180519060200120600c828154811061080057610800611caa565b906000526020600020906009020160000160405161081e9190611cfb565b6040518091039020141561092d57600c818154811061083f5761083f611caa565b60009182526020808320600460099093020191909101805460018101825590835291200180546001600160a01b03191633179055600c80543491908390811061088a5761088a611caa565b906000526020600020906009020160050160008282546108aa9190611e32565b9250508190555082600c82815481106108c5576108c5611caa565b600091825260208083203384526003600990930201919091018152604090912082516108f79391929190910190611758565b5034600c828154811061090c5761090c611caa565b60009182526020808320338452600260099093020191909101905260409020555b8061093781611dad565b9150506107db565b505050565b6000805b600c54811015610520578280519060200120600c828154811061096d5761096d611caa565b906000526020600020906009020160000160405161098b9190611cfb565b60405180910390201415610a8157610a4f84600c83815481106109b0576109b0611caa565b906000526020600020906009020160000180546109cc90611cc0565b80601f01602080910402602001604051908101604052809291908181526020018280546109f890611cc0565b8015610a455780601f10610a1a57610100808354040283529160200191610a45565b820191906000526020600020905b815481529060010190602001808311610a2857829003601f168201915b5050505050610d21565b15610a8157600c8181548110610a6757610a67611caa565b906000526020600020906009020160080154915050610463565b80610a8b81611dad565b915050610948565b606060005b600c54811015610bb0578280519060200120600c8281548110610abd57610abd611caa565b9060005260206000209060090201600001604051610adb9190611cfb565b60405180910390201415610b9e57600c8181548110610afc57610afc611caa565b90600052602060002090600902016006018054610b1890611cc0565b80601f0160208091040260200160405190810160405280929190818152602001828054610b4490611cc0565b8015610b915780601f10610b6657610100808354040283529160200191610b91565b820191906000526020600020905b815481529060010190602001808311610b7457829003601f168201915b5050505050915050919050565b80610ba881611dad565b915050610a98565b5050604080516020810190915260008152919050565b336001600160a01b037f00000000000000000000000000000000000000000000000000000000000000001614610c3e5760405162461bcd60e51b815260206004820152601f60248201527f4f6e6c7920565246436f6f7264696e61746f722063616e2066756c66696c6c006044820152606401610554565b610579828261120a565b6060600d805480602002602001604051908101604052809291908181526020016000905b82821015610d18578382906000526020600020018054610c8b90611cc0565b80601f0160208091040260200160405190810160405280929190818152602001828054610cb790611cc0565b8015610d045780601f10610cd957610100808354040283529160200191610d04565b820191906000526020600020905b815481529060010190602001808311610ce757829003601f168201915b505050505081526020019060010190610c6c565b50505050905090565b600080610d2e848461031d565b905060005b600c54811015610de1578380519060200120600c8281548110610d5857610d58611caa565b9060005260206000209060090201600001604051610d769190611cfb565b60405180910390201415610dcf578180519060200120600c8281548110610d9f57610d9f611caa565b9060005260206000209060090201600601604051610dbd9190611cfb565b60405180910390201492505050610463565b80610dd981611dad565b915050610d33565b506000949350505050565b6005546040516370a0823160e01b8152306004820152600091906001600160a01b037f000000000000000000000000000000000000000000000000000000000000000016906370a0823190602401602060405180830381865afa158015610e57573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190610e7b9190611df7565b1015610edd5760405162461bcd60e51b815260206004820152602b60248201527f4e6f7420656e6f756768204c494e4b202d2066696c6c20636f6e74726163742060448201526a1dda5d1a0819985d58d95d60aa1b6064820152608401610554565b610eeb600454600554611371565b905090565b6002546001600160a01b03163314610f1a5760405162461bcd60e51b815260040161055490611dc8565b600c805460018101808355600083815291929083908110610f3d57610f3d611caa565b600091825260209182902086516009909202019250610f6191839190870190611758565b508251610f7790600183019060208601906117dc565b5060078101805460ff19169055600060088201819055600d805460018101825591528451610fcc917fd7b6990105719101dabeb77144f2a3385c8033acd3af97e9423a695e81ad1eb501906020870190611758565b5050505050565b606060005b600c54811015611137578280519060200120600c8281548110610ffd57610ffd611caa565b906000526020600020906009020160000160405161101b9190611cfb565b6040518091039020141561112557600c818154811061103c5761103c611caa565b9060005260206000209060090201600101805480602002602001604051908101604052809291908181526020016000905b8282101561111957838290600052602060002001805461108c90611cc0565b80601f01602080910402602001604051908101604052809291908181526020018280546110b890611cc0565b80156111055780601f106110da57610100808354040283529160200191611105565b820191906000526020600020905b8154815290600101906020018083116110e857829003601f168201915b50505050508152602001906001019061106d565b50505050915050919050565b8061112f81611dad565b915050610fd8565b5060408051600580825260c0820190925290816020015b606081526020019060019003908161114e5790505092915050565b6000805b600c54811015611201578280519060200120600c828154811061119257611192611caa565b90600052602060002090600902016000016040516111b09190611cfb565b604051809103902014156111ef57600c81815481106111d1576111d1611caa565b600091825260209091206007600990920201015460ff169392505050565b806111f981611dad565b91505061116d565b50600092915050565b60005b600c5481101561136857600b6040516112269190611cfb565b6040518091039020600c828154811061124157611241611caa565b906000526020600020906009020160000160405161125f9190611cfb565b60405180910390201415611356576000600c828154811061128257611282611caa565b60009182526020909120600160099092020101546112a09084611e60565b9050600c82815481106112b5576112b5611caa565b906000526020600020906009020160010181815481106112d7576112d7611caa565b90600052602060002001600c83815481106112f4576112f4611caa565b906000526020600020906009020160060190805461131190611cc0565b61131c929190611835565b506001600c838154811061133257611332611caa565b60009182526020909120600990910201600701805460ff1916911515919091179055505b8061136081611dad565b91505061120d565b506105796114ec565b60007f00000000000000000000000000000000000000000000000000000000000000006001600160a01b0316634000aea07f0000000000000000000000000000000000000000000000000000000000000000848660006040516020016113e1929190918252602082015260400190565b6040516020818303038152906040526040518463ffffffff1660e01b815260040161140e93929190611e74565b6020604051808303816000875af115801561142d573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906114519190611e10565b5060008381526020818152604080832054815180840188905280830185905230606082015260808082018390528351808303909101815260a0909101909252815191830191909120868452929091526114ab906001611e32565b60008581526020818152604091829020929092558051808301879052808201849052815180820383018152606090910190915280519101205b949350505050565b60005b600c5481101561175557600b6040516115089190611cfb565b6040518091039020600c828154811061152357611523611caa565b90600052602060002090600902016000016040516115419190611cfb565b604051809103902014156117435760005b600c828154811061156557611565611caa565b906000526020600020906009020160040180549050811015611653576000600c838154811061159657611596611caa565b906000526020600020906009020160040182815481106115b8576115b8611caa565b9060005260206000200160009054906101000a90046001600160a01b031690506115ef81600c85815481106109b0576109b0611caa565b1561164057600a80546001810182556000919091527fc65a7bb8d6351c1cf70c95a316cc6a92839c986682d98bc35f958f4883f9d2a80180546001600160a01b0319166001600160a01b0383161790555b508061164b81611dad565b915050611552565b50600a541561170b576000600a80549050600c838154811061167757611677611caa565b9060005260206000209060090201600501546116939190611ea4565b905060005b600a5481101561170857600a81815481106116b5576116b5611caa565b60009182526020822001546040516001600160a01b039091169184156108fc02918591818181858888f193505050501580156116f5573d6000803e3d6000fd5b508061170081611dad565b915050611698565b50505b6000600c828154811061172057611720611caa565b906000526020600020906009020160050181905550600a600061174391906118b0565b8061174d81611dad565b9150506114ef565b50565b82805461176490611cc0565b90600052602060002090601f01602090048101928261178657600085556117cc565b82601f1061179f57805160ff19168380011785556117cc565b828001600101855582156117cc579182015b828111156117cc5782518255916020019190600101906117b1565b506117d89291506118ca565b5090565b828054828255906000526020600020908101928215611829579160200282015b828111156118295782518051611819918491602090910190611758565b50916020019190600101906117fc565b506117d89291506118df565b82805461184190611cc0565b90600052602060002090601f01602090048101928261186357600085556117cc565b82601f1061187457805485556117cc565b828001600101855582156117cc57600052602060002091601f016020900482015b828111156117cc578254825591600101919060010190611895565b508054600082559060005260206000209081019061175591905b5b808211156117d857600081556001016118cb565b808211156117d85760006118f382826118fc565b506001016118df565b50805461190890611cc0565b6000825580601f10611918575050565b601f01602090049060005260206000209081019061175591906118ca565b634e487b7160e01b600052604160045260246000fd5b604051601f8201601f1916810167ffffffffffffffff8111828210171561197557611975611936565b604052919050565b600082601f83011261198e57600080fd5b813567ffffffffffffffff8111156119a8576119a8611936565b6119bb601f8201601f191660200161194c565b8181528460208386010111156119d057600080fd5b816020850160208301376000918101602001919091529392505050565b60008060408385031215611a0057600080fd5b82356001600160a01b0381168114611a1757600080fd5b9150602083013567ffffffffffffffff811115611a3357600080fd5b611a3f8582860161197d565b9150509250929050565b6000815180845260005b81811015611a6f57602081850181015186830182015201611a53565b81811115611a81576000602083870101525b50601f01601f19169290920160200192915050565b602081526000611aa96020830184611a49565b9392505050565b600060208284031215611ac257600080fd5b813567ffffffffffffffff811115611ad957600080fd5b6114e48482850161197d565b60008060408385031215611af857600080fd5b823567ffffffffffffffff80821115611b1057600080fd5b611b1c8683870161197d565b93506020850135915080821115611b3257600080fd5b50611a3f8582860161197d565b60008060408385031215611b5257600080fd5b50508035926020909101359150565b6000602080830181845280855180835260408601915060408160051b870101925083870160005b82811015611bb657603f19888603018452611ba4858351611a49565b94509285019290850190600101611b88565b5092979650505050505050565b60008060408385031215611bd657600080fd5b823567ffffffffffffffff80821115611bee57600080fd5b611bfa8683870161197d565b9350602091508185013581811115611c1157600080fd5b8501601f81018713611c2257600080fd5b803582811115611c3457611c34611936565b8060051b611c4385820161194c565b918252828101850191858101908a841115611c5d57600080fd5b86850192505b83831015611c9957823586811115611c7b5760008081fd5b611c898c898389010161197d565b8352509186019190860190611c63565b809750505050505050509250929050565b634e487b7160e01b600052603260045260246000fd5b600181811c90821680611cd457607f821691505b60208210811415611cf557634e487b7160e01b600052602260045260246000fd5b50919050565b600080835481600182811c915080831680611d1757607f831692505b6020808410821415611d3757634e487b7160e01b86526022600452602486fd5b818015611d4b5760018114611d5c57611d89565b60ff19861689528489019650611d89565b60008a81526020902060005b86811015611d815781548b820152908501908301611d68565b505084890196505b509498975050505050505050565b634e487b7160e01b600052601160045260246000fd5b6000600019821415611dc157611dc1611d97565b5060010190565b602080825260159082015274596f75277265206e6f7420746865206f776e65722160581b604082015260600190565b600060208284031215611e0957600080fd5b5051919050565b600060208284031215611e2257600080fd5b81518015158114611aa957600080fd5b60008219821115611e4557611e45611d97565b500190565b634e487b7160e01b600052601260045260246000fd5b600082611e6f57611e6f611e4a565b500690565b60018060a01b0384168152826020820152606060408201526000611e9b6060830184611a49565b95945050505050565b600082611eb357611eb3611e4a565b50049056fea2646970667358221220e2aa23ce06b99f13c973258f9aeef4861465169a62d3510657cfe37dd347626564736f6c634300080b0033";

    public static final String FUNC_ADDBET = "addBet";

    public static final String FUNC_DIDADDRESSWIN = "didAddressWin";

    public static final String FUNC_ENTER = "enter";

    public static final String FUNC_GETBALANCE = "getBalance";

    public static final String FUNC_GETBETOPTIONS = "getBetOptions";

    public static final String FUNC_GETBETS = "getBets";

    public static final String FUNC_GETCONTRIBUTIONFORADDRESS = "getContributionForAddress";

    public static final String FUNC_GETPICKEDOPTIONFORADDRESS = "getPickedOptionForAddress";

    public static final String FUNC_GETRANDOMNUMBER = "getRandomNumber";

    public static final String FUNC_GETREWARDFORADDRESS = "getRewardForAddress";

    public static final String FUNC_GETWINOPTION = "getWinOption";

    public static final String FUNC_ISADDRESSPARTICIPATING = "isAddressParticipating";

    public static final String FUNC_ISRESOLVED = "isResolved";

    public static final String FUNC_MINIMUMENTRANCE = "minimumEntrance";

    public static final String FUNC_RAWFULFILLRANDOMNESS = "rawFulfillRandomness";

    public static final String FUNC_RESOLVE = "resolve";

    public static final String FUNC_WITHDRAWBALANCE = "withdrawBalance";

    @Deprecated
    protected Bets(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Bets(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Bets(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Bets(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addBet(String name, List<String> options) {
        final Function function = new Function(
                FUNC_ADDBET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Utf8String>(
                        org.web3j.abi.datatypes.Utf8String.class,
                        org.web3j.abi.Utils.typeMap(options, org.web3j.abi.datatypes.Utf8String.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> didAddressWin(String _address, String betName) {
        final Function function = new Function(FUNC_DIDADDRESSWIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _address), 
                new org.web3j.abi.datatypes.Utf8String(betName)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> enter(String _option, String betName, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_ENTER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_option), 
                new org.web3j.abi.datatypes.Utf8String(betName)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<BigInteger> getBalance() {
        final Function function = new Function(FUNC_GETBALANCE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<List> getBetOptions(String betName) {
        final Function function = new Function(FUNC_GETBETOPTIONS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(betName)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Utf8String>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<List> getBets() {
        final Function function = new Function(FUNC_GETBETS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Utf8String>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> getContributionForAddress(String _address, String betName) {
        final Function function = new Function(FUNC_GETCONTRIBUTIONFORADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _address), 
                new org.web3j.abi.datatypes.Utf8String(betName)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> getPickedOptionForAddress(String _address, String betName) {
        final Function function = new Function(FUNC_GETPICKEDOPTIONFORADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _address), 
                new org.web3j.abi.datatypes.Utf8String(betName)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> getRandomNumber() {
        final Function function = new Function(
                FUNC_GETRANDOMNUMBER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getRewardForAddress(String _address, String betName) {
        final Function function = new Function(FUNC_GETREWARDFORADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _address), 
                new org.web3j.abi.datatypes.Utf8String(betName)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> getWinOption(String betName) {
        final Function function = new Function(FUNC_GETWINOPTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(betName)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Boolean> isAddressParticipating(String _address, String betName) {
        final Function function = new Function(FUNC_ISADDRESSPARTICIPATING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _address), 
                new org.web3j.abi.datatypes.Utf8String(betName)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> isResolved(String betName) {
        final Function function = new Function(FUNC_ISRESOLVED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(betName)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> minimumEntrance() {
        final Function function = new Function(FUNC_MINIMUMENTRANCE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> rawFulfillRandomness(byte[] requestId, BigInteger randomness) {
        final Function function = new Function(
                FUNC_RAWFULFILLRANDOMNESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(requestId), 
                new org.web3j.abi.datatypes.generated.Uint256(randomness)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> resolve(String betName) {
        final Function function = new Function(
                FUNC_RESOLVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(betName)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> withdrawBalance() {
        final Function function = new Function(
                FUNC_WITHDRAWBALANCE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Bets load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Bets(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Bets load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Bets(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Bets load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Bets(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Bets load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Bets(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Bets> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Bets.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Bets> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Bets.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Bets> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Bets.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Bets> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Bets.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}