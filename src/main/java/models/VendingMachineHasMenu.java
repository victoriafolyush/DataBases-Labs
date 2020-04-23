package models;

import javax.persistence.*;

@Entity
@Table(name = "vending_machine_has_menu", schema = "vending_machine_db")
public class VendingMachineHasMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "vending_machine_id", nullable = false)
    private int vendingMachineId;

    @Basic
    @Column(name = "menu_id", nullable = false)
    private int menuId;


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


    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VendingMachineHasMenu that = (VendingMachineHasMenu) o;

        if (id != that.id) return false;
        if (vendingMachineId != that.vendingMachineId) return false;
        if (menuId != that.menuId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + vendingMachineId;
        result = 31 * result + menuId;
        return result;
    }

    @Override
    public String toString() {
        return "VendingMachineHasMenu{" +
                "id=" + id +
                ", vendingMachineId=" + vendingMachineId +
                ", menuId=" + menuId +
                '}';
    }
}
