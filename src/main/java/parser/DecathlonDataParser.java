package parser;

import data.Athlete;

import java.util.List;
import java.util.Map;

public interface DecathlonDataParser {
    Map<String, Athlete> parseAthletes(List<List<String>> data);
}
