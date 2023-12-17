package tacos.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tacos.entities.TacoOrder;
import tacos.services.TacoOrderService;

@RestController
@RequestMapping(path="/api/taco-orders", produces="application/json")
public class TacoOrderController {
	
	@Autowired
	private TacoOrderService tacoOrderService;
	
	@GetMapping(path="/")
	public ResponseEntity<TacoOrder> getTacoOrderById(@RequestParam	String id) {
		Optional<TacoOrder> tacoOrder = tacoOrderService.getTacoOrderById(Long.parseLong(id));
		if (tacoOrder.isPresent()){
			return new ResponseEntity<>(tacoOrder.get(), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path="")
	public ResponseEntity<Iterable<TacoOrder>> getAllTacoOrder() {
		Iterable<TacoOrder> tacoOrders = tacoOrderService.getAllTacoOrder();
		return new ResponseEntity<>(tacoOrders, HttpStatus.OK);
	}
	
	@PostMapping(path="", consumes="application/json")
	public ResponseEntity<TacoOrder> createTacoOrder(@RequestBody TacoOrder tacoOrder) {
		Optional<TacoOrder> createdTacoOrder = tacoOrderService.createTacoOrder(tacoOrder);
		if (createdTacoOrder.isPresent()) {
			return new ResponseEntity<>(createdTacoOrder.get(), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null,  HttpStatus.NOT_MODIFIED);
		}
	}

}
