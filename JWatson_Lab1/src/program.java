import edu.neumont.io.Bits;

/**
 * Created by JMichael on 8/10/2014.
 */
public class program {

    public static void main(String[] args){
        //char[] chars = {'a','a','a','a','a','b','b','c','c','c','c','c','c','d'};
        //String chars = "today_is_a_good_day_to_die";
        byte[] b = { -34, -24, -15,1 ,1 ,1 ,2 ,-109, -15, -34,-15, -34,-15, -34,-34 };
        byte[] by = {-34};
        byte[] bits ={1,1};// {1,1,0,1,0};//true, true, false, true, false (-34, 2)

        HuffmanTree huffTree = new HuffmanTree(b);
        HuffmanCompressor compressor = new HuffmanCompressor();
        System.out.println("Compression:");
        String result="";
        byte[] temp = compressor.compress(huffTree, by);
        for(int count = 0; count < temp.length; count++){
            result += temp[count]+"";
        }
        System.out.println(result);
        result = "";
        System.out.println("Decompression");
        int count = 0;
        for(byte bs : compressor.decompres(huffTree, bits.length, bits)){
            if(count < bits.length) {
                result += bs + "";
                count++;
            }
        }
        System.out.println(result);
//        huffTree.fromByte(by,bits);
//        System.out.println(bits);
//        Bits dbits = new Bits();
//        dbits.offer(true);
//        dbits.offer(true);
//        System.out.println(huffTree.toBytes(dbits));
    }
}
