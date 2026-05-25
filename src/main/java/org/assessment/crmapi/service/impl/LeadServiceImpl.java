package org.assessment.crmapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.assessment.crmapi.dto.LeadRequestDTO;
import org.assessment.crmapi.dto.LeadResponseDTO;
import org.assessment.crmapi.entity.Customer;
import org.assessment.crmapi.entity.Lead;
import org.assessment.crmapi.exception.ResourceNotFoundException;
import org.assessment.crmapi.repository.CustomerRepository;
import org.assessment.crmapi.repository.LeadRepository;
import org.assessment.crmapi.service.LeadService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeadServiceImpl implements LeadService {

    private final LeadRepository leadRepository;
    private final CustomerRepository customerRepository;

    @Override
    public LeadResponseDTO createLead(LeadRequestDTO dto) {

        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Customer not found with id: " + dto.getCustomerId()
                ));

        Lead lead = Lead.builder()
                .title(dto.getTitle())
                .status(dto.getStatus())
                .value(dto.getValue())
                .customer(customer)
                .build();

        return mapToDto(leadRepository.save(lead));
    }

    @Override
    public List<LeadResponseDTO> getAllLeads() {

        return leadRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public void deleteLead(Long id) {

        Lead lead = leadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lead not found with id: " + id));

        leadRepository.delete(lead);
    }

    private LeadResponseDTO mapToDto(Lead lead) {

        return LeadResponseDTO.builder()
                .id(lead.getId())
                .title(lead.getTitle())
                .status(lead.getStatus())
                .value(lead.getValue())
                .customerId(lead.getCustomer().getId())
                .build();
    }
}
