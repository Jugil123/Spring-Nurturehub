package com.appdev.techno.ie.nurturehub.Service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev.techno.ie.nurturehub.Entity.AccountEntity;
import com.appdev.techno.ie.nurturehub.Entity.RecipientEntity;
import com.appdev.techno.ie.nurturehub.Methods.LoginRequest;
import com.appdev.techno.ie.nurturehub.Repository.AccountRepository;
import com.appdev.techno.ie.nurturehub.Repository.RecipientRepository;

@Service
public class AccountService {

		@Autowired
		AccountRepository arepo;
		
		//C - Create or insert account record in tblaccount
		public AccountEntity insertAccount(AccountEntity account) {
			return arepo.save(account);
		}
		
		//R - read all records in tblaccount
		public List<AccountEntity> getAllAccounts(){
			return arepo.findAll();
		}
		 
		//U - update a account
		@SuppressWarnings("finally")
		public AccountEntity updateAccount(String username, AccountEntity newAccountDetails) {
			AccountEntity account = new AccountEntity();
			try {
				//1.)search the id number of account that will be updated
				account = arepo.findByUsername(username);
				
			    //2.) update the record
				account.setPassword(newAccountDetails.getPassword());
				
			}catch(NoSuchElementException ex) {
				throw new NoSuchElementException("Recipient "+ username + " does not exist!");
			}finally {
				return arepo.save(account);
			}
		}
		
		//D - delete a account
		@Transactional
		public String deleteAccount(String username) {
			String msg = "";
			
			if(arepo.findByUsername(username) != null) {
				arepo.deleteByUsername(username);
				msg = "Account " + username + " is successfully deleted!";
			}
			else
				msg = "Account " + username + " does not exist";
			return msg;
			
		}
		
		public int login(LoginRequest loginRequest) {
			 String username = loginRequest.getUsername();
		        String password = loginRequest.getPassword();

		        // Implement your custom logic to authenticate the user
		        AccountEntity user = arepo.findByUsername(username);

		        if (user != null && user.getPassword().equals(password)) {
		            return user.getUserType();
		        } else {
		            return 0;
		        }
		 }
	   
}
