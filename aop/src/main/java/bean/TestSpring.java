package bean;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@ComponentScan("java.*")
public class TestSpring {
    public static void main (String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//ApplicationContext context = new FileSystemXmlApplicationContext("applicationContext.xml");
        TestBean service = context.getBean("testBean",TestBean.class);

        System.out.println(service.toString());

    }
}
