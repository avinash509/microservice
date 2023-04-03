package Policy.springboot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Policy.springboot.Entity.Payment;
import Policy.springboot.Entity.Policy;
import Policy.springboot.Entity.Premium;
import Policy.springboot.Repository.PaymentRepository;
import Policy.springboot.Repository.PolicyRepository;
import Policy.springboot.Repository.PremiumRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private PaymentRepository paymentRepository;

   @Autowired
    private PremiumRepository premiumRepository;
    
    public Policy createPolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    
        public Policy getPolicyById(int id) {
            return policyRepository.findById(id).orElse(null);
    }

    public Policy updatePolicy(int id, Policy policy) {
        Policy existingPolicy = policyRepository.findById(id).orElse(null);
        if (existingPolicy != null) {
            existingPolicy.setName(policy.getName());
            return policyRepository.save(existingPolicy);
        }
        return null;
    }

    public void deletePolicy(int id) {
        policyRepository.deleteById(id);
    }

    /*public Premium addPremium(int id, Premium premium) {
        Policy policy = policyRepository.findById(id).orElse(null);
        if (policy != null) {
            policy.addPremium(premium);
            policyRepository.save(policy);
            return premium;
        }
        return null;
    }*/
    
   

    public Premium addPremium(int id, Premium premium) {
        Policy policy = policyRepository.findById(id).orElse(null);
        if (policy != null) {
            premium.setPolicy(policy); // set the policy for the new premium
            Premium newPremium = premiumRepository.save(premium); // persist the new premium to the database
            policy.addPremium(newPremium); // add the new premium to the policy
            policyRepository.save(policy); // update the policy in the database
            return newPremium; // return the new premium with its generated id
        }
        return null;
    }


    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment getPaymentById(int id) {
        return paymentRepository.findById(id).orElse(null);
    }

    public Payment updatePayment(int id, Payment payment) {
        Payment existingPayment = paymentRepository.findById(id).orElse(null);
        if (existingPayment != null) {
            existingPayment.setAmount(payment.getAmount());
            return paymentRepository.save(existingPayment);
        }
        return null;
    }

    public void deletePayment(int id) {
        paymentRepository.deleteById(id);
    }

    public Payment addPolicyToPayment(int id, Policy policy) {
        Payment payment = paymentRepository.findById(id).orElse(null);
        if (payment != null) {
            payment.addPolicy(policy);
            paymentRepository.save(payment);
            return payment;
        }
        return null;
    }

    public Iterable<Premium> getPremiumsByPolicyId(int id) {
        Policy policy = policyRepository.findById(id).orElse(null);
        if (policy != null) {
            return policy.getPremiums();
        }
        return null;
    }

    public Premium getPremiumByPolicyIdAndYear(int id, int year) {
        Policy policy = policyRepository.findById(id).orElse(null);
        if (policy != null) {
            return policy.getPremiumByYear(year);
        }
        return null;
    }

    public Iterable<Policy> getPoliciesByPaymentId(int id) {
        Payment payment = paymentRepository.findById(id).orElse(null);
        if (payment != null) {
            return payment.getPolicies();
        }
        return null;
    }

   public double getTotalPremiumByPolicyId(int id) {
        Policy policy = policyRepository.findById(id).orElse(null);
        if (policy != null) {
            return policy.getTotalPremium();
        }
        return 0;
    }

    public double getTotalAmountByPaymentId(int id) {
        Payment payment = paymentRepository.findById(id).orElse(null);
        if (payment != null) {
            return payment.getTotalAmount();
        }
        return 0;
    }
}
