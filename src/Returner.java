public class Returner<T> {
    private final T t;

    public Returner(T t) {
        this.t = t;
    }

    <U extends Number> void compareValues(U u) {
        System.out.println(t);
        System.out.println(u);

        System.out.println("is equal?");
        System.out.println(t.equals(u));
    }
}
