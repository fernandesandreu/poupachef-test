package br.com.poupachef.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import br.com.poupachef.entity.Supplier;
import br.com.poupachef.repository.SupplierRepository;
import br.com.poupachef.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierRepository repository;

	@Override
	public Supplier save(Supplier supplier) {

		if (ObjectUtils.isEmpty(supplier)) {
			throw new IllegalArgumentException("Deve ser fornecido dados para o registro.");
		}

		return this.repository.save(supplier);
	}

	@Override
	public Supplier update(Supplier supplier) {

		if (ObjectUtils.isEmpty(supplier)) {
			throw new IllegalArgumentException("Deve ser fornecido dados para o update.");
		}

		if (supplier.getId() == null || supplier.getId() == 0) {
			throw new IllegalArgumentException("Fornecedor inválido para atualização.");
		}

		return this.repository.save(supplier);
	}

	@Override
	public Supplier findOneById(Long id) {

		if (id == null) {
			throw new IllegalArgumentException("Deve ser fornecido o código identificador do Fornecedor.");
		}

		return this.repository.findById(id).get();
	}

	@Override
	public List<Supplier> findAll() {
		
		return this.repository.findAll();
	}

	@Override
	public void delete(Supplier supplier) {

		this.repository.delete(supplier);
	}

}
