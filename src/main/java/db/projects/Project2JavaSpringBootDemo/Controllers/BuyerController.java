package db.projects.Project2JavaSpringBootDemo.Controllers;


import db.projects.Project2JavaSpringBootDemo.Models.Buyer;
import db.projects.Project2JavaSpringBootDemo.Models.Property;
import db.projects.Project2JavaSpringBootDemo.Services.BuyerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BuyerController {
    @Autowired
    BuyerServices Service;

    @PostMapping("/saveBuyer")
    public String saveBuyer(@RequestBody Buyer buyer) {
        return this.Service.saveBuyer(buyer);
    }
    @PostMapping("/addNewPropertyToBuyer/{id}")
    public String addNewPropToBuyer(@PathVariable("id") Long id,  @RequestBody Property property) {return this.Service.addNewPropToBuyer(id, property);}

    @GetMapping("/getAllBuyers")
    public List<Buyer> getAllBuyers () {
        return this.Service.getAll();
    }
    @GetMapping("/getBuyerById/{id}")
    public Buyer findById(@PathVariable("id") Long id) {
        return this.Service.getById(id);
    }


    @DeleteMapping("/removeBuyer/{id}")
    public String  deleteBuyer (@PathVariable("id") Long id){
        return this.Service.deleteBuyer(id);
    }

    @PatchMapping("/updateBuyer/{id}")
    public String updateBuyer (@PathVariable ("id") Long id,
                                  @RequestParam(required = false) String firstName,
                                  @RequestParam(required = false) String surname,
                                  @RequestParam(required = false) String address,
                                  @RequestParam(required = false) String postcode,
                                  @RequestParam(required = false) String email,
                                  @RequestParam(required = false) String phone,
                               @RequestParam(required = false) Long propertyId) {
        return this.Service.updateBuyer(id, firstName, surname, address, postcode, email, phone, propertyId);
    }



}
