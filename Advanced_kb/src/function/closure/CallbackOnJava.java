package function.closure;

interface ICallbackOnJava {
    public int callJava(String id);
}


class CallbackOnJava {
    public void call(String arg, ICallbackOnJava callback) {
        System.out.println("szw java call(callbackJava) : " + callback.callJava(arg));
    }

}

