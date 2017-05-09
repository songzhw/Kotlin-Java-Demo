package ca.six.demo.lib.serialize;

public enum Num {
    THREE,TWO, ONE;

    //打印序数
    public void printValues() {
        System.out.println(ONE + "ONE.ordinal" + ONE.ordinal());
        System.out.println(TWO + "TWO.ordinal" + TWO.ordinal());
        System.out.println(THREE + "THREE.ordinal" + THREE.ordinal());
    }
}