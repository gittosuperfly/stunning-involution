package main.design;

/**
 * 单例模式
 * 某个类只能生成一个实例，该类提供了一个全局访问点供外部获取该实例，其拓展是有限多例模式。
 */
public class D1_Singleton {
    public static void main(String[] args) {
        LazySingleton.getInstance().show();
        HungrySingleton.getInstance().show();
        DoubleCheckLockSingleton.getInstance().show();
        ClassHolderSingleton.getInstance().show();
        EnumSingleton.INSTANCE.show();

        //Kotlin实现
        LazySingletonKt.get().show();
        HungrySingletonKt.INSTANCE.show();
        DoubleCheckLockSingletonKt.get().show();
        ClassHolderSingletonKt.get().show();
        EnumSingletonKt.INSTANCE.show();
    }
}

/**
 * 懒汉式 - 用的时候再加载，时间换空间
 * <p>
 * {@link LazySingleton}
 * 如果编写的是多线程程序，则不要删除上例代码中的关键字 {@Code synchronized} 和 {@Code volatile}，否则将存在线程非安全的问题。
 * 如果确定是单线程使用则请删除上述两个关键字。如果不删除这两个关键字就能保证线程安全，但是每次访问时都要同步，会影响性能，且消耗更多的资源。这是懒汉式单例的缺点。
 */
class LazySingleton {
    private static volatile LazySingleton INSTANCE = null;

    private LazySingleton() {
        //防止被外部创建
    }

    public static synchronized LazySingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }

    public void show(){
        System.out.println("LazySingleton");
    }
}

/**
 * 饿汉式 - 类加载的时候就创建一个单例，空间换时间
 * <p>
 * 饿汉式单例在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以是线程安全的，可以直接用于多线程而不会出现问题。
 */
class HungrySingleton {
    private static final HungrySingleton INSTANCE = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return INSTANCE;
    }

    public void show(){
        System.out.println("HungrySingleton");
    }
}

/**
 * 双重校验锁（DCL）
 *
 * 只有在对象需要被使用时才创建，第一次判断 INSTANCE == null为了避免非必要加锁，当第一次加载时才对实例进行加锁再实例化。
 * 这样既可以节约内存空间，又可以保证线程安全。
 */
class DoubleCheckLockSingleton {
    private static volatile DoubleCheckLockSingleton INSTANCE = null;

    private DoubleCheckLockSingleton() {
    }

    public static DoubleCheckLockSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (DoubleCheckLockSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckLockSingleton();
                }
            }
        }
        return INSTANCE;
    }

    public void show(){
        System.out.println("DoubleCheckLockSingleton");
    }
}

/**
 * 静态内部类模式
 *
 * 静态内部类也有着一个致命的缺点，就是传参的问题，由于是静态内部类的形式去创建单例的，故外部无法传递参数进去.
 */
class ClassHolderSingleton {
    private ClassHolderSingleton(){}

    private static class ClassHolderSingletonHolder{
        private static final ClassHolderSingleton INSTANCE = new ClassHolderSingleton();
    }

    public static ClassHolderSingleton getInstance(){
        return ClassHolderSingletonHolder.INSTANCE;
    }

    public void show(){
        System.out.println("ClassHolderSingleton");
    }
}

/**
 * 枚举实现
 *
 * 枚举在java中与普通类一样，都能拥有字段与方法，而且枚举实例创建是线程安全的，在任何情况下，它都是一个单例。
 * 直接以 EnumSingleton.INSTANCE 方式调用
 */
enum EnumSingletonKt {
    INSTANCE;

    public void show(){
        System.out.println("EnumSingleton");
    }
}