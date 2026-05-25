package org.assessment.crmapi.controller;

import lombok.RequiredArgsConstructor;
import org.assessment.crmapi.dto.LeadRequestDTO;
import org.assessment.crmapi.dto.LeadResponseDTO;
import org.assessment.crmapi.service.LeadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leads")
@RequiredArgsConstructor
public class LeadController {

    private final LeadService leadService;

    @PostMapping
    public ResponseEntity<LeadResponseDTO> createLead(
            @RequestBody LeadRequestDTO dto
    ) {
        return new ResponseEntity<>(
                leadService.createLead(dto),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<LeadResponseDTO>> getAllLeads() {
        return ResponseEntity.ok(leadService.getAllLeads());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLead(@PathVariable Long id) {
        leadService.deleteLead(id);
        return ResponseEntity.ok("Lead deleted successfully");
    }
}
