package Policy.springboot.Entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "policies")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    
    private String description;
    
    private String address;
    
    private String policyopendate;
    private double totalPremium;
    @ManyToMany(mappedBy = "policies")
    private Set<Payment> payments = new HashSet<>();
    
    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Premium> premiums = new HashSet<>();

  
    public Policy() {
    	
    }

    public Policy(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Premium> getPremiums() {
        return premiums;
    }

  
    public void removePremium(Premium premium) {
        premiums.remove(premium);
        premium.setPolicy(null);
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
        payment.getPolicies().add(this);
    }

    public void removePayment(Payment payment) {
        payments.remove(payment);
        payment.getPolicies().remove(this);
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPolicyopendate() {
		return policyopendate;
	}

	public void setPolicyopendate(String policyopendate) {
		this.policyopendate = policyopendate;
	}

	public void setPremiums(Set<Premium> premiums) {
		this.premiums = premiums;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

	

	public double getTotalPremium() {
		
		 return totalPremium;	
		 }

	
		public Premium getPremiumByYear(int year) {
		    for (Premium premium : premiums) {
		        if (premium.getYear() == year) {
		            return premium;
		        }
		    }
		    return null;
		
	}

	
			public void addPremium(Premium premium) {
			    premiums.add(premium);
			}

		}

	

	

