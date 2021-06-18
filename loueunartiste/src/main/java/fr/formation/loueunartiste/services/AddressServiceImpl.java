package fr.formation.loueunartiste.services;

import org.springframework.stereotype.Service;

import fr.formation.loueunartiste.repositories.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addresses;

    public AddressServiceImpl(AddressRepository addresses) {
	this.addresses = addresses;
    }

}
