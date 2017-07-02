package workshop2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import workshop2.beans.Company;
import workshop2.beans.Location;
import workshop2.beans.Person;

@ComponentScan
public class Application {

	public static void main(String[] args) {
		ApplicationContext context
				= new AnnotationConfigApplicationContext(Application.class);

		Location location = context.getBean("address", Location.class);
		location.setAddress("Street #01");
		location.setCity("Xi'an");
		location.setProvince("Shan Xi");

		Person person = context.getBean("person", Person.class);
		person.setName("Alex Li");
		person.setSID(new Long(2));

		Company company = context.getBean("company", Company.class);



		Gson gson = new GsonBuilder().serializeNulls().create();

		System.out.println("------ Company -----");
		System.out.println(gson.toJson(company));
		System.out.println("------ Person -----");
		System.out.println(gson.toJson(person));
		System.out.println("------ Location -----");
		System.out.println(gson.toJson(location));
	}
}
