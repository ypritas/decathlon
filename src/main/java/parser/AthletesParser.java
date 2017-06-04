package parser;

import data.Athlete;
import data.Event;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AthletesParser implements DecathlonDataParser {

    private static final int NAME_POSITION = 0;

    @Override
    public List<Athlete> parseAthletes(List<List<String>> data) {
        List<Athlete> result = new ArrayList<>();
        for (List<String> athleteEvents : data) {
            Map<String, String> events = parseEvents(athleteEvents);
            Athlete athlete = new Athlete(athleteEvents.get(NAME_POSITION), events);
            result.add(athlete);
        }
        return result;
    }

    private Map<String, String> parseEvents(List<String> athleteEvents) {
        Map<String, String> events = new LinkedHashMap<>();
        events.put(Event.EVENT_100M.getName(), athleteEvents.get(Event.EVENT_100M.getPosition()));
        events.put(Event.EVENT_LONG_JUMP.getName(), athleteEvents.get(Event.EVENT_LONG_JUMP.getPosition()));
        events.put(Event.EVENT_SHOT_PUT.getName(), athleteEvents.get(Event.EVENT_SHOT_PUT.getPosition()));
        events.put(Event.EVENT_HIGH_JUMP.getName(), athleteEvents.get(Event.EVENT_HIGH_JUMP.getPosition()));
        events.put(Event.EVENT_400M.getName(), athleteEvents.get(Event.EVENT_400M.getPosition()));
        events.put(Event.EVENT_110M_HURDLES.getName(), athleteEvents.get(Event.EVENT_110M_HURDLES.getPosition()));
        events.put(Event.EVENT_DISCUS_THROW.getName(), athleteEvents.get(Event.EVENT_DISCUS_THROW.getPosition()));
        events.put(Event.EVENT_POLE_VAULT.getName(), athleteEvents.get(Event.EVENT_POLE_VAULT.getPosition()));
        events.put(Event.EVENT_JAVELIN_THROW.getName(), athleteEvents.get(Event.EVENT_JAVELIN_THROW.getPosition()));
        events.put(Event.EVENT_1500M.getName(), athleteEvents.get(Event.EVENT_1500M.getPosition()));
        return events;
    }

}
