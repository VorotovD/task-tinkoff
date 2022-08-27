import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Класс, описывающий прямую полку с товарами разных категории и методы передвижения по ней
 * Передвижение по категориям товаров выполняется в порядке возрастания категорий
 */
public class Shelf {
    private final ArrayList<Character> category;
    private final ArrayList<Integer[]> sequences;

    /**
     * @param category  Последовательность категорий товаров на полке
     * @param sequences Лист массивов границ подполок главной полки
     */
    public Shelf(String category, ArrayList<Integer[]> sequences) {
        this.category = new ArrayList<>();
        for (int i = 0; i < category.length(); i++) {
            this.category.add(category.toLowerCase().charAt(i));
        }
        for (Integer[] seq : sequences) {
            if (seq[0] < 0 || seq[1] > category.length() || seq[0] > seq[1]) {
                throw new IllegalArgumentException("Неверные границы подполок");
            }
        }
        this.sequences = sequences;
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
    public TreeMap<Character, TreeSet<Integer>> getTreeMapShelf(int start, int end) {
        TreeMap<Character, TreeSet<Integer>> result = new TreeMap<>();
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
     * Метод рассчитывает сумму передвижений по каждой подполке в отдельности
     *
     * @return Массив сумм передвижений для каждой подполки
     */
    public ArrayList<Integer> getCountOperations() {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer[] seq : sequences) {
            int intmResult = 0;
            int length = seq[1] - seq[0] + 1;
            TreeMap<Character, TreeSet<Integer>> res = getTreeMapShelf(seq[0], seq[1]);
            int previousPosition = seq[0];
            for (Character set : res.keySet()) {
                for (Integer pos : res.get(set)) {
                    if (!pos.equals(previousPosition)) {
                        if (previousPosition < pos) {
                            intmResult += pos - previousPosition;
                        } else {
                            intmResult += length - previousPosition + pos;
                        }
                        previousPosition = pos;

                    }
                }
            }
            result.add(intmResult);
        }
        return result;
    }

}
