package tacos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tacos.entities.Taco;
import tacos.repositories.TacoRepository;

@Service
public class TacoService {
	
	@Autowired
	private TacoRepository tacoRepository;
	
	public Optional<Taco> findTacoById(Long id) {
		return tacoRepository.findById(id);
	}
	
	public Iterable<Taco> getAllTacos() {
		return tacoRepository.findAll();
	}

	public Taco createTaco(Taco taco) {
		return tacoRepository.save(taco);
	}
	
	
}
