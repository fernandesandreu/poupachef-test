package br.com.poupachef.service;

import java.util.List;

import br.com.poupachef.entity.Product;
import br.com.poupachef.to.UpdateStokProductTO;

public interface ProductService {

	Product save(Product product);

	Product update(Product product);

	Product findOneById(Long id);

	List<Product> findAll();

	void delete(Product product);
	
	Product updateStok(UpdateStokProductTO updateStokProductTO);

}
