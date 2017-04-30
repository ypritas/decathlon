package parser;

import data.Athlete;
import data.Event;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AthletesParserTest {

    private List<List<String>> data;

    @Before
    public void setUp() throws IOException {
        data = new ArrayList<>();
        List<String> events = new ArrayList<>();
        events.add("Siim Susi");
        events.add("12.61");
        events.add("5.00");
        events.add("9.22");
        events.add("1.50");
        events.add("60.39");
        events.add("16.43");
        events.add("21.60");
        events.add("2.60");
        events.add("35.81");
        events.add("5.25.72");
        data.add(events);
        events = new ArrayList<>();
        events.add("Beata Kana");
        events.add("13.04");
        events.add("4.53");
        events.add("7.79");
        events.add("1.55");
        events.add("64.72");
        events.add("18.74");
        events.add("24.20");
        events.add("2.40");
        events.add("28.20");
        events.add("6.50.76");
        data.add(events);
        events = new ArrayList<>();
        events.add("Jaana Lind");
        events.add("13.75");
        events.add("4.84");
        events.add("10.12");
        events.add("1.50");
        events.add("68.44");
        events.add("19.18");
        events.add("30.85");
        events.add("2.80");
        events.add("33.88");
        events.add("6.22.75");
        data.add(events);
        events = new ArrayList<>();
        events.add("Anti Loop");
        events.add("13.43");
        events.add("4.35");
        events.add("8.64");
        events.add("1.50");
        events.add("66.06");
        events.add("19.05");
        events.add("24.89");
        events.add("2.20");
        events.add("33.48");
        events.add("6.51.01");
        data.add(events);
        events = new ArrayList<>();
        events.add("Antanas Antanukas");
        events.add("20.00");
        events.add("2.00");
        events.add("15.00");
        events.add("1.80");
        events.add("80.00");
        events.add("25.00");
        events.add("23.25");
        events.add("2.20");
        events.add("33.48");
        events.add("6.51.01");
        data.add(events);
    }



    @Test
    public void loadAthletes () {
        Map<String, Athlete> result = new AthletesParser().parseAthletes(data);
        Assert.assertEquals(5, result.size());
        Assert.assertEquals(10, result.get("Siim Susi").getEvents().size());
        Assert.assertEquals("12.61", result.get("Siim Susi").getEvents().get(Event.EVENT_100M.getName()));
        Assert.assertEquals("5.00", result.get("Siim Susi").getEvents().get(Event.EVENT_LONG_JUMP.getName()));
        Assert.assertEquals("9.22", result.get("Siim Susi").getEvents().get(Event.EVENT_SHOT_PUT.getName()));
        Assert.assertEquals("1.50", result.get("Siim Susi").getEvents().get(Event.EVENT_HIGH_JUMP.getName()));
        Assert.assertEquals("60.39", result.get("Siim Susi").getEvents().get(Event.EVENT_400M.getName()));
        Assert.assertEquals("16.43", result.get("Siim Susi").getEvents().get(Event.EVENT_110M_HURDLES.getName()));
        Assert.assertEquals("21.60", result.get("Siim Susi").getEvents().get(Event.EVENT_DISCUS_THROW.getName()));
        Assert.assertEquals("2.60", result.get("Siim Susi").getEvents().get(Event.EVENT_POLE_VAULT.getName()));
        Assert.assertEquals("35.81", result.get("Siim Susi").getEvents().get(Event.EVENT_JAVELIN_THROW.getName()));
        Assert.assertEquals("5.25.72", result.get("Siim Susi").getEvents().get(Event.EVENT_1500M.getName()));
        Assert.assertEquals(new BigDecimal(4200), result.get("Siim Susi").getTotalPoints());
    }
}
