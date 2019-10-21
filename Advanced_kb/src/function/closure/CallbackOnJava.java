package function.closure;

interface ICallbackOnJava {
    public int callJava(String id);
}

interface ICallbackOnJava2 {
    public int callJava2A(String id);

    public int callJava2B(String id);
}


class CallbackOnJava {
    public void call(String arg, ICallbackOnJava callback) {
        System.out.println("szw java call(callbackJava) : " + callback.callJava(arg));
    }

    public void call2A(String arg, ICallbackOnJava2 callback) {
        System.out.println("szw java call(callbackJava) : " + callback.callJava2A(arg));
    }

    public void call2B(String arg, ICallbackOnJava2 callback) {
        System.out.println("szw java call(callbackJava) : " + callback.callJava2B(arg));
    }
}

