package data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by p998tbd on 2016.12.13.
 */
public enum Event {
    EVENT_100M(1, "_100_m", 25.4347f, 18f, 1.81f, EventType.Track, MeasurementType.Seconds),
    EVENT_LONG_JUMP(2, "Long_jump", 0.14354f,220f,1.4f,EventType.Field, MeasurementType.Centemeters),
    EVENT_SHOT_PUT(3, "Shot_put", 51.39f, 1.5f, 1.05f, EventType.Field, MeasurementType.Meters),
    EVENT_HIGH_JUMP(4, "High_jump", 0.8465f, 75f, 1.42f, EventType.Field, MeasurementType.Centemeters),
    EVENT_400M(5, "_400_m",1.53775f, 82f, 1.81f, EventType.Track, MeasurementType.Seconds),
    EVENT_110M_HURDLES(6, "_110_m_hurdles", 5.74352f, 28.5f, 1.92f, EventType.Track, MeasurementType.Seconds),
    EVENT_DISCUS_THROW(7, "Discus_throw", 12.91f, 4f, 1.1f, EventType.Field, MeasurementType.Meters),
    EVENT_POLE_VAULT(8, "Pole_vault", 0.2797f, 100f, 1.35f, EventType.Field, MeasurementType.Centemeters),
    EVENT_JAVELIN_THROW(9, "Javelin_throw", 10.14f, 7f, 1.08f, EventType.Field, MeasurementType.Meters),
    EVENT_1500M(10, "_1500_m", 0.03768f, 480f, 1.85f, EventType.Track, MeasurementType.MinutesAndSeconds);

    public static final int SECONDS_IN_MINUTE = 60;
    public static final int MIILISECONDS_IN_SECOND = 100;
    private final int position;
    private String name = "";
    private final float aIndex;
    private final float bIndex;
    private final float cIndex;
    private final EventType type;
    private final MeasurementType measurementType;

    Event(int position, String name, float aIndex, float bIndex, float cIndex, EventType type, MeasurementType measurementType) {
        this.position = position;
        this.aIndex = aIndex;
        this.bIndex = bIndex;
        this.cIndex = cIndex;
        this.type = type;
        this.name = name;
        this.measurementType = measurementType;
    }

    public int getPoints(String timeOrDistance) {
      if (type == EventType.Track) {
          return (int) (aIndex * Math.pow(bIndex - parsePerformance(timeOrDistance, measurementType), cIndex));
      } else {
          return (int) (aIndex * Math.pow(parsePerformance(timeOrDistance, measurementType) - bIndex, cIndex));
      }
    }

    private float parsePerformance(String timeOrDistance, MeasurementType measurementType) {
        if (measurementType == MeasurementType.MinutesAndSeconds || measurementType == MeasurementType.Seconds) {
            DateFormat formatter = new SimpleDateFormat(measurementType.getFormat());
            try {
                Date dt = formatter.parse(timeOrDistance);
                Calendar cal = Calendar.getInstance();
                cal.setTime(dt);
                return getSeconds(cal);
            } catch (ParseException e) {
                return 0;
            }
        } else {
            return Float.parseFloat(timeOrDistance)*measurementType.getMultiplier();
        }
    }

    private float getSeconds(Calendar cal) {
        return cal.get(Calendar.MINUTE)* SECONDS_IN_MINUTE + cal.get(Calendar.SECOND) + ((float) cal.get(Calendar.MILLISECOND))/ MIILISECONDS_IN_SECOND;
    }

    public int getPosition () {
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
