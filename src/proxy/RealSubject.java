package proxy;

/**
 * 目标对象
 */
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("This is RealSubject call request.");
    }
}
