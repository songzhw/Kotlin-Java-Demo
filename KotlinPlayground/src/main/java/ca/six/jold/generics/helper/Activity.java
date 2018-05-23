package ca.six.jold.generics.helper;

public class Activity extends Context {
    public void startActivity(Context ctx, Class<? extends Activity> clz) {
        System.out.println("startActivity() : " + ctx + " ; " + clz);
    }
}
