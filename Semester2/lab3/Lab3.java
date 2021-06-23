package lab3;

import java.util.ArrayList;
import java.util.Random;

public class Lab3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> list = generateRandomArray(10000);
        
        RBTree bst = new RBTree();
        long tStart = System.nanoTime();
        for(int i = 0; i < 10000; i++){
            bst.insert(list.get(i));
        }
        long tEnd = System.nanoTime();
        System.out.println("Insertion time for RBTree is " + (tEnd-tStart) + " nanoseconds");

        long tStartDel = System.nanoTime();
        bst.deleteNode(40);
        long tEndDel = System.nanoTime();
        System.out.println("Delete time for RBTree is " + (tEndDel-tStartDel) + " nanoseconds");



        AVLTree avl = new AVLTree();
        
        long tStartA = System.nanoTime();
        for(int i = 0; i < 10000; i++){
            avl.insert(list.get(i));
        }
        long tEndA = System.nanoTime();
        System.out.println("Insertion time for AVLTree is " + (tEndA-tStartA) + " nanoseconds");

        long tStartDelA = System.nanoTime();
        avl.deleteNode(40);
        long tEndDelA = System.nanoTime();
        System.out.println("Delete time for AVLTree is " + (tEndDelA-tStartDelA) + " nanoseconds");
    }
    
    static ArrayList generateRandomArray(int size) {
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < size; i++) {
            list.add((int) (Math.random() * 10000));
        }
        return list;
    }
    
}
