package lab1;

public class Lab1 {
    
    public static void main(String[] args) {
        
        System.out.println("Testing LinkedList:");
        testList(new LinkedList());
        System.out.println("--------------------------------------------");
        
        System.out.println("Testing DoubleLinkedList:");
        testList(new DoubleLinkedList());
        System.out.println("--------------------------------------------");
        
        System.out.println("Testing ArrayList:");
        testList(new ArrayList());
        
    }
    
    public static void testList(List list) {
        
        //testing List
        long start;
        int iter = 1000;
        
        
        //testing addFirst
        start = System.nanoTime();
        for(int i = 0; i < iter; i++) {
            list.addFirst((int) (Math.random() * 1000));
        }
        System.out.println("\taddFirst:   " + (System.nanoTime() - start) / 1000 + " microseconds");
        generateArray(list, iter);
        
        
        //testing addLast
        start = System.nanoTime();
        for (int i = 0; i < iter; i++) {
            list.addLast((int) (Math.random() * 1000));
        }
        System.out.println("\tadd Last:   " + (System.nanoTime() - start) / 1000 + " microseconds");
        generateArray(list, iter);
        
        
        //testing add
        start = System.nanoTime();
        for (int i = 0; i < iter; i++) {
            list.add((int) (Math.random() * 1000), (int) (Math.random() * 1000));
        }
        System.out.println("\tadd:   " + (System.nanoTime() - start) / 1000 + " microseconds");
        generateArray(list, iter);
        
        
        //testing removeFirst
        start = System.nanoTime();
        for (int i = 0; i < iter; i++) {
            list.removeFirst();
        }
        System.out.println("\tremoveFirst:   " + (System.nanoTime() - start) / 1000 + " microseconds");
        generateArray(list, iter);
        
        
        //testing removeLast
        start = System.nanoTime();
        for (int i = 0; i < iter; i++) {
            list.removeLast();
        }
        System.out.println("\tremoveLast:   " + (System.nanoTime() - start) / 1000 + " microseconds");
        generateArray(list, iter);
        
        
        //testing remove
        start = System.nanoTime();
        for (int i = 0; i < iter; i++) {
            list.remove((int) (Math.random() * 1000));
        }
        System.out.println("\tremove:   " + (System.nanoTime() - start) / 1000 + " microseconds");
        generateArray(list, iter);
        
        
        //testing changeFirst
        start = System.nanoTime();
        for (int i = 0; i < iter; i++) {
            list.changeFirst((int) (Math.random() * 1000));
        }
        System.out.println("\tchangeFirst:   " + (System.nanoTime() - start) / 1000 + " microseconds");
        generateArray(list, iter);
        
        
        //testing changeLast
        start = System.nanoTime();
        for (int i = 0; i < iter; i++) {
            list.changeLast((int) (Math.random() * 1000));
        }
        System.out.println("\tchangeLast:   " + (System.nanoTime() - start) / 1000 + " microseconds");
        generateArray(list, iter);
        
        
        //testing change
        start = System.nanoTime();
        for (int i = 0; i < iter; i++) {
            list.change((int) (Math.random() * 1000), (int) (Math.random() * 1000));
        }
        System.out.println("\tchange:   " + (System.nanoTime() - start) / 1000 + " microseconds");
        generateArray(list, iter);
        
        
        //testing get
        start = System.nanoTime();
        for (int i = 0; i < iter; i++) {
            list.get((int) (Math.random() * 1000));
        }
        System.out.println("\tget:   " + (System.nanoTime() - start) / 1000 + " microseconds");
        generateArray(list, iter);
        
        
        //testing index
        start = System.nanoTime();
        for (int i = 0; i < iter; i++) {
            list.index((int) (Math.random() * 1000));
        }
        System.out.println("\tindex:   " + (System.nanoTime() - start) / 1000 + " microseconds");
        generateArray(list, iter);
        
    }
    
    public static void generateArray (List list, int iter) {
        list.clean();
        for (int i = 0; i < 2 * iter; i++) {
            list.addLast((int) (Math.random() * 1000));
        }
    }
    
}
