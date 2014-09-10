import junit.framework.TestCase;
import org.junit.Test;

import java.util.LinkedList;

public class TopoSortTest extends TestCase {

    @Test
    public void testSort(){
        Graph g = new Graph(6);
        TopoSort topoSort = new TopoSort();
        g.addEgde(0,1,1);
        g.addEgde(1, 2, 1);
        g.addEgde(1,3,1);
        g.addEgde(3,4,1);
        g.addEgde(4,5,1);
        g.addEgde(5,2,1);
       // g.addEgde(5,3,1);
        assertEquals(6,g.vcount());
        LinkedList<Integer> list = topoSort.sort(g);
        assertEquals(6,list.size());
        assertEquals(0,list.get(0).intValue());
        assertEquals(1,list.get(1).intValue());
        assertEquals(3,list.get(2).intValue());
        assertEquals(4,list.get(3).intValue());
        assertEquals(5,list.get(4).intValue());
        assertEquals(2,list.get(5).intValue());
    }
}