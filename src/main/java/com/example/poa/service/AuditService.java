package com.example.poa.service;

import com.example.poa.entity.Audit;
import com.example.poa.repository.AuditRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;

@Service
public class AuditService {
    private final AuditRepository auditRepository;

    public AuditService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    public List<Audit> auditeazaActiuni() {
        return auditRepository.findAll().stream().sorted(Comparator.comparing(Audit::getTimestamp)).toList();
    }

    public void salveazaActiune(String numeActiune) {
        Audit audit = new Audit();
        audit.setNumeActiune(numeActiune);
        audit.setTimestamp(new Timestamp(System.currentTimeMillis()));

        auditRepository.save(audit);
    }
}
