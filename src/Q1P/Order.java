package Q1P;

import java.sql.Date;
import java.util.Arrays;

public class Order {
    private Integer id;
    private Product[] product;
    private Customer customer;
    private Integer bill;
    private Date date;
    private Boolean isPayment;

    public Order(Integer id, Product[] product, Customer customer, Integer bill, Date date, Boolean isPayment) {
        this.id = id;
        this.product = product;
        this.customer = customer;
        this.bill = bill;
        this.date = date;
        this.isPayment = isPayment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product[] getProduct() {
        return product;
    }

    public void setProduct(Product[] product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getBill() {
        return bill;
    }

    public void setBill(Integer bill) {
        this.bill = bill;
    }

    public Boolean getPayment() {
        return isPayment;
    }

    public void setPayment(Boolean payment) {
        isPayment = payment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product=" + Arrays.toString(product) +
                ", customer=" + customer +
                ", bill=" + bill +
                ", date=" + date +
                ", isPayment=" + isPayment +
                '}';
    }
}
