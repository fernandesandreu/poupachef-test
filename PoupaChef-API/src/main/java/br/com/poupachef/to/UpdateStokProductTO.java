package br.com.poupachef.to;

public class UpdateStokProductTO {

	private Long idProduct;
	private boolean decrease;
	private Integer quantity;

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public boolean isDecrease() {
		return decrease;
	}

	public void setDecrease(boolean decrease) {
		this.decrease = decrease;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
