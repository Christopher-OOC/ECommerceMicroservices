package com.javalord.Customer.customer;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public String createCustomer(CustomerRequest request) {
        var customer = customerRepository.save(customerMapper.toCustomer(request));
        return customer.getId();
    }

    public void updateCustomer(@Valid CustomerRequest request) {
        var customer = customerRepository.findById(request.id())
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("Cannot update customer:: No customer found with the " +
                                "provided ID:: %s", request.id())
                ));
        mergerCustomer(customer, request);
        customerRepository.save(customer);
    }

    private void mergerCustomer(Customer customer, @Valid CustomerRequest request) {
        if (StringUtils.isNotBlank(request.firstname())) {
            customer.setFirstname(request.firstname());
        }
        if (StringUtils.isNotBlank(request.lastname())) {
            customer.setFirstname(request.lastname());
        }
        if (StringUtils.isNotBlank(request.email())) {
            customer.setFirstname(request.email());
        }
        if (request.address() != null) {
            customer.setAddress(request.address());
        }
    }

    public List<CustomerResponse> findAllCustomers() {
        return customerRepository
                .findAll()
                .stream()
                .map(customerMapper::fromCustomer)
                .collect(Collectors.toList());

    }

    public Boolean exitsById(String custometId) {
        return customerRepository.findById(custometId).isPresent();
    }

    public CustomerResponse findById(String custometId) {
        return customerRepository.findById(custometId).map(customerMapper::fromCustomer)
                .orElseThrow(() -> new CustomerNotFoundException(String.format("No customer found with the " +
                        "provided ID:: %s", custometId)));
    }

    public void deleteCustomer(String custometId) {
        customerRepository.deleteById(custometId);
    }
}
