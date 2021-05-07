package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Date moment;
	OrderStatus status;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss:mm");
	List<OrderItem> items = new ArrayList<>();
	Client client;
	
	public Order(Client client, OrderStatus status) {
		this.client = client;
		moment = new Date();
		this.status = status;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public double total() {
		double totalValue = 0.0;
		for(OrderItem x : items) {
			totalValue += x.subTotal();
		}
		return totalValue;
	}
	

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: " + sdf.format(moment));
		sb.append("\nOrder status: " + status);
		sb.append("\n" + client);
		sb.append("Order Items: \n");
		for(OrderItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Total price: " + total());
		return sb.toString();
	}
	
}
