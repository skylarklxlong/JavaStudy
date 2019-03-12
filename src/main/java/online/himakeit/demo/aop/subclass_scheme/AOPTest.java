package online.himakeit.demo.aop.subclass_scheme;

/**
 * author：LiXueLong
 * date：2019-03-12
 * mail1：skylarklxlong@outlook.com
 * mail2：li_xuelong@126.com
 * des:aop子类实现方式
 */
public class AOPTest {
    public static void main(String[] args) {
        AOPInstrumenter instrumenter = new AOPInstrumenter();
        StudentInfoServiceImpl studentInfo = (StudentInfoServiceImpl) instrumenter.getInstrumentedClass(StudentInfoServiceImpl.class);
        studentInfo.findInfo("阿飞");
    }
}
