package rxjava2;

import io.reactivex.Observable;

class Changex {
    private final int id;

    public Changex(int id) {
        this.id = id;
    }
}

class Eventx {
    private final Changex changex;

    public Eventx(Changex c) {
        this.changex = c;
    }
}

class ComplexScanWith {
    public static void main(String[] args) {

    }

    public void work() {
        Observable.just(new Changex(10))
                .scanWith(this::one, this::two)
                .subscribe();
    }

    public Eventx one() {
        Changex c = new Changex(21);
        return new Eventx(c);
    }

    public Eventx two(Eventx e, Changex c) {
        return new Eventx(c);
    }
}
