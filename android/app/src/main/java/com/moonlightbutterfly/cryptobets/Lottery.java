package com.moonlightbutterfly.cryptobets;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Int256;
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
public class Lottery extends Contract {
    public static final String BINARY = "{\r\n"
            + "\t\"functionDebugData\": {\r\n"
            + "\t\t\"@_410\": {\r\n"
            + "\t\t\t\"entryPoint\": null,\r\n"
            + "\t\t\t\"id\": 410,\r\n"
            + "\t\t\t\"parameterSlots\": 0,\r\n"
            + "\t\t\t\"returnSlots\": 0\r\n"
            + "\t\t},\r\n"
            + "\t\t\"@_98\": {\r\n"
            + "\t\t\t\"entryPoint\": null,\r\n"
            + "\t\t\t\"id\": 98,\r\n"
            + "\t\t\t\"parameterSlots\": 2,\r\n"
            + "\t\t\t\"returnSlots\": 0\r\n"
            + "\t\t},\r\n"
            + "\t\t\"extract_byte_array_length\": {\r\n"
            + "\t\t\t\"entryPoint\": 958,\r\n"
            + "\t\t\t\"id\": null,\r\n"
            + "\t\t\t\"parameterSlots\": 1,\r\n"
            + "\t\t\t\"returnSlots\": 1\r\n"
            + "\t\t},\r\n"
            + "\t\t\"panic_error_0x22\": {\r\n"
            + "\t\t\t\"entryPoint\": 1012,\r\n"
            + "\t\t\t\"id\": null,\r\n"
            + "\t\t\t\"parameterSlots\": 0,\r\n"
            + "\t\t\t\"returnSlots\": 0\r\n"
            + "\t\t}\r\n"
            + "\t},\r\n"
            + "\t\"generatedSources\": [\r\n"
            + "\t\t{\r\n"
            + "\t\t\t\"ast\": {\r\n"
            + "\t\t\t\t\"nodeType\": \"YulBlock\",\r\n"
            + "\t\t\t\t\"src\": \"0:516:5\",\r\n"
            + "\t\t\t\t\"statements\": [\r\n"
            + "\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\"body\": {\r\n"
            + "\t\t\t\t\t\t\t\"nodeType\": \"YulBlock\",\r\n"
            + "\t\t\t\t\t\t\t\"src\": \"58:269:5\",\r\n"
            + "\t\t\t\t\t\t\t\"statements\": [\r\n"
            + "\t\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulAssignment\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\"src\": \"68:22:5\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\"value\": {\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"arguments\": [\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"data\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"82:4:5\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"kind\": \"number\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulLiteral\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"88:1:5\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"value\": \"2\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t}\r\n"
            + "\t\t\t\t\t\t\t\t\t\t],\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"functionName\": {\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"div\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"78:3:5\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"src\": \"78:12:5\"\r\n"
            + "\t\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t\t\"variableNames\": [\r\n"
            + "\t\t\t\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"length\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"68:6:5\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t}\r\n"
            + "\t\t\t\t\t\t\t\t\t]\r\n"
            + "\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulVariableDeclaration\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\"src\": \"99:38:5\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\"value\": {\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"arguments\": [\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"data\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"129:4:5\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"kind\": \"number\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulLiteral\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"135:1:5\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"value\": \"1\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t}\r\n"
            + "\t\t\t\t\t\t\t\t\t\t],\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"functionName\": {\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"and\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"125:3:5\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"src\": \"125:12:5\"\r\n"
            + "\t\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t\t\"variables\": [\r\n"
            + "\t\t\t\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"outOfPlaceEncoding\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulTypedName\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"103:18:5\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t}\r\n"
            + "\t\t\t\t\t\t\t\t\t]\r\n"
            + "\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\t\"body\": {\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulBlock\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"src\": \"176:51:5\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"statements\": [\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulAssignment\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"190:27:5\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"value\": {\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"arguments\": [\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"length\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"204:6:5\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"kind\": \"number\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulLiteral\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"212:4:5\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"value\": \"0x7f\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t],\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"functionName\": {\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"and\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"200:3:5\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"200:17:5\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"variableNames\": [\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"length\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"190:6:5\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t}\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t]\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t}\r\n"
            + "\t\t\t\t\t\t\t\t\t\t]\r\n"
            + "\t\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t\t\"condition\": {\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"arguments\": [\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"outOfPlaceEncoding\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"156:18:5\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t}\r\n"
            + "\t\t\t\t\t\t\t\t\t\t],\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"functionName\": {\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"iszero\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"149:6:5\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"src\": \"149:26:5\"\r\n"
            + "\t\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIf\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\"src\": \"146:81:5\"\r\n"
            + "\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\t\"body\": {\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulBlock\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"src\": \"279:42:5\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"statements\": [\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"expression\": {\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"arguments\": [],\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"functionName\": {\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"panic_error_0x22\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"293:16:5\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"293:18:5\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulExpressionStatement\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"293:18:5\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t}\r\n"
            + "\t\t\t\t\t\t\t\t\t\t]\r\n"
            + "\t\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t\t\"condition\": {\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"arguments\": [\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"outOfPlaceEncoding\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"243:18:5\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"arguments\": [\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"length\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"266:6:5\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"kind\": \"number\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulLiteral\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"274:2:5\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"value\": \"32\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t}\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t],\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"functionName\": {\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"lt\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"263:2:5\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"263:14:5\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t}\r\n"
            + "\t\t\t\t\t\t\t\t\t\t],\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"functionName\": {\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"eq\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"240:2:5\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"src\": \"240:38:5\"\r\n"
            + "\t\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIf\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\"src\": \"237:84:5\"\r\n"
            + "\t\t\t\t\t\t\t\t}\r\n"
            + "\t\t\t\t\t\t\t]\r\n"
            + "\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\"name\": \"extract_byte_array_length\",\r\n"
            + "\t\t\t\t\t\t\"nodeType\": \"YulFunctionDefinition\",\r\n"
            + "\t\t\t\t\t\t\"parameters\": [\r\n"
            + "\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\"name\": \"data\",\r\n"
            + "\t\t\t\t\t\t\t\t\"nodeType\": \"YulTypedName\",\r\n"
            + "\t\t\t\t\t\t\t\t\"src\": \"42:4:5\",\r\n"
            + "\t\t\t\t\t\t\t\t\"type\": \"\"\r\n"
            + "\t\t\t\t\t\t\t}\r\n"
            + "\t\t\t\t\t\t],\r\n"
            + "\t\t\t\t\t\t\"returnVariables\": [\r\n"
            + "\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\"name\": \"length\",\r\n"
            + "\t\t\t\t\t\t\t\t\"nodeType\": \"YulTypedName\",\r\n"
            + "\t\t\t\t\t\t\t\t\"src\": \"51:6:5\",\r\n"
            + "\t\t\t\t\t\t\t\t\"type\": \"\"\r\n"
            + "\t\t\t\t\t\t\t}\r\n"
            + "\t\t\t\t\t\t],\r\n"
            + "\t\t\t\t\t\t\"src\": \"7:320:5\"\r\n"
            + "\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\"body\": {\r\n"
            + "\t\t\t\t\t\t\t\"nodeType\": \"YulBlock\",\r\n"
            + "\t\t\t\t\t\t\t\"src\": \"361:152:5\",\r\n"
            + "\t\t\t\t\t\t\t\"statements\": [\r\n"
            + "\t\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\t\"expression\": {\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"arguments\": [\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"kind\": \"number\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulLiteral\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"378:1:5\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"value\": \"0\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"kind\": \"number\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulLiteral\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"381:77:5\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"value\": \"35408467139433450592217433187231851964531694900788300625387963629091585785856\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t}\r\n"
            + "\t\t\t\t\t\t\t\t\t\t],\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"functionName\": {\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"mstore\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"371:6:5\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"src\": \"371:88:5\"\r\n"
            + "\t\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulExpressionStatement\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\"src\": \"371:88:5\"\r\n"
            + "\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\t\"expression\": {\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"arguments\": [\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"kind\": \"number\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulLiteral\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"475:1:5\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"value\": \"4\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"kind\": \"number\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulLiteral\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"478:4:5\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"value\": \"0x22\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t}\r\n"
            + "\t\t\t\t\t\t\t\t\t\t],\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"functionName\": {\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"mstore\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"468:6:5\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"src\": \"468:15:5\"\r\n"
            + "\t\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulExpressionStatement\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\"src\": \"468:15:5\"\r\n"
            + "\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\t\"expression\": {\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"arguments\": [\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"kind\": \"number\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulLiteral\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"499:1:5\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"value\": \"0\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"kind\": \"number\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulLiteral\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"502:4:5\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"value\": \"0x24\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t}\r\n"
            + "\t\t\t\t\t\t\t\t\t\t],\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"functionName\": {\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"revert\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"492:6:5\"\r\n"
            + "\t\t\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\t\"src\": \"492:15:5\"\r\n"
            + "\t\t\t\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulExpressionStatement\",\r\n"
            + "\t\t\t\t\t\t\t\t\t\"src\": \"492:15:5\"\r\n"
            + "\t\t\t\t\t\t\t\t}\r\n"
            + "\t\t\t\t\t\t\t]\r\n"
            + "\t\t\t\t\t\t},\r\n"
            + "\t\t\t\t\t\t\"name\": \"panic_error_0x22\",\r\n"
            + "\t\t\t\t\t\t\"nodeType\": \"YulFunctionDefinition\",\r\n"
            + "\t\t\t\t\t\t\"src\": \"333:180:5\"\r\n"
            + "\t\t\t\t\t}\r\n"
            + "\t\t\t\t]\r\n"
            + "\t\t\t},\r\n"
            + "\t\t\t\"contents\": \"{\\n\\n    function extract_byte_array_length(data) -> length {\\n        length := div(data, 2)\\n        let outOfPlaceEncoding := and(data, 1)\\n        if iszero(outOfPlaceEncoding) {\\n            length := and(length, 0x7f)\\n        }\\n\\n        if eq(outOfPlaceEncoding, lt(length, 32)) {\\n            panic_error_0x22()\\n        }\\n    }\\n\\n    function panic_error_0x22() {\\n        mstore(0, 35408467139433450592217433187231851964531694900788300625387963629091585785856)\\n        mstore(4, 0x22)\\n        revert(0, 0x24)\\n    }\\n\\n}\\n\",\r\n"
            + "\t\t\t\"id\": 5,\r\n"
            + "\t\t\t\"language\": \"Yul\",\r\n"
            + "\t\t\t\"name\": \"#utility.yul\"\r\n"
            + "\t\t}\r\n"
            + "\t],\r\n"
            + "\t\"linkReferences\": {},\r\n"
            + "\t\"object\": \"60c0604052662386f26fc10000600c556040518060400160405280600481526020017f5465737400000000000000000000000000000000000000000000000000000000815250600d90805190602001906200005c9291906200030e565b506004601155738a753747a1fa494ec906ce90e9f37563a8af630e601260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555073b3dccb4cf7a26f6cf6b120cf5a73875b7bbc655b601360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055507301be23585060835e02b77ef475b0cc51aa1e0709601460006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055507f2ed0feb3e7fd2022120aa84fab1945545a9f2ffc9076fd6156fa96eaff4c131160001b6015553480156200019557600080fd5b50601360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16601460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1660a08173ffffffffffffffffffffffffffffffffffffffff1660601b815250508073ffffffffffffffffffffffffffffffffffffffff1660808173ffffffffffffffffffffffffffffffffffffffff1660601b815250505050601260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555033600960006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550601554600e8190555067016345785d8a0000600f8190555062000423565b8280546200031c90620003be565b90600052602060002090601f0160209004810192826200034057600085556200038c565b82601f106200035b57805160ff19168380011785556200038c565b828001600101855582156200038c579182015b828111156200038b5782518255916020019190600101906200036e565b5b5090506200039b91906200039f565b5090565b5b80821115620003ba576000816000905550600101620003a0565b5090565b60006002820490506001821680620003d757607f821691505b60208210811415620003ee57620003ed620003f4565b5b50919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b60805160601c60a05160601c611ffd6200046b60003960008181610d4501526113ab01526000818161099101528181610a3c015281816111ac015261136f0152611ffd6000f3fe6080604052600436106101815760003560e01c80636bd5450a116100d1578063a59f3e0c1161008a578063dbdff2c111610064578063dbdff2c1146105a6578063e9820fa4146105d1578063edf26d9b1461060e578063f28f81d51461064b57610181565b8063a59f3e0c14610510578063aad448251461052c578063d13fa88f1461056957610181565b80636bd5450a146103da57806389b08f11146104175780638af0fa5e146104545780638e15f4731461049157806394985ddd146104bc5780639b10b924146104e557610181565b80633289a5461161013e57806342e94c901161011857806342e94c901461030c5780635fd8c7101461034957806362287c3114610360578063635f63131461039d57610181565b80633289a5461461027957806337c08923146102b65780633f6fa655146102e157610181565b806306fdde031461018657806312065fe0146101b157806323c674d4146101dc57806324cf4feb1461021957806326a30e0c146102445780632810e1d61461026f575b600080fd5b34801561019257600080fd5b5061019b610688565b6040516101a89190611a65565b60405180910390f35b3480156101bd57600080fd5b506101c6610716565b6040516101d39190611b47565b60405180910390f35b3480156101e857600080fd5b5061020360048036038101906101fe9190611666565b61071e565b6040516102109190611924565b60405180910390f35b34801561022557600080fd5b5061022e61075d565b60405161023b9190611b47565b60405180910390f35b34801561025057600080fd5b50610259610763565b6040516102669190611b47565b60405180910390f35b61027761076d565b005b34801561028557600080fd5b506102a0600480360381019061029b91906115cc565b61085e565b6040516102ad9190611b47565b60405180910390f35b3480156102c257600080fd5b506102cb610876565b6040516102d89190611b47565b60405180910390f35b3480156102ed57600080fd5b506102f661087c565b60405161030391906119a6565b60405180910390f35b34801561031857600080fd5b50610333600480360381019061032e91906115cc565b61088f565b6040516103409190611b47565b60405180910390f35b34801561035557600080fd5b5061035e6108a7565b005b34801561036c57600080fd5b50610387600480360381019061038291906115cc565b610b0d565b60405161039491906119a6565b60405180910390f35b3480156103a957600080fd5b506103c460048036038101906103bf91906115cc565b610bb9565b6040516103d19190611a65565b60405180910390f35b3480156103e657600080fd5b5061040160048036038101906103fc91906115cc565b610c0a565b60405161040e91906119a6565b60405180910390f35b34801561042357600080fd5b5061043e600480360381019061043991906115cc565b610c2a565b60405161044b91906119a6565b60405180910390f35b34801561046057600080fd5b5061047b600480360381019061047691906115cc565b610c4a565b6040516104889190611b47565b60405180910390f35b34801561049d57600080fd5b506104a6610c93565b6040516104b39190611a4a565b60405180910390f35b3480156104c857600080fd5b506104e360048036038101906104de9190611626565b610d43565b005b3480156104f157600080fd5b506104fa610ddf565b6040516105079190611b47565b60405180910390f35b61052a60048036038101906105259190611666565b610de5565b005b34801561053857600080fd5b50610553600480360381019061054e91906115cc565b61104a565b6040516105609190611b47565b60405180910390f35b34801561057557600080fd5b50610590600480360381019061058b9190611666565b611093565b60405161059d9190611a65565b60405180910390f35b3480156105b257600080fd5b506105bb6111a5565b6040516105c891906119c1565b60405180910390f35b3480156105dd57600080fd5b506105f860048036038101906105f391906115cc565b6112a7565b60405161060591906119a6565b60405180910390f35b34801561061a57600080fd5b5061063560048036038101906106309190611666565b6112fd565b6040516106429190611924565b60405180910390f35b34801561065757600080fd5b50610672600480360381019061066d91906115cc565b61133c565b60405161067f9190611b47565b60405180910390f35b600d805461069590611c95565b80601f01602080910402602001604051908101604052809291908181526020018280546106c190611c95565b801561070e5780601f106106e35761010080835404028352916020019161070e565b820191906000526020600020905b8154815290600101906020018083116106f157829003601f168201915b505050505081565b600047905090565b6006818154811061072e57600080fd5b906000526020600020016000915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600c5481565b6000601154905090565b600960009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146107fd576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016107f490611aa7565b60405180910390fd5b60001515600b60009054906101000a900460ff16151514610853576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161084a90611a87565b60405180910390fd5b61085b6111a5565b50565b60056020528060005260406000206000915090505481565b600a5481565b600b60009054906101000a900460ff1681565b60086020528060005260406000206000915090505481565b600960009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610937576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161092e90611aa7565b60405180910390fd5b60011515600b60009054906101000a900460ff1615151461098d576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161098490611b07565b60405180910390fd5b60007f000000000000000000000000000000000000000000000000000000000000000073ffffffffffffffffffffffffffffffffffffffff166370a08231306040518263ffffffff1660e01b81526004016109e89190611924565b60206040518083038186803b158015610a0057600080fd5b505afa158015610a14573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190610a389190611693565b90507f000000000000000000000000000000000000000000000000000000000000000073ffffffffffffffffffffffffffffffffffffffff1663a9059cbb600960009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16836040518363ffffffff1660e01b8152600401610ab792919061193f565b602060405180830381600087803b158015610ad157600080fd5b505af1158015610ae5573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190610b0991906115f9565b5050565b600060011515600b60009054906101000a900460ff16151514610b65576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610b5c90611b07565b60405180910390fd5b600460008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff169050919050565b6060610c03600760008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054611093565b9050919050565b60046020528060005260406000206000915054906101000a900460ff1681565b60026020528060005260406000206000915054906101000a900460ff1681565b6000600860008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020549050919050565b600080600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663feaf968c6040518163ffffffff1660e01b815260040160a06040518083038186803b158015610cfe57600080fd5b505afa158015610d12573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190610d3691906116c0565b5050509150508091505090565b7f000000000000000000000000000000000000000000000000000000000000000073ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610dd1576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610dc890611b27565b60405180910390fd5b610ddb8282611354565b5050565b60105481565b600c543411610e29576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610e2090611ae7565b60405180910390fd5b60001515600b60009054906101000a900460ff16151514610e7f576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610e7690611a87565b60405180910390fd5b60001515600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff1615151415610f3c576003339080600181540180825580915050600190039060005260206000200160009091909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b6001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555080600760003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208190555034600860003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008282546110279190611b9a565b9250508190555034600a60008282546110409190611b9a565b9250508190555050565b6000600560008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020549050919050565b606060018214156110db576040518060400160405280600381526020017f4f6e65000000000000000000000000000000000000000000000000000000000081525090506111a0565b6002821415611121576040518060400160405280600381526020017f54776f000000000000000000000000000000000000000000000000000000000081525090506111a0565b6003821415611167576040518060400160405280600581526020017f546872656500000000000000000000000000000000000000000000000000000081525090506111a0565b6040518060400160405280600481526020017f466f75720000000000000000000000000000000000000000000000000000000081525090505b919050565b6000600f547f000000000000000000000000000000000000000000000000000000000000000073ffffffffffffffffffffffffffffffffffffffff166370a08231306040518263ffffffff1660e01b81526004016112039190611924565b60206040518083038186803b15801561121b57600080fd5b505afa15801561122f573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906112539190611693565b1015611294576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161128b90611ac7565b60405180910390fd5b6112a2600e54600f5461136b565b905090565b6000600260008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff169050919050565b6003818154811061130d57600080fd5b906000526020600020016000915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60076020528060005260406000206000915090505481565b6004816113619190611cdb565b6010819055505050565b60007f000000000000000000000000000000000000000000000000000000000000000073ffffffffffffffffffffffffffffffffffffffff16634000aea07f0000000000000000000000000000000000000000000000000000000000000000848660006040516020016113df9291906119dc565b6040516020818303038152906040526040518463ffffffff1660e01b815260040161140c93929190611968565b602060405180830381600087803b15801561142657600080fd5b505af115801561143a573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525081019061145e91906115f9565b50600061148084600030600080898152602001908152602001600020546114ca565b90506001600080868152602001908152602001600020546114a19190611b9a565b600080868152602001908152602001600020819055506114c18482611506565b91505092915050565b6000848484846040516020016114e39493929190611a05565b6040516020818303038152906040528051906020012060001c9050949350505050565b6000828260405160200161151b9291906118f8565b60405160208183030381529060405280519060200120905092915050565b60008135905061154881611f3d565b92915050565b60008151905061155d81611f54565b92915050565b60008135905061157281611f6b565b92915050565b60008151905061158781611f82565b92915050565b60008135905061159c81611f99565b92915050565b6000815190506115b181611f99565b92915050565b6000815190506115c681611fb0565b92915050565b6000602082840312156115e2576115e1611d99565b5b60006115f084828501611539565b91505092915050565b60006020828403121561160f5761160e611d99565b5b600061161d8482850161154e565b91505092915050565b6000806040838503121561163d5761163c611d99565b5b600061164b85828601611563565b925050602061165c8582860161158d565b9150509250929050565b60006020828403121561167c5761167b611d99565b5b600061168a8482850161158d565b91505092915050565b6000602082840312156116a9576116a8611d99565b5b60006116b7848285016115a2565b91505092915050565b600080600080600060a086880312156116dc576116db611d99565b5b60006116ea888289016115b7565b95505060206116fb88828901611578565b945050604061170c888289016115a2565b935050606061171d888289016115a2565b925050608061172e888289016115b7565b9150509295509295909350565b61174481611bf0565b82525050565b61175381611c02565b82525050565b61176281611c0e565b82525050565b61177961177482611c0e565b611cc7565b82525050565b600061178a82611b62565b6117948185611b78565b93506117a4818560208601611c62565b6117ad81611d9e565b840191505092915050565b6117c181611c18565b82525050565b60006117d282611b6d565b6117dc8185611b89565b93506117ec818560208601611c62565b6117f581611d9e565b840191505092915050565b600061180d602383611b89565b915061181882611daf565b604082019050919050565b6000611830601583611b89565b915061183b82611dfe565b602082019050919050565b6000611853602b83611b89565b915061185e82611e27565b604082019050919050565b6000611876602483611b89565b915061188182611e76565b604082019050919050565b6000611899602283611b89565b91506118a482611ec5565b604082019050919050565b60006118bc601f83611b89565b91506118c782611f14565b602082019050919050565b6118db81611c42565b82525050565b6118f26118ed82611c42565b611cd1565b82525050565b60006119048285611768565b60208201915061191482846118e1565b6020820191508190509392505050565b6000602082019050611939600083018461173b565b92915050565b6000604082019050611954600083018561173b565b61196160208301846118d2565b9392505050565b600060608201905061197d600083018661173b565b61198a60208301856118d2565b818103604083015261199c818461177f565b9050949350505050565b60006020820190506119bb600083018461174a565b92915050565b60006020820190506119d66000830184611759565b92915050565b60006040820190506119f16000830185611759565b6119fe60208301846118d2565b9392505050565b6000608082019050611a1a6000830187611759565b611a2760208301866118d2565b611a34604083018561173b565b611a4160608301846118d2565b95945050505050565b6000602082019050611a5f60008301846117b8565b92915050565b60006020820190508181036000830152611a7f81846117c7565b905092915050565b60006020820190508181036000830152611aa081611800565b9050919050565b60006020820190508181036000830152611ac081611823565b9050919050565b60006020820190508181036000830152611ae081611846565b9050919050565b60006020820190508181036000830152611b0081611869565b9050919050565b60006020820190508181036000830152611b208161188c565b9050919050565b60006020820190508181036000830152611b40816118af565b9050919050565b6000602082019050611b5c60008301846118d2565b92915050565b600081519050919050565b600081519050919050565b600082825260208201905092915050565b600082825260208201905092915050565b6000611ba582611c42565b9150611bb083611c42565b9250827fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff03821115611be557611be4611d0c565b5b828201905092915050565b6000611bfb82611c22565b9050919050565b60008115159050919050565b6000819050919050565b6000819050919050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000819050919050565b600069ffffffffffffffffffff82169050919050565b60005b83811015611c80578082015181840152602081019050611c65565b83811115611c8f576000848401525b50505050565b60006002820490506001821680611cad57607f821691505b60208210811415611cc157611cc0611d6a565b5b50919050565b6000819050919050565b6000819050919050565b6000611ce682611c42565b9150611cf183611c42565b925082611d0157611d00611d3b565b5b828206905092915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b600080fd5b6000601f19601f8301169050919050565b7f5468697320636f6e74726163742077617320616c7265616479207265736f6c7660008201527f6564210000000000000000000000000000000000000000000000000000000000602082015250565b7f596f75277265206e6f7420746865206f776e6572210000000000000000000000600082015250565b7f4e6f7420656e6f756768204c494e4b202d2066696c6c20636f6e74726163742060008201527f7769746820666175636574000000000000000000000000000000000000000000602082015250565b7f596f75206861766520746f20656e746572206d696e696d756d20302e3031204560008201527f7468657200000000000000000000000000000000000000000000000000000000602082015250565b7f5468697320636f6e7472616374206973206e6f74207265736f6c76656420796560008201527f7421000000000000000000000000000000000000000000000000000000000000602082015250565b7f4f6e6c7920565246436f6f7264696e61746f722063616e2066756c66696c6c00600082015250565b611f4681611bf0565b8114611f5157600080fd5b50565b611f5d81611c02565b8114611f6857600080fd5b50565b611f7481611c0e565b8114611f7f57600080fd5b50565b611f8b81611c18565b8114611f9657600080fd5b50565b611fa281611c42565b8114611fad57600080fd5b50565b611fb981611c4c565b8114611fc457600080fd5b5056fea264697066735822122035831c23b06d895917ccb73f8f0f926dfeafeb78797e97b426602ededb2c85ba64736f6c63430008070033\",\r\n"
            + "\t\"opcodes\": \"PUSH1 0xC0 PUSH1 0x40 MSTORE PUSH7 0x2386F26FC10000 PUSH1 0xC SSTORE PUSH1 0x40 MLOAD DUP1 PUSH1 0x40 ADD PUSH1 0x40 MSTORE DUP1 PUSH1 0x4 DUP2 MSTORE PUSH1 0x20 ADD PUSH32 0x5465737400000000000000000000000000000000000000000000000000000000 DUP2 MSTORE POP PUSH1 0xD SWAP1 DUP1 MLOAD SWAP1 PUSH1 0x20 ADD SWAP1 PUSH3 0x5C SWAP3 SWAP2 SWAP1 PUSH3 0x30E JUMP JUMPDEST POP PUSH1 0x4 PUSH1 0x11 SSTORE PUSH20 0x8A753747A1FA494EC906CE90E9F37563A8AF630E PUSH1 0x12 PUSH1 0x0 PUSH2 0x100 EXP DUP2 SLOAD DUP2 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF MUL NOT AND SWAP1 DUP4 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND MUL OR SWAP1 SSTORE POP PUSH20 0xB3DCCB4CF7A26F6CF6B120CF5A73875B7BBC655B PUSH1 0x13 PUSH1 0x0 PUSH2 0x100 EXP DUP2 SLOAD DUP2 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF MUL NOT AND SWAP1 DUP4 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND MUL OR SWAP1 SSTORE POP PUSH20 0x1BE23585060835E02B77EF475B0CC51AA1E0709 PUSH1 0x14 PUSH1 0x0 PUSH2 0x100 EXP DUP2 SLOAD DUP2 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF MUL NOT AND SWAP1 DUP4 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND MUL OR SWAP1 SSTORE POP PUSH32 0x2ED0FEB3E7FD2022120AA84FAB1945545A9F2FFC9076FD6156FA96EAFF4C1311 PUSH1 0x0 SHL PUSH1 0x15 SSTORE CALLVALUE DUP1 ISZERO PUSH3 0x195 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH1 0x13 PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH1 0x14 PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH1 0xA0 DUP2 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH1 0x60 SHL DUP2 MSTORE POP POP DUP1 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH1 0x80 DUP2 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH1 0x60 SHL DUP2 MSTORE POP POP POP POP PUSH1 0x12 PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH1 0x1 PUSH1 0x0 PUSH2 0x100 EXP DUP2 SLOAD DUP2 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF MUL NOT AND SWAP1 DUP4 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND MUL OR SWAP1 SSTORE POP CALLER PUSH1 0x9 PUSH1 0x0 PUSH2 0x100 EXP DUP2 SLOAD DUP2 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF MUL NOT AND SWAP1 DUP4 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND MUL OR SWAP1 SSTORE POP PUSH1 0x15 SLOAD PUSH1 0xE DUP2 SWAP1 SSTORE POP PUSH8 0x16345785D8A0000 PUSH1 0xF DUP2 SWAP1 SSTORE POP PUSH3 0x423 JUMP JUMPDEST DUP3 DUP1 SLOAD PUSH3 0x31C SWAP1 PUSH3 0x3BE JUMP JUMPDEST SWAP1 PUSH1 0x0 MSTORE PUSH1 0x20 PUSH1 0x0 KECCAK256 SWAP1 PUSH1 0x1F ADD PUSH1 0x20 SWAP1 DIV DUP2 ADD SWAP3 DUP3 PUSH3 0x340 JUMPI PUSH1 0x0 DUP6 SSTORE PUSH3 0x38C JUMP JUMPDEST DUP3 PUSH1 0x1F LT PUSH3 0x35B JUMPI DUP1 MLOAD PUSH1 0xFF NOT AND DUP4 DUP1 ADD OR DUP6 SSTORE PUSH3 0x38C JUMP JUMPDEST DUP3 DUP1 ADD PUSH1 0x1 ADD DUP6 SSTORE DUP3 ISZERO PUSH3 0x38C JUMPI SWAP2 DUP3 ADD JUMPDEST DUP3 DUP2 GT ISZERO PUSH3 0x38B JUMPI DUP3 MLOAD DUP3 SSTORE SWAP2 PUSH1 0x20 ADD SWAP2 SWAP1 PUSH1 0x1 ADD SWAP1 PUSH3 0x36E JUMP JUMPDEST JUMPDEST POP SWAP1 POP PUSH3 0x39B SWAP2 SWAP1 PUSH3 0x39F JUMP JUMPDEST POP SWAP1 JUMP JUMPDEST JUMPDEST DUP1 DUP3 GT ISZERO PUSH3 0x3BA JUMPI PUSH1 0x0 DUP2 PUSH1 0x0 SWAP1 SSTORE POP PUSH1 0x1 ADD PUSH3 0x3A0 JUMP JUMPDEST POP SWAP1 JUMP JUMPDEST PUSH1 0x0 PUSH1 0x2 DUP3 DIV SWAP1 POP PUSH1 0x1 DUP3 AND DUP1 PUSH3 0x3D7 JUMPI PUSH1 0x7F DUP3 AND SWAP2 POP JUMPDEST PUSH1 0x20 DUP3 LT DUP2 EQ ISZERO PUSH3 0x3EE JUMPI PUSH3 0x3ED PUSH3 0x3F4 JUMP JUMPDEST JUMPDEST POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH32 0x4E487B7100000000000000000000000000000000000000000000000000000000 PUSH1 0x0 MSTORE PUSH1 0x22 PUSH1 0x4 MSTORE PUSH1 0x24 PUSH1 0x0 REVERT JUMPDEST PUSH1 0x80 MLOAD PUSH1 0x60 SHR PUSH1 0xA0 MLOAD PUSH1 0x60 SHR PUSH2 0x1FFD PUSH3 0x46B PUSH1 0x0 CODECOPY PUSH1 0x0 DUP2 DUP2 PUSH2 0xD45 ADD MSTORE PUSH2 0x13AB ADD MSTORE PUSH1 0x0 DUP2 DUP2 PUSH2 0x991 ADD MSTORE DUP2 DUP2 PUSH2 0xA3C ADD MSTORE DUP2 DUP2 PUSH2 0x11AC ADD MSTORE PUSH2 0x136F ADD MSTORE PUSH2 0x1FFD PUSH1 0x0 RETURN INVALID PUSH1 0x80 PUSH1 0x40 MSTORE PUSH1 0x4 CALLDATASIZE LT PUSH2 0x181 JUMPI PUSH1 0x0 CALLDATALOAD PUSH1 0xE0 SHR DUP1 PUSH4 0x6BD5450A GT PUSH2 0xD1 JUMPI DUP1 PUSH4 0xA59F3E0C GT PUSH2 0x8A JUMPI DUP1 PUSH4 0xDBDFF2C1 GT PUSH2 0x64 JUMPI DUP1 PUSH4 0xDBDFF2C1 EQ PUSH2 0x5A6 JUMPI DUP1 PUSH4 0xE9820FA4 EQ PUSH2 0x5D1 JUMPI DUP1 PUSH4 0xEDF26D9B EQ PUSH2 0x60E JUMPI DUP1 PUSH4 0xF28F81D5 EQ PUSH2 0x64B JUMPI PUSH2 0x181 JUMP JUMPDEST DUP1 PUSH4 0xA59F3E0C EQ PUSH2 0x510 JUMPI DUP1 PUSH4 0xAAD44825 EQ PUSH2 0x52C JUMPI DUP1 PUSH4 0xD13FA88F EQ PUSH2 0x569 JUMPI PUSH2 0x181 JUMP JUMPDEST DUP1 PUSH4 0x6BD5450A EQ PUSH2 0x3DA JUMPI DUP1 PUSH4 0x89B08F11 EQ PUSH2 0x417 JUMPI DUP1 PUSH4 0x8AF0FA5E EQ PUSH2 0x454 JUMPI DUP1 PUSH4 0x8E15F473 EQ PUSH2 0x491 JUMPI DUP1 PUSH4 0x94985DDD EQ PUSH2 0x4BC JUMPI DUP1 PUSH4 0x9B10B924 EQ PUSH2 0x4E5 JUMPI PUSH2 0x181 JUMP JUMPDEST DUP1 PUSH4 0x3289A546 GT PUSH2 0x13E JUMPI DUP1 PUSH4 0x42E94C90 GT PUSH2 0x118 JUMPI DUP1 PUSH4 0x42E94C90 EQ PUSH2 0x30C JUMPI DUP1 PUSH4 0x5FD8C710 EQ PUSH2 0x349 JUMPI DUP1 PUSH4 0x62287C31 EQ PUSH2 0x360 JUMPI DUP1 PUSH4 0x635F6313 EQ PUSH2 0x39D JUMPI PUSH2 0x181 JUMP JUMPDEST DUP1 PUSH4 0x3289A546 EQ PUSH2 0x279 JUMPI DUP1 PUSH4 0x37C08923 EQ PUSH2 0x2B6 JUMPI DUP1 PUSH4 0x3F6FA655 EQ PUSH2 0x2E1 JUMPI PUSH2 0x181 JUMP JUMPDEST DUP1 PUSH4 0x6FDDE03 EQ PUSH2 0x186 JUMPI DUP1 PUSH4 0x12065FE0 EQ PUSH2 0x1B1 JUMPI DUP1 PUSH4 0x23C674D4 EQ PUSH2 0x1DC JUMPI DUP1 PUSH4 0x24CF4FEB EQ PUSH2 0x219 JUMPI DUP1 PUSH4 0x26A30E0C EQ PUSH2 0x244 JUMPI DUP1 PUSH4 0x2810E1D6 EQ PUSH2 0x26F JUMPI JUMPDEST PUSH1 0x0 DUP1 REVERT JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x192 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x19B PUSH2 0x688 JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x1A8 SWAP2 SWAP1 PUSH2 0x1A65 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x1BD JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x1C6 PUSH2 0x716 JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x1D3 SWAP2 SWAP1 PUSH2 0x1B47 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x1E8 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x203 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x1FE SWAP2 SWAP1 PUSH2 0x1666 JUMP JUMPDEST PUSH2 0x71E JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x210 SWAP2 SWAP1 PUSH2 0x1924 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x225 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x22E PUSH2 0x75D JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x23B SWAP2 SWAP1 PUSH2 0x1B47 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x250 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x259 PUSH2 0x763 JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x266 SWAP2 SWAP1 PUSH2 0x1B47 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST PUSH2 0x277 PUSH2 0x76D JUMP JUMPDEST STOP JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x285 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x2A0 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x29B SWAP2 SWAP1 PUSH2 0x15CC JUMP JUMPDEST PUSH2 0x85E JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x2AD SWAP2 SWAP1 PUSH2 0x1B47 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x2C2 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x2CB PUSH2 0x876 JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x2D8 SWAP2 SWAP1 PUSH2 0x1B47 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x2ED JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x2F6 PUSH2 0x87C JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x303 SWAP2 SWAP1 PUSH2 0x19A6 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x318 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x333 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x32E SWAP2 SWAP1 PUSH2 0x15CC JUMP JUMPDEST PUSH2 0x88F JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x340 SWAP2 SWAP1 PUSH2 0x1B47 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x355 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x35E PUSH2 0x8A7 JUMP JUMPDEST STOP JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x36C JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x387 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x382 SWAP2 SWAP1 PUSH2 0x15CC JUMP JUMPDEST PUSH2 0xB0D JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x394 SWAP2 SWAP1 PUSH2 0x19A6 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x3A9 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x3C4 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x3BF SWAP2 SWAP1 PUSH2 0x15CC JUMP JUMPDEST PUSH2 0xBB9 JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x3D1 SWAP2 SWAP1 PUSH2 0x1A65 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x3E6 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x401 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x3FC SWAP2 SWAP1 PUSH2 0x15CC JUMP JUMPDEST PUSH2 0xC0A JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x40E SWAP2 SWAP1 PUSH2 0x19A6 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x423 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x43E PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x439 SWAP2 SWAP1 PUSH2 0x15CC JUMP JUMPDEST PUSH2 0xC2A JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x44B SWAP2 SWAP1 PUSH2 0x19A6 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x460 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x47B PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x476 SWAP2 SWAP1 PUSH2 0x15CC JUMP JUMPDEST PUSH2 0xC4A JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x488 SWAP2 SWAP1 PUSH2 0x1B47 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x49D JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x4A6 PUSH2 0xC93 JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x4B3 SWAP2 SWAP1 PUSH2 0x1A4A JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x4C8 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x4E3 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x4DE SWAP2 SWAP1 PUSH2 0x1626 JUMP JUMPDEST PUSH2 0xD43 JUMP JUMPDEST STOP JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x4F1 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x4FA PUSH2 0xDDF JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x507 SWAP2 SWAP1 PUSH2 0x1B47 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST PUSH2 0x52A PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x525 SWAP2 SWAP1 PUSH2 0x1666 JUMP JUMPDEST PUSH2 0xDE5 JUMP JUMPDEST STOP JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x538 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x553 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x54E SWAP2 SWAP1 PUSH2 0x15CC JUMP JUMPDEST PUSH2 0x104A JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x560 SWAP2 SWAP1 PUSH2 0x1B47 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x575 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x590 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x58B SWAP2 SWAP1 PUSH2 0x1666 JUMP JUMPDEST PUSH2 0x1093 JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x59D SWAP2 SWAP1 PUSH2 0x1A65 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x5B2 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x5BB PUSH2 0x11A5 JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x5C8 SWAP2 SWAP1 PUSH2 0x19C1 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x5DD JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x5F8 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x5F3 SWAP2 SWAP1 PUSH2 0x15CC JUMP JUMPDEST PUSH2 0x12A7 JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x605 SWAP2 SWAP1 PUSH2 0x19A6 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x61A JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x635 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x630 SWAP2 SWAP1 PUSH2 0x1666 JUMP JUMPDEST PUSH2 0x12FD JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x642 SWAP2 SWAP1 PUSH2 0x1924 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x657 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x672 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x66D SWAP2 SWAP1 PUSH2 0x15CC JUMP JUMPDEST PUSH2 0x133C JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x67F SWAP2 SWAP1 PUSH2 0x1B47 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST PUSH1 0xD DUP1 SLOAD PUSH2 0x695 SWAP1 PUSH2 0x1C95 JUMP JUMPDEST DUP1 PUSH1 0x1F ADD PUSH1 0x20 DUP1 SWAP2 DIV MUL PUSH1 0x20 ADD PUSH1 0x40 MLOAD SWAP1 DUP2 ADD PUSH1 0x40 MSTORE DUP1 SWAP3 SWAP2 SWAP1 DUP2 DUP2 MSTORE PUSH1 0x20 ADD DUP3 DUP1 SLOAD PUSH2 0x6C1 SWAP1 PUSH2 0x1C95 JUMP JUMPDEST DUP1 ISZERO PUSH2 0x70E JUMPI DUP1 PUSH1 0x1F LT PUSH2 0x6E3 JUMPI PUSH2 0x100 DUP1 DUP4 SLOAD DIV MUL DUP4 MSTORE SWAP2 PUSH1 0x20 ADD SWAP2 PUSH2 0x70E JUMP JUMPDEST DUP3 ADD SWAP2 SWAP1 PUSH1 0x0 MSTORE PUSH1 0x20 PUSH1 0x0 KECCAK256 SWAP1 JUMPDEST DUP2 SLOAD DUP2 MSTORE SWAP1 PUSH1 0x1 ADD SWAP1 PUSH1 0x20 ADD DUP1 DUP4 GT PUSH2 0x6F1 JUMPI DUP3 SWAP1 SUB PUSH1 0x1F AND DUP3 ADD SWAP2 JUMPDEST POP POP POP POP POP DUP2 JUMP JUMPDEST PUSH1 0x0 SELFBALANCE SWAP1 POP SWAP1 JUMP JUMPDEST PUSH1 0x6 DUP2 DUP2 SLOAD DUP2 LT PUSH2 0x72E JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST SWAP1 PUSH1 0x0 MSTORE PUSH1 0x20 PUSH1 0x0 KECCAK256 ADD PUSH1 0x0 SWAP2 POP SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 JUMP JUMPDEST PUSH1 0xC SLOAD DUP2 JUMP JUMPDEST PUSH1 0x0 PUSH1 0x11 SLOAD SWAP1 POP SWAP1 JUMP JUMPDEST PUSH1 0x9 PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND CALLER PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND EQ PUSH2 0x7FD JUMPI PUSH1 0x40 MLOAD PUSH32 0x8C379A000000000000000000000000000000000000000000000000000000000 DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0x7F4 SWAP1 PUSH2 0x1AA7 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 REVERT JUMPDEST PUSH1 0x0 ISZERO ISZERO PUSH1 0xB PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH1 0xFF AND ISZERO ISZERO EQ PUSH2 0x853 JUMPI PUSH1 0x40 MLOAD PUSH32 0x8C379A000000000000000000000000000000000000000000000000000000000 DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0x84A SWAP1 PUSH2 0x1A87 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 REVERT JUMPDEST PUSH2 0x85B PUSH2 0x11A5 JUMP JUMPDEST POP JUMP JUMPDEST PUSH1 0x5 PUSH1 0x20 MSTORE DUP1 PUSH1 0x0 MSTORE PUSH1 0x40 PUSH1 0x0 KECCAK256 PUSH1 0x0 SWAP2 POP SWAP1 POP SLOAD DUP2 JUMP JUMPDEST PUSH1 0xA SLOAD DUP2 JUMP JUMPDEST PUSH1 0xB PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH1 0xFF AND DUP2 JUMP JUMPDEST PUSH1 0x8 PUSH1 0x20 MSTORE DUP1 PUSH1 0x0 MSTORE PUSH1 0x40 PUSH1 0x0 KECCAK256 PUSH1 0x0 SWAP2 POP SWAP1 POP SLOAD DUP2 JUMP JUMPDEST PUSH1 0x9 PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND CALLER PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND EQ PUSH2 0x937 JUMPI PUSH1 0x40 MLOAD PUSH32 0x8C379A000000000000000000000000000000000000000000000000000000000 DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0x92E SWAP1 PUSH2 0x1AA7 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 REVERT JUMPDEST PUSH1 0x1 ISZERO ISZERO PUSH1 0xB PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH1 0xFF AND ISZERO ISZERO EQ PUSH2 0x98D JUMPI PUSH1 0x40 MLOAD PUSH32 0x8C379A000000000000000000000000000000000000000000000000000000000 DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0x984 SWAP1 PUSH2 0x1B07 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 REVERT JUMPDEST PUSH1 0x0 PUSH32 0x0 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH4 0x70A08231 ADDRESS PUSH1 0x40 MLOAD DUP3 PUSH4 0xFFFFFFFF AND PUSH1 0xE0 SHL DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0x9E8 SWAP2 SWAP1 PUSH2 0x1924 JUMP JUMPDEST PUSH1 0x20 PUSH1 0x40 MLOAD DUP1 DUP4 SUB DUP2 DUP7 DUP1 EXTCODESIZE ISZERO DUP1 ISZERO PUSH2 0xA00 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP GAS STATICCALL ISZERO DUP1 ISZERO PUSH2 0xA14 JUMPI RETURNDATASIZE PUSH1 0x0 DUP1 RETURNDATACOPY RETURNDATASIZE PUSH1 0x0 REVERT JUMPDEST POP POP POP POP PUSH1 0x40 MLOAD RETURNDATASIZE PUSH1 0x1F NOT PUSH1 0x1F DUP3 ADD AND DUP3 ADD DUP1 PUSH1 0x40 MSTORE POP DUP2 ADD SWAP1 PUSH2 0xA38 SWAP2 SWAP1 PUSH2 0x1693 JUMP JUMPDEST SWAP1 POP PUSH32 0x0 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH4 0xA9059CBB PUSH1 0x9 PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP4 PUSH1 0x40 MLOAD DUP4 PUSH4 0xFFFFFFFF AND PUSH1 0xE0 SHL DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0xAB7 SWAP3 SWAP2 SWAP1 PUSH2 0x193F JUMP JUMPDEST PUSH1 0x20 PUSH1 0x40 MLOAD DUP1 DUP4 SUB DUP2 PUSH1 0x0 DUP8 DUP1 EXTCODESIZE ISZERO DUP1 ISZERO PUSH2 0xAD1 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP GAS CALL ISZERO DUP1 ISZERO PUSH2 0xAE5 JUMPI RETURNDATASIZE PUSH1 0x0 DUP1 RETURNDATACOPY RETURNDATASIZE PUSH1 0x0 REVERT JUMPDEST POP POP POP POP PUSH1 0x40 MLOAD RETURNDATASIZE PUSH1 0x1F NOT PUSH1 0x1F DUP3 ADD AND DUP3 ADD DUP1 PUSH1 0x40 MSTORE POP DUP2 ADD SWAP1 PUSH2 0xB09 SWAP2 SWAP1 PUSH2 0x15F9 JUMP JUMPDEST POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x1 ISZERO ISZERO PUSH1 0xB PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH1 0xFF AND ISZERO ISZERO EQ PUSH2 0xB65 JUMPI PUSH1 0x40 MLOAD PUSH32 0x8C379A000000000000000000000000000000000000000000000000000000000 DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0xB5C SWAP1 PUSH2 0x1B07 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 REVERT JUMPDEST PUSH1 0x4 PUSH1 0x0 DUP4 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH1 0xFF AND SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x60 PUSH2 0xC03 PUSH1 0x7 PUSH1 0x0 DUP5 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 SLOAD PUSH2 0x1093 JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x4 PUSH1 0x20 MSTORE DUP1 PUSH1 0x0 MSTORE PUSH1 0x40 PUSH1 0x0 KECCAK256 PUSH1 0x0 SWAP2 POP SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH1 0xFF AND DUP2 JUMP JUMPDEST PUSH1 0x2 PUSH1 0x20 MSTORE DUP1 PUSH1 0x0 MSTORE PUSH1 0x40 PUSH1 0x0 KECCAK256 PUSH1 0x0 SWAP2 POP SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH1 0xFF AND DUP2 JUMP JUMPDEST PUSH1 0x0 PUSH1 0x8 PUSH1 0x0 DUP4 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 SLOAD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 DUP1 PUSH1 0x1 PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH4 0xFEAF968C PUSH1 0x40 MLOAD DUP2 PUSH4 0xFFFFFFFF AND PUSH1 0xE0 SHL DUP2 MSTORE PUSH1 0x4 ADD PUSH1 0xA0 PUSH1 0x40 MLOAD DUP1 DUP4 SUB DUP2 DUP7 DUP1 EXTCODESIZE ISZERO DUP1 ISZERO PUSH2 0xCFE JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP GAS STATICCALL ISZERO DUP1 ISZERO PUSH2 0xD12 JUMPI RETURNDATASIZE PUSH1 0x0 DUP1 RETURNDATACOPY RETURNDATASIZE PUSH1 0x0 REVERT JUMPDEST POP POP POP POP PUSH1 0x40 MLOAD RETURNDATASIZE PUSH1 0x1F NOT PUSH1 0x1F DUP3 ADD AND DUP3 ADD DUP1 PUSH1 0x40 MSTORE POP DUP2 ADD SWAP1 PUSH2 0xD36 SWAP2 SWAP1 PUSH2 0x16C0 JUMP JUMPDEST POP POP POP SWAP2 POP POP DUP1 SWAP2 POP POP SWAP1 JUMP JUMPDEST PUSH32 0x0 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND CALLER PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND EQ PUSH2 0xDD1 JUMPI PUSH1 0x40 MLOAD PUSH32 0x8C379A000000000000000000000000000000000000000000000000000000000 DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0xDC8 SWAP1 PUSH2 0x1B27 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 REVERT JUMPDEST PUSH2 0xDDB DUP3 DUP3 PUSH2 0x1354 JUMP JUMPDEST POP POP JUMP JUMPDEST PUSH1 0x10 SLOAD DUP2 JUMP JUMPDEST PUSH1 0xC SLOAD CALLVALUE GT PUSH2 0xE29 JUMPI PUSH1 0x40 MLOAD PUSH32 0x8C379A000000000000000000000000000000000000000000000000000000000 DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0xE20 SWAP1 PUSH2 0x1AE7 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 REVERT JUMPDEST PUSH1 0x0 ISZERO ISZERO PUSH1 0xB PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH1 0xFF AND ISZERO ISZERO EQ PUSH2 0xE7F JUMPI PUSH1 0x40 MLOAD PUSH32 0x8C379A000000000000000000000000000000000000000000000000000000000 DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0xE76 SWAP1 PUSH2 0x1A87 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 REVERT JUMPDEST PUSH1 0x0 ISZERO ISZERO PUSH1 0x2 PUSH1 0x0 CALLER PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH1 0xFF AND ISZERO ISZERO EQ ISZERO PUSH2 0xF3C JUMPI PUSH1 0x3 CALLER SWAP1 DUP1 PUSH1 0x1 DUP2 SLOAD ADD DUP1 DUP3 SSTORE DUP1 SWAP2 POP POP PUSH1 0x1 SWAP1 SUB SWAP1 PUSH1 0x0 MSTORE PUSH1 0x20 PUSH1 0x0 KECCAK256 ADD PUSH1 0x0 SWAP1 SWAP2 SWAP1 SWAP2 SWAP1 SWAP2 PUSH2 0x100 EXP DUP2 SLOAD DUP2 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF MUL NOT AND SWAP1 DUP4 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND MUL OR SWAP1 SSTORE POP JUMPDEST PUSH1 0x1 PUSH1 0x2 PUSH1 0x0 CALLER PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 PUSH1 0x0 PUSH2 0x100 EXP DUP2 SLOAD DUP2 PUSH1 0xFF MUL NOT AND SWAP1 DUP4 ISZERO ISZERO MUL OR SWAP1 SSTORE POP DUP1 PUSH1 0x7 PUSH1 0x0 CALLER PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 DUP2 SWAP1 SSTORE POP CALLVALUE PUSH1 0x8 PUSH1 0x0 CALLER PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 PUSH1 0x0 DUP3 DUP3 SLOAD PUSH2 0x1027 SWAP2 SWAP1 PUSH2 0x1B9A JUMP JUMPDEST SWAP3 POP POP DUP2 SWAP1 SSTORE POP CALLVALUE PUSH1 0xA PUSH1 0x0 DUP3 DUP3 SLOAD PUSH2 0x1040 SWAP2 SWAP1 PUSH2 0x1B9A JUMP JUMPDEST SWAP3 POP POP DUP2 SWAP1 SSTORE POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x5 PUSH1 0x0 DUP4 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 SLOAD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x60 PUSH1 0x1 DUP3 EQ ISZERO PUSH2 0x10DB JUMPI PUSH1 0x40 MLOAD DUP1 PUSH1 0x40 ADD PUSH1 0x40 MSTORE DUP1 PUSH1 0x3 DUP2 MSTORE PUSH1 0x20 ADD PUSH32 0x4F6E650000000000000000000000000000000000000000000000000000000000 DUP2 MSTORE POP SWAP1 POP PUSH2 0x11A0 JUMP JUMPDEST PUSH1 0x2 DUP3 EQ ISZERO PUSH2 0x1121 JUMPI PUSH1 0x40 MLOAD DUP1 PUSH1 0x40 ADD PUSH1 0x40 MSTORE DUP1 PUSH1 0x3 DUP2 MSTORE PUSH1 0x20 ADD PUSH32 0x54776F0000000000000000000000000000000000000000000000000000000000 DUP2 MSTORE POP SWAP1 POP PUSH2 0x11A0 JUMP JUMPDEST PUSH1 0x3 DUP3 EQ ISZERO PUSH2 0x1167 JUMPI PUSH1 0x40 MLOAD DUP1 PUSH1 0x40 ADD PUSH1 0x40 MSTORE DUP1 PUSH1 0x5 DUP2 MSTORE PUSH1 0x20 ADD PUSH32 0x5468726565000000000000000000000000000000000000000000000000000000 DUP2 MSTORE POP SWAP1 POP PUSH2 0x11A0 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 PUSH1 0x40 ADD PUSH1 0x40 MSTORE DUP1 PUSH1 0x4 DUP2 MSTORE PUSH1 0x20 ADD PUSH32 0x466F757200000000000000000000000000000000000000000000000000000000 DUP2 MSTORE POP SWAP1 POP JUMPDEST SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0xF SLOAD PUSH32 0x0 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH4 0x70A08231 ADDRESS PUSH1 0x40 MLOAD DUP3 PUSH4 0xFFFFFFFF AND PUSH1 0xE0 SHL DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0x1203 SWAP2 SWAP1 PUSH2 0x1924 JUMP JUMPDEST PUSH1 0x20 PUSH1 0x40 MLOAD DUP1 DUP4 SUB DUP2 DUP7 DUP1 EXTCODESIZE ISZERO DUP1 ISZERO PUSH2 0x121B JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP GAS STATICCALL ISZERO DUP1 ISZERO PUSH2 0x122F JUMPI RETURNDATASIZE PUSH1 0x0 DUP1 RETURNDATACOPY RETURNDATASIZE PUSH1 0x0 REVERT JUMPDEST POP POP POP POP PUSH1 0x40 MLOAD RETURNDATASIZE PUSH1 0x1F NOT PUSH1 0x1F DUP3 ADD AND DUP3 ADD DUP1 PUSH1 0x40 MSTORE POP DUP2 ADD SWAP1 PUSH2 0x1253 SWAP2 SWAP1 PUSH2 0x1693 JUMP JUMPDEST LT ISZERO PUSH2 0x1294 JUMPI PUSH1 0x40 MLOAD PUSH32 0x8C379A000000000000000000000000000000000000000000000000000000000 DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0x128B SWAP1 PUSH2 0x1AC7 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 REVERT JUMPDEST PUSH2 0x12A2 PUSH1 0xE SLOAD PUSH1 0xF SLOAD PUSH2 0x136B JUMP JUMPDEST SWAP1 POP SWAP1 JUMP JUMPDEST PUSH1 0x0 PUSH1 0x2 PUSH1 0x0 DUP4 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH1 0xFF AND SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x3 DUP2 DUP2 SLOAD DUP2 LT PUSH2 0x130D JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST SWAP1 PUSH1 0x0 MSTORE PUSH1 0x20 PUSH1 0x0 KECCAK256 ADD PUSH1 0x0 SWAP2 POP SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 JUMP JUMPDEST PUSH1 0x7 PUSH1 0x20 MSTORE DUP1 PUSH1 0x0 MSTORE PUSH1 0x40 PUSH1 0x0 KECCAK256 PUSH1 0x0 SWAP2 POP SWAP1 POP SLOAD DUP2 JUMP JUMPDEST PUSH1 0x4 DUP2 PUSH2 0x1361 SWAP2 SWAP1 PUSH2 0x1CDB JUMP JUMPDEST PUSH1 0x10 DUP2 SWAP1 SSTORE POP POP POP JUMP JUMPDEST PUSH1 0x0 PUSH32 0x0 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH4 0x4000AEA0 PUSH32 0x0 DUP5 DUP7 PUSH1 0x0 PUSH1 0x40 MLOAD PUSH1 0x20 ADD PUSH2 0x13DF SWAP3 SWAP2 SWAP1 PUSH2 0x19DC JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH1 0x20 DUP2 DUP4 SUB SUB DUP2 MSTORE SWAP1 PUSH1 0x40 MSTORE PUSH1 0x40 MLOAD DUP5 PUSH4 0xFFFFFFFF AND PUSH1 0xE0 SHL DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0x140C SWAP4 SWAP3 SWAP2 SWAP1 PUSH2 0x1968 JUMP JUMPDEST PUSH1 0x20 PUSH1 0x40 MLOAD DUP1 DUP4 SUB DUP2 PUSH1 0x0 DUP8 DUP1 EXTCODESIZE ISZERO DUP1 ISZERO PUSH2 0x1426 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP GAS CALL ISZERO DUP1 ISZERO PUSH2 0x143A JUMPI RETURNDATASIZE PUSH1 0x0 DUP1 RETURNDATACOPY RETURNDATASIZE PUSH1 0x0 REVERT JUMPDEST POP POP POP POP PUSH1 0x40 MLOAD RETURNDATASIZE PUSH1 0x1F NOT PUSH1 0x1F DUP3 ADD AND DUP3 ADD DUP1 PUSH1 0x40 MSTORE POP DUP2 ADD SWAP1 PUSH2 0x145E SWAP2 SWAP1 PUSH2 0x15F9 JUMP JUMPDEST POP PUSH1 0x0 PUSH2 0x1480 DUP5 PUSH1 0x0 ADDRESS PUSH1 0x0 DUP1 DUP10 DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 SLOAD PUSH2 0x14CA JUMP JUMPDEST SWAP1 POP PUSH1 0x1 PUSH1 0x0 DUP1 DUP7 DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 SLOAD PUSH2 0x14A1 SWAP2 SWAP1 PUSH2 0x1B9A JUMP JUMPDEST PUSH1 0x0 DUP1 DUP7 DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 DUP2 SWAP1 SSTORE POP PUSH2 0x14C1 DUP5 DUP3 PUSH2 0x1506 JUMP JUMPDEST SWAP2 POP POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP5 DUP5 DUP5 DUP5 PUSH1 0x40 MLOAD PUSH1 0x20 ADD PUSH2 0x14E3 SWAP5 SWAP4 SWAP3 SWAP2 SWAP1 PUSH2 0x1A05 JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH1 0x20 DUP2 DUP4 SUB SUB DUP2 MSTORE SWAP1 PUSH1 0x40 MSTORE DUP1 MLOAD SWAP1 PUSH1 0x20 ADD KECCAK256 PUSH1 0x0 SHR SWAP1 POP SWAP5 SWAP4 POP POP POP POP JUMP JUMPDEST PUSH1 0x0 DUP3 DUP3 PUSH1 0x40 MLOAD PUSH1 0x20 ADD PUSH2 0x151B SWAP3 SWAP2 SWAP1 PUSH2 0x18F8 JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH1 0x20 DUP2 DUP4 SUB SUB DUP2 MSTORE SWAP1 PUSH1 0x40 MSTORE DUP1 MLOAD SWAP1 PUSH1 0x20 ADD KECCAK256 SWAP1 POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP2 CALLDATALOAD SWAP1 POP PUSH2 0x1548 DUP2 PUSH2 0x1F3D JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP2 MLOAD SWAP1 POP PUSH2 0x155D DUP2 PUSH2 0x1F54 JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP2 CALLDATALOAD SWAP1 POP PUSH2 0x1572 DUP2 PUSH2 0x1F6B JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP2 MLOAD SWAP1 POP PUSH2 0x1587 DUP2 PUSH2 0x1F82 JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP2 CALLDATALOAD SWAP1 POP PUSH2 0x159C DUP2 PUSH2 0x1F99 JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP2 MLOAD SWAP1 POP PUSH2 0x15B1 DUP2 PUSH2 0x1F99 JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP2 MLOAD SWAP1 POP PUSH2 0x15C6 DUP2 PUSH2 0x1FB0 JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 DUP5 SUB SLT ISZERO PUSH2 0x15E2 JUMPI PUSH2 0x15E1 PUSH2 0x1D99 JUMP JUMPDEST JUMPDEST PUSH1 0x0 PUSH2 0x15F0 DUP5 DUP3 DUP6 ADD PUSH2 0x1539 JUMP JUMPDEST SWAP2 POP POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 DUP5 SUB SLT ISZERO PUSH2 0x160F JUMPI PUSH2 0x160E PUSH2 0x1D99 JUMP JUMPDEST JUMPDEST PUSH1 0x0 PUSH2 0x161D DUP5 DUP3 DUP6 ADD PUSH2 0x154E JUMP JUMPDEST SWAP2 POP POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP1 PUSH1 0x40 DUP4 DUP6 SUB SLT ISZERO PUSH2 0x163D JUMPI PUSH2 0x163C PUSH2 0x1D99 JUMP JUMPDEST JUMPDEST PUSH1 0x0 PUSH2 0x164B DUP6 DUP3 DUP7 ADD PUSH2 0x1563 JUMP JUMPDEST SWAP3 POP POP PUSH1 0x20 PUSH2 0x165C DUP6 DUP3 DUP7 ADD PUSH2 0x158D JUMP JUMPDEST SWAP2 POP POP SWAP3 POP SWAP3 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 DUP5 SUB SLT ISZERO PUSH2 0x167C JUMPI PUSH2 0x167B PUSH2 0x1D99 JUMP JUMPDEST JUMPDEST PUSH1 0x0 PUSH2 0x168A DUP5 DUP3 DUP6 ADD PUSH2 0x158D JUMP JUMPDEST SWAP2 POP POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 DUP5 SUB SLT ISZERO PUSH2 0x16A9 JUMPI PUSH2 0x16A8 PUSH2 0x1D99 JUMP JUMPDEST JUMPDEST PUSH1 0x0 PUSH2 0x16B7 DUP5 DUP3 DUP6 ADD PUSH2 0x15A2 JUMP JUMPDEST SWAP2 POP POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP1 PUSH1 0x0 DUP1 PUSH1 0x0 PUSH1 0xA0 DUP7 DUP9 SUB SLT ISZERO PUSH2 0x16DC JUMPI PUSH2 0x16DB PUSH2 0x1D99 JUMP JUMPDEST JUMPDEST PUSH1 0x0 PUSH2 0x16EA DUP9 DUP3 DUP10 ADD PUSH2 0x15B7 JUMP JUMPDEST SWAP6 POP POP PUSH1 0x20 PUSH2 0x16FB DUP9 DUP3 DUP10 ADD PUSH2 0x1578 JUMP JUMPDEST SWAP5 POP POP PUSH1 0x40 PUSH2 0x170C DUP9 DUP3 DUP10 ADD PUSH2 0x15A2 JUMP JUMPDEST SWAP4 POP POP PUSH1 0x60 PUSH2 0x171D DUP9 DUP3 DUP10 ADD PUSH2 0x15A2 JUMP JUMPDEST SWAP3 POP POP PUSH1 0x80 PUSH2 0x172E DUP9 DUP3 DUP10 ADD PUSH2 0x15B7 JUMP JUMPDEST SWAP2 POP POP SWAP3 SWAP6 POP SWAP3 SWAP6 SWAP1 SWAP4 POP JUMP JUMPDEST PUSH2 0x1744 DUP2 PUSH2 0x1BF0 JUMP JUMPDEST DUP3 MSTORE POP POP JUMP JUMPDEST PUSH2 0x1753 DUP2 PUSH2 0x1C02 JUMP JUMPDEST DUP3 MSTORE POP POP JUMP JUMPDEST PUSH2 0x1762 DUP2 PUSH2 0x1C0E JUMP JUMPDEST DUP3 MSTORE POP POP JUMP JUMPDEST PUSH2 0x1779 PUSH2 0x1774 DUP3 PUSH2 0x1C0E JUMP JUMPDEST PUSH2 0x1CC7 JUMP JUMPDEST DUP3 MSTORE POP POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x178A DUP3 PUSH2 0x1B62 JUMP JUMPDEST PUSH2 0x1794 DUP2 DUP6 PUSH2 0x1B78 JUMP JUMPDEST SWAP4 POP PUSH2 0x17A4 DUP2 DUP6 PUSH1 0x20 DUP7 ADD PUSH2 0x1C62 JUMP JUMPDEST PUSH2 0x17AD DUP2 PUSH2 0x1D9E JUMP JUMPDEST DUP5 ADD SWAP2 POP POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH2 0x17C1 DUP2 PUSH2 0x1C18 JUMP JUMPDEST DUP3 MSTORE POP POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x17D2 DUP3 PUSH2 0x1B6D JUMP JUMPDEST PUSH2 0x17DC DUP2 DUP6 PUSH2 0x1B89 JUMP JUMPDEST SWAP4 POP PUSH2 0x17EC DUP2 DUP6 PUSH1 0x20 DUP7 ADD PUSH2 0x1C62 JUMP JUMPDEST PUSH2 0x17F5 DUP2 PUSH2 0x1D9E JUMP JUMPDEST DUP5 ADD SWAP2 POP POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x180D PUSH1 0x23 DUP4 PUSH2 0x1B89 JUMP JUMPDEST SWAP2 POP PUSH2 0x1818 DUP3 PUSH2 0x1DAF JUMP JUMPDEST PUSH1 0x40 DUP3 ADD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x1830 PUSH1 0x15 DUP4 PUSH2 0x1B89 JUMP JUMPDEST SWAP2 POP PUSH2 0x183B DUP3 PUSH2 0x1DFE JUMP JUMPDEST PUSH1 0x20 DUP3 ADD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x1853 PUSH1 0x2B DUP4 PUSH2 0x1B89 JUMP JUMPDEST SWAP2 POP PUSH2 0x185E DUP3 PUSH2 0x1E27 JUMP JUMPDEST PUSH1 0x40 DUP3 ADD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x1876 PUSH1 0x24 DUP4 PUSH2 0x1B89 JUMP JUMPDEST SWAP2 POP PUSH2 0x1881 DUP3 PUSH2 0x1E76 JUMP JUMPDEST PUSH1 0x40 DUP3 ADD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x1899 PUSH1 0x22 DUP4 PUSH2 0x1B89 JUMP JUMPDEST SWAP2 POP PUSH2 0x18A4 DUP3 PUSH2 0x1EC5 JUMP JUMPDEST PUSH1 0x40 DUP3 ADD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x18BC PUSH1 0x1F DUP4 PUSH2 0x1B89 JUMP JUMPDEST SWAP2 POP PUSH2 0x18C7 DUP3 PUSH2 0x1F14 JUMP JUMPDEST PUSH1 0x20 DUP3 ADD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH2 0x18DB DUP2 PUSH2 0x1C42 JUMP JUMPDEST DUP3 MSTORE POP POP JUMP JUMPDEST PUSH2 0x18F2 PUSH2 0x18ED DUP3 PUSH2 0x1C42 JUMP JUMPDEST PUSH2 0x1CD1 JUMP JUMPDEST DUP3 MSTORE POP POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x1904 DUP3 DUP6 PUSH2 0x1768 JUMP JUMPDEST PUSH1 0x20 DUP3 ADD SWAP2 POP PUSH2 0x1914 DUP3 DUP5 PUSH2 0x18E1 JUMP JUMPDEST PUSH1 0x20 DUP3 ADD SWAP2 POP DUP2 SWAP1 POP SWAP4 SWAP3 POP POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP PUSH2 0x1939 PUSH1 0x0 DUP4 ADD DUP5 PUSH2 0x173B JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x40 DUP3 ADD SWAP1 POP PUSH2 0x1954 PUSH1 0x0 DUP4 ADD DUP6 PUSH2 0x173B JUMP JUMPDEST PUSH2 0x1961 PUSH1 0x20 DUP4 ADD DUP5 PUSH2 0x18D2 JUMP JUMPDEST SWAP4 SWAP3 POP POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x60 DUP3 ADD SWAP1 POP PUSH2 0x197D PUSH1 0x0 DUP4 ADD DUP7 PUSH2 0x173B JUMP JUMPDEST PUSH2 0x198A PUSH1 0x20 DUP4 ADD DUP6 PUSH2 0x18D2 JUMP JUMPDEST DUP2 DUP2 SUB PUSH1 0x40 DUP4 ADD MSTORE PUSH2 0x199C DUP2 DUP5 PUSH2 0x177F JUMP JUMPDEST SWAP1 POP SWAP5 SWAP4 POP POP POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP PUSH2 0x19BB PUSH1 0x0 DUP4 ADD DUP5 PUSH2 0x174A JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP PUSH2 0x19D6 PUSH1 0x0 DUP4 ADD DUP5 PUSH2 0x1759 JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x40 DUP3 ADD SWAP1 POP PUSH2 0x19F1 PUSH1 0x0 DUP4 ADD DUP6 PUSH2 0x1759 JUMP JUMPDEST PUSH2 0x19FE PUSH1 0x20 DUP4 ADD DUP5 PUSH2 0x18D2 JUMP JUMPDEST SWAP4 SWAP3 POP POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x80 DUP3 ADD SWAP1 POP PUSH2 0x1A1A PUSH1 0x0 DUP4 ADD DUP8 PUSH2 0x1759 JUMP JUMPDEST PUSH2 0x1A27 PUSH1 0x20 DUP4 ADD DUP7 PUSH2 0x18D2 JUMP JUMPDEST PUSH2 0x1A34 PUSH1 0x40 DUP4 ADD DUP6 PUSH2 0x173B JUMP JUMPDEST PUSH2 0x1A41 PUSH1 0x60 DUP4 ADD DUP5 PUSH2 0x18D2 JUMP JUMPDEST SWAP6 SWAP5 POP POP POP POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP PUSH2 0x1A5F PUSH1 0x0 DUP4 ADD DUP5 PUSH2 0x17B8 JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP DUP2 DUP2 SUB PUSH1 0x0 DUP4 ADD MSTORE PUSH2 0x1A7F DUP2 DUP5 PUSH2 0x17C7 JUMP JUMPDEST SWAP1 POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP DUP2 DUP2 SUB PUSH1 0x0 DUP4 ADD MSTORE PUSH2 0x1AA0 DUP2 PUSH2 0x1800 JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP DUP2 DUP2 SUB PUSH1 0x0 DUP4 ADD MSTORE PUSH2 0x1AC0 DUP2 PUSH2 0x1823 JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP DUP2 DUP2 SUB PUSH1 0x0 DUP4 ADD MSTORE PUSH2 0x1AE0 DUP2 PUSH2 0x1846 JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP DUP2 DUP2 SUB PUSH1 0x0 DUP4 ADD MSTORE PUSH2 0x1B00 DUP2 PUSH2 0x1869 JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP DUP2 DUP2 SUB PUSH1 0x0 DUP4 ADD MSTORE PUSH2 0x1B20 DUP2 PUSH2 0x188C JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP DUP2 DUP2 SUB PUSH1 0x0 DUP4 ADD MSTORE PUSH2 0x1B40 DUP2 PUSH2 0x18AF JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP PUSH2 0x1B5C PUSH1 0x0 DUP4 ADD DUP5 PUSH2 0x18D2 JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP2 MLOAD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 DUP2 MLOAD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 DUP3 DUP3 MSTORE PUSH1 0x20 DUP3 ADD SWAP1 POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP3 DUP3 MSTORE PUSH1 0x20 DUP3 ADD SWAP1 POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x1BA5 DUP3 PUSH2 0x1C42 JUMP JUMPDEST SWAP2 POP PUSH2 0x1BB0 DUP4 PUSH2 0x1C42 JUMP JUMPDEST SWAP3 POP DUP3 PUSH32 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF SUB DUP3 GT ISZERO PUSH2 0x1BE5 JUMPI PUSH2 0x1BE4 PUSH2 0x1D0C JUMP JUMPDEST JUMPDEST DUP3 DUP3 ADD SWAP1 POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x1BFB DUP3 PUSH2 0x1C22 JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 DUP2 ISZERO ISZERO SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 DUP2 SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 DUP2 SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF DUP3 AND SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 DUP2 SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH10 0xFFFFFFFFFFFFFFFFFFFF DUP3 AND SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 JUMPDEST DUP4 DUP2 LT ISZERO PUSH2 0x1C80 JUMPI DUP1 DUP3 ADD MLOAD DUP2 DUP5 ADD MSTORE PUSH1 0x20 DUP2 ADD SWAP1 POP PUSH2 0x1C65 JUMP JUMPDEST DUP4 DUP2 GT ISZERO PUSH2 0x1C8F JUMPI PUSH1 0x0 DUP5 DUP5 ADD MSTORE JUMPDEST POP POP POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x2 DUP3 DIV SWAP1 POP PUSH1 0x1 DUP3 AND DUP1 PUSH2 0x1CAD JUMPI PUSH1 0x7F DUP3 AND SWAP2 POP JUMPDEST PUSH1 0x20 DUP3 LT DUP2 EQ ISZERO PUSH2 0x1CC1 JUMPI PUSH2 0x1CC0 PUSH2 0x1D6A JUMP JUMPDEST JUMPDEST POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 DUP2 SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 DUP2 SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x1CE6 DUP3 PUSH2 0x1C42 JUMP JUMPDEST SWAP2 POP PUSH2 0x1CF1 DUP4 PUSH2 0x1C42 JUMP JUMPDEST SWAP3 POP DUP3 PUSH2 0x1D01 JUMPI PUSH2 0x1D00 PUSH2 0x1D3B JUMP JUMPDEST JUMPDEST DUP3 DUP3 MOD SWAP1 POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH32 0x4E487B7100000000000000000000000000000000000000000000000000000000 PUSH1 0x0 MSTORE PUSH1 0x11 PUSH1 0x4 MSTORE PUSH1 0x24 PUSH1 0x0 REVERT JUMPDEST PUSH32 0x4E487B7100000000000000000000000000000000000000000000000000000000 PUSH1 0x0 MSTORE PUSH1 0x12 PUSH1 0x4 MSTORE PUSH1 0x24 PUSH1 0x0 REVERT JUMPDEST PUSH32 0x4E487B7100000000000000000000000000000000000000000000000000000000 PUSH1 0x0 MSTORE PUSH1 0x22 PUSH1 0x4 MSTORE PUSH1 0x24 PUSH1 0x0 REVERT JUMPDEST PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH1 0x0 PUSH1 0x1F NOT PUSH1 0x1F DUP4 ADD AND SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH32 0x5468697320636F6E74726163742077617320616C7265616479207265736F6C76 PUSH1 0x0 DUP3 ADD MSTORE PUSH32 0x6564210000000000000000000000000000000000000000000000000000000000 PUSH1 0x20 DUP3 ADD MSTORE POP JUMP JUMPDEST PUSH32 0x596F75277265206E6F7420746865206F776E6572210000000000000000000000 PUSH1 0x0 DUP3 ADD MSTORE POP JUMP JUMPDEST PUSH32 0x4E6F7420656E6F756768204C494E4B202D2066696C6C20636F6E747261637420 PUSH1 0x0 DUP3 ADD MSTORE PUSH32 0x7769746820666175636574000000000000000000000000000000000000000000 PUSH1 0x20 DUP3 ADD MSTORE POP JUMP JUMPDEST PUSH32 0x596F75206861766520746F20656E746572206D696E696D756D20302E30312045 PUSH1 0x0 DUP3 ADD MSTORE PUSH32 0x7468657200000000000000000000000000000000000000000000000000000000 PUSH1 0x20 DUP3 ADD MSTORE POP JUMP JUMPDEST PUSH32 0x5468697320636F6E7472616374206973206E6F74207265736F6C766564207965 PUSH1 0x0 DUP3 ADD MSTORE PUSH32 0x7421000000000000000000000000000000000000000000000000000000000000 PUSH1 0x20 DUP3 ADD MSTORE POP JUMP JUMPDEST PUSH32 0x4F6E6C7920565246436F6F7264696E61746F722063616E2066756C66696C6C00 PUSH1 0x0 DUP3 ADD MSTORE POP JUMP JUMPDEST PUSH2 0x1F46 DUP2 PUSH2 0x1BF0 JUMP JUMPDEST DUP2 EQ PUSH2 0x1F51 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP JUMP JUMPDEST PUSH2 0x1F5D DUP2 PUSH2 0x1C02 JUMP JUMPDEST DUP2 EQ PUSH2 0x1F68 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP JUMP JUMPDEST PUSH2 0x1F74 DUP2 PUSH2 0x1C0E JUMP JUMPDEST DUP2 EQ PUSH2 0x1F7F JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP JUMP JUMPDEST PUSH2 0x1F8B DUP2 PUSH2 0x1C18 JUMP JUMPDEST DUP2 EQ PUSH2 0x1F96 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP JUMP JUMPDEST PUSH2 0x1FA2 DUP2 PUSH2 0x1C42 JUMP JUMPDEST DUP2 EQ PUSH2 0x1FAD JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP JUMP JUMPDEST PUSH2 0x1FB9 DUP2 PUSH2 0x1C4C JUMP JUMPDEST DUP2 EQ PUSH2 0x1FC4 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP JUMP INVALID LOG2 PUSH5 0x6970667358 0x22 SLT KECCAK256 CALLDATALOAD DUP4 SHR 0x23 0xB0 PUSH14 0x895917CCB73F8F0F926DFEAFEB78 PUSH26 0x7E97B426602EDEDB2C85BA64736F6C6343000807003300000000 \",\r\n"
            + "\t\"sourceMap\": \"453:5394:4:-:0;;;1002:17;969:50;;1026:27;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;:::i;:::-;;1178:1;1151:28;;1231:42;1192:81;;;;;;;;;;;;;;;;;;;;1312:42;1280:74;;;;;;;;;;;;;;;;;;;;1388:42;1361:69;;;;;;;;;;;;;;;;;;;;1462:66;1437:91;;;;1537:362;;;;;;;;;;1587:21;;;;;;;;;;;1642:16;;;;;;;;;;;9386:15:0;9369:32;;;;;;;;;;;;9433:5;9407:32;;;;;;;;;;;;9299:145;;1735:28:4::1;;;;;;;;;;;1701:9;;:63;;;;;;;;;;;;;;;;;;1783:10;1775:5;;:18;;;;;;;;;;;;;;;;;;1814:14;;1804:7;:24;;;;1845:14;1839:3;:20;;;;453:5394:::0;;;;;;;;;:::i;:::-;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;:::i;:::-;;;:::o;:::-;;;;;;;;;;;;;;;;;;;;;:::o;7:320:5:-;51:6;88:1;82:4;78:12;68:22;;135:1;129:4;125:12;156:18;146:81;;212:4;204:6;200:17;190:27;;146:81;274:2;266:6;263:14;243:18;240:38;237:84;;;293:18;;:::i;:::-;237:84;58:269;7:320;;;:::o;333:180::-;381:77;378:1;371:88;478:4;475:1;468:15;502:4;499:1;492:15;453:5394:4;;;;;;;;;;;;;;;;;;;\"\r\n"
            + "}";

    public static final String FUNC_ADDRESSES = "addresses";

    public static final String FUNC_CONTRIBUTIONS = "contributions";

    public static final String FUNC_DIDADDRESSWIN = "didAddressWin";

    public static final String FUNC_ENTER = "enter";

    public static final String FUNC_GETBALANCE = "getBalance";

    public static final String FUNC_GETCONTRIBUTIONFORADDRESS = "getContributionForAddress";

    public static final String FUNC_GETLATESTPRICE = "getLatestPrice";

    public static final String FUNC_GETOPTIONSAMOUNT = "getOptionsAmount";

    public static final String FUNC_GETPICKEDOPTIONFORADDRESS = "getPickedOptionForAddress";

    public static final String FUNC_GETRANDOMNUMBER = "getRandomNumber";

    public static final String FUNC_GETREWARDFORADDRESS = "getRewardForAddress";

    public static final String FUNC_GETSTRINGREPRESENTATION = "getStringRepresentation";

    public static final String FUNC_ISADDRESSPARTICIPATING = "isAddressParticipating";

    public static final String FUNC_MINIMUMENTRANCE = "minimumEntrance";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_PICKEDOPTIONS = "pickedOptions";

    public static final String FUNC_RAWFULFILLRANDOMNESS = "rawFulfillRandomness";

    public static final String FUNC_RESOLVE = "resolve";

    public static final String FUNC_RESOLVED = "resolved";

    public static final String FUNC_TOTALCONTRIBUTIONS = "totalContributions";

    public static final String FUNC_WALLETS = "wallets";

    public static final String FUNC_WINOPTION = "winOption";

    public static final String FUNC_WINNERS = "winners";

    public static final String FUNC_WINNERSLIST = "winnersList";

    public static final String FUNC_WINNERSREWARDS = "winnersRewards";

    public static final String FUNC_WITHDRAWBALANCE = "withdrawBalance";

    @Deprecated
    protected Lottery(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Lottery(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Lottery(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Lottery(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> addresses(BigInteger param0) {
        final Function function = new Function(FUNC_ADDRESSES, 
                Arrays.<Type>asList(new Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> contributions(String param0) {
        final Function function = new Function(FUNC_CONTRIBUTIONS, 
                Arrays.<Type>asList(new Address(160, param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> didAddressWin(String _address) {
        final Function function = new Function(FUNC_DIDADDRESSWIN, 
                Arrays.<Type>asList(new Address(160, _address)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> enter(BigInteger _option) {
        final Function function = new Function(
                FUNC_ENTER, 
                Arrays.<Type>asList(new Uint256(_option)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getBalance() {
        final Function function = new Function(FUNC_GETBALANCE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getContributionForAddress(String _address) {
        final Function function = new Function(FUNC_GETCONTRIBUTIONFORADDRESS, 
                Arrays.<Type>asList(new Address(160, _address)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getLatestPrice() {
        final Function function = new Function(FUNC_GETLATESTPRICE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getOptionsAmount() {
        final Function function = new Function(FUNC_GETOPTIONSAMOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getPickedOptionForAddress(String _address) {
        final Function function = new Function(FUNC_GETPICKEDOPTIONFORADDRESS, 
                Arrays.<Type>asList(new Address(160, _address)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> getRandomNumber() {
        final Function function = new Function(
                FUNC_GETRANDOMNUMBER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getRewardForAddress(String _address) {
        final Function function = new Function(FUNC_GETREWARDFORADDRESS, 
                Arrays.<Type>asList(new Address(160, _address)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> getStringRepresentation(BigInteger _option) {
        final Function function = new Function(FUNC_GETSTRINGREPRESENTATION, 
                Arrays.<Type>asList(new Uint256(_option)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Boolean> isAddressParticipating(String _address) {
        final Function function = new Function(FUNC_ISADDRESSPARTICIPATING, 
                Arrays.<Type>asList(new Address(160, _address)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> minimumEntrance() {
        final Function function = new Function(FUNC_MINIMUMENTRANCE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> name() {
        final Function function = new Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> pickedOptions(String param0) {
        final Function function = new Function(FUNC_PICKEDOPTIONS, 
                Arrays.<Type>asList(new Address(160, param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> rawFulfillRandomness(byte[] requestId, BigInteger randomness) {
        final Function function = new Function(
                FUNC_RAWFULFILLRANDOMNESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(requestId), 
                new Uint256(randomness)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> resolve() {
        final Function function = new Function(
                FUNC_RESOLVE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> resolved() {
        final Function function = new Function(FUNC_RESOLVED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> totalContributions() {
        final Function function = new Function(FUNC_TOTALCONTRIBUTIONS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> wallets(String param0) {
        final Function function = new Function(FUNC_WALLETS, 
                Arrays.<Type>asList(new Address(160, param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> winOption() {
        final Function function = new Function(FUNC_WINOPTION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> winners(String param0) {
        final Function function = new Function(FUNC_WINNERS, 
                Arrays.<Type>asList(new Address(160, param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> winnersList(BigInteger param0) {
        final Function function = new Function(FUNC_WINNERSLIST, 
                Arrays.<Type>asList(new Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> winnersRewards(String param0) {
        final Function function = new Function(FUNC_WINNERSREWARDS, 
                Arrays.<Type>asList(new Address(160, param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> withdrawBalance() {
        final Function function = new Function(
                FUNC_WITHDRAWBALANCE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Lottery load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Lottery(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Lottery load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Lottery(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Lottery load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Lottery(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Lottery load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Lottery(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Lottery> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Lottery.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Lottery> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Lottery.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Lottery> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Lottery.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Lottery> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Lottery.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
