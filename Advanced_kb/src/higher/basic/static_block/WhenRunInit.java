package higher.basic.static_block;

class WhenRunInitTarget {
    static int one = 20;

    static {
        System.out.println("WhenRunInit static {}");
    }

    public WhenRunInitTarget() {
        System.out.println("WhenRunInit CF");
    }
}


class WhenRunInit {
    public static void main(String[] args) {
        System.out.println("i'm main()");
        int a = WhenRunInitTarget.one;
        WhenRunInitTarget.one = 33;
    }
}
