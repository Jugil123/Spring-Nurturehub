package com.appdev.techno.ie.nurturehub.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.appdev.techno.ie.nurturehub.Entity.AdminEntity;
import com.appdev.techno.ie.nurturehub.Repository.AccountRepository;
import com.appdev.techno.ie.nurturehub.Repository.AdminRepository;
import java.util.List;

@Service
public class AdminService {

	@Autowired
	AdminRepository adrepo;
	
	@Autowired
	AccountRepository arepo;
	
	@Autowired
	AccountService aserv;
	
	public List<AdminEntity> getAllAdmins(){
		return adrepo.findAll();
	}
	
	public ResponseEntity<AdminEntity> getAdminById(int adminId){
		AdminEntity admin = adrepo.findById(adminId).orElse(null);
		if (admin != null) {
            return ResponseEntity.ok(admin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

