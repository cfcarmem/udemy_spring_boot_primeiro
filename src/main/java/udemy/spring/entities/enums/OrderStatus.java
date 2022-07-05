package udemy.spring.entities.enums;

public enum OrderStatus {
	PAYMENT(1),
	WAITING_PAYMENT(2),
	CANCELED(3),
	DELIVERED(4);
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
	
	//converter numérico para enumerado. Static pois pode ser usado sem precisar instanciar a classe
	public static OrderStatus valueOf(int code) {
		for(OrderStatus s: OrderStatus.values()) {
			if(s.getCode() == code) {
			  return s;
			}
		}
		throw new IllegalArgumentException("Código do Status é inválido");
	}

}
