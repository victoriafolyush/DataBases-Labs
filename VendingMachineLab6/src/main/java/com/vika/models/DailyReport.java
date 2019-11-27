package com.vika.models;

import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "daily_report", schema = "vending_machine_db")
public class DailyReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private int id;
    @Column(name = "time_of_report", nullable = false)
    private Timestamp timeOfReport;
    @Column(name = "currency_loaded_from", nullable = false)
    private Double currencyLoadedFrom;
    @Column(name = "quantity_product_loaded_from", nullable = true, precision = 0)
    private Double quantityProductLoadedFrom;
    @Column(name = "quantity_product_loaded_to", nullable = true, precision = 0)
    private Double quantityProductLoadedTo;
    @Column(name = "mechanic_id", nullable = false)
    private Integer mechanicId;
    @Column(name = "vending_machine_id", nullable = false)
    private Integer vendingMachineId;

    public DailyReport(Timestamp timeOfReport, Double currencyLoadedFrom, Double quantityProductLoadedFrom, Double quantityProductLoadedTo, Integer mechanicId, Integer vendingMachineId) {
        this.timeOfReport = timeOfReport;
        this.currencyLoadedFrom = currencyLoadedFrom;
        this.quantityProductLoadedFrom = quantityProductLoadedFrom;
        this.quantityProductLoadedTo = quantityProductLoadedTo;
        this.mechanicId = mechanicId;
        this.vendingMachineId = vendingMachineId;
    }

    public DailyReport() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTimeOfReport() {
        return timeOfReport;
    }

    public void setTimeOfReport(Timestamp timeOfReport) {
        this.timeOfReport = timeOfReport;
    }

    public Double getCurrencyLoadedFrom() {
        return currencyLoadedFrom;
    }

    public void setCurrencyLoadedFrom(Double currencyLoadedFrom) {
        this.currencyLoadedFrom = currencyLoadedFrom;
    }

    public Double getQuantityProductLoadedFrom() {
        return quantityProductLoadedFrom;
    }

    public void setQuantityProductLoadedFrom(Double quantityProductLoadedFrom) {
        this.quantityProductLoadedFrom = quantityProductLoadedFrom;
    }

    public Double getQuantityProductLoadedTo() {
        return quantityProductLoadedTo;
    }

    public void setQuantityProductLoadedTo(Double quantityProductLoadedTo) {
        this.quantityProductLoadedTo = quantityProductLoadedTo;
    }

    public Integer getMechanicId() {
        return mechanicId;
    }

    public void setMechanicId(Integer mechanicId) {
        this.mechanicId = mechanicId;
    }

    public Integer getVendingMachineId() {
        return vendingMachineId;
    }

    public void setVendingMachineId(Integer vendingMachineId) {
        this.vendingMachineId = vendingMachineId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DailyReport that = (DailyReport) o;

        if (id != that.id) return false;
        if (mechanicId != that.mechanicId) return false;
        if (vendingMachineId != that.vendingMachineId) return false;
        if (timeOfReport != null ? !timeOfReport.equals(that.timeOfReport) : that.timeOfReport != null) return false;
        if (currencyLoadedFrom != null ? !currencyLoadedFrom.equals(that.currencyLoadedFrom) : that.currencyLoadedFrom != null)
            return false;
        if (quantityProductLoadedFrom != null ? !quantityProductLoadedFrom.equals(that.quantityProductLoadedFrom) : that.quantityProductLoadedFrom != null)
            return false;
        if (quantityProductLoadedTo != null ? !quantityProductLoadedTo.equals(that.quantityProductLoadedTo) : that.quantityProductLoadedTo != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (timeOfReport != null ? timeOfReport.hashCode() : 0);
        result = 31 * result + (currencyLoadedFrom != null ? currencyLoadedFrom.hashCode() : 0);
        result = 31 * result + (quantityProductLoadedFrom != null ? quantityProductLoadedFrom.hashCode() : 0);
        result = 31 * result + (quantityProductLoadedTo != null ? quantityProductLoadedTo.hashCode() : 0);
        result = 31 * result + mechanicId;
        result = 31 * result + vendingMachineId;
        return result;
    }

    @Override
    public String toString() {
        return "DailyReport{" +
                "id=" + id +
                ", timeOfReport=" + timeOfReport +
                ", currencyLoadedFrom=" + currencyLoadedFrom +
                ", quantityProductLoadedFrom=" + quantityProductLoadedFrom +
                ", quantityProductLoadedTo=" + quantityProductLoadedTo +
                ", mechanicId=" + mechanicId +
                ", vendingMachineId=" + vendingMachineId +
                '}';
    }
}
