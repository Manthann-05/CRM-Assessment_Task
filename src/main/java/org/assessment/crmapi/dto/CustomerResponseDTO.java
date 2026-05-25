package org.assessment.crmapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String company;
    private String notes;
}
