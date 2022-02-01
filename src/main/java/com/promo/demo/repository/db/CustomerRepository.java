package com.promo.demo.repository.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.promo.demo.model.db.CustomerModel;


@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long>{

	
	@Transactional
	@Modifying
	@Query("update  CustomerModel c set STATUS =:newStatus where  STATUS =:oldStatus ")
	void updateCustomers(@Param("newStatus") Integer newStatus , @Param("oldStatus") Integer oldStatus   );
}
