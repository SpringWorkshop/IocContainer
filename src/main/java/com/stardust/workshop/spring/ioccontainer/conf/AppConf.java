package com.stardust.workshop.spring.ioccontainer.conf;


import com.stardust.workshop.spring.ioccontainer.beans.MailBox;
import com.stardust.workshop.spring.ioccontainer.beans.Person;
import com.stardust.workshop.spring.ioccontainer.processors.AppBeanFactoryPostProcessor;
import com.stardust.workshop.spring.ioccontainer.processors.AppBeanPostProcessor;
import com.stardust.workshop.spring.ioccontainer.processors.AppInstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConf {
//    @Bean(name = "mailbox")
//    @Scope("prototype")
//    @Autowired
//    public MailBox getMailBox(Person owner) {
//        MailBox mailBox = new MailBox();
//        mailBox.setOwner(owner);
//        mailBox.setBoxCode("710048");
//        return mailBox;
//    }

    @Bean
    public BeanFactoryPostProcessor getBeanFactoryPostProcessor() {
        return new AppBeanFactoryPostProcessor();
    }

    @Bean
    public BeanPostProcessor getBeanPostProcessor() {
        return new AppBeanPostProcessor();
    }

    @Bean
    public InstantiationAwareBeanPostProcessor getInstantiationAwareBeanPostProcessor() {
        return new AppInstantiationAwareBeanPostProcessor();
    }
}
