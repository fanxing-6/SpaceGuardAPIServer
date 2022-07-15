package cn.nttt.utils;


import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.nttt.enums.AppHttpCodeEnum;
import cn.nttt.exception.SystemException;
import org.springframework.stereotype.Component;

@Component
public class RSAUtil
{

    private static String AUTHCODE = "camera";

    private static String PRIVATE_KEY = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBANcQJPrwTapZOrGX\n" +
            "Gt3AhuNEnLK5NRoKnvlO95KSUCtlyqCggBfYSV8ZUNafIt5wMZWVdJowrL903M4F\n" +
            "m9XIoDVXtoJURxT3FanF4PMyZdj8tE/IjQaXyNO2Cu9m8hcM2leHHcSZGO4MkIhW\n" +
            "9oBhXDuzAnPWQu45OTC3W9Y16RMLAgMBAAECgYBBvhuv4jm7s18v3qNF2o7hdp34\n" +
            "PImxFkIWsD8aPUPooEta4vWFVIbJXXHKygbcvKtLsM5ePDbyqAS/rhM/PP9L/7fP\n" +
            "QXiecKe5SMKxeGEu+n+myi8pP2jlp39+NXBu7rMtPBAnHGZ/gem47D6i7ZBlpcwU\n" +
            "YSMhplD52WqviAfLAQJBAOzIHNjQaJwbKKdvqMRuyQqSqf2N7v96ekqgVjYNppG9\n" +
            "s8Ijx+3H9jUujBQ4XhMtoap3FUKf2H2QD+PDRQpXmcsCQQDohMI8d+AkacdD9bjL\n" +
            "asPXrB9D7kH13eMJXeaJ7FTkEj0x9R3CA/eoPaIfiAqWG1eVd3vzgYTis/zWgKja\n" +
            "GkPBAkBfrKhDT0rFsQ+nQC3wWVdwpzx60Iv+vQ2G8+yB4NgqUX2991lEkiTA7nL5\n" +
            "hKE2nJyTVZTIm/ANJFXXUUKnYCgrAkA2wwWoDieZC9ylcdra9cM4KU6XxiZ8zIxr\n" +
            "KVVhiGqZ6H3HJU6j4iFS22kyeezcW4YuKpzjxc5RQki7EEQ0UdlBAkBAu35pjnXq\n" +
            "DLIc3BWhdXBmekHe86C3U/JF2ZDoXb9oDsvERDUvSYH4nQ+semG4tOrD2gOe7qcL\n" +
            "fPLXcH3kqQDg";
    private static String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDXECT68E2qWTqxlxrdwIbjRJyy\n" +
            "uTUaCp75TveSklArZcqgoIAX2ElfGVDWnyLecDGVlXSaMKy/dNzOBZvVyKA1V7aC\n" +
            "VEcU9xWpxeDzMmXY/LRPyI0Gl8jTtgrvZvIXDNpXhx3EmRjuDJCIVvaAYVw7swJz\n" +
            "1kLuOTkwt1vWNekTCwIDAQAB";

    static RSA rsa = new RSA(PRIVATE_KEY, PUBLIC_KEY);

    /**
     * 私钥解密字符串
     *
     * @param authCode 公钥加密过的字符串
     * @return 解密之后的字符串
     */
    public String Decrypt(String authCode) 
    {

        String decrypt = rsa.decryptStr(authCode, KeyType.PrivateKey);
        return decrypt;
    }
    public String GetUUID(String authCode)
    {
        if (Decrypt(authCode).equals(AUTHCODE))
        {
            return IdUtil.simpleUUID();
        }
        throw  new SystemException(AppHttpCodeEnum.AUTHCODE_ERROR);
    }

    public String Eecrypt(String str)
    {
        String authCode = rsa.encryptBase64(str, KeyType.PublicKey);
        return authCode;
    }


}
