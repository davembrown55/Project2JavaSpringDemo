package db.projects.Project2JavaSpringBootDemo.Models;

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

    @ManyToOne(cascade= CascadeType.ALL )
    @JoinColumn(name="sellerId", referencedColumnName = "sellerId")
    private Seller seller;

    @ManyToOne (cascade= CascadeType.ALL)
    @JoinColumn(name="buyerId", referencedColumnName = "buyerId")
    private Buyer buyer;

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
}
