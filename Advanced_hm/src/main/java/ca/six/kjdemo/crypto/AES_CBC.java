package ca.six.kjdemo.crypto;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.util.Base64;

class AES_CBC {
    public static void main(String[] args) throws Exception {
        String src = "$ -> west lake西湖美景2020?!";
        String key = "whatalovelyday=>"; // 长度一定得是16的倍数
        String iv = "2020, be happy12";  // iv的长度一定得是16的倍数

        byte[] raw = key.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");

        byte[] ivRaw = iv.getBytes("utf-8");
        AlgorithmParameters params = AlgorithmParameters.getInstance("AES");
        params.init(new IvParameterSpec(ivRaw));

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, params);
        byte[] encrypted = cipher.doFinal(src.getBytes("utf-8"));

        String result1 = Base64.getEncoder().encodeToString(encrypted);
        System.out.println(result1);
    }
}

/*
[都没有iv的情况下, 明文为"[easy plaintext]", key = "0123456789abcdef" (key长度不为16倍数, 也会报错)时]
    AES/ECB/NoPadding的加密结果是:  nSA0RU/u2r9dyd5mopht0g==  (明文长度再稍多一点或少一点, 就是加解密失败)
    AES/CBC/NoPadding的加密结果是:  y0zrOJy7mxYTr6ptgimk+Q==  (明文长度再稍多一点或少一点, 就是加解密失败)
    AES/CBC/PKCS5Padding的加密结果是:   NrpHGh0Ox1t5dc0v6EcYZnHzQKOMEGleyFWcn74yZwA=   (明文长度是多少, 都能加解密成功)
    AES/CBC/PKCS7Padding的加密结果是失败, 会说:"Process 'command '../Home/bin/java'' finished with non-zero exit value 1". 可能是java平台默认情况下不支持PKCS7


[在有iv的情况下, 明文为: "$ -> west lake西湖美景2020?!", key = "whatalovelyday=>"]
    AES/CBC/Pkcs5Padding
    没有iv时, 加密为: a9zzKWk6wQpmbcYP3BmWB971+dbJ58nPFq/A3u+/rCX5/Q/G7h2WGQICds4UwUep
    加了iv后, 加密为: pcA+CtAKPAK7w0TlveW+btRtxViKzMyoCXuuVgiKjqqphFX5kJKIWEV8N6W+FKGK

 */