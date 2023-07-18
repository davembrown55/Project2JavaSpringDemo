package db.projects.Project2JavaSpringBootDemo.Services;


import db.projects.Project2JavaSpringBootDemo.Models.Booking;
import db.projects.Project2JavaSpringBootDemo.Models.Buyer;
import db.projects.Project2JavaSpringBootDemo.Models.Property;
import db.projects.Project2JavaSpringBootDemo.repositories.BookingRepo;
import db.projects.Project2JavaSpringBootDemo.repositories.BuyerRepo;
import db.projects.Project2JavaSpringBootDemo.repositories.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServices {
    @Autowired
    BookingRepo repo;

    @Autowired
    PropertyRepo pRepo;
    @Autowired
    BuyerRepo bRepo;

    public String createBooking (Booking booking) {
        repo.save(booking);
        return "Booking Saved";
    }
    public List<Booking> getAll() {
        return this.repo.findAll();
    }
    public Booking getById (Long id) {
        Booking b = null;
        Optional<Booking> optionalAddress = this.repo.findById(id);
        if (optionalAddress.isPresent()) {
            b = optionalAddress.get();
        }
        return b;
    }
    public String deleteBooking(Long id) {
        if (this.getById(id)== null){
            return "Error no records with that ID exist";
        } else {

            this.repo.deleteById(id);
            return "Successfully removed.";
        }
    }
    public String updateBooking(Long id, LocalDateTime date /*, LocalTime time */) {
        if(this.getById(id) == null){
            return "Error no records with that ID exist";
        } else {
            Booking toUpdate = this.getById(id);
            if (date != null) toUpdate.setDate(date);
            //if (time != null) toUpdate.setTime(time);
            this.repo.save(toUpdate);
            return "Booking Updated";
        }
    }
    public List<Booking> findByProperty_PropertyId (Long id) {
        return this.repo.findByProperty_PropertyId(id);
    }
    public List<Booking> findByBuyer_BuyerId (Long id) {
        return this.repo.findByBuyer_BuyerId(id);
    }



    public Property getPropById (Long id) {
        Property p = null;
        Optional<Property> optionalAddress = this.pRepo.findById(id);
        if (optionalAddress.isPresent()) {
            p = optionalAddress.get();
        }
        return p;
    }

    public Buyer getBuyerById(Long id) {
        Buyer b = null;
        Optional<Buyer> optionalAddress = this.bRepo.findById(id);
        if (optionalAddress.isPresent()) {
            b = optionalAddress.get();
        }
        return b;
    }
}
