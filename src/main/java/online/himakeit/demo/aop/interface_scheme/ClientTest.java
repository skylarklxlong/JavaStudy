package online.himakeit.demo.aop.interface_scheme;

/**
 * author：LiXueLong
 * date：2019-03-12
 * mail1：skylarklxlong@outlook.com
 * mail2：li_xuelong@126.com
 * des:aop接口实现方式
 */
public class ClientTest {
    public static void main(String[] args) {
        StudentInfoService studentInfo = (StudentInfoService) AOPFactory.
                getAOPProxyedObject("online.himakeit.demo.aop.interface_scheme.StudentInfoServiceImpl");
        studentInfo.findInfo("阿飞");
    }
}
