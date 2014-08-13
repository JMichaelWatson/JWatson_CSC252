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
        return null;
    }

    public byte[] decompres(HuffmanTree tree, int uncompressedLength, byte[] b){

        return null;
    }
}
