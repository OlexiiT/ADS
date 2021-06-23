package ispyt1;

import java.util.Comparator;

public class FilmActorsSorter implements Comparator{ 

    @Override
    public int compare(Object o1, Object o2) {
        return ((Film) (o1)).countActors()- ((Film) (o2)).countActors();
    }
    
}
