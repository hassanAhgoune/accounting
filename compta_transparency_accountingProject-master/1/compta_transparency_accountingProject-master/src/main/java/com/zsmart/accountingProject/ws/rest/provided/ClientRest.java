package com.zsmart.accountingProject.ws.rest.provided ;


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
import com.zsmart.accountingProject.service.facade.ClientService;
import com.zsmart.accountingProject.bean.Client;
import com.zsmart.accountingProject.ws.rest.vo.ClientVo;
import com.zsmart.accountingProject.ws.rest.converter.ClientConverter;
import com.zsmart.accountingProject.service.util.* ;
@RestController
@RequestMapping("/accountingProject/Client")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ClientRest {

 @Autowired 
 private ClientService clientService;

 @Autowired 
private ClientConverter clientConverter ;

@PostMapping("/")
public ClientVo save(@RequestBody ClientVo clientVo){
Client client= clientConverter.toItem(clientVo);
return clientConverter.toVo(clientService.save(client));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
clientService.deleteById(id);
}
@GetMapping("/")
public List<ClientVo> findAll(){
return clientConverter.toVo(clientService.findAll());
}

 public ClientConverter getClientConverter(){
return clientConverter;
}
 
 public void setClientConverter(ClientConverter clientConverter){
this.clientConverter=clientConverter;
}

 public ClientService getClientService(){
return clientService;
}
 
 public void setClientService(ClientService clientService){
this.clientService=clientService;
}

}