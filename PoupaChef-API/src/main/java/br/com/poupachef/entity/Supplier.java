package br.com.poupachef.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "SUPPLIER")
public class Supplier extends EntityUtil{

	@Id
    @GeneratedValue(generator = "CO_SEQ_Supplier_Gen")
    @SequenceGenerator(name = "CO_SEQ_Supplier_Gen", sequenceName = "CO_SEQ_Supplier", allocationSize = 1)
	@Column
	private Long id;
	@Column
	private String name;

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

}
