package alexeyavSolution;

import java.util.Objects;

/**
 * Класс, описывающий лифт
 */
public class Lift {

    // Номер лифта
    private final int number;
    // Этаж, с которого отправляется
    private final int from;
    // Этаж, на который приходит
    private final int to;

    /**
     * Конструктор генерации лифта
     * @param number Номер лифта
     * @param from   Этаж, с которого отправляется
     * @param to     Этаж, на который приходит
     */
    public Lift(int number, int from, int to) {
        if (number < 0 || from < 0 || from > to) {
            throw new IllegalArgumentException("Неправильный параметры в консТрукторе лифта");
        }
        this.number = number;
        this.from = from;
        this.to = to;
    }

    /**
     * @return Этаж, с которого отправляется
     */
    public int getFrom() {
        return from;
    }

    /**
     * @return Этаж, на который приходит
     */
    public int getTo() {
        return to;
    }

    /**
     * @return Номер лифта
     */
    public int getNumber() {
        return number;
    }

    /**
     * Метод сравнения двух лифтов. Лифты равны, если равны их номера
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lift lift = (Lift) o;
        return number == lift.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
