package parser;

import data.Athlete;

import java.util.List;
import java.util.Map;

/**
 * Created by p998tbd on 2016.12.13.
 */
public interface DecathlonDataParser {
    Map<String, Athlete> parseAthletes(List<List<String>> data);
}
