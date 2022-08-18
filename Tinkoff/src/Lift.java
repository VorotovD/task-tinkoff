public class Lift {

    private final int number;
    private final int from;
    private final int to;

    public Lift(int number, int from, int to) {
        if (number < 0 || from < 0 || from >= to) {
            throw new IllegalArgumentException("Неправильный параметры в консТрукторе лифта");
        }
        this.number = number;
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getNumber() {
        return number;
    }

}
