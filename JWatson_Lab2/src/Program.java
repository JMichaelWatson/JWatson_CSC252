/**
 * Created by JMichael on 8/18/2014.
 */
public class Program {

    public static void main(String[] args) {

        HeadBasedPriorityQueue<Integer> heap = new HeadBasedPriorityQueue<Integer>();
        AVLBasedPriorityQueue<Integer> avl = new AVLBasedPriorityQueue<Integer>();

        heap.offer(1);
        heap.offer(8);
        heap.offer(6);
        heap.offer(5);
        heap.offer(3);
        heap.offer(7);
        heap.offer(4);
        System.out.println("Heap:");
        System.out.println(heap.print());

        avl.offer(1);
        avl.offer(8);
        avl.offer(6);
        avl.offer(5);
        avl.offer(3);
        avl.offer(7);
        avl.offer(4);
        System.out.println("AVL Tree");
        avl.print();
    }
}
