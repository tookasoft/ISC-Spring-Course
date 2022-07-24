package org.example.domain;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.example.validation.ProductQuantityConstraint;

public class Product {

    private long productId;

    @NotEmpty
    @Size(min = 3, max = 200, message = "Please enter your name between {min} and {max} characters")
    private String name;
    private CharSequence charSequence;

    @NotEmpty
    private String description;

    @Pattern(regexp = "^PRD-[0-9]{6}", message = "please start with PRD and 6 numbers")
    private String code;
    private long price;

    @ProductQuantityConstraint(lowest = 5)
    private int quantity;
    private long productCategoryId;
    private long creatorUserId;
    private Date createDate;

    public Product() {
    }

    public Product(long productId, String name, String description, int quantity, long price, long productCategoryId, long creatorUserId, Date createDate) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.productCategoryId = productCategoryId;
        this.creatorUserId = creatorUserId;
        this.createDate = createDate;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public long getCreatorUserId() {
        return creatorUserId;
    }

    public void setCreatorUserId(long creatorUserId) {
        this.creatorUserId = creatorUserId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", productCategoryId=" + productCategoryId +
                ", creatorUserId=" + creatorUserId +
                ", createDate=" + createDate +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
