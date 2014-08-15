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
       for(int count = 0; count < bits.size(); count++) {
           if(counter < 8){
               if(bits.get(count)){
                   newByte += "1";
                   counter++;
               }else{
                   newByte += "0";
                   counter++;
               }
           }else{
               bytes[index] = (byte)Integer.parseInt(newByte,2);
               count--;
               counter = 0;
               index++;
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
            for(char c : converter.toCharArray()){
                if(c == '1'){
                    bits.offer(true);
                }else{
                    bits.offer(false);
                }
            }
        }
        byte[] bytes = new byte[uncompressedLength];
        for(int count = 0; count < uncompressedLength; count++){
            bytes[count]=tree.toByte(bits);
        }
        return bytes;
    }
}
