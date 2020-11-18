package hh.swd20.CarSovellus.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long carid;
    
    @NotNull
	@Size(min=1, max=30)
    private String cartitle;
    
    @NotNull
	@Size(min=1, max=15)
    private String carcountry;
    
    @NotNull
	
    private Integer caryear;
    
    @NotNull
	@Size(min=2, max=200)
    String carinfo;
    
    
    @NotNull
    Double carprice;
    @JsonIgnoreProperties ("cars") 
    @ManyToOne
    @JoinColumn(name = "Cid")
    private Owner owner;

    
    public Car(String cartitle, String carcountry, Integer caryear, String carinfo, Double carprice) {
        super();
        this.cartitle = cartitle;
        this.carcountry = carcountry;
        this.caryear = caryear;
        this.carinfo = carinfo;
        this.carprice = carprice;
    }
    public Car(String cartitle, String carcountry, Integer caryear, String carinfo, Double carprice, Owner owner) {
        super();
        this.cartitle = cartitle;
        this.carcountry = carcountry;
        this.caryear = caryear;
        this.carinfo = carinfo;
        this.carprice = carprice;
        this.owner = owner;
    }
    public Car() {
        super();
    }
    public void setCarid(long carid) {
        this.carid = carid;
    }
    public long getCarid() {
        return carid;
    }
    public String getCartitle() {
        return cartitle;
    }
    public void setCartitle(String cartitle) {
        this.cartitle = cartitle;
    }
    public String getCarcountry() {
        return carcountry;
    }
    public void setCarcountry(String carcountry) {
        this.carcountry = carcountry;
    }
    public Integer getCaryear() {
        return caryear;
    }
    public void setCaryear(Integer caryear) {
        this.caryear = caryear;
    }
    public String getCarinfo() {
        return carinfo;
    }
    public void setCarinfo(String carinfo) {
        this.carinfo = carinfo;
    }
    public Double getCarprice() {
        return carprice;
    }
    public void setCarprice(Double carprice) {
        this.carprice = carprice;
    }
    
    public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	@Override
    public String toString() {
        if (this.owner != null)
            return "Car [cartitle=" + cartitle + ", carcountry=" + carcountry + ", caryear=" + caryear + ", carinfo=" + carinfo + ", carprice="
                    + carprice + ", owner=" + this.getOwner() + "]";
        else
            return "Car [cartitle=" + cartitle + ",carcountry=" + carcountry + ", caryear=" + caryear + ", carinfo=" + carinfo + ", carprice="
                    + carprice + "]";
    }

		
	}



