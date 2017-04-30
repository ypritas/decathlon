package data;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class EventTest {

    @Test
    public void getPointsTest () {
        Assert.assertEquals(Event.EVENT_100M.toString(), new BigDecimal(536), Event.EVENT_100M.getPoints("12.61"));
        Assert.assertEquals(Event.EVENT_LONG_JUMP.toString(), new BigDecimal(382), Event.EVENT_LONG_JUMP.getPoints("5.00"));
        Assert.assertEquals(Event.EVENT_SHOT_PUT.toString(), new BigDecimal(439), Event.EVENT_SHOT_PUT.getPoints("9.22"));
        Assert.assertEquals(Event.EVENT_HIGH_JUMP.toString(), new BigDecimal(389), Event.EVENT_HIGH_JUMP.getPoints("1.50"));
        Assert.assertEquals(Event.EVENT_400M.toString(), new BigDecimal(400), Event.EVENT_400M.getPoints("60.39"));
        Assert.assertEquals(Event.EVENT_110M_HURDLES.toString(), new BigDecimal(685), Event.EVENT_110M_HURDLES.getPoints("16.43"));
        Assert.assertEquals(Event.EVENT_DISCUS_THROW.toString(), new BigDecimal(302), Event.EVENT_DISCUS_THROW.getPoints("21.60"));
        Assert.assertEquals(Event.EVENT_POLE_VAULT.toString(), new BigDecimal(264), Event.EVENT_POLE_VAULT.getPoints("2.60"));
        Assert.assertEquals(Event.EVENT_1500M.toString(), new BigDecimal(421), Event.EVENT_1500M.getPoints("5.25.72"));
    }
}
