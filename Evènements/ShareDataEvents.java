package fr.isep.algo.classolympians;

import java.util.ArrayList;
import java.util.List;

public class ShareDataEvents {
    private static final List<Event> events = new ArrayList<>();

    public static void addEvent(Event event) {
        events.add(event);
    }

    public static List<Event> getEvents() {
        return new ArrayList<>(events);
    }

    public static List<Event> getEventsForAthlete(String athleteName) {
        List<Event> athleteEvents = new ArrayList<>();
        for (Event event : events) {
            if (event.hasAthlete(athleteName)) {
                athleteEvents.add(event);
            }
        }
        return athleteEvents;
    }

    public static void registerAthleteToEvent(String athleteName, String eventName) {
        for (Event event : events) {
            if (event.getName().equals(eventName)) {
                event.registerAthlete(athleteName);
                break;
            }
        }
    }
}
