package reflections;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import android.view.WindowManager;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo1 {
    public static void main(String[] args) {
        reflectField();
        reflectClass();
    }

    public static void reflectClass() {
        WindowInsets wi = new WindowInsets();
        DisplayCutout c1 = wi.getDisplayCutout();
        /*before: 0-0-0-0*/ System.out.println("before: " + c1.getSafeInsetTop() + " - " + c1.getSafeInsetLeft() + " - " + c1.getSafeInsetRight() + " - " + c1.getSafeInsetBottom());

        wi.change();
        try {
            Method method = WindowInsets.class.getMethod("getDisplayCutout");
            Object displayCutout = method.invoke(wi);

            Class clz = Class.forName("android.view.DisplayCutout");
            int top = (int) clz.getMethod("getSafeInsetTop").invoke(displayCutout);
            int left = (int) clz.getMethod("getSafeInsetLeft").invoke(displayCutout);
            int right = (int) clz.getMethod("getSafeInsetRight").invoke(displayCutout);
            int bottom = (int) clz.getMethod("getSafeInsetBottom").invoke(displayCutout);

            /*before: 20-10-30-40*/ System.out.println("after: " + top + " - " + left + " - " + right + " - " + bottom);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void reflectField() {
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        System.out.println("before change: " + lp.layoutInDisplayCutoutMode); //=> 0

        Class<WindowManager.LayoutParams> clz = WindowManager.LayoutParams.class;
        Field field = null;
        try {
            field = clz.getField("layoutInDisplayCutoutMode");
            field.set(lp, 20);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("after change: " + lp.layoutInDisplayCutoutMode); //=> 0

        System.out.println("= = = = = = = = = = = = = = = = = = ");
    }
}
