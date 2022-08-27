import java.util.*;

/**
 * Класс, описывающий прямую полку с товарами разных категории и методы передвижения по ней
 * Передвижение по категориям товаров выполняется в порядке возрастания категорий
 */
public class Shelf {
    private final ArrayList<Character> category;

    /**
     * @param category Последовательность категорий товаров на полке
     */
    public Shelf(String category) {
        this.category = new ArrayList<>();
        for (int i = 0; i < category.length(); i++) {
            this.category.add(category.toLowerCase().charAt(i));
        }
    }

    /**
     * Метод возвращает (отсротированую по возрастанию подполку главной подполки) map.
     * Key - буква (категория товаров),
     * Value - отсортированные по возрастанию позиции буквы (данной категории) на подполке.
     *
     * @param start Стартовый индекс подполки
     * @param end   Конечный индекс подполки
     * @return Отсротированная по возрастанию категорий и их позиций, подполка главной подполки
     */
    //TODO упростить метод
    public Map<Character, Set<Integer>> getTreeMapShelf(int start, int end) {
        Map<Character, Set<Integer>> result = new TreeMap<>();
        for (Character character : category) {
            TreeSet<Integer> positions = new TreeSet<>();
            for (int i = start; i <= end; i++) {
                if (character.equals(category.get(i))) {
                    positions.add(i);
                }
            }
            if (!positions.isEmpty()) {
                result.put(character, positions);
            }
        }
        return result;
    }

    /**
     * Метод рассчитывает сумму передвижений для подполки
     *
     * @param sequence Координаты подполки
     * @return Сумму передвижений для подполки
     */
    public int getCountOperations(Integer[] sequence) {
        int countOperations = 0;
        int shelfLength = sequence[1] - sequence[0] + 1;
        int actualPosition = sequence[0];
        Map<Character, Set<Integer>> res = getTreeMapShelf(sequence[0], sequence[1]);
        for (Character set : res.keySet()) {
            while (!res.get(set).isEmpty()) {
                int nextPosition = getNextIndex(res.get(set), actualPosition, shelfLength);
                if (actualPosition < nextPosition) {
                    countOperations += nextPosition - actualPosition;
                } else {
                    if (actualPosition != nextPosition) {
                        countOperations += shelfLength - actualPosition + nextPosition;
                    }
                }
                actualPosition = nextPosition;
            }
        }
        return countOperations;
    }

    /**
     * Метод вычисляет ближайший следующий индекс для категории с учетом передвижения только в сторону увеличения индексов,
     * удаляет результирующий индекс из набора индексов
     *
     * @param setPositions   Позиции данной котегории в полке
     * @param actualPosition Текущая позиция
     * @param shelfLength    Длина полки
     * @return Ближайший индекс для данной категории
     */
    public int getNextIndex(Set<Integer> setPositions, int actualPosition, int shelfLength) {
        Integer[] result = new Integer[2];
        result[0] = 0;
        result[1] = 100000;
        for (Integer candidatePosition : setPositions) {
            int path;
            if (candidatePosition < actualPosition) {
                path = shelfLength - actualPosition + candidatePosition;
            } else {
                path = candidatePosition - actualPosition;
            }
            if (result[1] > path) {
                result[1] = path;
                result[0] = candidatePosition;
            }
        }
        setPositions.remove(result[0]);
        return result[0];
    }

}
