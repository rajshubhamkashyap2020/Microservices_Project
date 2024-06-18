package ms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ms.api.entity.Address;
import ms.api.service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	
	@GetMapping("/getAllAddress")
	public ResponseEntity<List<Address>> getAllAddresses(){
		
		List<Address> res= addressService.getAllAddresses();
		
		return new ResponseEntity<List<Address>>(res,HttpStatus.OK);
		
	}

}
