package br.com.poupachef.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "PRODUCT")
public class Product extends EntityUtil {

	@Id
	@GeneratedValue(generator = "CO_SEQ_Product_Gen")
	@SequenceGenerator(name = "CO_SEQ_Product_Gen", sequenceName = "CO_SEQ_Product", allocationSize = 1)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private Integer stokQuantity;
	@Column(nullable = false)
	private Double unityPrice;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "supplierId")
	private Supplier supplierId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStokQuantity() {
		return stokQuantity;
	}

	public void setStokQuantity(Integer stokQuantity) {
		this.stokQuantity = stokQuantity;
	}

	public Double getUnityPrice() {
		return unityPrice;
	}

	public void setUnityPrice(Double unityPrice) {
		this.unityPrice = unityPrice;
	}

	public Supplier getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Supplier supplierId) {
		this.supplierId = supplierId;
	}

}
