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
    }
}
