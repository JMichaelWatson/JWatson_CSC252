/**
 * Created by JMichael on 8/10/2014.
 */
public class program {

    public static void main(String[] args){
        //char[] chars = {'a','a','a','a','a','b','b','c','c','c','c','c','c','d'};
        //String chars = "today_is_a_good_day_to_die";
        byte[] b = { -34, -24, -15,1 ,1 ,1 ,2 ,-109, -15, -34,-15, -34,-15, -34 };
        HuffmanTree huffTree = new HuffmanTree(b);
    }
}
