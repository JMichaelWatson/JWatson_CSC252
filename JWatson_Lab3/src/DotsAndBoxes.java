/**
 * Created by JMichael on 8/27/2014.
 */
public class DotsAndBoxes  {

    Graph graph;
    StringAndCoins stringAndCoins;
    int gameSize;
    int scores[] = new int[2];


    public DotsAndBoxes(int rows, int columns){
        this.gameSize = columns;
        graph = new Graph(rows*columns);
        stringAndCoins = new StringAndCoins(rows,columns);
    }

    public int drawLine(int player, int x1, int y1, int x2, int y2){
        if(x1 > x2){
            //right to left
            // horizontal
            return horizontal(player,x2 ,y2, x1, y1);
        }else if(y1 > y2){
            //bottom up
            // vertical
            return vertical(player, x2, y2, x1, y1);
        }else if(x2 > x1){
            //horizontal normal
            return horizontal(player, x1, y1, x2, y2);
        }else{
            //vertical normal
            return vertical(player,x1,y1,x2,y2);
        }
    }

    private int vertical(int player, int x1, int y1, int x2, int y2){
        //for vertical
        int sFromVertex = (x2 + (y2 * (gameSize+1)));
        int sToVertex = (x2+1 + (y2 * (gameSize+1)));
        if(stringAndCoins.isEdge(sFromVertex,  sToVertex)) {
            int fromVertex = (x1 + (y1 * gameSize));
            int toVertex = (x2 + (y2 * gameSize));
            System.out.println("Adding  edge from: " +fromVertex + " to " + toVertex);
            graph.addBiEgde(fromVertex, toVertex, player);
            stringAndCoins.addBiEdge(sFromVertex,  sToVertex,0);
        }
        //return if the score if any
        int sco =stringAndCoins.checkCapture(sFromVertex,sToVertex,y1,y2);
        scores[player] += sco;
        return sco;
    }

    private int horizontal(int player, int x1, int y1, int x2, int y2){
        int sFromVertex = (x2 + (y2 * (gameSize+1)));
        int sToVertex = (x2 + ((y2+1) * (gameSize+1)));
        if(stringAndCoins.isEdge(sFromVertex,  sToVertex)) {
            int fromVertex = (x1 + (y1 * gameSize));
            int toVertex = (x2 + (y2 * gameSize));
            System.out.println("Adding  edge from: " +fromVertex + " to " + toVertex);
            graph.addBiEgde(fromVertex, toVertex, player);
            stringAndCoins.addBiEdge(sFromVertex,  sToVertex,0);
        }
        //return if the score if any
        int sco =stringAndCoins.checkCapture(sFromVertex,sToVertex,y1,y2);
        scores[player] += sco;
        return sco;
    }

    public int score(int player){
        return scores[player];
    }

    public boolean anyMovesLeft(){
        return stringAndCoins.anyMovesLeft();
    }

    public int countDoubleCrosses(){
        return stringAndCoins.countDoubleCross();
    }

    public int countCycles(){
        return stringAndCoins.countCycles();
    }

    public int countOpenChains(){
        return stringAndCoins.countOpenChains();
    }

    //testing purpose only
    public void print(){
        System.out.println("Graph:");
        graph.printAdjMatrix();
        System.out.println("String and Coins");
        stringAndCoins.printAdjMatrix();
    }





}
