package tacos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tacos.entities.TacoOrder;
import tacos.repositories.TacoOrderRepository;

@Service
public class TacoOrderService {
 
	@Autowired
	private TacoOrderRepository tacoOrderRepository;
	
	public Optional<TacoOrder> getTacoOrderById(Long id) {
		Optional<TacoOrder> tacoOrder = tacoOrderRepository.findById(id);
		return tacoOrder;
	}
	
	public Iterable<TacoOrder> getAllTacoOrder() {
		Iterable<TacoOrder> tacoOrders = tacoOrderRepository.findAll();
		return tacoOrders;
	}
	
	public Optional<TacoOrder> createTacoOrder(TacoOrder tacoOrder) {
		TacoOrder tacoOrderCreated = tacoOrderRepository.save(tacoOrder);
		return tacoOrderRepository.findById(tacoOrderCreated.getId());
	}
}
