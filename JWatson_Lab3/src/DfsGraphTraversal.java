import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMichael on 8/25/2014.
 */
public class DfsGraphTraversal {


    public List<List<Integer>> traverse(Graph g) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int count = 0; count < g.vcount(); count++) {
            result.add(DFS(g, count));
        }
        return null;
    }

    private List<Integer> DFS(Graph g, int v) {
        List<Integer> dfs = new ArrayList<Integer>();
        for (int w = g.first(v); w < g.vcount(); w = g.next(v, w)) {
            if (g.getColor(w) == 0) {
                dfs.addAll(DFS(g, w));
            }
        }
        dfs.add(v);
        return dfs;
    }
}
