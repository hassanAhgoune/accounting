package com.zsmart.accountingProject.ws ;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.zsmart.accountingProject.service.facade.OperationComptableGroupeService;
import com.zsmart.accountingProject.bean.OperationComptableGroupe;

import com.zsmart.accountingProject.service.util.* ;
@RestController
@RequestMapping("/accountingProject/OperationComptableGroupe")
@CrossOrigin(origins = {"http://localhost:4200"})
public class OperationComptableGroupeRest {

 @Autowired 
 private OperationComptableGroupeService operationComptableGroupeService;

 
}