package br.com.poupachef.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.poupachef.entity.Product;
import br.com.poupachef.service.ProductService;
import br.com.poupachef.to.UpdateStokProductTO;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/create-product", produces = { "application/json" }, method = RequestMethod.POST)
	public Product createProduct(@RequestBody Product product) {

		return this.productService.save(product);
	}

	@RequestMapping(value = "/update-product", produces = { "application/json" }, method = RequestMethod.POST)
	public Product updateProduct(@RequestBody Product product) {

		return this.productService.update(product);
	}

	@RequestMapping(value = "/delete-product", produces = { "application/json" }, method = RequestMethod.DELETE)
	public void deleteProduct(@RequestBody Product product) {

		this.productService.delete(product);
	}

	@RequestMapping(value = "/get-product/{id}", produces = { "application/json" }, method = RequestMethod.GET)
	public Product getProduct(@PathVariable Long id) {

		return this.productService.findOneById(id);
	}

	@RequestMapping(value = "/get-all-product", produces = { "application/json" }, method = RequestMethod.GET)
	public List<Product> getAllProduct() {

		return this.productService.findAll();
	}

	@RequestMapping(value = "/update-stok-product", produces = { "application/json" }, method = RequestMethod.POST)
	public Product updateStok(@RequestBody UpdateStokProductTO updateStokProductTO) {

		return this.productService.updateStok(updateStokProductTO);
	}

}
