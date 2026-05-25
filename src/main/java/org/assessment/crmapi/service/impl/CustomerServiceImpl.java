package org.assessment.crmapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.assessment.crmapi.dto.CustomerRequestDTO;
import org.assessment.crmapi.dto.CustomerResponseDTO;
import org.assessment.crmapi.entity.Customer;
import org.assessment.crmapi.exception.ResourceNotFoundException;
import org.assessment.crmapi.repository.CustomerRepository;
import org.assessment.crmapi.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerResponseDTO createCustomer(CustomerRequestDTO dto) {

        Customer customer = Customer.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .company(dto.getCompany())
                .notes(dto.getNotes())
                .build();

        return mapToDto(customerRepository.save(customer));
    }

    @Override
    public CustomerResponseDTO getCustomerById(Long id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));

        return mapToDto(customer);
    }

    @Override
    public Page<CustomerResponseDTO> getAllCustomers(int page, int size) {

        return customerRepository.findAll(PageRequest.of(page, size))
                .map(this::mapToDto);
    }

    @Override
    public Page<CustomerResponseDTO> searchCustomers(String keyword, int page, int size) {

        return customerRepository
                .findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
                        keyword, keyword, PageRequest.of(page, size)
                )
                .map(this::mapToDto);
    }

    @Override
    public CustomerResponseDTO updateCustomer(Long id, CustomerRequestDTO dto) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));

        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        customer.setCompany(dto.getCompany());
        customer.setNotes(dto.getNotes());

        return mapToDto(customerRepository.save(customer));
    }

    @Override
    public void deleteCustomer(Long id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));

        customerRepository.delete(customer);
    }

    private CustomerResponseDTO mapToDto(Customer customer) {

        return CustomerResponseDTO.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .company(customer.getCompany())
                .notes(customer.getNotes())
                .build();
    }
}
