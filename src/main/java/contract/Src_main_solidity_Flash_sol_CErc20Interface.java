package contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
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
public class Src_main_solidity_Flash_sol_CErc20Interface extends Contract {
    public static final String BINARY = "Bin file was not provided";

    public static final String FUNC__ADDRESERVES = "_addReserves";

    public static final String FUNC_BORROW = "borrow";

    public static final String FUNC_LIQUIDATEBORROW = "liquidateBorrow";

    public static final String FUNC_MINT = "mint";

    public static final String FUNC_REDEEM = "redeem";

    public static final String FUNC_REDEEMUNDERLYING = "redeemUnderlying";

    public static final String FUNC_REPAYBORROW = "repayBorrow";

    public static final String FUNC_REPAYBORROWBEHALF = "repayBorrowBehalf";

    @Deprecated
    protected Src_main_solidity_Flash_sol_CErc20Interface(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Src_main_solidity_Flash_sol_CErc20Interface(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Src_main_solidity_Flash_sol_CErc20Interface(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Src_main_solidity_Flash_sol_CErc20Interface(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> _addReserves(BigInteger addAmount) {
        final Function function = new Function(
                FUNC__ADDRESERVES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(addAmount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> borrow(BigInteger borrowAmount) {
        final Function function = new Function(
                FUNC_BORROW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(borrowAmount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> liquidateBorrow(String borrower, BigInteger repayAmount, String cTokenCollateral) {
        final Function function = new Function(
                FUNC_LIQUIDATEBORROW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, borrower), 
                new org.web3j.abi.datatypes.generated.Uint256(repayAmount), 
                new org.web3j.abi.datatypes.Address(160, cTokenCollateral)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> mint(BigInteger mintAmount) {
        final Function function = new Function(
                FUNC_MINT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(mintAmount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> mintNativeToken(BigInteger mintAmount) {
        final Function function = new Function(
                FUNC_MINT,
                Collections.<Type>emptyList(),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, mintAmount);
    }

    public RemoteFunctionCall<TransactionReceipt> redeem(BigInteger redeemTokens) {
        final Function function = new Function(
                FUNC_REDEEM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(redeemTokens)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> redeemUnderlying(BigInteger redeemAmount) {
        final Function function = new Function(
                FUNC_REDEEMUNDERLYING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(redeemAmount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> repayBorrow(BigInteger repayAmount) {
        final Function function = new Function(
                FUNC_REPAYBORROW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(repayAmount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> repayBorrowBehalf(String borrower, BigInteger repayAmount) {
        final Function function = new Function(
                FUNC_REPAYBORROWBEHALF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, borrower), 
                new org.web3j.abi.datatypes.generated.Uint256(repayAmount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Src_main_solidity_Flash_sol_CErc20Interface load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Src_main_solidity_Flash_sol_CErc20Interface(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Src_main_solidity_Flash_sol_CErc20Interface load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Src_main_solidity_Flash_sol_CErc20Interface(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Src_main_solidity_Flash_sol_CErc20Interface load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Src_main_solidity_Flash_sol_CErc20Interface(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Src_main_solidity_Flash_sol_CErc20Interface load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Src_main_solidity_Flash_sol_CErc20Interface(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
