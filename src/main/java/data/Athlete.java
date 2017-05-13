package data;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Athlete implements Comparable<Athlete> {
    private String name;
    private Map<String, String> events = new LinkedHashMap<>();
    private BigDecimal totalPoints;

    public Map<String, String> getEvents() {
        return events;
    }

    public void setEvents(Map<String, String> events) {
        this.events = events;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(BigDecimal totalPoints) {
        this.totalPoints = totalPoints;
    }

    @Override
    public int compareTo(Athlete a) {
        return getTotalPoints().compareTo(a.getTotalPoints());
    }
}
