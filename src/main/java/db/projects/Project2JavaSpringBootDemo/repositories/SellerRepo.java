package db.projects.Project2JavaSpringBootDemo.repositories;

import db.projects.Project2JavaSpringBootDemo.Models.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepo extends JpaRepository <Seller, Long> {

}
