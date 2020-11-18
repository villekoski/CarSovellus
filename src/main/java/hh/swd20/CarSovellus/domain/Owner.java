package hh.swd20.CarSovellus.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Owner {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long ownerid;
	
	@NotNull
	@Size(min=1, max=30)
	private String ownername;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private List<Car> cars;
	
	public Owner() {
		
	}
	public Owner(String ownername) {
        super();
        this.ownername = ownername;
      
    }
	public long getOwnerid() {
		return ownerid;
	}
	public void setOwnerid(long ownerid) {
		this.ownerid = ownerid;
	}
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	public Owner(long ownerid, String ownername) {
		super();
		this.ownerid = ownerid;
		this.ownername = ownername;
	}

	
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	
	@Override
	public String toString() {
		return "Owner [ownerid=" + ownerid + ", ownername=" + ownername + "]";
	}
	

}
