package tacos.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tacos.entities.Ingredient;
import tacos.repositories.IngredientRepository;

@RestController
@RequestMapping(path="/api/ingredients", produces="application/json")
public class IngredientController {
	
	private IngredientRepository ingredientRepository;
	
	@Autowired
	public IngredientController(IngredientRepository ingredientRepository) {
		this.ingredientRepository = ingredientRepository;
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Ingredient> findIngredientById_1(@PathVariable("id") String id) {
		Optional<Ingredient> ingredient = ingredientRepository.findById(id);
		if (ingredient.isPresent()) {
			return new ResponseEntity<>(ingredient.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path="", params={"id"})
	public ResponseEntity<Ingredient> findIngredientById_2(@RequestParam(name="id") String id) {
		Optional<Ingredient> ingredient = ingredientRepository.findById(id);
		if (ingredient.isPresent()) {
			return new ResponseEntity<>(ingredient.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
}
