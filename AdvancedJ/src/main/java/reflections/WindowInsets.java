package reflections;

public class WindowInsets {
    private DisplayCutout mDisplayCutout = new DisplayCutout();

    public DisplayCutout getDisplayCutout() {
        return mDisplayCutout;
    }

    public void change() {
        mDisplayCutout.mSafeInsets = new Rect(10, 20, 30, 40);
    }
}
