package ca.six.jold.temp;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

class Key2 {
  public static void main(String[] args) throws Exception {
    String src = "easy plaintext";
    String key = "0123456789abcdef";
    byte[] raw = key.getBytes("utf-8");
    SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");

    Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
    cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
    byte[] encrypted = cipher.doFinal(src.getBytes("utf-8"));
    String result = Base64.getEncoder().encodeToString(encrypted);
    System.out.println(result);
  }
}
