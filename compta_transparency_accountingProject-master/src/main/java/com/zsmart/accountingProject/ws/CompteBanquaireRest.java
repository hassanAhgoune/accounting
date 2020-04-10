package com.zsmart.accountingProject.ws ;


import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.zsmart.accountingProject.service.facade.CompteBanquaireService;
import com.zsmart.accountingProject.bean.Caisse;
import com.zsmart.accountingProject.bean.CompteBanquaire;

import com.zsmart.accountingProject.service.util.* ;
@RestController
@RequestMapping("/accountingProject/CompteBanquaire")
@CrossOrigin(origins = {"http://localhost:4200"})
public class CompteBanquaireRest {

 @Autowired 
 private CompteBanquaireService compteBanquaireService;

 @PostMapping("/")
	public ResponseEntity<?> create(@Valid @RequestBody CompteBanquaire compteBanquaire, BindingResult result) {
		
		CompteBanquaire New = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			New = compteBanquaireService.save(compteBanquaire);
		} catch(DataAccessException e) {
			response.put("message", "Impossible d'interroger la base de données");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("message", "n'existe pas dans la base de données!!");
		response.put("caisse", New);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
  
	
  
  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id ) {
  	
  	Map<String, Object> response = new HashMap<>();
  	
  	try {
  		CompteBanquaire compteBanquaire = compteBanquaireService.findById(id);

  	    compteBanquaireService.delete(compteBanquaire);
  	} catch (DataAccessException e) {
  		response.put("message", "Impossible d'interroger la base de données");
  		response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
  		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  	}
  	
  	response.put("message", "La compte Banquaire a bien été supprimé!");
  	
  	return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
  }







@GetMapping("/")
public List<CompteBanquaire > findAll(){
return compteBanquaireService.findAll() ;
}


}