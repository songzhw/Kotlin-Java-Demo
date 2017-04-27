package ca.six.demo.lib;

public class QuickDemo {
    public static void main(String[] args) {
//        String url = "a";
//        String url = "a/b";
        String url = "a/b/c";
        String[] splited = url.split("/");
        for(String s: splited){
            System.out.println("s = "+s);
        }

//        String s1 = "xd";
        String s1 = "ab";
        String s2 = "xxd";
        String s3 = s2.replace(s1, "**");
        System.out.println(" === s3 = "+s3);

    }
}




