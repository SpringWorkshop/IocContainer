package workshop4;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import workshop4.beans.*;

public class Application {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("workshop4/beans.xml");
		Company company = context.getBean("company", Company.class);

		Gson gson = new GsonBuilder().serializeNulls().create();

		System.out.println("------ Company -----");
		System.out.println(gson.toJson(company));
	}
}
