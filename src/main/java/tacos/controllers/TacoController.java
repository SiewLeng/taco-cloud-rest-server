package tacos.controllers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tacos.entities.Taco;
import tacos.services.TacoService;

@RestController
@RequestMapping(path="/api/tacos", produces="application/json")
public class TacoController {
	
	@Autowired
	private TacoService tacoService;
	
	@PostMapping(path="")
	public ResponseEntity<Taco> createTaco(@RequestBody Taco taco) {
		Taco tacoCreated = tacoService.createTaco(taco);
		if (Objects.isNull(tacoCreated)) {
			return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
		} else {
			return new ResponseEntity<>(tacoCreated, HttpStatus.OK);
		}
	}
	
	
}
