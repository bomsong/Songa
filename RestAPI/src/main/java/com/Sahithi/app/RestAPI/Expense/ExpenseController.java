package com.Sahithi.app.RestAPI.Expense;


import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Sahithi.app.RestAPI.User.User;
import com.Sahithi.app.RestAPI.User.UserRepository;

@RestController
public class ExpenseController {

	@Autowired
	private ExpenseService expenseservice;
	
	
	
	
	@GetMapping("/expenses")
	public List <Expenses> getAllExpenses(){

	return expenseservice.getAllExpenses();
	
	
	
	}
	
	@ResponseStatus (value=HttpStatus.CREATED)
	@PostMapping("/expensesave/{userid}")
 	public Expenses saveAllExpen( @PathVariable Long userid,@RequestBody Expenses expenses,User user){
		
	
	
 		return expenseservice.saveAllExpenses(expenses,user,userid);
 	
	}
	
	
	
	
	/*@GetMapping("/expense/{id}")
	
	public Expenses getExpenseById(@PathVariable Long id) {
		
	

	return expenseservice.getExpenseById(id);
	
	
		
	}*/
	
	
	@GetMapping("/expense/{userid}")
	public Long getExpenseById(@PathVariable Long userid, Expenses expense,User user) {
		
		return expenseservice.getExpenseByUser(expense, userid, user).getId();
	}
	
	
	/*@ResponseStatus(value=HttpStatus.NO_CONTENT)
	@DeleteMapping("/expenses")
	public void  deleteExpenseById(@RequestParam("id") Long id) {

		 expenseservice.deleteExpenseById(id);
				
		}*/
	
	@GetMapping("/expenses/category")
	public List<Expenses> readByCategory(String category){

		return expenseservice.readByCategory(category);
	
	
	
}
	@GetMapping("expenses/name")
	public List<Expenses> getExpensebyName( String name){

		return expenseservice.readByName(name);
}

	
	
	@GetMapping("expenses/date")
	public List<Expenses> getExpenseByDate(@RequestParam(required=false) Date startDate,
	                                      @RequestParam(required=false) Date endDate) {
	
	return expenseservice.readByDate(startDate, endDate);
	
	
	}
	
@GetMapping("/getloggedinuser/{id}")	
	public User Readuser(@PathVariable Long id) {
	
	User user=new User();
	
		return expenseservice.getloggedinuser(id);
	}


@GetMapping("/expensing/{id}")
public Expenses getbyid(@PathVariable Long id){
	
	return expenseservice.GetExpenseById(id);
	
	
}

@GetMapping("/expenseuser/{id}")
public List  <Expenses> getuserexpense(@PathVariable Long id,User user){
	
	return expenseservice.userexpence(user, id);
	
	
}

@PutMapping("/expenseupdate/{userid}")
public Expenses Updateuserexpense(@PathVariable Long userid,@RequestBody Expenses expenses,User user){
	
	
	
	return expenseservice.updateallexpenses(expenses, user, userid);

}

@DeleteMapping("/expensedelete/{id}")
public void deleteExpense(@PathVariable Long id,Expenses expenses) {
	expenseservice.deleteExpenseById(expenses,id);


}
}





	
	
	
	
	
	
