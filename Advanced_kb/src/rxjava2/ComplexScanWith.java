package rxjava2;

import io.reactivex.Observable;

class Changex {
    private final int id;

    public Changex(int id) {
        this.id = id;
    }

    public Eventx two(Changex c) {
        return new Eventx(c);
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
                .scanWith(this::one, Eventx::two)
                .subscribe();
    }

    public Eventx one() {
        Changex c = new Changex(21);
        return new Eventx(c);
    }

}
