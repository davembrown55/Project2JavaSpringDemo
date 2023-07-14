package db.projects.Project2JavaSpringBootDemo.Controllers;


import db.projects.Project2JavaSpringBootDemo.Models.Property;
import db.projects.Project2JavaSpringBootDemo.Models.Seller;
import db.projects.Project2JavaSpringBootDemo.Services.SellerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Properties;

@RestController
public class SellerController {
    @Autowired
    SellerServices Service;

    @PostMapping("/saveSeller")
    public String saveSeller(@RequestBody Seller seller) {
        return this.Service.saveSeller(seller);
    }
    @GetMapping("/getAllSellers")
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
                               @RequestParam(required = false) String phone) {
        return this.Service.updateSeller(id, firstName, surname, address, postcode, email, phone);
    }
//    @GetMapping("/listAllSellersProperties/{id}")
//    public List<Property> sellersProps (@PathVariable("id") Long id) {
//        return this.Service.sellersProps(id);
//    }

}
