package Code.Services;
import Code.Customer;

import java.util.HashSet;
import java.util.Set;

public class CustomerService {

    private Set<Customer> blockedCustomers = new HashSet<>();

    public void blockCustomer(Customer customer) {
        blockedCustomers.add(customer);
    }

    public boolean isBlocked(Customer customer) {
        return blockedCustomers.contains(customer);
    }

}