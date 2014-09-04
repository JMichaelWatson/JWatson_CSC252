/**
 * Created by JMichael on 9/3/2014.
 */
public class Program {

    public static void main(String[] args) {
        FibCOde fibCOde = new FibCOde();
        for(int i = 0; i <= 50; i++){
            Long nan0  = System.nanoTime();
            System.out.println("Fib " + i + " = " + fibCOde.fib(i) + " Time= " + ((System.nanoTime() - nan0) /1000000) + "ms");
        }
    }
}
