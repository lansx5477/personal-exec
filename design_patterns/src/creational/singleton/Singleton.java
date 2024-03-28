package creational.singleton;

/**
 *
 * @Author: xiaoyinglan
 * @Date: 2023/07/05/11:12
 * @Description: 单例类（不可被继承）
 */
public final class Singleton {

    /**
     * 注意必须要加 volatile 关键字，因为在并发情况下，如果没有volatile关键字，在 instance = new Singleton() 处会出现问题
     * instance = new Singleton() 可以分解为以下三行伪代码
     * a. memory = allocate()  // 分配内存
     * b. ctorInstanc(memory)  // 初始化对象
     * c. instance = memory    // 设置instance指向刚分配的地址
     * 上面的代码在编译运行时，可能会出现重排序从a-b-c排序为a-c-b。在多线程的情况下会出现以下问题：
     * 当线程A在执行 instance = new Singleton() 时，B线程进来执行到 if (instance != null) 。假设此时A执行的过程中发生了指令重排序，即先执行了a和c，没有执行b。
     * 那么由于A线程执行了c导致 instance 指向了一段地址，所以B线程判断 instance 不为 null，会直接返回一个未初始化的对象
     */
    private static volatile Singleton instance;

    private String value;


    private Singleton() {
    }

    private Singleton(String value) {
        this.value = value;
    }

    /**
     * 获取单例对象，如果已经存在缓存的单例对象则直接返回，否则创建新单例对象
     * @return
     */
    public static Singleton getInstance() {
        if (instance != null) {
            return instance;
        }
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }

    /**
     * 获取单例对象，如果已经存在缓存的单例对象则更新其属性值并返回，否则创建新单例对象
     * @param value
     * @return
     */
    public static Singleton getInstance(String value) {
        if (instance != null) {
            instance.setValue(value);
            return instance;
        }
        synchronized (Singleton.class) {
            if (instance != null) {
                instance.value = value;
                return instance;
            }
            return instance = new Singleton(value);
        }
    }

    public void setValue(String value) {
        this.value = value;
    }
}
