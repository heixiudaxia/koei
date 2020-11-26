package onjava8.finalize;

/**
 * @Author jojo
 * @create 2020/2/1 下午5:38
 */
public class Book {

    boolean checkedOut = false;

    Book(boolean checkout) {
        checkedOut = checkout;
    }

    void checkin() {
        checkedOut = false;
    }

    protected void finalize() {
        System.out.println("执行finalize方法");
        if (checkedOut) {
            System.out.println("Error: check out");
        } else {
            System.out.println("成功执行:" + this);
        }
    }

}
