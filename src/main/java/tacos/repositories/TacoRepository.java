package tacos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import tacos.entities.Taco;

@Repository
public interface TacoRepository extends CrudRepository<Taco, String> {
    
	Optional<Taco> findById(Long id);

}
