package db.projects.Project2JavaSpringBootDemo.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.sql.Time;
import java.time.format.DateTimeFormatter;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingId;

    @OneToOne
    @JoinColumn(name="fk_property_id,", referencedColumnName = "propertyId")
    private Property property;
    @OneToOne
    @JoinColumn(name="fk_buyer_id,", referencedColumnName = "buyerId")
    private Buyer buyer;
    @Column(name="DATE")
    private LocalDateTime date;
//    @Column(name="TIME")
//    //@JsonFormat(/*shape = JsonFormat.Shape.STRING,*/ pattern = "HH:mm:ss")
//    private LocalTime time;

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public LocalDateTime getDate() {
        return date;
    }


    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
