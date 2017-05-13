package calculation;

import data.Athlete;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PlaceCalculator {

    public static Map<String, String> getPlaces(List<Athlete> source) {
        int excludeLastOne = 1;
        Map<String, Athlete> sortedMap = new LinkedHashMap<>();
        source.stream()
                .sorted(Comparator.naturalOrder())
                .forEachOrdered(athlete -> sortedMap.put(athlete.getName(), athlete));
        Map<String, String> places = new LinkedHashMap<>();
        long place = 1;
        long startPlace = place;
        for (Athlete athlete : source) {
            long samePlacesCount = checkCountSamePointsValue(athlete.getTotalPoints(), source);
            if (samePlacesCount > 1) {
                places.put(athlete.getName(), Long.toString(startPlace) + "-" + (startPlace + samePlacesCount - excludeLastOne));
                place= startPlace + samePlacesCount;
            } else {
                places.put(athlete.getName(), Long.toString(place));
                place++;
                startPlace = place;
            }
        }
        return places;
    }

    private static long checkCountSamePointsValue(BigDecimal totalPoints, List<Athlete> source) {
        return source.stream().filter(athlete -> athlete.getTotalPoints().compareTo(totalPoints) == 0).count();
    }

}
