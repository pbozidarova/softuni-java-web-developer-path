package hiberspring.repository;


import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {
    Branch findAllByName(String name);

    //@Query("SELECT b FROM Branch as b WHERE b.products.size >1")
    //List<Branch> findAllByProductsGreaterThan();
}

