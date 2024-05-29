package fr.isep.algo.classolympians;

import java.util.ArrayList;
import java.util.List;

public class ShareDataAthlètes {
    private static List<Athlète> athlètes = new ArrayList<>();

    static {
        athlètes.add(new Athlète("Riner", "Teddy", "France", "38", "Judo"));
        athlètes.add(new Athlète("Mayer", "Kevin", "France", "30", "Décathlon"));
        athlètes.add(new Athlète("Lavillenie", "Renaud", "France", "34", "Saut à la perche"));
        athlètes.add(new Athlète("Mbappé", "Kylian", "France", "23", "Football"));
        athlètes.add(new Athlète("Marchand", "Léon", "France", "20", "Natation"));
    }

    public static List<Athlète> getAthlètes() {
        return athlètes;
    }

    public static void addAthlète(Athlète athlète) {
        athlètes.add(athlète);
    }
}
