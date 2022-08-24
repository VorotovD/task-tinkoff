package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Клас для описания лифтового маршрута. Представляет собой список лифтов, в котором конечный этаж предыдущего лифта
 * равен начальному этажу следующего лифта. Назовем такой список связанным.
 */
public class Path {

    // Список лифтов
    private final List<Lift> liftList = new ArrayList<>();

    /**
     * Конструктор маршрута из списка лифтов. Список проходит проверку на связанность.
     * @param liftList Список лифтов
     */
    public Path(List<Lift> liftList) {
        Lift prev = null;
        for (Lift curr: liftList) {
            if (prev != null && prev.getTo() != curr.getFrom()) {
                throw new IllegalArgumentException("Передана неправильный список лифтов для создания маршрута");
            }
            prev = curr;
        }
        this.liftList.addAll(liftList);
    }

    /**
     * Коструктор лифтового маршрута из начального лифта и последующего маршрута.
     * При инициализации происходит проверка на то, чтобы конечный этаж лифта был равен начальному этажу
     * первого лифта в маршруте.
     * @param lift Лифт, предназначенный быть начальным
     * @param path Последующй лифтовой маршрут
     */
    public Path(Lift lift, Path path) {
        if (!path.isEmpty() && lift.getTo() != path.getFirst().getFrom()) {
            throw new IllegalArgumentException("Невозможно соединить переданный лифт с указанным маршрутом");
        }
        liftList.add(lift);
        liftList.addAll(path.liftList);
    }

    /**
     * Длина лифтового маршрута, представляющая собой количество лифтов в списке.
     * @return Длина лифтового маршрута
     */
    public int length() {
        return liftList.size();
    }

    /**
     * @return Первый лифт в маршруте
     */
    public Lift getFirst() {
        return liftList.get(0);
    }

    /**
     * @return Неизменяемый список лифтов в маршруте
     */
    public List<Lift> getLiftList() {
        return Collections.unmodifiableList(liftList);
    }

    /**
     * @return Пустой(true) или непустой(false) лифтовой маршрут
     */
    public boolean isEmpty() {
        return liftList.isEmpty();
    }

}
