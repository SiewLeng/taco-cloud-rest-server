package tacos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tacos.entities.Taco;
import tacos.repositories.TacoRepository;

@Service
public class TacoService {
	
	@Autowired
	private TacoRepository tacoRepository;
	
	public Taco createTaco(Taco taco) {
		return tacoRepository.save(taco);
	}

}
