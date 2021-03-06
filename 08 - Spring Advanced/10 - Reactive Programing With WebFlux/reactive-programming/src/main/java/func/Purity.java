package func;

public class Purity {

    public int sum(int a, int b){
        return a + b;
    }

    public int get(){
        return 10;
    }

    public void useless(int a){
        int b = a + 1;
    }

    int requestCount = 0;

    //non pure function
    public void incRequest(int count){
        requestCount += count;
    }

}
