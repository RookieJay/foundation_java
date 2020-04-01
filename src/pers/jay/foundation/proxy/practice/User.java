package pers.jay.foundation.proxy.practice;

/**
 * 目标对象(委托者)：用户
 */
public class User implements Action {

    private boolean hasPrivilege;

    private String s;

    public boolean isHasPrivilege() {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("非法参数");
        }
        return hasPrivilege;
    }

    public void setHasPrivilege(boolean hasPrivilege) {
        this.hasPrivilege = hasPrivilege;
    }

    @Override
    public void query() {
        System.out.println("我是用户，我开始查询了...");
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
