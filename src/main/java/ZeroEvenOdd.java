import java.util.function.IntConsumer;

/**
 * @author macheng
 * @date 2021/3/10 20:30
 */
public class ZeroEvenOdd {
    private int n;
    private volatile int i=1;
    private volatile int flag=-1;
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        while(true){
            if(flag==-1){
                if(i<=n){
                    printNumber.accept(0);
                    System.out.println(0);
                    i++;
                    flag=i%2;
                }else{
                    i++;
                    flag=i%2;
                    break;
                }
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while(true){
            if(flag==0){
                if(i<=n ){
                    printNumber.accept(i);
                    System.out.println(i);
                    flag=-1;
                }else{
                    break;
                }
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while(true){
            if(flag==1){

                if(i<=n ){
                    printNumber.accept(i);
                    flag=-1;

                }else{
                    break;
                }
            }
        }
    }
}
