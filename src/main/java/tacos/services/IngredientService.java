package tacos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tacos.entities.Ingredient;
import tacos.repositories.IngredientRepository;

@Service
public class IngredientService {
	
	@Autowired
	private IngredientRepository ingredientRepository;
	
	public Optional<Ingredient> findIngredientById(String id) {
		Optional<Ingredient> ingredient = ingredientRepository.findById(id);
		return ingredient;
	}
	
	public Iterable<Ingredient> getAllIngredients() {
		Iterable<Ingredient> ingredients = ingredientRepository.findAll();
		return ingredients;
	}

}
