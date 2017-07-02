package workshop3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import workshop3.beans.Company;

@ComponentScan
public class Application {

	public static void main(String[] args) {
		ApplicationContext context
				= new AnnotationConfigApplicationContext(Application.class);

		Company company = context.getBean("company", Company.class);

		Gson gson = new GsonBuilder().serializeNulls().create();

		System.out.println("------ Company -----");
		System.out.println(gson.toJson(company));
	}
}
