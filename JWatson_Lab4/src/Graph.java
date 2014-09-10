import java.util.List;

/**
 * Created by JMichael on 8/20/2014.
 */
public class Graph {
    private int[][] edges; //adjcent matrix
    private int[] color; //visisted array
    private int size;

    public Graph(int v) {
        this.size = v;
        edges = new int[v][v];
        color = new int[v];
    }

    public void resetColor(){
        for(int v = 0; v < size; v++){
            setColor(v,0);
        }
    }

    public boolean checkDependentTOPO(int vertex){
        for(int y = 0; y < vcount(); y++){
            if(edges[vertex][y] != 0){
                if(color[y] ==0)
                 return false;
            }
        }
        return true;
    }


    //iterate through neighbors
    //  first(int) exmaple first(3) return 4th
    //  next(next next); example next(3,4) return the next neighbor after 4 if no next neighbor return 4

    public boolean hasCycle(int start)
    {
        color[start] = 1;
        for (int j = 0; j < vcount(); j++) {
            if (edges[start][j] == 1  &&  (color[j] != 0  ||  hasCycle(j)))
                return true;
        }
        return false;
    }

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

    public int next(int vertex,  int lastVisitedNeighbor) {
        for (int count = lastVisitedNeighbor + 1; count < vcount(); count++) {
            if (edges[vertex][count] != 0) {
                return count;
            }
        }
        return vcount();
    }


    //CRUD Edges

    public void addBiEgde(int fromVertex, int toVertex, int weight) {
        edges[fromVertex][toVertex] = weight;
        edges[toVertex][fromVertex] = weight;
    }
    public boolean anyMovesLeft(){
        boolean isMoves = false;
        for(int i = 0; i < edges.length; i++){
            for(int j = 0; j < edges.length; j++){
                if(isEdge(i,j)){
                    isMoves = true;
                }
            }
        }
        return isMoves;
    }

    public void addEgde(int fromVertex, int toVertex, int weight){
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



    public void printAdjMatrix(){
        System.out.println("------------------------------------------------");
        System.out.println("Matrix:");
       for(int x = 0; x < size; x ++){
           String result = "";
           for(int y = 0; y < size; y++){
               result += edges[x][y] + " ";
           }
           System.out.println(result);
       }
        System.out.println("------------------------------------------------");
    }
    //for(int curr = first(vertex); curr < vcount(); curr = next(vertex, curr){}
    //for bfs dfs algos

}
