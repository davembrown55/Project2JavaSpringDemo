package db.projects.Project2JavaSpringBootDemo.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "Properties")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long propertyId;
    private String address, postcode;
    private Integer price, bedrooms, bathrooms;
    private Boolean garden;

    @Enumerated(EnumType.STRING)
    @Column(name="type")
    private propType type;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private propStatus status;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="sellerId"/*, referencedColumnName = "sellerId"*/)
    @JsonBackReference(value="seller-prop")
    private Seller seller;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="buyerId" /*, referencedColumnName = "buyerId"*/)
    @JsonBackReference(value="buyer-prop")
    private Buyer buyer;

    public Property() {}

    public boolean canBookViewing() {
        return getStatus() == propStatus.FORSALE;
    }

    public long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(long propertyId) {
        this.propertyId = propertyId;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Boolean getGarden() {
        return garden;
    }

    public void setGarden(Boolean garden) {
        this.garden = garden;
    }

    public propType getType() {
        return type;
    }

    public void setType(propType type) {
        this.type = type;
    }

    public propStatus getStatus() {
        return status;
    }

    public void setStatus(propStatus status) {
        this.status = status;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

//    @Override
//    public boolean equals(Object o) {
//        if(this == o) return true;
//        if(!(o instanceof Property)) return false;
//        return propertyId != null && propertyId.equals(((Property) o).getPropertyId());
//    }
//    @Override
//    public int hashcode() {
//        return getClass().hashCode();
//    }


}
