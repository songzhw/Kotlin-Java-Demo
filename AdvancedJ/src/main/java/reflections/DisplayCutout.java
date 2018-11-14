package reflections;

public final class DisplayCutout {
    public Rect mSafeInsets = new Rect();

    public int getSafeInsetTop() {
        return mSafeInsets.top;
    }

    public int getSafeInsetBottom() {
        return mSafeInsets.bottom;
    }

    public int getSafeInsetLeft() {
        return mSafeInsets.left;
    }

    public int getSafeInsetRight() {
        return mSafeInsets.right;
    }
}


class Rect {
    public int left;
    public int top;
    public int right;
    public int bottom;

    public Rect() { }

    public Rect(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }
}