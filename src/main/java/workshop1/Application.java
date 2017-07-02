package workshop1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import workshop1.beans.Company;
import workshop1.beans.Person;
import workshop1.beans.Location;

public class Application {

	public static void main(String[] args) {
		// declare BeanFactory
		DefaultListableBeanFactory factory
				= new DefaultListableBeanFactory();

		BeanDefinition addressBeanDefinition = registerAddressWithBeanDefinition(factory);

		registerCompanyWithBeanDefinitionAndInjectLocation(factory, addressBeanDefinition);

		registerPersonWithBeanDefinitionBuilder(factory);

		// get beans from factory
		Company company = factory.getBean("company", Company.class);
		Person person = factory.getBean("person", Person.class);

		// output beans
		Gson gson = new GsonBuilder().serializeNulls().create();
		System.out.println("------ Company -----");
		System.out.println(gson.toJson(company));
		System.out.println("------ Person -----");
		System.out.println(gson.toJson(person));
	}

	private static BeanDefinition registerAddressWithBeanDefinition(DefaultListableBeanFactory factory) {
		GenericBeanDefinition beanDefinition
				= new GenericBeanDefinition();
		beanDefinition.setBeanClass(Location.class);
		factory.registerBeanDefinition("address", beanDefinition);
		return beanDefinition;
	}

	private static BeanDefinition registerCompanyWithBeanDefinitionAndInjectLocation(DefaultListableBeanFactory factory, BeanDefinition addressBeanDefinition) {
		// create company bean definition
		GenericBeanDefinition beanDefinition
				= new GenericBeanDefinition();
		beanDefinition.setBeanClass(Company.class);
		// inject properties
		beanDefinition.getPropertyValues().add("name", "Great Company");
		beanDefinition.getPropertyValues().add("location", addressBeanDefinition);
		beanDefinition.getPropertyValues().add("owner", new RuntimeBeanReference("person"));
		// let container know create person first
		beanDefinition.setDependsOn("person");

		// register bean to factory
		factory.registerBeanDefinition("company", beanDefinition);
		return beanDefinition;
	}

	private static BeanDefinition registerPersonWithBeanDefinitionBuilder(DefaultListableBeanFactory factory) {
		// create person bean definition via BeanDefinitionBuilder
		BeanDefinitionBuilder beanDefinitionBuilder
				= BeanDefinitionBuilder.genericBeanDefinition(Person.class);
		beanDefinitionBuilder.addPropertyValue("SID", 1);
		beanDefinitionBuilder.addPropertyValue("name", "Alex Li");
		// dependency injection with property reference
		beanDefinitionBuilder.addPropertyReference("address", "address");
		BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
		factory.registerBeanDefinition("person", beanDefinition);
		return beanDefinition;
	}
}
