package lk.ijse.Entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;



    @Column(name = "product_name", nullable = false, length = 100)
    private String productName;


    @Column(name = "price", nullable = false)
    private Double price;

    @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private List<Order> orders;

    public Product() {
    }

    public Product(String productName , Double price) {
        this.productName = productName;
        this.price = price;

    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
