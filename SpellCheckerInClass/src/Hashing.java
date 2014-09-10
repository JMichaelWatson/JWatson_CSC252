/**
 * Created by JMichael on 9/9/2014.
 */
public class Hashing {
    public static int hash(String str){
        int hash = 0;
        for(int i = 0; i < str.length(); i++){
            hash += 31 * hash + str.charAt(i);
        }
        return hash;
    }

    public static void main(String[] args) {
        System.out.println(hash("mike"));
        System.out.println(hash("jake"));
        System.out.println(hash("darrius"));
    }
}
