import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("MIK","VLA","GRI"));
        teams.add(new Team("VLA","MIK","GRI"));
        teams.add(new Team("IVA","ILY","VLA"));
        teams.add(new Team("AND","VLA","ILY"));
        teams.add(new Team("VLA","IVA","AND"));

        System.out.println(getMaxWinVictories(teams));
    }

    public static int getMaxWinVictories(List<Team> teams) {
        int result = 0;
        for (Team team : teams) {
            int i = 0;
            for (Team overlap : teams) {
                if (team.equals(overlap)) {
                    ++i;
                }
            }
            if (result < i) {
                result = i;
            }
        }
        return result;
    }
}
