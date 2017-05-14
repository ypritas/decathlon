package calculation;

import data.Athlete;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PlaceCalculator {

    public static Map<String, String> getPlaces(List<Athlete> source) {
        Map<String, String> places = new LinkedHashMap<>();
        long place = 1;
        long startPlace = place;
        for (Athlete athlete : source) {
            long samePlacesCount = source.stream()
                    .filter(participant -> participant.compareTo(athlete) == 0).count();
            if (samePlacesCount > 1) {
                int excludeLastOne = 1;
                places.put(athlete.getName(), startPlace + "-" + (startPlace + samePlacesCount - excludeLastOne));
                place = startPlace + samePlacesCount;
            } else {
                places.put(athlete.getName(), Long.toString(place));
                startPlace = ++place;
            }
        }
        return places;
    }
}
