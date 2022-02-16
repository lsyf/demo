package org.example;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import org.junit.Test;

import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;

public class RSATest {


    @Test
    public void pkcs8_2() throws Exception {
        String publicKeyBase64 = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvAbnJY+uE7QYRShew/6gB5slZ7d7cFf3BwvjFvUV6+BKWAchKZqSGoENOQGB5gzPZtzsYAGXd6qfkQHL++fJOQ3hiaSpGiklKMn/0+xuu6ugu5Evgtp2cCkkynsoA2GXl7FDotAdRuPgt14dr5A5YEsfA1SyjVMFv+yPui0rwmAy13JlWp1GzkUf6KySeUM7coj2D2VLQdigPTJn6tdcNli7+Kq1U3xUoV8pqqHJCIDnVnT1MIgJukiv8k9vIFNuBVWoLeIV/v2kv8aizwdCn80vLWMN0J2tjUNtox1yZ6afty5+qjLoawC9oESqQ2g3szHBuVnwqw99MQAtpi8frwIDAQAB";


        publicKeyBase64 = publicKeyBase64
                .trim()
                .replaceAll("-----BEGIN PUBLIC KEY-----", "")
                .replaceAll("-----END PUBLIC KEY-----", "")
                .replaceAll("\n", "")
                .replaceAll("\r", "");
        System.out.println(publicKeyBase64);
        //校验有效性
        verifyPublicKey(publicKeyBase64);
    }

    private void verifyPublicKey(String publicKeyBase64) {
        try {
            X509EncodedKeySpec bobPubKeySpec = new X509EncodedKeySpec(
                    Base64.decode(publicKeyBase64));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            keyFactory.generatePublic(bobPubKeySpec);
        } catch (Throwable e) {
            e.printStackTrace();
            throw new RuntimeException("密钥无效，error=" + e.getMessage());
        }
    }

