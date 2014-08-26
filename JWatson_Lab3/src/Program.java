import javax.swing.*;
import java.util.List;

/**
 * Created by JMichael on 8/26/2014.
 */
public class Program {

    public static void main(String[] args) {
        Graph g = new Graph(7);
        BfsGraphTaversal bfs = new BfsGraphTaversal();
        DfsGraphTraversal dfs = new DfsGraphTraversal();
        g.addBiEgde(0,1,2);
        g.addBiEgde(0,2,3);
        g.addBiEgde(0,3,5);
        g.addBiEgde(1,2,1);
        g.addBiEgde(1,3,6);
        g.addBiEgde(2,4,4);
        g.addBiEgde(5,6,2);
        g.printAdjMatrix();
        System.out.println("Printing BFS results:");
        for(List<Integer> l : bfs.traverse(g)){
            String result = "";
            for(int i : l){
                result += i + " ";
            }
            System.out.println(result);
        }
        g.resetColor();
        System.out.println("Printing DFS results:");
        List<List<Integer>> list = dfs.traverse(g);
        for(List<Integer> l : list){
            String result = "";
            for(int i : l){
                result += i + " ";
            }
            System.out.println(result);
        }
    }
}
