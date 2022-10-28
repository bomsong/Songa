package com.Sahithi.app.RestAPI.Expense;




import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Sahithi.app.RestAPI.User.User;

@Repository
public interface ExpenseRepository extends JpaRepository< Expenses, Long> {

	
	List<Expenses> findByCategory(String category);
	
	List<Expenses> findByNameContaining(String name);

	
	List<Expenses> findByUser(User user);



	
}
