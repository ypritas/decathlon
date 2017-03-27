package data;

/**
 * Created by p998tbd on 2016.12.14.
 */
public enum MeasurementType {
    Meters(1, ""), Centemeters(100, ""), Seconds(1, "ss.SS"), MinutesAndSeconds(1000, "mm.ss.SS");

    private final String format;
    private final int multiplier;

    MeasurementType(int multiplier, String format) {
        this.format = format;
        this.multiplier = multiplier;
    }

    int getMultiplier() {
        return multiplier;
    }

    String getFormat () {
        return format;
    }

}
