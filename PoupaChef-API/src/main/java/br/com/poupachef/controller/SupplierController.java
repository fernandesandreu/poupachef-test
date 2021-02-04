package br.com.poupachef.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.poupachef.entity.Supplier;
import br.com.poupachef.service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
	
	@Autowired
	private SupplierService service;
	
	@RequestMapping(value = "/create-supplier", produces = { "application/json" }, method = RequestMethod.POST)
	public Supplier createSupplier(@RequestBody Supplier supplier) {
		
		return this.service.save(supplier);
	}
	
	@RequestMapping(value = "/update-supplier", produces = { "application/json" }, method = RequestMethod.POST)
	public Supplier updateSupplier(@RequestBody Supplier supplier) {
		
		return this.service.update(supplier);
	}
	
	@RequestMapping(value = "/delete-supplier", produces = { "application/json" }, method = RequestMethod.DELETE)
	public void deleteSupplier(@RequestBody Supplier supplier) {
		
		this.service.delete(supplier);
	}
	
	@RequestMapping(value = "/get-supplier/{id}", produces = { "application/json" }, method = RequestMethod.GET)
	public Supplier getSupplier(@PathVariable Long id) {
		
		return this.service.findOneById(id);
	}
	
	@RequestMapping(value = "/get-all-supplier", produces = { "application/json" }, method = RequestMethod.GET)
	public List<Supplier> getAllSupplier() {
		
		return this.service.findAll();
	}

}
