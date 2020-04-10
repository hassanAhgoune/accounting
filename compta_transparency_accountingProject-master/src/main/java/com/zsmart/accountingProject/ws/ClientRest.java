package com.zsmart.accountingProject.ws ;


import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.zsmart.accountingProject.service.facade.ClientService;

import com.zsmart.accountingProject.bean.Client;

import com.zsmart.accountingProject.service.util.* ;
@RestController
@RequestMapping("/accountingProject/Client")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ClientRest {

 @Autowired 
 private ClientService clientService;

 @GetMapping("/")
	public List<Client> index() {
		return clientService.findAll();
	}
	
 
 /////////////////////////// hadi   khliwha   htal   mn b3d   ouncherhha 
	/*
	 * @GetMapping("/client/page/{page}") public Page<Client> index(@PathVariable
	 * Integer page) { Pageable pageable = PageRequest.of(page, 4); return
	 * clientService.findAll(pageable); }
	 */
 
/////////////////////////////////
 
	
	@GetMapping("/client/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Client cliente = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			cliente = clientService.findById(id);
		} catch(DataAccessException e) {
			response.put("message", "Impossible d'interroger la base de données");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(cliente == null) {
			response.put("message", "Le cliente ID: ".concat(id.toString().concat(" n'existe pas dans la base de données!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Client>(cliente, HttpStatus.OK);
	}
	
	
	@PostMapping("/")
	public ResponseEntity<?> create(@Valid @RequestBody Client cliente, BindingResult result) {
		
		Client clienteNew = null;
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
			clienteNew = clientService.save(cliente);
		} catch(DataAccessException e) {
			response.put("message", "Impossible d'interroger la base de données");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("message", "n'existe pas dans la base de données!!");
		response.put("cliente", clienteNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/clientes/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Client cliente, BindingResult result, @PathVariable Long id) {

		Client clienteActual = clientService.findById(id);

		Client clienteUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (clienteActual == null) {
			response.put("message", "Error: impossible   pour  editer  ce   client ID: "
					.concat(id.toString().concat(" n'existe pas dans la base de données!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

		clienteActual.setCode(cliente.getCode());
		clienteActual.setFactureClients(cliente.getFactureClients());
		clienteActual.setIce(cliente.getIce());
		clienteActual.setIdentifiantFiscale(cliente.getIdentifiantFiscale());
		clienteActual.setLibelle(cliente.getLibelle());
		clienteActual.setRc(cliente.getRc());
			clienteUpdated = clientService.save(clienteActual);

		} catch (DataAccessException e) {
			response.put("message", "Impossible d'interroger la base de données");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("message", "El cliente ha sido actualizado con éxito!");
		response.put("cliente", clienteUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			Client cliente = clientService.findById(id);
		
		    clientService.delete(cliente);
		} catch (DataAccessException e) {
			response.put("message", "Impossible d'interroger la base de données");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("message", "Le client a bien été supprimé!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}


}