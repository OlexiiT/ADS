package ispyt1;

import java.util.Comparator;

public class FilmNameSorter implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        return ((Film) (o1)).getName().compareTo(((Film) (o2)).getName());
    }
    
}
