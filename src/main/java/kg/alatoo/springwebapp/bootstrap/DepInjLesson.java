package kg.alatoo.springwebapp.bootstrap;

import kg.alatoo.springwebapp.config.MyBean;
import kg.alatoo.springwebapp.config.MyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DepInjLesson implements CommandLineRunner {

    private MyBean myBean;
    private final MyConfig myConfig;


    @Autowired
    public DepInjLesson(MyConfig myConfig) {
//        this.myBean = myBean;
        this.myConfig = myConfig;
    }

    @Override
    public void run(String... args) throws Exception {
        MyBean firstBean = myConfig.getBean();
        MyBean secondBean = myConfig.getBean();
        System.out.println("myBean = " + myBean);
        System.out.println("firstBean = " + firstBean);
        System.out.println("secondBean = " + secondBean);

//        myBean.setName("myBean");
        secondBean.setName("secondBean");

        System.out.println("myBean = " + myBean);
        System.out.println("firstBean = " + firstBean);
        System.out.println("secondBean = " + secondBean);
    }
}
