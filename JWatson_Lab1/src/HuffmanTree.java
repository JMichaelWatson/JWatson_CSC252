import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;


/**
 * Created by JMichael on 8/10/2014.
 */
public class HuffmanTree {

    private Node root;
    private int freqcount;
    private HashMap<String, Double> freqChar = new HashMap<String, Double>();
    private PriorityQueue<Node> queue = new PriorityQueue<Node>();

    public HuffmanTree(byte[] bytes){
        freqcount=bytes.length;
        CreateFreqChar(bytes);
        PrintFreqChart();
        FillQueue();
        BuildTree();
        Printer p = new Printer();
        p.printNode(root);
    }

    public HuffmanTree(char[] chars){
        freqcount=chars.length;
        CreateFreqChar(chars);
        PrintFreqChart();
        FillQueue();
        BuildTree();
        Printer p = new Printer();
        p.printNode(root);



    }

    private void BuildTree() {
        int size = queue.size();
        for(int count = 0; count < size; count++){
            if(queue.size() > 1){
                Node first = queue.poll();
                Node second = queue.poll();
                Node parent = new Node(first.getKey() + " " + second.getKey(), first.getValue() + second.getValue());
                parent.setLeft(first);
                parent.setRight(second);
                queue.add(parent);
            }else{
                root = queue.poll();
            }
        }
    }

    private void FillQueue() {
        Iterator<String> keySetIterator = freqChar.keySet().iterator();

        while(keySetIterator.hasNext()){
            String key = keySetIterator.next();
            Node temp = new Node(key,freqChar.get(key)/freqcount);
            temp.setIsLeaf(true);
            queue.add(temp);
            System.out.println("Inserted Node: " + temp.getKey());
        }
    }



    private void PrintFreqChart() {
        Iterator<String> keySetIterator = freqChar.keySet().iterator();

        while(keySetIterator.hasNext()){
            String key = keySetIterator.next();
            System.out.println("key: " + key + " value: " + freqChar.get(key));
        }
    }

    private void CreateFreqChar(char[] chars) {
        for(char c : chars){
            if(!freqChar.containsKey(c+"")){
                freqChar.put(c+"",1.0);
            }else{
                double temp = freqChar.get(c+"");
                freqChar.replace(c+"",temp + 1);
            }
        }
    }
    private void CreateFreqChar(byte[] bytes) {
        for(byte b : bytes){
            if(!freqChar.containsKey(b+" ")){
                freqChar.put(b+" ",1.0);
            }else{
                double temp = freqChar.get(b+" ");
                freqChar.replace(b+" ",temp + 1);
            }
        }
    }

    public void PrintTree() {
        Printer p = new Printer();
        p.printNode(root);
    }
}
