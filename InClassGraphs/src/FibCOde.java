import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * Created by JMichael on 9/3/2014.
 */
public class FibCOde {
    List<Integer> fibs = new ArrayList<Integer>();

    public FibCOde(){
        fibs.add(0);
        fibs.add(1);
    }
    public int fib(int n){
       if(fibs.size()-1 < n){
           fibRec(n);
       }
        return fibs.get(n);
    }

    private int fibRec(int n){
       for(int i = fibs.size() - 2; i < n; i++){
            fibs.add(fibs.get(i) + fibs.get(i+1));
        }
        return fibs.get(n-1);
    }
}
