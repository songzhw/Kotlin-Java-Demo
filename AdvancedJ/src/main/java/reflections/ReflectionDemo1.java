package reflections;

import java.lang.reflect.Field;

public class ReflectionDemo1 {
    public static void main(String[] args) {
        reflectField();
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
