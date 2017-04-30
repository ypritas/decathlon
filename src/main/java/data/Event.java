package data;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public enum Event {
    EVENT_100M(1, "_100_m", new BigDecimal(25.4347), new BigDecimal(18), new BigDecimal(1.81), EventType.Track, MeasurementType.Seconds),
    EVENT_LONG_JUMP(2, "Long_jump", new BigDecimal(0.14354), new BigDecimal(220), new BigDecimal(1.4), EventType.Field, MeasurementType.Centimeters),
    EVENT_SHOT_PUT(3, "Shot_put", new BigDecimal(51.39), new BigDecimal(1.5), new BigDecimal(1.05), EventType.Field, MeasurementType.Meters),
    EVENT_HIGH_JUMP(4, "High_jump", new BigDecimal(0.8465), new BigDecimal(75), new BigDecimal(1.42), EventType.Field, MeasurementType.Centimeters),
    EVENT_400M(5, "_400_m", new BigDecimal(1.53775), new BigDecimal(82), new BigDecimal(1.81), EventType.Track, MeasurementType.Seconds),
    EVENT_110M_HURDLES(6, "_110_m_hurdles", new BigDecimal(5.74352), new BigDecimal(28.5), new BigDecimal(1.92), EventType.Track, MeasurementType.Seconds),
    EVENT_DISCUS_THROW(7, "Discus_throw", new BigDecimal(12.91), new BigDecimal(4), new BigDecimal(1.1), EventType.Field, MeasurementType.Meters),
    EVENT_POLE_VAULT(8, "Pole_vault", new BigDecimal(0.2797), new BigDecimal(100), new BigDecimal(1.35), EventType.Field, MeasurementType.Centimeters),
    EVENT_JAVELIN_THROW(9, "Javelin_throw", new BigDecimal(10.14), new BigDecimal(7), new BigDecimal(1.08), EventType.Field, MeasurementType.Meters),
    EVENT_1500M(10, "_1500_m", new BigDecimal(0.03768), new BigDecimal(480), new BigDecimal(1.85), EventType.Track, MeasurementType.MinutesAndSeconds);

    private static final int SECONDS_IN_MINUTE = 60;
    private static final int MIILISECONDS_IN_SECOND = 100;
    private final int position;
    private String name = "";
    private final BigDecimal aIndex;
    private final BigDecimal bIndex;
    private final BigDecimal cIndex;
    private final EventType type;
    private final MeasurementType measurementType;

    Event(int position, String name, BigDecimal aIndex, BigDecimal bIndex, BigDecimal cIndex, EventType type, MeasurementType measurementType) {
        this.position = position;
        this.aIndex = aIndex;
        this.bIndex = bIndex;
        this.cIndex = cIndex;
        this.type = type;
        this.name = name;
        this.measurementType = measurementType;
    }

    public BigDecimal getPoints(String timeOrDistance) {
        try {
            if (type == EventType.Track) {
                return aIndex.multiply(new BigDecimal(Math.pow(bIndex.subtract(parsePerformance(timeOrDistance, measurementType)).doubleValue(), cIndex.doubleValue()))).setScale(0, BigDecimal.ROUND_DOWN);
            } else {
                return aIndex.multiply(new BigDecimal(Math.pow(parsePerformance(timeOrDistance, measurementType).subtract(bIndex).doubleValue(), cIndex.doubleValue()))).setScale(0, BigDecimal.ROUND_DOWN);
            }
        } catch (NumberFormatException wrongNumber) {
            return BigDecimal.ZERO;
        }
    }

    private BigDecimal parsePerformance(String timeOrDistance, MeasurementType measurementType) {
        if (measurementType == MeasurementType.MinutesAndSeconds || measurementType == MeasurementType.Seconds) {
            DateFormat formatter = new SimpleDateFormat(measurementType.getFormat());
            try {
                Date dt = formatter.parse(timeOrDistance);
                Calendar cal = Calendar.getInstance();
                cal.setTime(dt);
                return getSeconds(cal);
            } catch (ParseException e) {
                return BigDecimal.ZERO;
            }
        } else {
            return new BigDecimal(Float.parseFloat(timeOrDistance) * measurementType.getMultiplier());
        }
    }

    private BigDecimal getSeconds(Calendar cal) {
        return BigDecimal.valueOf(cal.get(Calendar.MINUTE) * SECONDS_IN_MINUTE + cal.get(Calendar.SECOND) + ((float) cal.get(Calendar.MILLISECOND)) / MIILISECONDS_IN_SECOND);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public static Event fromString(String name) {
        if (name != null) {
            for (Event event : Event.values()) {
                if (name.equalsIgnoreCase(event.name)) {
                    return event;
                }
            }
        }
        return null;
    }

}
