package hh.swd20.CarSovellus.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface CarRepository extends CrudRepository<Car, Long>{
	List<Car> findByCartitle (String cartitle);

}
