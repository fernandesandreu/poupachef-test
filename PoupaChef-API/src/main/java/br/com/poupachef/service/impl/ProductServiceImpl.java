package br.com.poupachef.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import br.com.poupachef.entity.Product;
import br.com.poupachef.repository.ProductRepository;
import br.com.poupachef.service.ProductService;
import br.com.poupachef.service.SupplierService;
import br.com.poupachef.to.UpdateStokProductTO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private SupplierService supplierService;

	@Override
	public Product save(Product product) {

		if (ObjectUtils.isEmpty(product)) {
			throw new IllegalArgumentException("Deve ser fornecido dados para o registro.");
		}
		
		try {
			product.setSupplierId(supplierService.findOneById(product.getSupplierId().getId()));
		} catch (Exception e) {
			throw new IllegalArgumentException("Não existe o Fonecedor informado");
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
		
		Optional<Product> product = this.repository.findById(id);

		if (!product.isPresent()) {
			throw new IllegalArgumentException("Não foi encontrado Produto com este código indentificador.");
		}
		
		return product.get();
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

	@Override
	public Product updateStok(UpdateStokProductTO updateStokProductTO) {
		
		if (ObjectUtils.isEmpty(updateStokProductTO)) {
			throw new IllegalArgumentException("Deve ser fornecido dados para o update.");
		}
		
		if (updateStokProductTO.getIdProduct() == null || updateStokProductTO.getIdProduct() == 0) {
			throw new IllegalArgumentException("Deve ser fornecido o código indentificador do produto.");
		}
		
		if (updateStokProductTO.getQuantity() == null || updateStokProductTO.getQuantity() == 0) {
			throw new IllegalArgumentException("Quantidade deve ser maior que 0(zero).");
		}
		
		Product product = this.findOneById(updateStokProductTO.getIdProduct());
		int previewStok = 0; 
		
		if  (updateStokProductTO.isDecrease()) {
			previewStok = product.getStokQuantity() - updateStokProductTO.getQuantity();
			if (previewStok < 0) {
				throw new IllegalArgumentException("Valor do estoque atual menor que o enviado.");
			} else {
				product.setStokQuantity(previewStok);
			}
			
			return this.update(product);
		} else {
			previewStok = product.getStokQuantity() + updateStokProductTO.getQuantity();
			product.setStokQuantity(previewStok);
			
			return this.update(product);
		}
	}

}
