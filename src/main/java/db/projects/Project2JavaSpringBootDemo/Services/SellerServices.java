package db.projects.Project2JavaSpringBootDemo.Services;
import db.projects.Project2JavaSpringBootDemo.Models.Property;
import db.projects.Project2JavaSpringBootDemo.Models.Seller;
import db.projects.Project2JavaSpringBootDemo.repositories.SellerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.AbstractList;
import java.util.List;
import java.util.Optional;

@Service
public class SellerServices {
    @Autowired
    SellerRepo repo;

    public String saveSeller (Seller seller) {
        repo.save(seller);
        return "Seller Saved";
    }
    public List<Seller> getAll() {
        return this.repo.findAll();
    }
    public Seller getById (Long id) {
        Seller s = null;
        Optional<Seller> optionalAddress = this.repo.findById(id);
        if (optionalAddress.isPresent()) {
            s = optionalAddress.get();
        }
        return s;
    }
    public String deleteSeller(Long id) {
        if (this.getById(id)== null){
            return "Error no records with that ID exist";
        } else {
            this.repo.deleteById(id);
            return "Successfully removed.";
        }
    }
    public String updateSeller(Long id, String firstName, String surname, String address,
                              String postcode, String email, String phone) {
        if(this.getById(id) == null){
            return "Error no records with that ID exist";
        } else {

            Seller toUpdate = this.getById(id);
            if (firstName != null) toUpdate.setFirstName(firstName);
            if (surname != null) toUpdate.setSurname(surname);
            if (address != null) toUpdate.setAddress(address);
            if (postcode != null) toUpdate.setPostcode(postcode);
            if (email != null) toUpdate.setEmail(email);
            if (phone != null) toUpdate.setPhone(phone);

            this.repo.save(toUpdate);
            return toUpdate.getAddress() + " was updated";
            }
        }
//    public List<Property> sellersProps (Long id) {
//        List<Property> sellerPropList = Seller.getProperties();
//
//        return sellerPropList;
//        }
}

