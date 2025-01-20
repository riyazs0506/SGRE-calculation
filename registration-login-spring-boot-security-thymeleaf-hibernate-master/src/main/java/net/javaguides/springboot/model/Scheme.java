package net.javaguides.springboot.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Scheme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key

    private String name;
    private Double entryAmount;
    private Integer totalMonths;
    private Double taxPercentage;
    private Double totalAmount;
    private Double taxAmount;
    private Double totalReceiveAmount;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getEntryAmount() {
        return entryAmount;
    }

    public void setEntryAmount(Double entryAmount) {
        this.entryAmount = entryAmount;
    }

    public Integer getTotalMonths() {
        return totalMonths;
    }

    public void setTotalMonths(Integer totalMonths) {
        this.totalMonths = totalMonths;
    }

    public Double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(Double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Double getTotalReceiveAmount() {
        return totalReceiveAmount;
    }

    public void setTotalReceiveAmount(Double totalReceiveAmount) {
        this.totalReceiveAmount = totalReceiveAmount;
    }
}
