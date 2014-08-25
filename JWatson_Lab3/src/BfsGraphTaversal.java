import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMichael on 8/25/2014.
 */
public class BfsGraphTaversal {



    public List<List<Integer>> traverse(Graph g){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int count = 0; count < g.vcount(); count++) {
            List<Integer>bfs = new ArrayList<Integer>();
            for (int curr = g.first(count); curr < g.vcount(); curr = g.next(count, curr)) {
                    if(g.getColor(curr) == 0){
                        g.setColor(curr,1);
                        bfs.add(curr);
                    }
            }
            result.add(bfs);
        }
        return result;
    }
}
