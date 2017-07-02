package workshop2.beans;


import org.springframework.stereotype.Component;

@Component("address")
public class HomeAddress extends Location {
    private String postcode;

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
