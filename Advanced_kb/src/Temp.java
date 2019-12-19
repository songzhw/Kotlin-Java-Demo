import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//
//class User {
//    public String name = "songzhw";
//}
//
//interface IRvType<T> {
//    void render(T datum);
//}
//
//class Adapter {
//    public List data;
//    public Map<Class, IRvType> props;
//
//    public Adapter(List list, Map<Class, IRvType> in) {
//        this.data = list;
//        this.props = in;
//    }
//
//    public void onRender(Class clazz, int position) {
//        IRvType type = props.get(clazz);
//        Object value = data.get(position);
//        type.render(value);
//    }
//}
//
//public class Temp {
//    public static void main(String[] args) {
//        IRvType<String> one = new IRvType<String>() {
//            @Override
//            public void render(String datum) {
//                System.out.println("render string: " + datum);
//            }
//        };
//        IRvType<User> two = new IRvType<User>() {
//            @Override
//            public void render(User datum) {
//                System.out.println("render user: " + datum.name);
//            }
//        };
//        Map<Class, IRvType> map = new HashMap<>();
//        map.put(String.class, one);
//        map.put(User.class, two);
//
//        List data = new ArrayList();
//        data.add("200");
//        data.add(new User());
//
//        Adapter adapter = new Adapter(data, map);
//    }
//}