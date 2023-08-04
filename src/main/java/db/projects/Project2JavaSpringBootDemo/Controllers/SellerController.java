package db.projects.Project2JavaSpringBootDemo.Controllers;
import jakarta.validation.Valid;

import db.projects.Project2JavaSpringBootDemo.Models.Property;
import db.projects.Project2JavaSpringBootDemo.Models.Seller;
import db.projects.Project2JavaSpringBootDemo.Services.SellerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Properties;

@RequestMapping("/api/seller")
@RestController
@CrossOrigin("*")
public class SellerController {
    @Autowired
    SellerServices Service;

    @PostMapping
    public String saveSeller(@Valid @RequestBody Seller seller) {
        return this.Service.saveSeller(seller);
    }
    @PostMapping("/addNewPropertyToSeller/{id}")
    public String addNewPropToSeller(@PathVariable("id") Long id,  @RequestBody Property property) {return this.Service.addNewPropToSeller(id, property);}


    @GetMapping
    public List<Seller> getAllSellers () {
        return this.Service.getAll();
    }
    @GetMapping("/getSellerById/{id}")
    public Seller findById(@PathVariable("id") Long id) {
        return this.Service.getById(id);
    }


    @DeleteMapping("/removeSeller/{id}")
    public String  deleteSeller (@PathVariable("id") Long id){
        return this.Service.deleteSeller(id);
    }

    @PatchMapping("/updateSeller/{id}")
    public String updateSeller (@PathVariable ("id") Long id,
                               @RequestParam(required = false) String firstName,
                               @RequestParam(required = false) String surname,
                               @RequestParam(required = false) String address,
                               @RequestParam(required = false) String postcode,
                               @RequestParam(required = false) String email,
                               @RequestParam(required = false) String phone,
                               @RequestParam(required = false) Long propertyId ) {
        return this.Service.updateSeller(id, firstName, surname, address, postcode, email, phone, propertyId);
    }
//    @GetMapping("/listAllSellersProperties/{id}")
//    public List<Property> sellersProps (@PathVariable("id") Long id) {
//        return this.Service.sellersProps(id);
//    }

}
