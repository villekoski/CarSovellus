package hh.swd20.CarSovellus.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long>{
	List<Owner> findByOwnername (String ownername);
} 


