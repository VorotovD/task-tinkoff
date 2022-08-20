import java.util.Arrays;
import java.util.Objects;

public class Team {

    String[] team = new String[3];

    public Team(String first, String second, String third) {
        team[0] = first;
        team[1] = second;
        team[2] = third;
        Arrays.sort(team);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return (this.team[0].equals(team.team[0]) &&
                this.team[1].equals(team.team[1]) &&
                this.team[2].equals(team.team[2]));
    }

    @Override
    public int hashCode() {
        return Objects.hash(team[0],team[1],team[2]);
    }
}
