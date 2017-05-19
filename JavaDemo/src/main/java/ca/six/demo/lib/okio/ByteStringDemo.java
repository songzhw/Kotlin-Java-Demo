package ca.six.demo.lib.okio;

import okio.ByteString;

/**
 * Created by songzhw on 2016/3/16.
 */
public class ByteStringDemo {
    public static void main(String[] args) {

        byte[] data = "http://www.github.com".getBytes();
        ByteString bs = ByteString.of(data);

        System.out.println("base64 = "+bs.base64());
        System.out.println("base64 (url) = "+bs.base64Url());
        System.out.println("md5 = "+bs.md5().hex());
        System.out.println("sha256 = "+bs.sha256().hex());
        System.out.println("hex = "+bs.hex());
    }
}
