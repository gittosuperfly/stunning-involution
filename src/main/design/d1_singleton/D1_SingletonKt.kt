package main.design.d1_singleton

fun main() {
    LazySingletonKt.get().show()
    HungrySingletonKt.show()
    DoubleCheckLockSingletonKt.get().show()
    ClassHolderSingletonKt.get().show()
    EnumSingletonKt.INSTANCE.show()
}

/**
 * 懒汉式
 * 为了使线程安全，需加 {@code @Synchronized}注解
 */
class LazySingletonKt private constructor() {
    companion object {
        private var INSTANCE: LazySingletonKt? = null
            get() {
                if (field == null) {
                    field = LazySingletonKt()
                }
                return field
            }
        @JvmStatic
        @Synchronized
        fun get(): LazySingletonKt {
            return INSTANCE!!
        }
    }

    fun show() {
        println("LazySingletonKt")
    }
}

/**
 * 饿汉式 一个 object 搞定
 * 其字节码翻译过来的代码
 * public final class HungrySingletonKt {
 *     public static final HungrySingletonKt INSTANCE;
 *     private HungrySingletonKt() {}
 *     static {
 *         HungrySingletonKt var0 = new HungrySingletonKt();
 *         INSTANCE = var0;
 *     }
 * }
 * 可以看到就是饿汉式的实现
 */
object HungrySingletonKt {
    fun show() {
        println("HungrySingletonKt")
    }
}

/**
 * 双重校验锁（DCL）
 * 这里用到了委托Lazy：
 * Lazy是接受一个 lambda 并返回一个 Lazy 实例的函数，返回的实例可以作为实现延迟属性的委托：
 *     -第一次调用 get() 会执行已传递给 lazy() 的 lambda 表达式并记录结果
 *     -后续调用 get() 只是返回记录的结果
 *     
 * 这里看一下lazy的实现[lazy],可以看到 lazyMode = LazyThreadSafetyMode.SYNCHRONIZED 时具体实现为 [SynchronizedLazyImpl] .
 * 查看[SynchronizedLazyImpl]可以看到他的实现和DCL是类似的。
 */
class DoubleCheckLockSingletonKt private constructor(){
    companion object{
        private val instance by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            DoubleCheckLockSingletonKt()
        }
        @JvmStatic
        fun get() = instance
    }

    fun show() {
        println("DoubleCheckLockSingletonKt")
    }
}

/**
 * 静态内部类实现
 */
class ClassHolderSingletonKt private constructor() {
    companion object {
        private val instance = SingletonHolder.holder
        @JvmStatic
        fun get() = instance
    }

    private object SingletonHolder {
        val holder= ClassHolderSingletonKt()
    }

    fun show() {
        println("ClassHolderSingletonKt")
    }
}

/**
 * 枚举实现
 */
enum class EnumSingletonKt {
    INSTANCE;

    fun show() {
        println("EnumSingletonKt")
    }
}

