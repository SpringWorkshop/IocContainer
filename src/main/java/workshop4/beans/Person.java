package workshop4.beans;

public class Person {
    private Long SID;

    private String name;

    private Location address;

    public Long getSID() {
        return SID;
    }

    public void setSID(Long SID) {
        this.SID = SID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getAddress() {
        return address;
    }

    public void setAddress(Location address) {
        this.address = address;
    }
}
