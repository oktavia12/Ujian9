package com.juaracoding.ujianapi.Repository;
import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.juaracoding.ujianapi.entity.Biodata;

public interface BiodataRepository extends CrudRepository<Biodata, Long>{

	@Query(value = "SELECT * FROM biodata WHERE name LIKE %?1%",nativeQuery=true)
	List<Biodata> findByName(String name);
}