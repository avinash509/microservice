package Policy.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Policy.springboot.Entity.Policy;
import Policy.springboot.Entity.Premium;

public interface PremiumRepository extends JpaRepository<Policy, Integer> {

	Premium save(Premium premium);
}
