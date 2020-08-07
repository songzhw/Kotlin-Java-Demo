package ca.six.kjdemo.crypto;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

class AES_ECB {

    public static void main(String[] args) throws Exception {
        String src = "[easy plaintext]";
        String key = "0123456789abcdef";
        byte[] raw = key.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");

        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(src.getBytes("utf-8"));

        String result1 = Base64.getEncoder().encodeToString(encrypted);
        System.out.println(result1); //=> nSA0RU/u2r9dyd5mopht0g==

        String result2 = bytesToHex(encrypted);
        System.out.println(result2); //=> 9d2034454feedabf5dc9de66a2986dd2
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xff);
            if (hex.length() < 2) sb.append(0);
            sb.append(hex);
        }
        return sb.toString();
    }
}
