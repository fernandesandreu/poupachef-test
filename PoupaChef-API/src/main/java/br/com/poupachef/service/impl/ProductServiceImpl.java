package br.com.poupachef.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import br.com.poupachef.entity.Product;
import br.com.poupachef.repository.ProductRepository;
import br.com.poupachef.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository repository;

	@Override
	public Product save(Product product) {

		if (ObjectUtils.isEmpty(product)) {
			throw new IllegalArgumentException("Deve ser fornecido dados para o registro.");
		}

		return this.repository.save(product);
	}

	@Override
	public Product update(Product product) {

		if (ObjectUtils.isEmpty(product)) {
			throw new IllegalArgumentException("Deve ser fornecido dados para o update.");
		}

		if (product.getId() == null || product.getId() == 0) {
			throw new IllegalArgumentException("Produto inválido para atualização.");
		}

		return this.repository.save(product);
	}

	@Override
	public Product findOneById(Long id) {

		if (id == null) {
			throw new IllegalArgumentException("Deve ser fornecido o código identificador do Produto.");
		}

		return this.repository.findById(id).get();
	}

	@Override
	public List<Product> findAll() {

		return this.repository.findAll();
	}

	@Override
	public void delete(Product product) {
		if (ObjectUtils.isEmpty(product)) {
			throw new IllegalArgumentException("Deve ser fornecido dados para o registro.");
		}
		this.repository.delete(product);
	}

}
