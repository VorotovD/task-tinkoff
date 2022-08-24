package alexeyavSolution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Сложные операции с лифтовыми маршрутами
 */
public class PathFinder {

    private PathFinder() {
    }

    private static Path findLongestPathFromFloor(Set<Lift> liftSet, int floor) {
        Path result = new Path(List.of());

        for(Lift lift: liftSet) {
            if (lift.getFrom() == floor) {
                Path path = findLongestPathFromFloor(liftSet, lift.getTo());
                Path resultCandidate = new Path(lift,path);
                if (resultCandidate.length() > result.length()) {
                    result = resultCandidate;
                }
            }
        }
        return result;
    }

    /**
     * Найти любой маршрут с 1 этажа до любого этажа, с которого уже нельзя подняться выше
     * @param liftSet Множество лифтов
     * @return Лифтовой маршрут
     */
    public static Path findPath(Set<Lift> liftSet) {
        return findLongestPathFromFloor(liftSet, 1);
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
