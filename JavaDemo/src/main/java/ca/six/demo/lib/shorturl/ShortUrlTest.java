package ca.six.demo.lib.shorturl;


import java.security.MessageDigest;

/**
 * Created by hzsongzhengwang on 2016/1/8.
 *
 * a-zA-Z0-9 这64位取6位组合,可产生500多亿个组合数量.
 *
 */

public class ShortUrlTest {
    private static String[] chars = new String[] { "a" , "b" , "c" , "d" , "e" , "f" , "g" , "h" ,
            "i" , "j" , "k" , "l" , "m" , "n" , "o" , "p" , "q" , "r" , "s" , "t" ,
            "u" , "v" , "w" , "x" , "y" , "z" , "0" , "1" , "2" , "3" , "4" , "5" ,
            "6" , "7" , "8" , "9" , "A" , "B" , "C" , "D" , "E" , "F" , "G" , "H" ,
            "I" , "J" , "K" , "L" , "M" , "N" , "O" , "P" , "Q" , "R" , "S" , "T" ,
            "U" , "V" , "W" , "X" , "Y" , "Z" };

    public static void main(String[] args) throws Exception{
        String longUrl = "http://www.six.cn/test.html?id=2321838&name=songzhw";
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(longUrl.getBytes());
        byte[] mdBytes = md.digest(); // length = 16

        // 1. 将长网址md5生成32位签名串,分为4段, 每段8个字节;
        String mdStr = ByteUtil.bytesToHexString(mdBytes);


        // 2. 对这四段循环处理, 取8个字节.
        String[] resUrl = new String[4];
        for(int i = 0; i< 4; i++){
            // 3. 再将它看成16进制串与0x3fffffff(30位1)与操作, 即超过30位的忽略处理;
            String temp = mdStr.substring(i * 8, i * 8 + 8);
            long temp30 = 0x3FFFFFFF & Long.parseLong(temp, 16);

            // 4. 这30位分成6段, 每5位的数字作为字母表的索引取得特定字符, 依次进行获得6位字符串;
            String out = "";
            for (int j = 0 ; j < 6; j++){
                long index = 0x0000003D & temp30; // 3D 即十进制的61. 因为0和其它数&，结果都是0. 所以这里其实是把范围卡在0-61之内。
                out += chars[(int) index]; // 因为是知道值是在0 - 61， 所以肯定是没有超int的范围，可以强转的
                temp30 = temp30 >> 5;  // 每次循环按位右移 5 位
            }
            resUrl[i] = out;
        }

        // 5. 总的md5串可以获得4个6位串; 取里面的任意一个就可作为这个长url的短url地址;
        for(String shorty : resUrl) {
            System.out.println(" = "+shorty);
        }
    }

}
