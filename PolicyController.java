package Policy.springboot.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Policy.springboot.Entity.Payment;
import Policy.springboot.Entity.Policy;
import Policy.springboot.Entity.Premium;
import Policy.springboot.Service.PolicyService;

@RestController
@RequestMapping("/api")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @PostMapping("/policies")
    public Policy createPolicy(@RequestBody Policy policy) {
        return policyService.createPolicy(policy);
    }

   
        @GetMapping("/policies/{id}")
       public ResponseEntity<Policy> getPolicyById(@PathVariable int id) {
                Policy policy = policyService.getPolicyById(id);
                if (policy != null) {
                    return ResponseEntity.ok(policy);
                } else {
                    return ResponseEntity.notFound().build();
                }
            }

        
    

    @PutMapping("/policies/{id}")
    public Policy updatePolicy(@PathVariable int id, @RequestBody Policy policy) {
        return policyService.updatePolicy(id, policy);
        
    }

    @DeleteMapping("/policies/{id}")
    public void deletePolicy(@PathVariable int id) {
        policyService.deletePolicy(id);
    }

    @PostMapping("/policies/{id}/premiums")
    public Premium addPremium(@PathVariable int id, @RequestBody Premium premium) {
        return policyService.addPremium(id, premium);
    }

    @PostMapping("/payments")
    public Payment createPayment(@RequestBody Payment payment) {
        return policyService.createPayment(payment);
    }

    @GetMapping("/payments/{id}")
    public Payment getPaymentById(@PathVariable int id) {
        return policyService.getPaymentById(id);
    }

    @PutMapping("/payments/{id}")
    public Payment updatePayment(@PathVariable int id, @RequestBody Payment payment) {
        return policyService.updatePayment(id, payment);
    }

    @DeleteMapping("/payments/{id}")
    public void deletePayment(@PathVariable int id) {
        policyService.deletePayment(id);
    }

    @PostMapping("/payments/{id}/policies")
    public Payment addPolicyToPayment(@PathVariable int id, @RequestBody Policy policy) {
        return policyService.addPolicyToPayment(id, policy);
    }
    

    @GetMapping("/policies/{id}/premiums")
    public Iterable<Premium> getPremiumsByPolicyId(@PathVariable int id) {
        return policyService.getPremiumsByPolicyId(id);
    }

   @GetMapping("/policies/{id}/premiums/{year}")
    public Premium getPremiumByPolicyIdAndYear(@PathVariable int id, @PathVariable int year) {
        return policyService.getPremiumByPolicyIdAndYear(id, year);
    }

    @GetMapping("/payments/{id}/policies")
    public Iterable<Policy> getPoliciesByPaymentId(@PathVariable int id) {
        return policyService.getPoliciesByPaymentId(id);
    }

    @GetMapping("/policies/{id}/total_premium")
    public double getTotalPremiumByPolicyId(@PathVariable int id) {
        return policyService.getTotalPremiumByPolicyId(id);
    }

    @GetMapping("/payments/{id}/total_amount")
    public double getTotalAmountByPaymentId(@PathVariable int id) {
        return policyService.getTotalAmountByPaymentId(id);
    }
}
