package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Scheme;
import net.javaguides.springboot.repository.SchemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchemeService {

    @Autowired
    private SchemeRepository schemeRepository;

    public List<Scheme> calculateSchemes(List<Scheme> schemes) {
        for (Scheme scheme : schemes) {
            if (isInvalidScheme(scheme)) {
                throw new IllegalArgumentException("Invalid scheme data");
            }

            double totalDays = calculateTotalDays(scheme.getTotalMonths());
            double totalAmount = calculateTotalAmount(scheme.getEntryAmount(), totalDays);
            double taxAmount = calculateTaxAmount(totalAmount, scheme.getTaxPercentage());
            double totalReceiveAmount = calculateTotalReceiveAmount(totalAmount, taxAmount);

            scheme.setTotalAmount(totalAmount);
            scheme.setTaxAmount(taxAmount);
            scheme.setTotalReceiveAmount(totalReceiveAmount);

            // Save the updated scheme to the database
            schemeRepository.save(scheme);
        }

        return schemes;
    }

    private boolean isInvalidScheme(Scheme scheme) {
        return scheme.getName() == null ||
                scheme.getEntryAmount() == null ||
                scheme.getTotalMonths() == null ||
                scheme.getTaxPercentage() == null;
    }

    private double calculateTotalDays(Integer totalMonths) {
        return totalMonths * 30; // Assuming 30 days per month
    }

    private double calculateTotalAmount(Double entryAmount, double totalDays) {
        return entryAmount * totalDays; // Total amount calculation
    }

    private double calculateTaxAmount(double totalAmount, Double taxPercentage) {
        return totalAmount * (taxPercentage / 100); // Tax calculation
    }

    private double calculateTotalReceiveAmount(double totalAmount, double taxAmount) {
        return totalAmount - taxAmount; // Total receive amount calculation
    }
    public List<Scheme> findAll() {
        return schemeRepository.findAll();
    }

    public Scheme saveScheme(Scheme scheme) {
        return schemeRepository.save(scheme);
    }

    public void deleteScheme(Long id) {
        schemeRepository.deleteById(id);
    }
}