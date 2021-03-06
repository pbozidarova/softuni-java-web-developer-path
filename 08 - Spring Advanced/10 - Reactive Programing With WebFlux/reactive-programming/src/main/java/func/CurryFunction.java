package func;

import java.util.function.Function;

public class CurryFunction {

    public int multiply(int a, int b){
        return a * b;
    }

    Function<Integer, Function<Integer, Integer>> curryMulti = u -> v -> u * v;

    public void test(){
        int res1 = multiply(2, 3);
        int res2 = curryMulti.apply(2). apply(3);
    }

}
