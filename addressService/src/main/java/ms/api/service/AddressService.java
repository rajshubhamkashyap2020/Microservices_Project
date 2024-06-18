package ms.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ms.api.entity.Address;
import ms.api.repo.AddressRepo;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepo addressRepo;

	public List<Address> getAllAddresses() {
		return addressRepo.findAll();
	}

}
