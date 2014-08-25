import edu.neumont.io.Bits;

import java.util.*;


/**
 * Created by JMichael on 8/10/2014.
 */
public class HuffmanTree {

    private Node root;
    private int freqcount;
    private Map<Byte, Double> freqChar = new TreeMap<Byte, Double>();
//    private PriorityQueue<Node> queue = new PriorityQueue<Node>();
    private HeadBasedPriorityQueue<Node> queue = new HeadBasedPriorityQueue<Node>(257);
//    private AVLBasedPriorityQueue<Node> queue = new AVLBasedPriorityQueue<Node>();

    public HuffmanTree(byte[] bytes){
        freqcount=bytes.length;
        CreateFreqChar(bytes);
        BasicSetup();
    }

    public HuffmanTree(Map<Byte,Double> freqChar){
        freqcount = freqChar.size();
        this.freqChar = freqChar;
        BasicSetup();
    }

    public byte toByte(Bits bits){
        //decompression
        return decompress(root, bits);
    }

    public void fromByte(byte b, Bits bits){
        //compression
        compression(root, b, bits);

    }

    private void BasicSetup() {
//        PrintFreqChart();
        FillQueue();
        BuildTree();
//        PrintTree();
    }

    private void compression(Node current, byte b, Bits bits) {
             if(current != null){
                 if(!current.getIsLeaf()) {
                     if (current.getKey().contains(b)) {
                         List<Byte> leftKey = current.getLeftNode().getKey();
                         if (leftKey.contains(b)) {
                             bits.offer(false);
                             compression(current.getLeftNode(), b, bits);
                         } else {
                             bits.offer(true);
                             compression(current.getRightNode(), b, bits);
                         }
                     }
                 }
             }
    }

    private byte decompress(Node current, Bits bits){
        byte result = 0;
        if(current != null){
            if(bits.size() <=0)
                System.out.println("ERROR: " + current.getKey());
            else {
                if (!current.getIsLeaf()) {
                    boolean bit = bits.poll();
                    if (bit) {
                        result = decompress(current.getRightNode(), bits);
                    } else {
                        result = decompress(current.getLeftNode(), bits);
                    }
                } else {
                   // bits.poll();
                    result = current.getKey().get(0);
                }
            }
        }
        return result;
    }

    private void BuildTree() {
        int size = queue.size();
        for(int count = 0; count < size; count++){
            if(queue.size() > 1){
                Node first = queue.poll();
                Node second = queue.poll();
                    Node parent = new Node(first.getKey(), first.getValue() + second.getValue());
                    parent.addKey(second.getKey());
                    parent.setLeft(first);
                    parent.setRight(second);
                    queue.offer(parent);
//                    System.out.println("Parent Key: " + parent.getKey());
            }else{
                root = queue.poll();
            }
        }
    }

    private void FillQueue() {
        Iterator<Byte> keySetIterator = freqChar.keySet().iterator();

        while(keySetIterator.hasNext()){
            byte key = keySetIterator.next();
            Node temp = new Node(key,freqChar.get(key)/freqcount);
            temp.setIsLeaf(true);
            queue.offer(temp);
//            System.out.println("Inserted AVLNode: " + temp.getKey());
        }
    }

    private void PrintFreqChart() {
        Iterator<Byte> keySetIterator = freqChar.keySet().iterator();
        while(keySetIterator.hasNext()){
            byte key = keySetIterator.next();
            System.out.println("key: " + key + " value: " + freqChar.get(key));
        }
    }

    private void CreateFreqChar(byte[] bytes) {
        for(byte b : bytes){
            if(!freqChar.containsKey(b)){
                freqChar.put(b,1.0);
            }else{
                double temp = freqChar.get(b);
                freqChar.replace(b,temp + 1);
            }
        }
    }

    public void PrintTree() {
        Printer p = new Printer();
        p.printNode(root);
    }
}
