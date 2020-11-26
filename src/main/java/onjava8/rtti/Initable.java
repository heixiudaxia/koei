package onjava8.rtti;

/**
 * @Author jojo
 * @create 2020/3/8 下午3:10
 */
class Initable {
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
    static final int staticFinal = 47;

    static {
        System.out.println("Initializing Initable");
    }

}
