package db.projects.Project2JavaSpringBootDemo.repositories;

import db.projects.Project2JavaSpringBootDemo.Models.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepo extends JpaRepository<Property, Long> {

    public List<Property> findBySeller_SellerId(Long id);

    public List<Property> findByBuyer_BuyerId(Long id);

}
