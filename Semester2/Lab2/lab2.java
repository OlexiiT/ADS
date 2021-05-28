package lab2;

public class Lab2 {

    public static void main(String[] args) {
        
        test(10000);
        
    }
    
    public static void test (int iter) {
        
        BinaryTree treeSorted = new BinaryTree();
        BinaryTree treeRandom = new BinaryTree();
        System.out.println("Testing BinaryTree:");
        System.out.println("\n----------------------------------------\n");
        
        BinaryTree tree = new BinaryTree();
        for (int i = 0; i < 500; i++){
            tree.insert((int) (Math.random() * 1000));
        }
        System.out.println("Sum: " + tree.getSum());
        System.out.println("\n----------------------------------------\n");
        
        System.out.println("Inserting:");
        long startSorted = System.nanoTime();
        for (int i = 0; i < iter; i++) {
            treeSorted.insert(i);
        }
        long finishSorted = System.nanoTime();
        long startRandom = System.nanoTime();
        for (int i = 0; i < iter; i++) {
            treeRandom.insert((int) (Math.random() * 1000));
        }
        long finishRandom = System.nanoTime();
        int timeSorted = (int) (finishSorted - startSorted);
        int timeRandom = (int) (finishRandom - startRandom);
        int maxTime = (timeRandom > timeSorted) ? timeRandom : timeSorted;
        int minTime = (timeRandom > timeSorted) ? timeSorted : timeRandom;
        int aveTime = (timeRandom + timeSorted) / 2;
        System.out.println("The worst case: " + maxTime/1000 + " microseconds");
        System.out.println("The average case: " + aveTime/1000 + " microseconds");
        System.out.println("The best case: " + minTime/1000 + " microseconds");
        System.out.println("\n----------------------------------------\n");
        
        
        
        System.out.println("Finding:");
        startSorted = System.nanoTime();
        for (int i = 0; i < iter; i++) {
            treeSorted.find(i);
        }
        finishSorted = System.nanoTime();
        startRandom = System.nanoTime();
        for (int i = 0; i < iter; i++) {
            treeRandom.find((int) (Math.random() * 1000));
        }
        finishRandom = System.nanoTime();
        timeSorted = (int) (finishSorted - startSorted);
        timeRandom = (int) (finishRandom - startRandom);
        maxTime = (timeRandom > timeSorted) ? timeRandom : timeSorted;
        minTime = (timeRandom > timeSorted) ? timeSorted : timeRandom;
        aveTime = (timeRandom + timeSorted) / 2;
        System.out.println("The worst case: " + maxTime/1000 + " microseconds");
        System.out.println("The average case: " + aveTime/1000 + " microseconds");
        System.out.println("The best case: " + minTime/1000 + " microseconds");
        System.out.println("\n----------------------------------------\n");
        
        
        
        System.out.println("Deleting:");
        startSorted = System.nanoTime();
        for (int i = 0; i < iter; i++) {
            treeSorted.delete(4999 - i);
        }
        finishSorted = System.nanoTime();
        startRandom = System.nanoTime();
        for (int i = 0; i < iter; i++) {
            treeRandom.delete((int) (Math.random() * 1000));
        }
        finishRandom = System.nanoTime();
        timeSorted = (int) (finishSorted - startSorted);
        timeRandom = (int) (finishRandom - startRandom);
        maxTime = (timeRandom > timeSorted) ? timeRandom : timeSorted;
        minTime = (timeRandom > timeSorted) ? timeSorted : timeRandom;
        aveTime = (timeRandom + timeSorted) / 2;
        System.out.println("The worst case: " + maxTime/1000 + " microseconds");
        System.out.println("The average case: " + aveTime/1000 + " microseconds");
        System.out.println("The best case: " + minTime/1000 + " microseconds");
        System.out.println("\n----------------------------------------\n");
        
    }
    
}
