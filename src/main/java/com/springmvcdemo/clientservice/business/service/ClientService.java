package com.springmvcdemo.clientservice.business.service;

import com.springmvcdemo.clientservice.business.model.Client;

/**
 *
 */
public interface ClientService {

	Client findClient(String clientId);
}
