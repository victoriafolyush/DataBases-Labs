package models;

import javax.persistence.*;

@Entity
@Table(name = "daily_report_has_product", schema = "vending_machine_db")
public class DailyReportHasProduct {

    @Basic
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Id
    @Column(name = "daily_report_id", nullable = false)
    private int dailyReportId;

    @Basic
    @Column(name = "product_id", nullable = false)
    private int productId;

    @Basic
    @Column(name = "quantity_product", nullable = true)
    private Integer quantityProduct;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDailyReportId() {
        return dailyReportId;
    }

    public void setDailyReportId(int dailyReportId) {
        this.dailyReportId = dailyReportId;
    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Integer getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(Integer quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DailyReportHasProduct that = (DailyReportHasProduct) o;

        if (id != that.id) return false;
        if (dailyReportId != that.dailyReportId) return false;
        if (productId != that.productId) return false;
        if (quantityProduct != null ? !quantityProduct.equals(that.quantityProduct) : that.quantityProduct != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + dailyReportId;
        result = 31 * result + productId;
        result = 31 * result + (quantityProduct != null ? quantityProduct.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DailyReportHasProduct{" +
                "id=" + id +
                ", dailyReportId=" + dailyReportId +
                ", productId=" + productId +
                ", quantityProduct=" + quantityProduct +
                '}';
    }
}
