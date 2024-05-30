
package fr.isep.algo.classolympians;

import java.util.ArrayList;
import java.util.List;

public class ShareDataAthlètes {
    private static List<Athlète> athlètes = new ArrayList<>();

    static {
        athlètes.add(new Athlète("Mbappé", "Kylian", "France", 23, 'M',"Football"));
        athlètes.add(new Athlète("Marchand", "Léon", "France", 20,'M', "Natation"));
    }

    public static List<Athlète> getAthlètes() {
        return athlètes;
    }

    public static void addAthlète(Athlète athlète) {
        athlètes.add(athlète);
    }
}
