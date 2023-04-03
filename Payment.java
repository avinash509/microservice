package Policy.springboot.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import jakarta.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {

 
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String name;
    
    private double amount;
    
    private String year;
    
    private String plantype;
    private double totalAmount;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "payment_policy",
        joinColumns = { @JoinColumn(name = "payment_id") },
        inverseJoinColumns = { @JoinColumn(name = "policy_id") }
    )
    private Set<Policy> policies = new HashSet<>();

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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPlantype() {
		return plantype;
	}

	public void setPlantype(String plantype) {
		this.plantype = plantype;
	}

	public Set<Policy> getPolicies() {
		return policies;
	}

	public void setPolicies(Set<Policy> policies) {
		this.policies = policies;
	}

	public void addPolicy(Policy policy) {
		
		   policies.add(policy);
		
	}


		 public double getTotalAmount() {
		        return totalAmount;
		    }
	
	}

	
		
	

	