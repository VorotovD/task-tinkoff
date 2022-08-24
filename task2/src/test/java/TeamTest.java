import org.junit.Assert;
import org.junit.Test;

public class TeamTest {
    @Test
    public void equalsTestEqual() {
        Team team1 = new Team("ABC","DIF","HWE");
        Team team2 = new Team("DIF","HWE","ABC");
        Assert.assertEquals(team1,team2);
    }

    @Test
    public void equalsTestNotEqual() {
        Team team1 = new Team("ABC","DIF","HWE");
        Team team2 = new Team("RTU","HWE","ABC");
        Assert.assertNotEquals(team1,team2);
    }

}
