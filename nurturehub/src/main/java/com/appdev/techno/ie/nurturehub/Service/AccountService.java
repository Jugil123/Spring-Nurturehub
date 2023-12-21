package com.appdev.techno.ie.nurturehub.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.appdev.techno.ie.nurturehub.Entity.AccountEntity;
import com.appdev.techno.ie.nurturehub.Entity.AdminEntity;
import com.appdev.techno.ie.nurturehub.Entity.CaregiverEntity;
import com.appdev.techno.ie.nurturehub.Entity.RecipientEntity;
import com.appdev.techno.ie.nurturehub.Methods.LoginRequest;
import com.appdev.techno.ie.nurturehub.Repository.AccountRepository;
import com.appdev.techno.ie.nurturehub.Repository.AdminRepository;
import com.appdev.techno.ie.nurturehub.Repository.CaregiverRepository;
import com.appdev.techno.ie.nurturehub.Repository.RecipientRepository;

@Service
public class AccountService {

		@Autowired
		AccountRepository arepo;
		
		@Autowired
		CaregiverRepository crepo;
		
		@Autowired
		RecipientRepository rrepo;
		
		@Autowired
		AdminRepository adminrepo;
		
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
				account = arepo.findByUsernameAndIsDeleted(username,0);
				
			    //2.) update the record
				account.setPassword(newAccountDetails.getPassword());
				account.setFirstname(newAccountDetails.getFirstname());
				account.setLastname(newAccountDetails.getLastname());
				
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
			
			AccountEntity account = arepo.findByUsernameAndIsDeleted(username, 0);

			if(account != null) {
				account.setIsDeleted(1);
				msg = "Account " + username + " is successfully deleted!";
			}
			else
				msg = "Account " + username + " does not exist";
			return msg;
			
		}
		
		public Map<String, Object> login(LoginRequest loginRequest) {
		    String username = loginRequest.getUsername();
		    String password = loginRequest.getPassword();

		    // Implement your custom logic to authenticate the user
		    AccountEntity user = arepo.findByUsernameAndIsDeleted(username, 0);

		    if (user != null && user.getPassword().equals(password) && user.getIsDeleted() != 1) {
		        int userType = user.getUserType();
		        Map<String, Object> userInfo = new HashMap<>();

		        switch (userType) {
		            case 1: // Recipient
		                RecipientEntity recipient = rrepo.findByUsernameAndIsDeleted(username,0);
		                userInfo.put("userType", userType);
		                userInfo.put("userObject", recipient);
		                return userInfo;

		            case 2: // Caregiver
		                CaregiverEntity caregiver = crepo.findByUsernameAndIsDeleted(username,0);
		                userInfo.put("userType", userType);
		                userInfo.put("userObject", caregiver);
		                return userInfo;

		            case 3: // Admin
		                AdminEntity admin = adminrepo.findByUsernameAndIsDeleted(username,0);
		                userInfo.put("userType", userType);
		                userInfo.put("userObject", admin);
		                return userInfo;

		            default:
		                return null; // Invalid userType
		        }
		    } else {
		        return null; // Invalid credentials or user not found
		    }
		}
		
		
		public List<AccountEntity> findAccount(String searchString) {
			List<AccountEntity> account = arepo.findByCombinedNameAndIsDeleted(searchString, 0);
			
			if(account != null) {
				return account;
			}
			
			return null;
		}
		
		public AccountEntity findAccountByUsername(String username){
			AccountEntity account = arepo.findByUsernameAndIsDeleted(username, 0);
			
			if(account != null) {
				return account;
			}
			
			return null;
		}
		
		public void updateProfilePicture(String username, MultipartFile file) {
		    AccountEntity account = arepo.findByUsernameAndIsDeleted(username, 0);
		   
		    if(account != null) {
		    	
		    	 try {
		    		 account.setProfilePicture(file.getBytes());
				    } catch (IOException e) {
				        // Handle the exception
				        throw new RuntimeException("Failed to update profile picture", e);
				    }
			}
		    
		    arepo.save(account);
		   
		}
}
