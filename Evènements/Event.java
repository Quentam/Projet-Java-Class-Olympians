package fr.isep.algo.classolympians;

import java.util.HashSet;
import java.util.Set;

public class Event {
    private final String name;
    private final String date;
    private final Set<String> registeredAthletes;

    public Event(String name, String date) {
        this.name = name;
        this.date = date;
        this.registeredAthletes = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public boolean hasAthlete(String athleteName) {
        return registeredAthletes.contains(athleteName);
    }

    public void registerAthlete(String athleteName) {
        registeredAthletes.add(athleteName);
    }

    public Set<String> getRegisteredAthletes() {
        return registeredAthletes;
    }
}
