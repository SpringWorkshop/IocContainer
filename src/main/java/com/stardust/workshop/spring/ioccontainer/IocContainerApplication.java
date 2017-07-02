package com.stardust.workshop.spring.ioccontainer;

import com.stardust.workshop.spring.ioccontainer.beans.*;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanReference;
import org.springframework.beans.factory.config.RuntimeBeanNameReference;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class IocContainerApplication {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Company.class);
		factory.registerBeanDefinition("company", builder.getBeanDefinition());
		builder = BeanDefinitionBuilder.genericBeanDefinition(Department.class);
		builder.addPropertyValue("name", "Dept A");
		builder.addPropertyReference("company", "company");
		factory.registerBeanDefinition("department", builder.getBeanDefinition());


		GenericBeanDefinition personDef = new GenericBeanDefinition();
		personDef.setBeanClass(Person.class);

		GenericBeanDefinition mailBoxDef = new GenericBeanDefinition();
		mailBoxDef.setBeanClass(MailBox.class);
		mailBoxDef.setDependsOn("person");
		MutablePropertyValues propertyValues = new MutablePropertyValues();
		propertyValues.addPropertyValue("owner", personDef);

		mailBoxDef.setPropertyValues(propertyValues);




		factory.registerBeanDefinition("person", personDef);
		factory.registerBeanDefinition("mailbox", mailBoxDef);

		MailBox mailBox = factory.getBean("mailbox", MailBox.class);
		Department department = factory.getBean("department", Department.class);

		ApplicationContext context
				= new AnnotationConfigApplicationContext(IocContainerApplication.class);

		Company company = context.getBean("company", Company.class);
		company.getLocation().setProvince("Province one");
		company.getOwner().setName("Company owner");

		//Person person = context.getBean("person", Person.class);
		//Location location = context.getBean("location", Location.class);
		//MailBox mailBox = context.getBean("mailbox", MailBox.class);
		//mailBox.getOwner().setName("LC");
		System.out.println("App shutdown");
	}
}
