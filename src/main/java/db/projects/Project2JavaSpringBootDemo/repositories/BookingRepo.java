package db.projects.Project2JavaSpringBootDemo.repositories;

import db.projects.Project2JavaSpringBootDemo.Models.Booking;
import db.projects.Project2JavaSpringBootDemo.Models.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository <Booking, Long> {
    public List<Booking> findByProperty_PropertyId(Long id);
    public List<Booking> findByBuyer_BuyerId(Long id);
}
