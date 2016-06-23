package com.springmvcdemo.clientservice.business.service;

import org.springframework.stereotype.Service;

import com.springmvcdemo.clientservice.business.model.Client;

/**
 *
 */
@Service
public class ClientServiceImpl implements ClientService {

	public Client findClient(String clientId) {
		
		// incredibly fake code here just to illustrate that this class gets called
		if ("1".equalsIgnoreCase(clientId)) {
			return new Client("1", "Wiggins", "Bob");
		}
		
		return null;
	}
}
