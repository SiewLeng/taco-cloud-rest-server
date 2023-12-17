package tacos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import javax.validation.constraints.NotNull;

@Entity
public class Ingredient {
	
	@Id
	@NotNull
	private final String id;
	
	@NotNull
	private final String name;
	
	@NotNull
	private final Type type;
	
	public enum Type {
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}
	
	public Ingredient() {
		this.id = null;
		this.name = null;
		this.type = null;
	}

	public Ingredient(String id, String name, Type type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Type getType() {
		return type;
	}

}