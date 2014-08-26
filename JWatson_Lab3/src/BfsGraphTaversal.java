import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by JMichael on 8/25/2014.
 */
public class BfsGraphTaversal {


    public List<List<Integer>> traverse(Graph g){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int count = 0; count < g.vcount(); count++){
            if(g.getColor(count)== 0){
                result.add(bfs(g,count));
            }
        }
        return result;
    }

    private List<Integer> bfs(Graph g, int start) {
        List<Integer> result = new ArrayList<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(start);
        g.setColor(start,1);
        while(q.size() > 0){
            int v= q.poll();
             result.add(v);
            for(int w = g.first(v); w < g.vcount(); w = g.next(v,w)){
                if(g.getColor(w) == 0){
                    g.setColor(w, 1);
                    q.offer(w);
                }
            }
        }
        return result;
    }
}

//int vcount = g.vcount();
//for (int count = 0; count < vcount; count++) {
//        List<Integer> bfs = new ArrayList<Integer>();
//        int curr = g.first(count);
//        if(g.getColor(count)==0) {
//        bfs.add(count);
//        g.setColor(count, 1);
//        }
//        while (curr < vcount) {
//        if (g.getColor(curr) == 0) {
//        g.setColor(curr, 1);
//        bfs.add(curr);
//        }
//        curr = g.next(count, curr);
//        }
//        if(bfs.size() >0) {
//        result.add(bfs);
//        }
//        }
