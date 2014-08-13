import edu.neumont.io.Bits;

/**
 * Created by JMichael on 8/12/2014.
 */
public class HuffmanCompressor {

    public byte[] compress(HuffmanTree tree, byte[] b) {
         Bits bits = new Bits();
        for(int count = 0; count < b.length; count++){
            tree.fromByte(b[count],bits);
        }
        byte[] bytes = new byte[(bits.size()/8)+1];
        int counter=0;
        int index = 0;
        String newByte ="";
       for(boolean bit : bits) {
           if(counter < 8){
               if(bit){
                   newByte += "1";
               }else{
                   newByte += "0";
               }
           }else{
               counter = 0;
               bytes[index] = Byte.valueOf(newByte);
               newByte = "";
           }
       }
        bytes[index] = Byte.valueOf(newByte);
        return bytes;
    }

    public byte[] decompres(HuffmanTree tree, int uncompressedLength, byte[] b){
        Bits bits = new Bits();
        for(byte byt : b){
            String converter = byt+"";
            for(char c : converter.toCharArray()){
                if(c == '1'){
                    bits.offer(true);
                }else{
                    bits.offer(false);
                }
            }
        }

        return tree.toBytes(bits);
    }
}
