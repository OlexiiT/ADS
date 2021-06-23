package ispyt1;

import java.util.HashMap;

public class Film implements Comparable<Film>{
    
    private String name;
    private int year;
    private String director;
    private HashMap actors;

    public Film(String name, int year, String director, HashMap actors) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.actors = actors;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public HashMap getActors() {
        return actors;
    }
    
    public int countActors() {
        return actors.size();
    }

    @Override
    public String toString() {
        return "{" + "name: " + name + ", year: " + year + ", actors: " + countActors() + "}";
    }

    @Override
    public int compareTo(Film o) {
        int r = name.compareTo(o.getName());
        if (r != 0) {
            return r;
        }
        r = year - o.getYear();
        if (r != 0) {
            return r;
        }
        r = director.compareTo(o.getDirector());
        return r;
    }
    
}
