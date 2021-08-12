package com.country.crud2.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.country.crud2.model.Country;

public interface CrudRepo extends JpaRepository<Country, Integer> {

}
