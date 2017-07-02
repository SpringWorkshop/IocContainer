package workshop5;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import workshop5.beans.*;

public class Application {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory
				= new DefaultListableBeanFactory();

		registerAddressWithBeanDefinition(factory);

		registerCompanyWithBeanDefinitionAndInjectLocation(factory);

		registerPersonWithBeanDefinitionBuilder(factory);

		Company company1 = (Company) factory.autowire(Company.class, AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, true);
		company1.setName("Company 1");
		company1.getLocation().setAddress("Address 1");

		Company company2 = factory.getBean("company", Company.class);
		factory.autowireBeanProperties(company2, AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, true);
		company2.setName("Company 2");
		company2.getLocation().setAddress("Address 2");

		// output beans
		Gson gson = new GsonBuilder().serializeNulls().create();
		System.out.println("------ Company 1 -----");
		System.out.println(gson.toJson(company1));
		System.out.println("------ Company 2 -----");
		System.out.println(gson.toJson(company2));
	}

	private static BeanDefinition registerAddressWithBeanDefinition(DefaultListableBeanFactory factory) {
		GenericBeanDefinition beanDefinition
				= new GenericBeanDefinition();
		beanDefinition.setBeanClass(Location.class);
		factory.registerBeanDefinition("location", beanDefinition);
		return beanDefinition;
	}

	private static BeanDefinition registerCompanyWithBeanDefinitionAndInjectLocation(DefaultListableBeanFactory factory) {
		GenericBeanDefinition beanDefinition
				= new GenericBeanDefinition();
		beanDefinition.setBeanClass(Company.class);
		beanDefinition.setDependsOn("person", "location");
		factory.registerBeanDefinition("company", beanDefinition);
		return beanDefinition;
	}

	private static BeanDefinition registerPersonWithBeanDefinitionBuilder(DefaultListableBeanFactory factory) {
		BeanDefinitionBuilder beanDefinitionBuilder
				= BeanDefinitionBuilder.genericBeanDefinition(Person.class);
		BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
		factory.registerBeanDefinition("person", beanDefinition);
		return beanDefinition;
	}
}
