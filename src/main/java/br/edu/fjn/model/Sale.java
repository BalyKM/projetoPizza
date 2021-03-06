package br.edu.fjn.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Sale {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@JoinColumn(nullable = false)
	@ManyToOne
	private Employee employee;
	
	@JoinColumn(nullable = false)
	@ManyToOne(cascade = CascadeType.ALL)
	private Client client;
	
	@Column(nullable = false)
	private String paymentMethod;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private CreditCard creditCard;
	
	@ManyToMany
	private List<Drink> drinks;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<PizzaSize> pizzas;
	
	@Column(nullable = false)
	private double totalPrice;
	
	private String note;
	
	public Sale() {
		
	}	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public List<Drink> getDrinks() {
		return drinks;
	}

	public void setDrinks(List<Drink> drinks) {
		this.drinks = drinks;
	}

	public List<PizzaSize> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<PizzaSize> pizzas) {
		this.pizzas = pizzas;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	
	
	

	
	

	

	
	
	
	
	
	
	
	
	
	
	
	
}
