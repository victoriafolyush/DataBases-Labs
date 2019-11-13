package models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "menu", schema = "vending_machine_db")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "date_of_creation", nullable = true)
    private Date dateOfCreation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu that = (Menu) o;

        if (id != that.id) return false;
        if (dateOfCreation != null ? !dateOfCreation.equals(that.dateOfCreation) : that.dateOfCreation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dateOfCreation != null ? dateOfCreation.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", dateOfCreation=" + dateOfCreation +
                '}';
    }
}
