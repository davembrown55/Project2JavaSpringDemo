package db.projects.Project2JavaSpringBootDemo.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Sellers")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sellerId;
    private String firstName, surname, address, postcode, email;
    private String phone;

    @OneToMany(mappedBy = "seller")
    private List<Property> properties;

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    public List<Property> getProperties() {
//        return this.properties;
//    }
//
//    public void setProperties(List<Property> properties) {
//        this.properties = properties;
//    }
}
