package ca.six.algo.linear;

/**
 * Created by songzhw on 2016-07-10.
 */
public class StaticLinkedList {
    // 最后一个元素是特殊节点，不存数据。 存放第一个有数值的元素的下标
    // 第一个元素也是特殊节点，不存数据。 存放“未被使用的节点们”的第一个下标。 这样不用每次都检索， 加快速度

    public static final int MAX_SIZE = 8;

    class Component{
        String data;
        int cursor; // 等于0是表示无指向
        public Component(String data, int cursor) {
            this.data = data;
            this.cursor = cursor;
        }
        @Override
        public String toString() {
            return "Component{" + "data='" + data + '\'' + ", cursor=" + cursor + '}';
        }
    }

    private Component[] ary = new Component[MAX_SIZE];

    public void print(){
        for(Component item : ary) {
            System.out.println(item);
        }
    }

    public void init(){
        for(int i = 0; i < MAX_SIZE; i++) {
            ary[i] = new Component("", i+1);
        }
        ary[MAX_SIZE - 1].cursor = 0;  // 等于0是表示无指向, 即末尾了
        // 第0个元素， 存的下标是1. 即第一个没被使用的节点的下标
    }

    public void add(String s){
        int i = ary[0].cursor;
        if(i != 0) { // ary is full, if i == 0
            ary[0].cursor = ary[i].cursor;
            ary[i].data = s;
        }
    }

    public void insert(String s, int i){

    }

    public static void main(String[] args) {
        StaticLinkedList list = new StaticLinkedList();
        list.init();
        list.add("甲");list.add("乙");list.add("丁");
        list.print();

    }

}
