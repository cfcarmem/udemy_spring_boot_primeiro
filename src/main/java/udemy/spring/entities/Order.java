package udemy.spring.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import udemy.spring.entities.enums.OrderStatus;

@Entity
@Table(name="tb_order")
public class Order implements Serializable {
	/**
	 * não esquecer de botar Serializable na classe
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//pegar o momento atual. Melhor que date
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	private Integer  orderStatus;
	//vamos criar as associações.
	//informar ao JPA que é chave estrangeira
	//um usuário tem vários pedidos. Muitos para UM anotation JPA
	//@JsonIgnore ---não quero que, ao pesquisar os usuários traga os pedidos. Vou deixar o JsonIgnor somente no usuario 
	
	@ManyToOne
	@JoinColumn(name="usuario_id")  //informa a chave estrangeira
	private Usuario client;
	
	@OneToMany(mappedBy = "id.order",fetch = FetchType.EAGER)
	private Set<OrderItem> items = new HashSet<>();
	
	//nome do atributo na classe. CascateType.ALL   (se o pedido for código 5 o pagamento será codigo 5. O mesmo ID para os dois, tem que colocar cacade all
	@OneToOne(mappedBy = "order", cascade=CascadeType.ALL)
	private Payment payment;
	
	public Order() {}

	public Order(Long id, Instant moment,  OrderStatus orderStatus, Usuario client) {
		this.id = id;
		this.moment = moment;
		this.client = client;
		setOrderStatus(orderStatus);
	}

	
	
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if(orderStatus != null) {
			this.orderStatus = orderStatus.getCode();
		}
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Usuario getClient() {
		return client;
	}

	public void setClient(Usuario client) {
		this.client = client;
	}
	
	public Set<OrderItem>getItems(){
		return items;
	}
    

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	
	public Double getTotal() {
		double soma = 0;
		for(OrderItem i: items) {
			soma += i.getSubTotal();
		}
		return soma;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", moment=" + moment + ", orderStatus=" + orderStatus + ", client=" + client + "]";
	}

	
	
	
	
	
	

}
