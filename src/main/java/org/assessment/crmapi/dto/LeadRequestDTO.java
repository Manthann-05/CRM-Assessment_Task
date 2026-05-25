package org.assessment.crmapi.dto;

import lombok.Data;

@Data
public class LeadRequestDTO {
    private String title;
    private String status;
    private Double value;
    private Long customerId;
}
