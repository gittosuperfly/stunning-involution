package main.design.d2_prototype

/**
 *
 */
fun main() {
    val real = RealizeTypeKt()
    val clone = real.clone() as RealizeTypeKt
    real.value = "REAL"
    clone.value = "CLONE"
    real.show()
    clone.show()
    println(real == clone)

    val real2 = RealizeTypeKt2("REAL")
    val clone2 = real2.copy(value = "CLONE")
    real2.show()
    clone2.show()
    println(real2 == clone2)
}

/**
 * 不建议使用Cloneable接口，而应该考虑使用拷贝构造器（copy constructor）或拷贝工厂（copy factory）来代替
 */
class RealizeTypeKt : Cloneable {
    init {
        println("原型创建成功")
    }

    var value: String? = null

    fun show() {
        println("$this  $value")
    }

    @Throws(CloneNotSupportedException::class)
    public override fun clone(): Any {
        println("原型克隆成功！")
        return super.clone()
    }
}

/**
 * Kotlin中的data class提供了方便的copy方法。copy方法其实就相当于一个拷贝工厂
 * 需要注意的是，copy方法实现的是浅拷贝，有些时候需要深拷贝，这就需要我们自己来实现
 */
data class RealizeTypeKt2(var value:String){
    fun show() {
        println("$this  $value")
    }
}