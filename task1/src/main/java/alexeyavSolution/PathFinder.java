package alexeyavSolution;

import java.util.List;
import java.util.Set;

/**
 * Сложные операции с лифтовыми маршрутами
 */
public class PathFinder {

    private PathFinder() {
    }

    private static Path findPathFromFloor(Set<Lift> liftSet, int floor) {
        for(Lift lift: liftSet) {
            if (lift.getFrom() == floor) {
                Path path = findPathFromFloor(liftSet, lift.getTo());
                return new Path(lift, path);
            }
        }
        return new Path(List.of());
    }

    /**
     * Найти любой маршрут с 1 этажа до любого этажа, с которого уже нельзя подняться выше
     * @param liftSet Множество лифтов
     * @return Лифтовой маршрут
     */
    public static Path findPath(Set<Lift> liftSet) {
        return findPathFromFloor(liftSet, 1);
    }

    /**
     * Вывод лифтового маршрута в стандартный вывод
     * @param path Лифтовой маршрут
     */
    public static void printPath(Path path) {
        for (Lift lift: path.getLiftList()) {
            System.out.printf("%d: %d %d%n", lift.getNumber(), lift.getFrom(), lift.getTo());
        }
    }

}
