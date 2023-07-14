package db.projects.Project2JavaSpringBootDemo.repositories;

import db.projects.Project2JavaSpringBootDemo.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository <Booking, Long> {

}
