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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.zsmart.accountingProject.service.facade.FactureService;

import com.zsmart.accountingProject.bean.Facture;

@RestController
@RequestMapping("/accountingProject/Facture")
@CrossOrigin(origins = {"http://localhost:4200"})
public class FactureRest {

 @Autowired 
 private FactureService factureService;

	
 @PostMapping("/")
	public ResponseEntity<?> create(@Valid @RequestBody Facture facture, BindingResult result) {
		
		Facture factureNew = null;
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
			factureNew = factureService.save(facture);
		} catch(DataAccessException e) {
			response.put("message", "Impossible d'interroger la base de données");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("message", "n'existe pas dans la base de données!!");
		response.put("facture", factureNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
     
	
     
     @DeleteMapping("/{id}")
     public ResponseEntity<?> delete(@PathVariable Long id ) {
     	
     	Map<String, Object> response = new HashMap<>();
     	
     	try {
     		Facture facture = factureService.findById(id);

     	    factureService.delete(facture);
     	} catch (DataAccessException e) {
     		response.put("message", "Impossible d'interroger la base de données");
     		response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
     		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
     	}
     	
     	response.put("message", "La facture a bien été supprimé!");
     	
     	return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
     }





@DeleteMapping("/{reference}")
public ResponseEntity<?> delete(@PathVariable String reference ) {
	
	Map<String, Object> response = new HashMap<>();
	
	try {
		Facture facture = factureService.findByReference(reference);

	    factureService.delete(facture);
	} catch (DataAccessException e) {
		response.put("message", "Impossible d'interroger la base de données");
		response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	response.put("message", "La facture a bien été supprimé!");
	
	return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
}


@GetMapping("/")
public List<Facture > findAll(){
return factureService.findAll() ;
}

 
 public FactureService getFactureService(){
return factureService;
}
 
 public void setFactureService(FactureService factureService){
this.factureService=factureService;
}

}