package org.example.factory;


import contract.Src_main_solidity_Flash_sol_CErc20Interface;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.StaticGasProvider;
import org.web3j.utils.Convert;
import token.ERC20;

/**
 * @author yasoolin
 * @version 1.0
 * @since 2022/3/26 10:18 下午
 */
public class CronFactory {

    public static final Web3j web3j;

    public static final Credentials factoryCredentials;

    private static final StaticGasProvider provider;

    public static final BigInteger AMOUNT_E18 = BigInteger.valueOf(10).pow(18);

    public static final BigInteger BORROW_PER_TIME = AMOUNT_E18.multiply(BigInteger.valueOf(100)); //TODO 一次要借多少个币

    public static final BigInteger BORROW_THRESHOLD = AMOUNT_E18.multiply(BigInteger.valueOf(100)); //TODO 开始借币的阈值 金库中svn达到了这个值就会开始借币

    public static final String CRON_SVN_ADDR = "0xaD0f513AbE0201d1De887d01cFeAd62fb8c5290D";

    public static final String SVN_ADDR = "0x654bAc3eC77d6dB497892478f854cF6e8245DcA9";


    static {
        String url = "https://evm-cronos.crypto.org";
        web3j = Web3j.build(new Web3jConfig().buildService(url));

        String privateKey = "0x00000"; //TODO 你的私钥 需要先抵押、准备一点gas token
        factoryCredentials = Credentials.create(privateKey);

        provider = new StaticGasProvider(
                Convert.toWei("10000", Convert.Unit.GWEI).toBigInteger(),  //TODO 10000 gwei gas 借b
                BigInteger.valueOf(4600000)
        );
    }

    public static Src_main_solidity_Flash_sol_CErc20Interface cronSvn() {
        return Src_main_solidity_Flash_sol_CErc20Interface.load(
                CRON_SVN_ADDR, web3j, factoryCredentials, provider
        );
    }

    public static BigInteger balanceOfDetail(String tokenAddr, String owner) throws Exception {
        return erc20(tokenAddr).balanceOf(owner).send();
    }

    public static BigDecimal balanceOf(String tokenAddr, String owner) throws Exception {
        BigInteger decimal = erc20(tokenAddr).decimals().send();
        return new BigDecimal(erc20(tokenAddr).balanceOf(owner).send())
                .divide(new BigDecimal(BigInteger.TEN.pow(decimal.intValue())),3, RoundingMode.HALF_DOWN);
    }

    public static ERC20 erc20(String addr) {
        return ERC20.load(
                addr, web3j, factoryCredentials, provider
        );
    }

    public static ERC20 svn() {
        return ERC20.load(SVN_ADDR, web3j, factoryCredentials, provider);
    }


    public static void main(String[] args) throws Exception {
        while (true) {
            if (balanceOfDetail(SVN_ADDR, CRON_SVN_ADDR).compareTo(BORROW_THRESHOLD) >= 0) {
                String borrowHash = cronSvn().borrow(BORROW_PER_TIME).send().getTransactionHash();
                System.out.println("借出hash: " + borrowHash);
                BigDecimal svnBalance = balanceOf(SVN_ADDR, factoryCredentials.getAddress());
                System.out.println("钱包svn余额: " + svnBalance);
            } else {
                System.out.println("金库svn不足: " + balanceOfDetail(SVN_ADDR, CRON_SVN_ADDR));
            }
            Thread.sleep(1000 * 1); //TODO 1s扫描一次
        }
    }

}
