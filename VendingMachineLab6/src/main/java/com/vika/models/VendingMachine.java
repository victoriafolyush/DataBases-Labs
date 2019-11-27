package com.vika.models;

import javax.persistence.*;

@Entity
@Table(name = "vending_machine", schema = "vending_machine_db", catalog = "")
public class VendingMachine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "model", nullable = true, length = 45)
    private String model;

    @Basic
    @Column(name = "is_empty", nullable = true, columnDefinition = "BIT(1,0)")
    private Byte isEmpty;

    @Basic
    @Column(name = "location_id", nullable = false)
    private int locationId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public Byte getIsEmpty() {
        return isEmpty;
    }

    public void setIsEmpty(Byte isEmpty) {
        this.isEmpty = isEmpty;
    }


    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VendingMachine that = (VendingMachine) o;

        if (id != that.id) return false;
        if (locationId != that.locationId) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        if (isEmpty != null ? !isEmpty.equals(that.isEmpty) : that.isEmpty != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (isEmpty != null ? isEmpty.hashCode() : 0);
        result = 31 * result + locationId;
        return result;
    }

    @Override
    public String toString() {
        return "VendingMachine{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", isEmpty=" + isEmpty +
                ", locationId=" + locationId +
                '}';
    }
}
