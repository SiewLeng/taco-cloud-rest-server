package tacos.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TacoOrder implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private Long id;
	
	@NotNull
	private String deliveryName;
	
	@NotNull
	private String deliveryStreet;
	
	private String deliveryCity;
	
	@NotNull
	private String deliveryState;
	
	@NotNull
	private String deliveryZip;
	
	@NotNull
	private String ccNumber;
	
	@NotNull
	private String ccExpiry;
	
	@NotNull
	private String ccCVV;
	
	@NotNull
	private final Date placedAt = new Date();
    
	@OneToMany(cascade = CascadeType.ALL)
	@NotNull
	private List<Taco> tacos;
	
	public TacoOrder() {
		this.setDeliveryName("");
		this.setDeliveryStreet("");
		this.setDeliveryCity("");
		this.setDeliveryState("");
		this.setDeliveryZip("");
		this.setCcNumber("");
		this.setCcExpiry("");
		this.setCcCVV("");
		this.tacos = new ArrayList<>();
	}
	
	public Long getId() {
		return this.id;
	}
	
	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public String getDeliveryStreet() {
		return deliveryStreet;
	}

	public void setDeliveryStreet(String deliveryStreet) {
		this.deliveryStreet = deliveryStreet;
	}

	public String getDeliveryCity() {
		return deliveryCity;
	}

	public void setDeliveryCity(String deliveryCity) {
		this.deliveryCity = deliveryCity;
	}

	public String getDeliveryState() {
		return deliveryState;
	}

	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}

	public String getDeliveryZip() {
		return deliveryZip;
	}

	public void setDeliveryZip(String deliveryZip) {
		this.deliveryZip = deliveryZip;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public String getCcExpiry() {
		return ccExpiry;
	}

	public void setCcExpiry(String ccExpiry) {
		this.ccExpiry = ccExpiry;
	}

	public String getCcCVV() {
		return ccCVV;
	}

	public void setCcCVV(String ccCVV) {
		this.ccCVV = ccCVV;
	}
	
	public List<Taco> getTacos() {
		return this.tacos;
	}
	
	public void addTaco(Taco taco) {
		this.tacos.add(taco);
	}
	
	public Date getPlacedAt() {
		return placedAt;
	}
	
	@Override
	public String toString() {
		String result = "";
		result += "\n" + "{deliveryName: " + this.deliveryName + ",";
		result += "\n" + "deliveryStreet: " + this.deliveryStreet + ",";
		result += "\n" + "deliveryCity: " + this.deliveryCity + ",";
		result += "\n" + "deliveryState: " + this.deliveryState + ",";
		result += "\n" + "deliveryZip: " + this.deliveryZip + ",";
		result += "\n" + "ccNumber: " + this.ccNumber + ",";
		result += "\n" + "ccExpiry: " + this.ccExpiry + ",";
		result += "\n" + "ccCVV: " + this.ccCVV + ",";
		result += "\n" + "tarcos: [";
		for (int i = 0; i < this.tacos.size(); i++) {
			result += this.tacos.get(i).toString();
		}
		result += "\n" + "]}";
		return result;
	}

}
