package db.projects.Project2JavaSpringBootDemo.Services;


import db.projects.Project2JavaSpringBootDemo.Models.Buyer;
import db.projects.Project2JavaSpringBootDemo.repositories.BuyerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyerServices {
    @Autowired
    BuyerRepo repo;

    public String saveBuyer(Buyer buyer) {
        repo.save(buyer);
        return "Buyer Saved";
    }

    public List<Buyer> getAll() {
        return this.repo.findAll();
    }

    public Buyer getById(Long id) {
        Buyer b = null;
        Optional<Buyer> optionalAddress = this.repo.findById(id);
        if (optionalAddress.isPresent()) {
            b = optionalAddress.get();
        }
        return b;
    }

    public String deleteBuyer(Long id) {
        if (this.getById(id) == null) {
            return "Error no records with that ID exist";
        } else {
            this.repo.deleteById(id);
            return "Successfully removed.";
        }
    }

    public String updateBuyer(Long id, String firstName, String surname, String address,
                              String postcode, String email, String phone) {
        if (this.getById(id) == null) {
            return "Error no records with that ID exist";
        } else {

            Buyer toUpdate = this.getById(id);
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
}
