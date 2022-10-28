package com.Sahithi.app.RestAPI.Expense;


import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.Sahithi.app.RestAPI.User.User;



public interface ExpenseService {

	List <Expenses> getAllExpenses();
	
	
	
	public Expenses getExpenseByUser(Expenses expenses,Long userid,User user);
	Expenses getuserByIDandName(Long id,String name);
	
	
	
    List<Expenses> readByCategory(String category);
	
    List<Expenses> readByName(String name);
	
    List<Expenses> readByDate(Date startDate, Date endDate);
  
    User getloggedinuser(Long id);
    
    //List<Expenses> getExpensebyuserid( Long userid);
	
    //Expenses saveAllExpenses(Expenses  expense);

    public Expenses saveAllExpenses( Expenses expenses,User user,Long userid);

	//Expenses saveAllExpenses(Expenses expenses,User User);
	//Expenses saveAllExpenses( Expenses expenses,User user);
	
    
	List<Expenses> userexpence(User user,Long userid);

	Expenses GetExpenseById(Long id);

	public Expenses updateallexpenses( Expenses expenses,User user,Long userid);



	void deleteExpenseById(Expenses expenses, Long id);
	
	
	



	
    
	  
}
