package calculation;

import data.Athlete;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PlaceCalculator {

    public static Map<String, String> getPlaces(List<Athlete> source) {
        int excludeLastOne = 1;
        Map<String, Athlete> sortedMap = new LinkedHashMap<>();
        source.stream()
                .sorted((e1, e2) -> e1.compareTo(e2))
                .forEachOrdered(x -> sortedMap.put(x.getName(), x));
        Map<String, String> places = new LinkedHashMap<>();
        int place = 1;
        int startPlace = place;
        for (Athlete athlete : source) {
            int samePlacesCount = checkCountSamePointsValue(athlete.getTotalPoints(), source);
            if (samePlacesCount > 1) {
                places.put(athlete.getName(), Integer.toString(startPlace) + "-" + (startPlace + samePlacesCount - excludeLastOne));
                place= startPlace + samePlacesCount;
            } else {
                places.put(athlete.getName(), Integer.toString(place));
                place++;
                startPlace = place;
            }
        }
        return places;
    }

    private static int checkCountSamePointsValue(BigDecimal totalPoints, List<Athlete> source) {
        int count = 0;
        for (Athlete athlete : source) {
            if (athlete.getTotalPoints().compareTo(totalPoints) == 0) {
                count++;
            }
        }
        return count;
    }

}
