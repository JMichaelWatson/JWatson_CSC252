import com.sun.org.apache.xpath.internal.SourceTree;
import edu.neumont.io.Bits;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by JMichael on 8/10/2014.
 */
public class program {

    public static void main(String[] args){
///BASIC TEST/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        char[] chars = {'a','a','a','a','a','b','b','c','c','c','c','c','c','d'};
//        String chars = "today_is_a_good_day_to_die";
//        byte[] b = { -34, -24, -15,1 ,1 ,1 ,2 ,-109, -15, -34,-15, -34,-15, -34,-34 };
//        byte[] by = {-34,2,-34,2};
//        byte[] bits = {-42,-128};//{(byte)Integer.parseInt("11010110",2),(byte)Integer.parseInt("10000000",2)};

//        HuffmanTree huffTree = new HuffmanTree(b);
//        HuffmanCompressor compressor = new HuffmanCompressor();
//        System.out.println("Compression:");
//        String result="";
//       byte[] temp = compressor.compress(huffTree, by);
//        for(int count = 0; count < temp.length; count++){
//            result += temp[count]+"_";
//        }
//        System.out.println(result);
//        result = "";
//        System.out.println("Decompression");
//        byte[] decompTemp = compressor.decompress(huffTree,4,bits);
//        for(byte bs : decompTemp){
//          result += bs + " ";
//        }
//        System.out.println(result);


 ///Java IMAGE/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//        Map<Byte, Double> freqChar = new TreeMap<Byte, Double>();
//        byte[] Keys = new byte[256];
//        byte x= -128;
//        for(int count = 0; count < 256; count++ ){
//            Keys[count] = x++;
//        }
//        double[] Values = {423, 116, 145, 136, 130, 165, 179, 197, 148, 125, 954, 156, 143, 145, 164, 241, 107,
//                149, 176, 153, 121, 164, 144, 166, 100, 138, 157, 140, 119, 138, 178, 289, 360, 120, 961, 195,
//                139, 147, 129, 192, 119, 146, 138, 184, 137, 196, 163, 331, 115, 160, 127, 172, 176, 181, 149,
//                194, 138, 154, 163, 167, 196, 174, 250, 354, 142, 169, 170, 209, 205, 179, 147, 245, 108, 179,
//                148, 186, 131, 160, 112, 219, 118, 204, 164, 154, 154, 175, 189, 239, 126, 145, 185, 179, 149,
//                167, 152, 244, 189, 257, 234, 208, 179, 170, 171, 178, 184, 189, 203, 184, 204, 208, 187, 163,
//                335, 326, 206, 189, 210, 204, 230, 202, 415, 240, 275, 295, 375, 308, 401, 608, 2099, 495, 374,
//                160, 130, 331, 107, 181, 117, 133, 476, 129, 137, 106, 107, 237, 184, 143, 122, 143, 1596, 205,
//                121, 170, 123, 124, 150, 132, 143, 133, 178, 308, 96, 102, 114, 176, 159, 149, 123, 199, 1156,
//                119, 144, 237, 131, 155, 143, 225, 92, 125, 117, 138, 135, 154, 124, 137, 121, 143, 149, 141, 177,
//                159, 247, 384, 302, 120, 95, 140, 87, 1460, 155, 199, 111, 198, 147, 182, 91, 148, 119, 233, 445,
//                1288, 138, 133, 122, 170, 156, 257, 143, 149, 180, 174, 132, 151, 193, 347, 91, 119, 135, 182, 124,
//                152, 109, 175, 152, 159, 166, 224, 126, 169, 145, 220, 119, 148, 133, 158, 144, 185, 139, 168, 244,
//                145, 167, 167, 262, 214, 293, 402};
//        for(int counter = 0; counter < 256; counter++){
//           // System.out.println("Key : " + Keys[counter] + " Value: " + Values[counter]);
//            freqChar.put(Keys[counter], Values[counter]);
//        }
//        HuffmanTree huffTree = new HuffmanTree(freqChar);
//        HuffmanCompressor compressor = new HuffmanCompressor();
//
//        try {
//            byte[] bytes = Files.readAllBytes(Paths.get("compressed.huff"));
//            System.out.println("Decompressing...");
//            byte[] decompBytes =  compressor.decompress(huffTree, 54679, bytes);
//            Files.write(Paths.get("decompressed.jpg"), decompBytes);
//            System.out.println("Decompressed...");
//        }catch (IOException exp){
//            System.out.println("INVALID FILE");
//        }

///PERSONAL IMAGE/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        try {
            byte[] bytes = Files.readAllBytes(Paths.get("Test.png"));
            HuffmanTree huffmanTree = new HuffmanTree(bytes);
            HuffmanCompressor compressor = new HuffmanCompressor();
            System.out.println("Compressing....");
            byte[] compressBytes =compressor.compress(huffmanTree,bytes);
            Files.write(Paths.get("compressed.png"), compressBytes);
            System.out.println("Compressed...");
            System.out.println("Decompressing...");
            byte[] decompressBytes = compressor.decompress(huffmanTree,bytes.length,compressBytes);
            Bits test = new Bits();
            huffmanTree.fromByte((byte)80, test);
            System.out.println(test);
            huffmanTree.toByte(test);
            System.out.println("-----------------------------------");
            System.out.println(Arrays.toString(bytes));
            System.out.println("-----------------------------------");
            System.out.println(Arrays.toString(decompressBytes));
            Files.write(Paths.get("decompressed.png"), decompressBytes);
            System.out.println("Decompressed...");
        }catch (IOException exp){
            System.out.println("INVALID FILE");
        }

    }
}
