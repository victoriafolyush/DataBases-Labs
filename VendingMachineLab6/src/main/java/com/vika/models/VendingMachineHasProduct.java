package com.vika.models;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "vending_machine_has_product", schema = "vending_machine_db")
public class VendingMachineHasProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "vending_machine_id", nullable = false)
    private int vendingMachineId;

    @Basic
    @Column(name = "product_id", nullable = false)
    private int productId;

    @Basic
    @Column(name = "sold_time", nullable = true)
    private Time soldTime;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getVendingMachineId() {
        return vendingMachineId;
    }

    public void setVendingMachineId(int vendingMachineId) {
        this.vendingMachineId = vendingMachineId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }


    public Time getSoldTime() {
        return soldTime;
    }

    public void setSoldTime(Time soldTime) {
        this.soldTime = soldTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VendingMachineHasProduct that = (VendingMachineHasProduct) o;

        if (id != that.id) return false;
        if (vendingMachineId != that.vendingMachineId) return false;
        if (productId != that.productId) return false;
        if (soldTime != null ? !soldTime.equals(that.soldTime) : that.soldTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + vendingMachineId;
        result = 31 * result + productId;
        result = 31 * result + (soldTime != null ? soldTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "VendingMachineHasProduct{" +
                "id=" + id +
                ", vendingMachineId=" + vendingMachineId +
                ", productId=" + productId +
                ", soldTime=" + soldTime +
                '}';
    }
}
