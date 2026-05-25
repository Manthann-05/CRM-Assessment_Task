package org.assessment.crmapi.service;

import org.assessment.crmapi.dto.LeadRequestDTO;
import org.assessment.crmapi.dto.LeadResponseDTO;

import java.util.List;

public interface LeadService {

    LeadResponseDTO createLead(LeadRequestDTO dto);

    List<LeadResponseDTO> getAllLeads();

    void deleteLead(Long id);
}
