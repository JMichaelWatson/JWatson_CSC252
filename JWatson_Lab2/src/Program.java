import java.util.Random;

/**
 * Created by JMichael on 8/18/2014.
 */
public class Program {

    public static void main(String[] args) {

        HeadBasedPriorityQueue<Integer> heap = new HeadBasedPriorityQueue<Integer>();
        AVLBasedPriorityQueue<Integer> avl = new AVLBasedPriorityQueue<Integer>();

//        heap.offer(1);
//        heap.offer(8);
//        heap.offer(6);
//        heap.offer(5);
//        heap.offer(3);
//        heap.offer(7);
//        heap.offer(4);
//        System.out.println("Heap:");
//        System.out.println(heap.print());
//        System.out.println("Poll: " + heap.poll());
//        System.out.println(heap.print());
//        System.out.println("Poll: " + heap.poll());
//        System.out.println(heap.print());

//        avl.offer(1);
//        avl.offer(8);
//        avl.offer(6);
//        avl.offer(5);
//        avl.offer(3);
//        avl.offer(7);
//        avl.offer(4);
//        System.out.println("AVL Tree");
//        avl.print();
//        System.out.println("Poll: " + avl.poll());
//        avl.print();
//        System.out.println("Poll: " + avl.poll());
//        avl.print();


//RIGHT
//        avl.offer(3);
//        avl.offer(1);
//        avl.offer(2);

//        avl.offer(3);
//        avl.offer(2);
//        avl.offer(1);

//        avl.offer(7);
//        avl.offer(8);
//        avl.offer(5);
//        avl.offer(6);
//        avl.offer(4);
//        avl.offer(3);
//LEFT
//        avl.offer(4);
//        avl.offer(3);
//        avl.offer(6);
//        avl.offer(5);
//        avl.offer(7);
//        avl.offer(8);

//        avl.offer(4);
//        avl.offer(2);
//        avl.offer(3);
//
//        avl.offer(3);
//        avl.offer(4);
//        avl.offer(5);
//size test
        /*avl.offer(4);
        avl.offer(3);
        avl.offer(6);
        avl.offer(5);
        avl.offer(7);
        avl.offer(8);
        avl.offer(10);
        avl.offer(11);
        avl.offer(1);
        avl.offer(20);
        avl.offer(18);
        avl.offer(19);
        avl.offer(30);
        avl.offer(24);
        avl.offer(29);
        avl.offer(50);
        avl.offer(40);
        avl.offer(43);
        avl.offer(25);*/

    for ( int i = 0; i < 128; i++ ) {
        int value = new Random().nextInt(50);
        System.out.println("About to insert: " + value);
        avl.offer(value);
        avl.print();
        System.out.println(avl.size());

    }


//        avl.print();
        System.out.println(avl.size());

    }
}
