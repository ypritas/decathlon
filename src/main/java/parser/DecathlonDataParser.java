package parser;

import data.Athlete;

import java.util.List;

public interface DecathlonDataParser {
    List<Athlete> parseAthletes(List<List<String>> data);
}
