package online.himakeit.demo.aop.interface_scheme;

import online.himakeit.demo.aop.interface_scheme.StudentInfoService;
/**
 * author：LiXueLong
 * date:2019-03-12-11:00
 * mail1：skylarklxlong@outlook.com
 * mail2：li_xuelong@126.com
 * des：StudentInfoServiceImpl实现类
 */
public class StudentInfoServiceImpl implements StudentInfoService {
    public void findInfo(String studentName) {
        System.out.println("你目前输入的名字是:" + studentName);
    }
}
