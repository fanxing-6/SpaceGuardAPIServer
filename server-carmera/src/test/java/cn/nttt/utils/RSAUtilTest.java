package cn.nttt.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RSAUtilTest
{
    @Autowired
    private  RSAUtil rsaUtil;

    @Test
    public  void test()
    {
        String authCode =rsaUtil.Eecrypt("123456");
        System.out.println("****************************************\n");
        System.out.println(authCode);
        System.out.println("****************************************\n");
        System.out.println(rsaUtil.Decrypt(authCode));
    }
}
