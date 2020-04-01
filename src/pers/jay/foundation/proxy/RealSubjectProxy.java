package pers.jay.foundation.proxy;

/**
 * 代理对象
 */
public class RealSubjectProxy implements Subject {

    private RealSubject subject;

    public RealSubjectProxy(RealSubject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        System.out.println("before call request.");
        subject.request();
        System.out.println("after call request.");
    }
}
