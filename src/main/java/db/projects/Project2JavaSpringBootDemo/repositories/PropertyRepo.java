package db.projects.Project2JavaSpringBootDemo.repositories;

import db.projects.Project2JavaSpringBootDemo.Models.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepo extends JpaRepository<Property, Long> {

}
