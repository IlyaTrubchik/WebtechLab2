package by.bsuir.webtech.ilya.entities;

import java.sql.Date;

public class Order extends Entity {
    private Long orderId;
    private Long userId;
    private Date orderDate;
    private int price;
    public Order(Long orderId,Long userId,Date orderDate,int price)
    {
        this.orderDate = orderDate;
        this.orderId = orderId;
        this.userId = userId;
        this.price = price;
    }
    public Order(Long userId,Date orderDate,int price)
    {
        this.orderDate = orderDate;
        this.userId = userId;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Long getUserId() {
        return userId;
    }
}
