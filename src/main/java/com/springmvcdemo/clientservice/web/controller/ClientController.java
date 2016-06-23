package com.springmvcdemo.clientservice.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvcdemo.clientservice.business.model.Client;
import com.springmvcdemo.clientservice.business.service.ClientService;
import com.springmvcdemo.clientservice.web.resource.ClientResource;

@Controller
@RequestMapping("/")
public class ClientController {

	// as of Spring 4.3 you no longer need to use @Autowired as long as you have a single
	// constructor. Spring will implicitly consider it an autowire target. this makes unit testing
	// much easier since we don't need to get Spring involved at all!!
	private ClientService clientService;	

	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@RequestMapping(value="clients/{clientId}/", method=RequestMethod.GET)
	public @ResponseBody ClientResource findClient(@PathVariable String clientId) {
		
		// really simple implementation just to show that this class gets called
		// for the correct request mapping
		Client client = clientService.findClient(clientId);
				
		if (client != null) {
			ClientResource res = new ClientResource(client.getId(), client.getLastName(), client.getFirstName());
			return res;
		}
		
		return null;
	}

}
