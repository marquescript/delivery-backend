package com.delivery.api.infra.persistence.jpa_entity;

import com.delivery.api.domain.entity.ItemOrder;
import jakarta.persistence.*;

@Entity
@Table(name = "item_order")
public class ItemOrderPersistence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "total_price")
    private Double totalPrice;

    private String observation;

    @ManyToOne
    @JoinColumn(name = "general_order_id")
    private OrderPersistence orderPersistence;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductPersistence productPersistence;

    public ItemOrderPersistence(Long id, Integer quantity, Double unitPrice, Double totalPrice, String observation, OrderPersistence orderPersistence, ProductPersistence productPersistence) {
        this.id = id;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.observation = observation;
        this.orderPersistence = orderPersistence;
        this.productPersistence = productPersistence;
    }

    public ItemOrderPersistence() {}

    public static ItemOrderPersistence convertItemOrderToItemOrderPersistence(ItemOrder itemOrder) {
        return new ItemOrderPersistence(
                itemOrder.getId(),
                itemOrder.getQuantity(),
                itemOrder.getUnitPrice(),
                itemOrder.getTotalPrice(),
                itemOrder.getObservation(),
                OrderPersistence.convertOrderToOrderPersistence(itemOrder.getOrder()),
                ProductPersistence.convertProductToProductPersistence(itemOrder.getProduct())
        );
    }

    public static ItemOrder convertItemOrderPersistenceToItemOrder(ItemOrderPersistence itemOrderPersistence) {
        return new ItemOrder(
                itemOrderPersistence.getId(),
                itemOrderPersistence.getQuantity(),
                itemOrderPersistence.getUnitPrice(),
                itemOrderPersistence.getTotalPrice(),
                itemOrderPersistence.getObservation(),
                OrderPersistence.convertOrderPersistenceToOrder(itemOrderPersistence.getOrderPersistence()),
                ProductPersistence.convertProductPersistenceToProduct(itemOrderPersistence.getProductPersistence())
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public OrderPersistence getOrderPersistence() {
        return orderPersistence;
    }

    public void setOrderPersistence(OrderPersistence orderPersistence) {
        this.orderPersistence = orderPersistence;
    }

    public ProductPersistence getProductPersistence() {
        return productPersistence;
    }

    public void setProductPersistence(ProductPersistence productPersistence) {
        this.productPersistence = productPersistence;
    }
}
