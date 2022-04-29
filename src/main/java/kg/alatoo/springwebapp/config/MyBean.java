package kg.alatoo.springwebapp.config;

import org.springframework.beans.factory.annotation.Value;


public class MyBean {

    private String name;

    public MyBean(@Value("${beans.my-bean.name}") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
