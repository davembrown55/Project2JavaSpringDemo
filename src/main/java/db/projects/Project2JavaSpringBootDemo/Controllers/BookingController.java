package db.projects.Project2JavaSpringBootDemo.Controllers;


import db.projects.Project2JavaSpringBootDemo.Models.Booking;
import db.projects.Project2JavaSpringBootDemo.Models.Property;
import db.projects.Project2JavaSpringBootDemo.Services.BookingServices;
import db.projects.Project2JavaSpringBootDemo.Services.PropertyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {
    @Autowired
    BookingServices Service;



    @PostMapping("/createBooking")
    public String createBooking(@RequestBody Booking booking) {
        return this.Service.createBooking(booking);
    }
    @GetMapping("/getAllBookings")
    public List<Booking> getAllSellers () {
        return this.Service.getAll();
    }
    @GetMapping("/getBookingById/{id}")
    public Booking findById(@PathVariable("id") Long id) {
        return this.Service.getById(id);
    }


    @DeleteMapping("/removeBooking/{id}")
    public String  deleteBooking (@PathVariable("id") Long id){
        return this.Service.deleteBooking(id);
    }

    @PatchMapping("/updateBooking/{id}")
    public String updateBooking (@PathVariable ("id") Long id,
                                @RequestParam(required = false)
                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date
                                /*, @RequestParam(required = false) LocalTime time */) {
        return this.Service.updateBooking(id, date /*, time*/);
    }

}