    @Test
    public void pkcs8() {
        String publicKeyBase64 = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyb3S0ZcQty+1a5V2xNKck/faySI/jaHnsT+P8+zBfY6hRgG9lCHiSlQlbq496rDWb/l7hNujhAoUevNdR5WINQR7dFcYLNawFZGbJFN/NSWByG25UouweeBTDq2heHONlAKoBW+pSWFHeYLf0LEz+VbFb+qP+bZ2iWTYvNdL67uDq6iTXVULYn+0KxMbh8BCVB5lL+dAdwug+jbMXMnZuOmZp1EKs8zg1YI8IHCvboD77ZZOCw/NzmkspeZj6/tmNaV94ozcvdx0uv7Mi1p3KXU15VDNTqZgcbKAmmE1hyUuEGua1XRFXSg3mqCB5ZAh0+8FSTgQK3o+GKDet3UuQQIDAQAB";
        String privateKeyBase64 = "-----BEGIN PRIVATE KEY-----\n" +
                "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDJvdLRlxC3L7Vr\n" +
                "lXbE0pyT99rJIj+NoeexP4/z7MF9jqFGAb2UIeJKVCVurj3qsNZv+XuE26OEChR6\n" +
                "811HlYg1BHt0Vxgs1rAVkZskU381JYHIbblSi7B54FMOraF4c42UAqgFb6lJYUd5\n" +
                "gt/QsTP5VsVv6o/5tnaJZNi810vru4OrqJNdVQtif7QrExuHwEJUHmUv50B3C6D6\n" +
                "Nsxcydm46ZmnUQqzzODVgjwgcK9ugPvtlk4LD83OaSyl5mPr+2Y1pX3ijNy93HS6\n" +
                "/syLWncpdTXlUM1OpmBxsoCaYTWHJS4Qa5rVdEVdKDeaoIHlkCHT7wVJOBArej4Y\n" +
                "oN63dS5BAgMBAAECggEBAKvo68rZ9c6EAw6IMMsLxY15eaBHZOyl+K9bwKlVKJR7\n" +
                "hAYJ2ahvL0uzZKpqJCznP/PvHkhaeX48sLMMyoIDdCvpg+HhjaI315ipmRBdblq1\n" +
                "eWB3z6H9kwZoF568aoofvZdQpCjtu83h7WwoD9zgA7AHNvtlYAaka2Is41wYAoP+\n" +
                "o8ML7tN5/3d4qPlXLTBDBZVlBr2mt/bT79dq48JirAvk97H3AOmn3jNN66Xxa82A\n" +
                "GIddvzV93NqsyHyqGV3r+lJdmZTyilKzSYcCW+fQtquQDn73N5O7uLGjDTsodnl6\n" +
                "DWptW0j2z9PH8VvuCss/tn2ALRveeQquTjFlHxj6UZkCgYEA8zdbsW1IK342xTr4\n" +
                "hmVfEVnnPYmnQvELAxZBPA+RfPlSSPmyOghfYhdxEilpXIhEe/Z/XJ2YmIGBdNBF\n" +
                "XDs08bRURO0s/bFl+NwH+ZIpXfWQZ46VL+6MxX30Wj4vcbZdgtUy6NLP9WpYriuw\n" +
                "PGj+qeQ/QEoZYngflKYkAuV0v88CgYEA1Fhk5PKRVvW7LLQD/8n9ROza0pgY0SI8\n" +
                "Zg9UfAZzKhCRZ1QG3Aj3SFx7R6uNWl37H0pVnQVLC0WCGAmeU0f6X20aH2U5cSxA\n" +
                "FFpZOt/Uf6xGv4vH16u4smN+WGOq8zurBhNWOh41tIBLG6fNOk4HXv5aOofv1a1h\n" +
                "Ks9fYY3zJO8CgYEA5NT364azeWBl7cmfHOvxt2SMAcUq3vvlbYEZ3YWUUC5QMiLk\n" +
                "gl9wRt1hYEIgRJRdQvjYOe55LTvj7mEqcS2vkZ4mDzfLteGb3LpAsprHWwT5WcW4\n" +
                "LgHW5tWr+uA5SVbYwokPPiliyjfFuhGW3i+3M2dx724IVjJJHFX42dTDtNcCgYBM\n" +
                "2tFprAG+n6HnRCBObCUm1TM+FZ6l0uZZaiMB4LO9/dEivN7etMALiK11+zlmA63o\n" +
                "XVcvRcMriTTUzmZnbh3IfAyAYHqx43ot46V4EZsvuoLAwS7LeHOY3TnVc/1jm60C\n" +
                "vezvjA+UDPsiP1GgUK2KTDUMCjdb9yy7+eJjxKTEMQKBgQC4pkI/ICj5xIJ3crlJ\n" +
                "h9c/SFLnDsNdKN/AAAjgkAtJrjoU9OobcRxi/Tb0mGv2v5Ev6slu7qfreAwnf6G3\n" +
                "o6jpotNJ6uKqoqzbWeQr3dcLHxWKv1ArjH1Y/6+WIiaKcCekq0pG4P02IHW6LZQN\n" +
                "PurM5F1H6BzoNujwA3PbStCS0w==\n" +
                "-----END PRIVATE KEY-----\n";


        publicKeyBase64 = publicKeyBase64.replaceAll("-----BEGIN PUBLIC KEY-----", "")
                .replaceAll("-----END PUBLIC KEY-----", "")
                .replaceAll("\n", "").replaceAll("\r", "");

        privateKeyBase64 = privateKeyBase64.replaceAll("-----BEGIN PRIVATE KEY-----", "")
                .replaceAll("-----END PRIVATE KEY-----", "")
                .replaceAll("\n", "").replaceAll("\r", "");

        System.out.println(publicKeyBase64);
        System.out.println(privateKeyBase64);

        //  根据公钥生成密文
        RSA rsa1 = new RSA(null, publicKeyBase64);
        byte[] encrypt = rsa1.encrypt(StrUtil.bytes("我是一段测试aaaa", CharsetUtil.CHARSET_UTF_8), KeyType.PublicKey);
        String hexStr = HexUtil.encodeHexStr(encrypt);
        //  根据私钥解密密文
        RSA rsa2 = new RSA(privateKeyBase64, null);
        byte[] decodeHex = HexUtil.decodeHex(hexStr);
        byte[] decrypt1 = rsa2.decrypt(decodeHex, KeyType.PrivateKey);
        System.out.println(StrUtil.str(decrypt1, CharsetUtil.CHARSET_UTF_8));


        RSA rsa3 = new RSA(null, publicKeyBase64);
        System.out.println(rsa3.getPublicKey().getFormat());
        System.out.println(rsa3.getPublicKey().getAlgorithm());
        System.out.println(rsa3.getPublicKey().getEncoded().length);
    }

}
