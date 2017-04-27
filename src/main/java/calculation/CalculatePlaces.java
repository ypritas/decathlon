package calculation;

import data.Athlete;

import java.util.LinkedHashMap;
import java.util.Map;

public class CalculatePlaces {

    private static final int EXCLUDE_LAST_ONE = 1;

    public static Map<String, String> getPlaces(Map<String,Athlete> source) {
        Map<String, Athlete> sortedMap = new LinkedHashMap<>();
        source.entrySet().stream()
                .sorted(Map.Entry.<String, Athlete>comparingByValue().reversed())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        Map<String, String> places = new LinkedHashMap<>();
        int place = 1;
        int startPlace = place;
        for (Map.Entry<String, Athlete> athlete : source.entrySet()) {
            int samePlacesCount = checkCountSamePointsValue(athlete.getValue().getTotalPoints(), source);
            if (samePlacesCount > 1) {
                places.put(athlete.getKey(), Integer.toString(startPlace) + "-" + (startPlace + samePlacesCount - EXCLUDE_LAST_ONE));
                place= startPlace + samePlacesCount;
            } else {
                places.put(athlete.getKey(), Integer.toString(place));
                place++;
                startPlace = place;
            }
        }
        return places;
    }

    private static int checkCountSamePointsValue(Integer totalPoints, Map<String,Athlete> source) {
        int count = 0;
        for (Map.Entry<String, Athlete> athlete : source.entrySet()) {
            if (athlete.getValue().getTotalPoints().compareTo(totalPoints) == 0) {
                count++;
            }
        }
        return count;
    }

}
