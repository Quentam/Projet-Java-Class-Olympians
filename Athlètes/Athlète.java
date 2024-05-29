package fr.isep.algo.classolympians;

public class Athlète {
    private String nom;
    private String prenom;
    private String pays;
    private String age;
    private String discipline;
    private String events;

    public Athlète(String nom, String prenom, String pays, String age, String discipline) {
        this.nom = nom;
        this.prenom = prenom;
        this.pays = pays;
        this.age = age;
        this.discipline = discipline;
        this.events = "";
    }

    // Getters and setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }
}
