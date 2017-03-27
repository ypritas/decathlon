package data;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by p998tbd on 2016.12.14.
 */
public class EventTest {

    @Test
    public void getPointsTest () {
        Assert.assertEquals(Event.EVENT_100M.toString(),536, Event.EVENT_100M.getPoints("12.61"));
        Assert.assertEquals(Event.EVENT_LONG_JUMP.toString(), 382, Event.EVENT_LONG_JUMP.getPoints("5.00"));
        Assert.assertEquals(Event.EVENT_SHOT_PUT.toString(),439, Event.EVENT_SHOT_PUT.getPoints("9.22"));
        Assert.assertEquals(Event.EVENT_HIGH_JUMP.toString(), 389, Event.EVENT_HIGH_JUMP.getPoints("1.50"));
        Assert.assertEquals(Event.EVENT_400M.toString(), 400, Event.EVENT_400M.getPoints("60.39"));
        Assert.assertEquals(Event.EVENT_110M_HURDLES.toString(), 685, Event.EVENT_110M_HURDLES.getPoints("16.43"));
        Assert.assertEquals(Event.EVENT_DISCUS_THROW.toString(), 302, Event.EVENT_DISCUS_THROW.getPoints("21.60"));
        Assert.assertEquals(Event.EVENT_POLE_VAULT.toString(), 264, Event.EVENT_POLE_VAULT.getPoints("2.60"));
        Assert.assertEquals(Event.EVENT_1500M.toString(), 421, Event.EVENT_1500M.getPoints("5.25.72"));
    }
}
