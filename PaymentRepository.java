package Policy.springboot.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import Policy.springboot.Entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
