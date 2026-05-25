package org.assessment.crmapi.service;

import org.springframework.data.domain.Page;
import org.assessment.crmapi.dto.CustomerRequestDTO;
import org.assessment.crmapi.dto.CustomerResponseDTO;

public interface CustomerService {

    CustomerResponseDTO createCustomer(CustomerRequestDTO dto);

    CustomerResponseDTO getCustomerById(Long id);

    Page<CustomerResponseDTO> getAllCustomers(int page, int size);

    Page<CustomerResponseDTO> searchCustomers(String keyword, int page, int size);

    CustomerResponseDTO updateCustomer(Long id, CustomerRequestDTO dto);

    void deleteCustomer(Long id);
}
