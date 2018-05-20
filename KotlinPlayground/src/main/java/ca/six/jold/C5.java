package ca.six.jold;

public class C5 {
    OnChange listener;

    public void setOnChangeListener(OnChange listener) {
        this.listener = listener;
    }

    public void change() {
        listener.change(23, 100, "bing");
    }

}
