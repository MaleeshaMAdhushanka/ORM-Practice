package lk.ijse.Entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "orderId", nullable = false)
    private Order order;

    @Column(name = "payment_date" , nullable = false)
    private LocalDate paymentDate;

    @Column(name = "amount", nullable = false)
    private Double amount;

    public Payment() {
    }

    public Payment(Order order, LocalDate paymentDate, Double amount) {
        this.order = order;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
