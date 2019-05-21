package ca.six.jold.temp;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

class Key1 {
  public static void main(String[] args) throws Exception {
    String uid = "";
    String did = "";
    String combined = did + uid;
    MessageDigest sha = MessageDigest.getInstance("SHA-256");
    sha.update(combined.getBytes(StandardCharsets.UTF_8));
    byte[] sha256 = sha.digest();
    System.out.println(bytesToHex(sha256));

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < sha256.length; i++) {
      sb.append("_");
      sb.append(sha256[i]);
    }
    System.out.println(sb.toString());
  }

  private static String bytesToHex(byte[] hash) {
    StringBuilder hexString = new StringBuilder();
    for (int i = 0; i < hash.length; i++) {
      String hex = Integer.toHexString(0xff & hash[i]);
      if (hex.length() == 1) hexString.append('0');
      hexString.append(hex);
    }
    System.out.println(hash.length);
    System.out.println(hexString.toString().length());
    return hexString.toString();
  }
}
// sha256 js: 31db3cbcdf0e13b957e73b31548117164593e2fced813ed8cbb3af265f175687
// sha256 ja: 31db3cbcdf0e13b957e73b31548117164593e2fced813ed8cbb3af265f175687
