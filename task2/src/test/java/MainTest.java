import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class MainTest {
    @Test
    public void getMaxWinsTest() {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("A","B","C"));
        teams.add(new Team("B","C","A"));
        teams.add(new Team("A","C","B"));
        teams.add(new Team("A","V","I"));
        teams.add(new Team("V","O","A"));
        teams.add(new Team("V","Q","A"));
        Assertions.assertEquals(3,Main.getMaxWins(teams));
    }
}
