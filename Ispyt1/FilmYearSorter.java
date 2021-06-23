package ispyt1;

import java.util.Comparator;

public class FilmYearSorter implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        return ((Film) (o1)).getYear()- ((Film) (o2)).getYear();
    }
    
}
