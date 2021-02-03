package br.com.poupachef.service;

import java.util.List;

import br.com.poupachef.entity.Supplier;

public interface SupplierService {
	
	Supplier save(Supplier supplier);

	Supplier update(Supplier supplier);

	Supplier findOneById(Long id);

	List<Supplier> findAll();

	void delete(Supplier supplier);

}
