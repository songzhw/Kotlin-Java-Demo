package basic.string;

// 𝄞 : utf-8是(hex)0xF0 0x9D 0x84 0x9E, utf-16是(hex)0xD834 0xDD1E, utf-32则是0x0001D11E
// utf-32(decimal)是119070, c/c++/java source code: 	"\uD834\uDD1E"

class Utf16 {
    public static void main(String[] args) {
        String str = "𝄞 clef";
        System.out.println(str.length()); //=> 7
        System.out.println(str.charAt(0));//=> ?

        System.out.println(str.codePointCount(0, 1));//=> 2
        System.out.println(str.codePointAt(0)); //=> 119070

    }
}
