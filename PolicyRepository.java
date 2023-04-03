package Policy.springboot.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import Policy.springboot.Entity.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Integer> {
}

