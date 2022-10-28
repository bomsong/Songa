package com.Sahithi.app.RestAPI.Expense;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Sahithi.app.RestAPI.User.User;
import com.Sahithi.app.RestAPI.User.UserRepository;


@Service
public   class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseRepository expenserepo;
	
	@Autowired
	private UserRepository userrepo;
	@Autowired
	private ExpenseService expenseservice;
	
	public Long user_id;
	
	@Override
	public List <Expenses> getAllExpenses(){

	return expenserepo.findAll();	
	
	}
	
	public Expenses saveAllExpenses( Expenses expenses,User user,Long userid){
		
    
		
	User user1=expenseservice.getloggedinuser(userid);
	
	user1.getId();
	expenses.setUser(user1);
	
	
		
	return expenserepo.save(expenses);
		
	}
	
	public Expenses updateallexpenses(Expenses expenses, User user, Long userid) {
		
		expenseservice.getExpenseByUser(expenses, userid, user);
		
		return expenseservice.saveAllExpenses(expenses, user, userid);
		
	}
	
	

public Expenses getExpenseByUser(Expenses expenses,Long userid,User user) {
		
	Optional<User> user1 =userrepo.findById(userid);	
	
	User user2=user1.get();
	
	user2.getId();
	
	expenses.setUser(user2);
	

return expenses ;

}
		
	

		
public List<Expenses> readByCategory(String category){

	return expenserepo.findByCategory(category);
		
		
}
public List<Expenses> readByName(String name){

	return expenserepo.findByNameContaining(name);
}

@Override
public List<Expenses> readByDate(Date startDate, Date endDate) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Expenses getuserByIDandName(Long id, String name) {
	// TODO Auto-generated method stub
	return null;
}
	
	
	
	

	
	


public User getloggedinuser( Long userid) {
Optional <User> username= userrepo.findById(userid);
	

	if (username.isPresent()) {

		return username.get();
		}
		else

		throw new RuntimeException("User is not found for the name" +userid);

	
}


public Expenses GetExpenseById(Long id) {
Optional <Expenses> username= expenserepo.findById(id);
	


	if (username.isPresent()) {

		return username.get();
		}
		else

		throw new RuntimeException("User is not found for the name" +id);

}


public List <Expenses> userexpence(User user,Long userid) {
	
List <Expenses> username= expenserepo.findByUser(user);

List <Expenses> username1=username.stream().filter(u->u.getCategory().equals("food")).collect(Collectors.toList());

 return username;
}


public void deleteExpenseById(Expenses expenses,Long id) {
	expenserepo.findById(id);
	expenserepo.delete(expenses);
	
}





}





















	
	
	
	
	
	
	
	
	














