package data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by p998tbd on 2016.12.15.
 */
public class Athlete implements  Comparable<Athlete>{
    String name;
    Map<String, String> events = new LinkedHashMap<>();
    Integer totalPoints;

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

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    @Override
    public int compareTo(Athlete a) {
        return getTotalPoints().compareTo(a.getTotalPoints());
    }
}
