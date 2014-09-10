import java.util.LinkedList;
import java.util.List;

/**
 * Created by JMichael on 9/10/2014.
 */
public class TopoSort {

    public LinkedList<Integer> sort(Graph g){
        DfsGraphTraversal dfsGraphTraversal = new DfsGraphTraversal();
       List<List<Integer>> unsorted = dfsGraphTraversal.traverse(g);
        if(g.hasCycle(g.first(0)))
            return new LinkedList<>();
        return reverse(unsorted.get(0));
    }

    private LinkedList<Integer> reverse(List<Integer> list){
        LinkedList<Integer> result = new LinkedList<>();
        for(int i= list.size()-1;  i >= 0; i--){
            result.add(list.get(i));
        }
        return result;
    }
}
