import edu.neumont.io.Bits;

import java.util.List;

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
                   counter++;
               }else{
                   newByte += "0";
                   counter++;
               }
           }else{
               counter = 0;
               bytes[index] = Byte.valueOf(newByte,2);
               newByte = "";
           }
       }
        while(newByte.length() < 8){
            newByte+="0";
        }
        bytes[index] = (byte)Integer.parseInt(newByte,2);
       // bytes[index] = Byte.valueOf(newByte,2);
        return bytes;
    }

    public byte[] decompress(HuffmanTree tree, int uncompressedLength, byte[] b){
        Bits bits = new Bits();
        for(int count = 0; count < b.length; count++){
            String converter = String.format("%8s", Integer.toBinaryString(b[count] & 0xFF)).replace(' ', '0');
            for(int counter = 0; counter < uncompressedLength; counter++){
                if(converter.charAt(counter) == '1'){
                    bits.offer(true);
                }else{
                    bits.offer(false);
                }
            }
        }

        return tree.toBytes(bits);
    }
}
