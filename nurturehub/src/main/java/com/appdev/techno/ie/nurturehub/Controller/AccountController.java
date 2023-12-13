package com.appdev.techno.ie.nurturehub.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appdev.techno.ie.nurturehub.Entity.AccountEntity;
import com.appdev.techno.ie.nurturehub.Entity.RecipientEntity;
import com.appdev.techno.ie.nurturehub.Methods.LoginRequest;
import com.appdev.techno.ie.nurturehub.Service.AccountService;
import com.appdev.techno.ie.nurturehub.Service.RecipientService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService aserv;
	
	
	//C - Create a recipient record
	@PostMapping("/insertAccount")
	public AccountEntity insertAccount(@RequestBody AccountEntity account) {
		return aserv.insertAccount(account);
	}
	
	//R - Read all recipient records in tblrecipient
	@GetMapping("/getAllAccounts")
	public List<AccountEntity>getAllAccounts(){
		return aserv.getAllAccounts();
	}
	
	//U - Update a recipient record
	@PutMapping("/updateAccount")
	public AccountEntity updateAccount(@RequestParam String username,@RequestBody AccountEntity newAccountDetails){
		return aserv.updateAccount(username, newAccountDetails);
	}
	
	//D - Delete a recipient record
	@DeleteMapping("/deleteAccount/{username}")
	public String deleteAccount(@PathVariable String username) {
		return aserv.deleteAccount(username);
	}
	
	@PostMapping("/login")
	 public Map<String, Object> login(@RequestBody LoginRequest loginRequest) {
		return aserv.login(loginRequest);
   }
	
	@GetMapping("/searchAccount")
	public List<AccountEntity> findAccount(@RequestParam String searchString){
		return aserv.findAccount(searchString);
	}
  
}
