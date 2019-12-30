package ca.six.kjdemo.mutual.jva;

import ca.six.kjdemo.mutual.kt.FunDefaultArgKt;

class FunDefaultArgDemo {
    public static void main(String[] args) {
        FunDefaultArgKt.getLion(22);
        // FunDefaultArgKt.getLion(); // error! Expect 1 argument, get 1
        FunDefaultArgKt.getTiger();
        FunDefaultArgKt.getTiger(41);
    }
}
/*
szw getLion(22)
szw getTiger(0)
szw getTiger(41)
 */
