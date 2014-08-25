/**
 * Created by JMichael on 8/20/2014.
 */
public class Graph {
    private int[][] edges; //adjcent matrix
    private int[] color; //visisted array

    public Graph(int v) {
        edges = new int[v][v];
        color = new int[v];
    }

    //iterate through neighbors
    //  first(int) exmaple first(3) return 4th
    //  next(next next); example next(3,4) return the next neighbor after 4 if no next neighbor return 4


    public int vcount() {
        return color.length;
    }

    public int first(int vertex) {
        for (int count = 0; count < vcount(); count++) {
            if (edges[vertex][count] != 0) {
                return count;
            }
        }
        return vcount();
    }

    public int next(int vertex, int lastVisitedNeighbor) {
        for (int count = lastVisitedNeighbor; count < vcount(); count++) {
            if (edges[vertex][count] != 0) {
                return count;
            }
        }
        return vcount();
    }

    //CRUD Edges

    public void addEgde(int fromVertex, int toVertex, int weight) {
        edges[fromVertex][toVertex] = weight;
    }

    public void removeEdge(int fromVertex, int toVertex) {
        edges[fromVertex][toVertex] = 0;
    }

    public boolean isEdge(int fromVertex, int toVertex){
        return edges[fromVertex][toVertex] != 0;
    }

    //Color the graph

    public int getColor(int vertex){
        return color[vertex];
    }

    public void setColor(int vertex, int color){
        this.color[vertex] = color;
    }

    //for(int curr = first(vertex); curr < vcount(); curr = next(vertex, curr){}
    //for bfs dfs algos

}
