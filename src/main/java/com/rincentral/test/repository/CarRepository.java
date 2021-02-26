package com.rincentral.test.repository;


import com.rincentral.test.models.CarFullInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//Repo and Service are not used, but typically data is stored using them (With JPA for example, and some DB)
@Repository
public interface CarRepository extends CrudRepository<CarFullInfo, Integer> {
}
