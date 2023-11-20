package com.appdev.techno.ie.nurturehub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appdev.techno.ie.nurturehub.Entity.AdminEntity;
import com.appdev.techno.ie.nurturehub.Service.AdminService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adserv;
	
	@GetMapping("/getAllAdmins")
	public List<AdminEntity> getAllAdmins(){
		return adserv.getAllAdmins();
	}
	
	@GetMapping("/getAdminById/{adid}")
	public ResponseEntity<AdminEntity> getAdminById(@PathVariable int adid){
		return adserv.getAdminById(adid);
	}
}
