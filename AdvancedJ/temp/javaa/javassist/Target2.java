package javaa.javassist;

class Target2 {
    /* 一般来说, 是用StringBuilder来做这种"+"很多的场景.这里用于测试执行时间, 所以来看看区别*/
    public void exeStrings() {
        String result = "";
        for (int i = 0; i < 20000; i++) {
            result += (char) (i % 26 + 'a');
        }
        System.out.println("exeStrings() : " + result);
    }

    public void exeStringBuilder() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 20000; i++) {
            sb.append((char) (i % 26 + 'a'));
        }
        System.out.println("exeStringBuilder() : " + sb.toString());
    }


}