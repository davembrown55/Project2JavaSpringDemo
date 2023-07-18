package db.projects.Project2JavaSpringBootDemo.Controllers;

import db.projects.Project2JavaSpringBootDemo.Models.*;
import db.projects.Project2JavaSpringBootDemo.Services.PropertyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyController {
    @Autowired
    PropertyServices pService;

    @PostMapping("/saveProperty")
    public String saveProp(@RequestBody Property prop) {
        return this.pService.saveProperty(prop);
    }
    @GetMapping("/getAllProperties")
    public List<Property> getAllProps () {
        return this.pService.getAll();
    }
    @GetMapping("/getPropertyById/{id}")
    public Property findById(@PathVariable("id") Long id) {
        return this.pService.getById(id);
    }

    @GetMapping("/GetAllPropertiesBySellerId/{id}")
    public  List<Property> GetallpropertiesBySellerId (@PathVariable("id") Long id) {
        return this.pService.findBySellerId(id);
    }

    @GetMapping("/GetAllPropertiesByBuyerId/{id}")
    public  List<Property> GetallpropertiesByBuyerId (@PathVariable("id") Long id) {
        return this.pService.findByBuyerId(id);
    }

    @DeleteMapping("/removeProperty/{id}")
    public String  deleteProperty (@PathVariable("id") Long id){
        return this.pService.deleteProp(id);
    }

    @PatchMapping("/updateProperty/{id}")
    public String updateProperty (@PathVariable ("id") Long id,
                                  @RequestParam(required = false) String address,
                                  @RequestParam(required = false) String postcode,
                                  @RequestParam(required = false) Integer price,
                                  @RequestParam(required = false) Integer bedrooms,
                                  @RequestParam(required = false) Integer bathrooms,
                                  @RequestParam(required = false) Boolean garden,
                                  @RequestParam(required = false) propType type,
                                  @RequestParam(required = false) propStatus status,
                                  @RequestParam(required = false) Long sellerId,
                                  @RequestParam(required = false) Long buyerId) {
        return this.pService.updateProperty(id, address, postcode, price, bedrooms, bathrooms,
                garden, type, status, sellerId, buyerId);
    }

}
