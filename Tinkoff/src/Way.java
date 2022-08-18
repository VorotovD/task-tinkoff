import java.util.ArrayList;
import java.util.List;

public class Way {

    private final List<Lift> liftList = new ArrayList<>();

    public Way(List<Lift> liftList) {
        Lift prev = null;
        for (Lift curr: liftList) {
            if (prev != null && prev.getTo() != curr.getFrom()) {
                throw new IllegalArgumentException("Передана неправильный список лифтов для создания пути");
            }
            prev = curr;
        }
        this.liftList.addAll(liftList);
    }

    public int count() {
        return liftList.size();
    }
    
}
