import com.sun.org.glassfish.external.statistics.annotations.Reset;

/**
 * Created by JMichael on 8/29/2014.
 */
public class StringAndCoins {
    int[][] strings;
    int[] color;
    int size;
    int baseSize;


    public StringAndCoins(int rows, int columns) {
        baseSize = columns + 1;
        this.size = (rows + 1) * (columns + 1);
        strings = new int[size][size];
        color = new int[size];
        setup();
    }


    private void setup() {
        for (int y = 1; y < baseSize - 1; y++) {
            for (int x = 1; x < baseSize - 1; x++) {
                int fromVertex = (x + (baseSize * y));
                int toVertex = (x + ((y - 1) * baseSize));
                addBiEdge(fromVertex, toVertex, 1);//top
                toVertex = (x + ((y + 1) * baseSize));
                addBiEdge(fromVertex, toVertex, 1);//down
                toVertex = ((x + 1) + ((y) * baseSize));
                addBiEdge(fromVertex, toVertex, 1);//right;
                toVertex = ((x - 1) + ((y) * baseSize));
                addBiEdge(fromVertex, toVertex, 1);//left

            }
        }
    }

    public void addBiEdge(int fromVertex, int toVertex, int weight) {
        strings[fromVertex][toVertex] = weight;
        strings[toVertex][fromVertex] = weight;
    }

    public void printAdjMatrix() {
        System.out.println("------------------------------------------------");
        System.out.println("Matrix:");
        for (int x = 0; x < size; x++) {
            String result = "";
            for (int y = 0; y < size; y++) {
                result += strings[x][y] + " ";
            }
            System.out.println(result);
        }
        System.out.println("------------------------------------------------");
    }

    public boolean isEdge(int fromVertex, int toVertex) {

        return strings[fromVertex][toVertex] != 0;
    }

    public boolean anyMovesLeft() {
        boolean isMoves = false;
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings.length; j++) {
                if (isEdge(i, j)) {
                    isMoves = true;
                }
            }
        }
        return isMoves;
    }


    public int checkCapture(int fromVertex, int toVertex) {
        int isCaptured = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[fromVertex][i] != 0) {
                isCaptured++;
            }
        }
        for (int i = 0; i < strings.length; i++) {
            if (strings[toVertex][i] != 0) {
                isCaptured++;
            }
        }
        return isCaptured;
    }

    public int countDoubleCross() {
        int total = 0;
        for (int i = 1; i < baseSize; i++) {
            if(color[i]==0) {
                int count = neighborCount(i);
                if (count == 1 && neighborCount(first(i)) == 1) {
                    total++;
                }
                color[i] = 1;
                color[first(i)] = 1;
            }
        }
        ResetColor();
        return total;
    }

    private int neighborCount(int fromVertex) {
        int count = 0;
        for (int j = 1; j < baseSize; j++) {
            if (strings[fromVertex][j] == 1) {
                count++;
            }
        }
        return count;
    }

    public int countCycles() {
        int total = 0;
        for (int i = 1; i < baseSize; i++) {
            if (color[i] != 1) {
                if (neighborCount(i) == 2) {
                    boolean cont = true;
                    int next = i;
                    while (cont) {
                        color[next] = 1;
                        next = first(next);
                        if (next == i) {
                            cont = false;
                            total++;
                        }
                        if (neighborCount(next) != 2) {
                            cont = false;
                        }
                    }
                }
            }
        }
        ResetColor();
        return total;
    }

    public int countOpenChains(){
        int total = 0;
        for (int i = 1; i < baseSize; i++) {
            if (color[i] != 1) {
                color[i] = 1;
                if(neighborCount(i) >= 3 || neighborCount(i) == 1){
                    int count = 0;
                    for(int curr = first(i); curr < this.baseSize; curr = next(i, curr)){
                        if(color[curr]!=1){
                            if (neighborCount(curr) > 0 && neighborCount(curr) <= 2) {
                                count++;
                                color[curr] = 1;
                                boolean contin = true;
                                while (contin) {
                                    curr = nextUncolor(curr);
                                    if(neighborCount(curr)<1 || neighborCount(curr)>2){
                                        contin = false;
                                    }else{
                                        count++;
                                    }
                                }
                                if (count > 2) {
                                    total++;
                                }
                            }
                        }
                    }
                }
            }
        }
        ResetColor();
        return total;
    }

    private int nextUncolor(int vertex){
        for(int curr = first(vertex); curr< this.baseSize; curr = next(vertex,curr)){
            if(color[curr] == 0){
                return curr;
            }
        }
        return vertex;
    }

    private void ResetColor() {
        for(int i = 0; i < size; i++){
            color[i] = 0;
        }
    }

    private int first(int vertex) {
        for (int count = 0; count < strings.length; count++) {
            if (strings[vertex][count] != 0) {
                return count;
            }
        }
        return strings.length;
    }

    private int next(int vertex, int lastVisitedNeighbor) {
        for (int count = lastVisitedNeighbor + 1; count < strings.length; count++) {
            if (strings[vertex][count] != 0) {
                return count;
            }
        }
        return strings.length;
    }

//for(int curr = first(vertex); curr < vcount(); curr = next(vertex, curr){}
}

