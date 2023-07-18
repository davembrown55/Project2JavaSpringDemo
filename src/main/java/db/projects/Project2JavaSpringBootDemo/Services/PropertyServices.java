package db.projects.Project2JavaSpringBootDemo.Services;

import db.projects.Project2JavaSpringBootDemo.Models.*;
import db.projects.Project2JavaSpringBootDemo.repositories.BuyerRepo;
import db.projects.Project2JavaSpringBootDemo.repositories.PropertyRepo;
import db.projects.Project2JavaSpringBootDemo.repositories.SellerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyServices {
    @Autowired
    PropertyRepo repo;

    @Autowired
    BuyerRepo bRepo;
    @Autowired
    SellerRepo sRepo;


    public String saveProperty (Property prop) {
        repo.save(prop);
        return "Property Saved";
    }
    public List<Property> getAll() {
        return this.repo.findAll();
    }
    public Property getById (Long id) {
         Property p = null;
        Optional<Property> optionalAddress = this.repo.findById(id);
        if (optionalAddress.isPresent()) {
            p = optionalAddress.get();
        }
        return p;
    }

    public List<Property> findBySellerId (Long id) {
        return this.repo.findBySeller_SellerId(id);
    }
    public List<Property> findByBuyerId (Long id) {
        return this.repo.findByBuyer_BuyerId(id);
    }
    public String deleteProp(Long id) {
        if (this.getById(id)== null){
            return "Error no records with that ID exist";
        } else {
            this.repo.deleteById(id);
            return "Successfully removed.";
        }
    }
    public String updateProperty(Long id, String address, String postcode, Integer price,
                                 Integer bedrooms, Integer bathrooms, Boolean garden, propType type,
                                 propStatus status, Long sellerId, Long buyerId) {
        if(this.getById(id) == null){
            return "Error no records with that ID exist";
        } else {

            Property toUpdate = this.getById(id);
            if (address != null) toUpdate.setAddress(address);
            if (postcode != null) toUpdate.setPostcode(postcode);
            if (price != null) toUpdate.setPrice(price);
            if (bedrooms != null) toUpdate.setBedrooms(bedrooms);
            if (bathrooms != null) toUpdate.setBathrooms(bathrooms);
            if (garden != null) toUpdate.setGarden(garden);
            if (type != null) toUpdate.setType(type);
            if (status != null) toUpdate.setStatus(status);

            if (buyerId != null) {
                Buyer newBuyer = getBuyerById(buyerId);
                toUpdate.setBuyer(newBuyer);
            }

            if (sellerId != null) {
                Seller newSeller = getSellerById(sellerId);
                toUpdate.setSeller(newSeller);
            }

            this.repo.save(toUpdate);
            return toUpdate.getAddress() + " was updated";
        }
    }

    public Buyer getBuyerById(Long id) {
        Buyer b = null;
        Optional<Buyer> optionalAddress = this.bRepo.findById(id);
        if (optionalAddress.isPresent()) {
            b = optionalAddress.get();
        }
        return b;
    }

    public Seller getSellerById(Long id) {
        Seller s = null;
        Optional<Seller> optionalAddress = this.sRepo.findById(id);
        if (optionalAddress.isPresent()) {
            s = optionalAddress.get();

        }
        return s;
    }
}
