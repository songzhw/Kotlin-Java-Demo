package ca.six.demo.statemac;

public class SmStringReader {
    private String string;
    private int index;

    public SmStringReader(String string) {
        this.string = string;
    }

    public char read()  {
        if (index < string.length() - 1) {
            return string.charAt(index++);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void unread() {
        index--;
        if (index < 0) {
            index = 0;
        }
    }
}