package main.design.d2_prototype;

/**
 * 原形模式
 * 用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型相同或相似的新对象。
 * 在这里，原型实例指定了要创建的对象的种类。用这种方式创建对象非常高效，根本无须知道对象创建的细节。
 *
 * 原型模式通常适用于以下场景。
 * 对象之间相同或相似，即只是个别的几个属性不同的时候。
 * 创建对象成本较大，例如初始化时间长，占用CPU太多，或者占用网络资源太多等，需要优化资源。
 * 创建一个对象需要繁琐的数据准备或访问权限等，需要提高性能或者提高安全性。
 * 系统中大量使用该类对象，且各个调用者都需要给它的属性重新赋值。
 */
public class D2_Prototype {
    public static void main(String[] args) throws CloneNotSupportedException{
        //text1
        RealizeType realize = new RealizeType();
        RealizeType cloneObject = (RealizeType) realize.clone();
        realize.setValue("REAL");
        cloneObject.setValue("CLONE");
        realize.show();
        cloneObject.show();
        System.out.println(realize == cloneObject);
    }
}

/**
 * 克隆的原型
 */
class RealizeType implements Cloneable {

    private String value;

    public RealizeType(){
        System.out.println("原型创建成功");
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void show(){
        System.out.println(this +"  "+value);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("原型克隆成功！");
        return super.clone();
    }
}


