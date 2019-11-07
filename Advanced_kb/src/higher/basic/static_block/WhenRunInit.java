package higher.basic.static_block;

class WhenRunInitTarget {
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
    }
}
