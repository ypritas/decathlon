package calculation;

import data.Athlete;
import data.Event;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PlaceCalculatorTest {

    private Map<String, Athlete> result = new LinkedHashMap<>();

    @Before
    public void setUp() throws IOException {
        Map<String, String> events = new HashMap<>();
        events.put(Event.EVENT_100M.getName(), "12.61");
        events.put(Event.EVENT_LONG_JUMP.getName(), "5.00");
        events.put(Event.EVENT_SHOT_PUT.getName(), "9.22");
        events.put(Event.EVENT_HIGH_JUMP.getName(), "1.50");
        events.put(Event.EVENT_400M.getName(), "60.39");
        events.put(Event.EVENT_110M_HURDLES.getName(), "16.43");
        events.put(Event.EVENT_DISCUS_THROW.getName(),"21.60");
        events.put(Event.EVENT_POLE_VAULT.getName(),"2.60");
        events.put(Event.EVENT_JAVELIN_THROW.getName(),"35.81");
        events.put(Event.EVENT_1500M.getName(),"5.25.72");
        Athlete athlete = new Athlete("Siim Susi", events, new BigDecimal(4200));
        events = new LinkedHashMap<>();
        events.put(Event.EVENT_100M.getName(), "13.04");
        events.put(Event.EVENT_LONG_JUMP.getName(), "4.53");
        events.put(Event.EVENT_SHOT_PUT.getName(), "7.79");
        events.put(Event.EVENT_HIGH_JUMP.getName(), "1.55");
        events.put(Event.EVENT_400M.getName(), "64.72");
        events.put(Event.EVENT_110M_HURDLES.getName(), "18.74");
        events.put(Event.EVENT_DISCUS_THROW.getName(), "24.20");
        events.put(Event.EVENT_POLE_VAULT.getName(), "2.40");
        events.put(Event.EVENT_JAVELIN_THROW.getName(), "28.20");
        events.put(Event.EVENT_1500M.getName(), "6.50.76");
        result.put(athlete.getName(), athlete);
        athlete = new Athlete("Beata Kana", events, new BigDecimal(3199));
        events = new LinkedHashMap<>();
        events.put(Event.EVENT_100M.getName(), "13.75");
        events.put(Event.EVENT_LONG_JUMP.getName(), "4.84");
        events.put(Event.EVENT_SHOT_PUT.getName(), "10.12");
        events.put(Event.EVENT_HIGH_JUMP.getName(), "1.50");
        events.put(Event.EVENT_400M.getName(), "68.44");
        events.put(Event.EVENT_110M_HURDLES.getName(), "19.18");
        events.put(Event.EVENT_DISCUS_THROW.getName(), "30.85");
        events.put(Event.EVENT_POLE_VAULT.getName(), "2.80");
        events.put(Event.EVENT_JAVELIN_THROW.getName(), "33.88");
        events.put(Event.EVENT_1500M.getName(), "6.22.75");
        result.put(athlete.getName(), athlete);
        athlete = new Athlete("Jaana Lind", events, new BigDecimal(3494));
        result.put(athlete.getName(), athlete);
        events = new LinkedHashMap<>();
        events.put(Event.EVENT_100M.getName(), "13.43");
        events.put(Event.EVENT_LONG_JUMP.getName(), "4.35");
        events.put(Event.EVENT_SHOT_PUT.getName(), "8.64");
        events.put(Event.EVENT_HIGH_JUMP.getName(), "1.50");
        events.put(Event.EVENT_400M.getName(), "66.06");
        events.put(Event.EVENT_110M_HURDLES.getName(), "19.05");
        events.put(Event.EVENT_DISCUS_THROW.getName(),"24.89");
        events.put(Event.EVENT_POLE_VAULT.getName(),"2.20");
        events.put(Event.EVENT_JAVELIN_THROW.getName(),"33.48");
        events.put(Event.EVENT_1500M.getName(),"6.51.01");
        athlete = new Athlete("Anti Loop", events, new BigDecimal(3099));
        result.put(athlete.getName(), athlete);
        events = new LinkedHashMap<>();
        events.put(Event.EVENT_100M.getName(), "20.00");
        events.put(Event.EVENT_LONG_JUMP.getName(), "2.00");
        events.put(Event.EVENT_SHOT_PUT.getName(), "15.00");
        events.put(Event.EVENT_HIGH_JUMP.getName(), "1.80");
        events.put(Event.EVENT_400M.getName(), "80.00");
        events.put(Event.EVENT_110M_HURDLES.getName(), "25.00");
        events.put(Event.EVENT_DISCUS_THROW.getName(),"23.25");
        events.put(Event.EVENT_POLE_VAULT.getName(),"2.20");
        events.put(Event.EVENT_JAVELIN_THROW.getName(),"33.48");
        events.put(Event.EVENT_1500M.getName(),"6.51.01");
        athlete = new Athlete("Antanas Antanukas", events, new BigDecimal(3441));
        result.put(athlete.getName(), athlete);
        events = new LinkedHashMap<>();
        events.put(Event.EVENT_100M.getName(), "20.00");
        events.put(Event.EVENT_LONG_JUMP.getName(), "2.00");
        events.put(Event.EVENT_SHOT_PUT.getName(), "15.00");
        events.put(Event.EVENT_HIGH_JUMP.getName(), "1.80");
        events.put(Event.EVENT_400M.getName(), "80.00");
        events.put(Event.EVENT_110M_HURDLES.getName(), "25.00");
        events.put(Event.EVENT_DISCUS_THROW.getName(),"23.25");
        events.put(Event.EVENT_POLE_VAULT.getName(),"2.20");
        events.put(Event.EVENT_JAVELIN_THROW.getName(),"33.48");
        events.put(Event.EVENT_1500M.getName(),"6.51.01");
        athlete = new Athlete("Antanas AntanukasNew", events, new BigDecimal(3441));
        result.put(athlete.getName(), athlete);
    }

    @Test
    public void getPlacesTest() {
        Map<String, String> places = PlaceCalculator.getPlaces(result);
        assertEquals(6, result.size());
        assertEquals("1", places.get("Siim Susi"));
        assertEquals("3", places.get("Jaana Lind"));
        assertEquals("5-6", places.get("Antanas Antanukas"));
        assertEquals("5-6", places.get("Antanas AntanukasNew"));
        assertEquals("2", places.get("Beata Kana"));
        assertEquals("4", places.get("Anti Loop"));
    }

}
