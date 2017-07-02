package workshop3.confs;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import workshop3.beans.*;

@Configuration
public class BeanConf {

    @Bean("location")
    public Location getLocationBean() {
        Location location = new Location();
        location.setProvince("HU_NAN");
        location.setCity("CHANGE_SHA");
        location.setAddress("ROAD #1");
        return location;
    }

    @Bean("address")
    public Location getHomeAddressBean() {
        HomeAddress address = new HomeAddress();
        address.setProvince("GUANG_DONG");
        address.setCity("GUANG_ZHOU");
        address.setAddress("STREET #2");
        address.setPostcode("POSTCODE_1234");
        return address;
    }

    @Bean(value = "person", autowire = Autowire.BY_NAME)
    public Person getPersonBean() {
        Person person = new Person();
        person.setName("Alex Li");
        person.setSID(new Long(3));
        return person;
    }

    @Bean(name = "company")
    @Autowired
    public Company getCompanyBean(Person person, Location location) {
        Company company = new Company();
        company.setName("My Company");
        company.setLocation(location);
        company.setOwner(person);
        return company;
    }
}
