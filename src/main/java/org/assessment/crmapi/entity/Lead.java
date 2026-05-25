package org.assessment.crmapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "leads")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String status;

    private Double value;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
