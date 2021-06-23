package ispyt1;

import java.util.HashMap;

public class Ispyt1 {
    
    public static void main(String[] args) {
        ArrayList list = task1();
        task2(list);
        task3(list);
    }
    
    public static void task3(ArrayList list) {
        
        long start;
        long end;
        HashSet s1 = new HashSet();
        TreeSet s2 = new TreeSet();
        
        System.out.println("\n\nTask 3:");
        System.out.println("HashSet:");
        
        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            s1.add(list.get(i));
        }
        end = System.nanoTime();
        
        System.out.println("Adding:  " + (end - start) + " nanoseconds");
        
        start = System.nanoTime();
        s1.hasObject(list.get(5));
        end = System.nanoTime();
        
        System.out.println("Affiliation check:   " + (end - start) + " nanoseconds");
        
        start = System.nanoTime();
        s1.remove(list.get(7));
        end = System.nanoTime();
        
        System.out.println("Deleting: " + (end - start) + " nanoseconds");
        
        
        
        System.out.println("\nTreeSet:");
        
        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            s2.add((Film) list.get(i));
        }
        end = System.nanoTime();
        
        System.out.println("Adding:  " + (end - start) + " nanoseconds");
        
        start = System.nanoTime();
        s2.hasObject((Film) list.get(5));
        end = System.nanoTime();
        
        System.out.println("Affiliation check:   " + (end - start) + " nanoseconds");
        
        start = System.nanoTime();
        s2.remove((Film) list.get(7));
        end = System.nanoTime();
        
        System.out.println("Deleting: " + (end - start) + " nanoseconds");
    }
    
    public static void task2(ArrayList list) {
        ArrayList priorities = new ArrayList();
        long start;
        long end;
        for (int i = 0; i < list.size(); i++) {
            priorities.addLast((int) (Math.random() * 10));
        }
        System.out.println("Task 2:");
        TreePriorityQueue q1 = new TreePriorityQueue();
        HeapPriorityQueue q2 = new HeapPriorityQueue();
        
        System.out.println("TreePriorityQueue:");
        
        start = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            q1.add((Film) list.get(i), (int) priorities.get(i));
        }
        end = System.nanoTime();
        
        System.out.println("Adding:   " + (end - start) + " nanoseconds");
        
        start = System.nanoTime();
        q1.getMin();
        end = System.nanoTime();
        
        System.out.println("Finding:  " + (end - start) + " nanoseconds");
        
        start = System.nanoTime();
        q1.deleteMin();
        end = System.nanoTime();
        
        System.out.println("Deleting: " + (end - start) + " nanoseconds");
        
        System.out.println("\nHeapPriorityQueue:");
        
        start = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            q2.add((Film) list.get(i), (int) priorities.get(i));
        }
        end = System.nanoTime();
        
        System.out.println("Adding:   " + (end - start) + " nanoseconds");
        
        start = System.nanoTime();
        q2.getMin();
        end = System.nanoTime();
        
        System.out.println("Finding:  " + (end - start) + " nanoseconds");
        
        start = System.nanoTime();
        q2.deleteMin();
        end = System.nanoTime();
        
        System.out.println("Deleting: " + (end - start) + " nanoseconds");
        
    }
    
    public static ArrayList task1() {
        System.out.println("Task 1:");
        ArrayList list = new ArrayList();
        for (int i = 0; i < 100; i++) {
            list.addLast(generateFilm());
        }
        
        System.out.println(list);
        list.sort(new FilmNameSorter());
        System.out.println(list);
        list.sort(new FilmYearSorter());
        System.out.println(list);
        list.sort(new FilmActorsSorter());
        System.out.println(list + "\n\n");
        return list;
    }
    
    public static Film generateFilm() {
        String name = generateString();
        int year = (int) (Math.random() * 127 + 1895);
        String director = generateString();
        HashMap actors = new HashMap();
        for (int i = 0; i < (int) (Math.random() * 199 + 1); i++) {
            actors.put(generateString(), generateString());
        }
        return new Film(name, year, director, actors);
    } 
    
    public static String generateString() {
        String s = "";
        char c;
        for (int i = 0; i < (int) (Math.random() * 9 + 1); i++) {
            c = (char) ((int) (Math.random() * 26) + 97);
            s += c;
        }
        return s;
    }
    
}
