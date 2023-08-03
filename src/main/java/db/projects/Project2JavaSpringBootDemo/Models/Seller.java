package db.projects.Project2JavaSpringBootDemo.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Sellers")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sellerId;
    private String title, firstName, surname, address, postcode, email;
    private String phone;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "seller")
    @JsonManagedReference(value="seller-prop")
    private List<Property> properties = new ArrayList<>();

    public Seller() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public List<Property> getProperties() {
        return properties;
    }

    public void addProperty(Property property) {
        this.properties.add(property);
        property.setSeller(this);
    }
    public void removeProperty(Property property) {
        property.setSeller(null);
        this.properties.remove(property);  //swap order?
    }


//    public void setProperties(List<Property> properties) {
//        this.properties = properties;
//
//        for(Property p: properties) {
//            p.setSeller(this);
//        }
//    }
}
