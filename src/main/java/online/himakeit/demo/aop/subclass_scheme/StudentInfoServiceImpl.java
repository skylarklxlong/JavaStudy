package online.himakeit.demo.aop.subclass_scheme;

/**
 * author：LiXueLong
 * date：2019-03-12
 * mail1：skylarklxlong@outlook.com
 * mail2：li_xuelong@126.com
 * des:业务处理
 */
public class StudentInfoServiceImpl{
    public void findInfo(String name){
        System.out.println("你目前输入的名字是:"+name);
    }
}