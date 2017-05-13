package data;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Athlete implements Comparable<Athlete> {
    private final String name;
    private Map<String, String> events = new LinkedHashMap<>();
    private final BigDecimal totalPoints;

    public Athlete(String name, Map<String, String> events, BigDecimal totalPoints) {
        this.name = name;
        this.totalPoints = totalPoints;
        this.events = events;
    }

    public Map<String, String> getEvents() {
        return events;
    }
    public String getName() {
        return name;
    }
    public BigDecimal getTotalPoints() {
        return totalPoints;
    }

    @Override
    public int compareTo(Athlete a) {
        return getTotalPoints().compareTo(a.getTotalPoints());
    }
}
