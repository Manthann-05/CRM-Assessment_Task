package org.assessment.crmapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LeadResponseDTO {
    private Long id;
    private String title;
    private String status;
    private Double value;
    private Long customerId;
}
