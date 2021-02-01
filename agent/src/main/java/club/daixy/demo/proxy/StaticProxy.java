package club.daixy.demo.proxy;

/**
 * @author daixiaoyong
 * @date 2021/1/25 10:44
 * @description 静态代理
 */
public class StaticProxy implements Owner{
    private LiuYi liuYi;

    //静态代理缺点：中介只能给具体的某一个人提供中介服务，这就很有局限性
    public StaticProxy(LiuYi liuYi){
        this.liuYi = liuYi;
    }


    @Override
    public void saleHouse() {
        System.out.println("find buyer，对价格进行初步筛选，合适的话才可以与房东进一步沟通");
        liuYi.saleHouse();
        System.out.println("卖房后期流程");
    }
}