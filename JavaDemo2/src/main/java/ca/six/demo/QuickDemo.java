package ca.six.demo;

public class QuickDemo {
    public static void main(String[] args) {
        QuickDemo obj = new QuickDemo();
        int index1 = obj.findSubstring_byForce("abcdefg", "def");
        System.out.println("szw index1 = "+index1);  //=> 3

        int index2 = obj.findSubstring_KMP("abcdefg", "def");
        System.out.println("szw index2 = "+index2);
    }


    int findSubstring_byForce(String str, String substr) {
        int i = 0, j = 0, lastIndex = i;
        while ((i < str.length()) && (j < substr.length())) {
            if (str.charAt(i) == substr.charAt(j)) {
                i++;
                j++; // 看2个str的下一个字符是否仍一样
            } else { // 这个位置明显不是子串. 让i从下一位置开始.
                j = 0;
                i = lastIndex + 1;
                lastIndex++;
            }

        }
        if (j == substr.length()) {
            return lastIndex; // 若找到是子串, 那k没变过, 就是子串的第一个char的位置
        }
        return -1;
    }

    int findSubstring_KMP(String str, String subStr){

        return -1;
    }
}
