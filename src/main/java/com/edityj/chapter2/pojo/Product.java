package com.edityj.chapter2.pojo;

import java.util.Date;

public class Product {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yj_product.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yj_product.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yj_product.sub_title
     *
     * @mbg.generated
     */
    private String sub_title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yj_product.original_price
     *
     * @mbg.generated
     */
    private Float original_price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yj_product.promote_price
     *
     * @mbg.generated
     */
    private Float promote_price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yj_product.stock
     *
     * @mbg.generated
     */
    private Integer stock;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yj_product.category_id
     *
     * @mbg.generated
     */
    private Integer category_id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yj_product.create_date
     *
     * @mbg.generated
     */
    private Date create_date;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yj_product.id
     *
     * @return the value of yj_product.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yj_product.id
     *
     * @param id the value for yj_product.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yj_product.name
     *
     * @return the value of yj_product.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yj_product.name
     *
     * @param name the value for yj_product.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yj_product.sub_title
     *
     * @return the value of yj_product.sub_title
     *
     * @mbg.generated
     */
    public String getSub_title() {
        return sub_title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yj_product.sub_title
     *
     * @param sub_title the value for yj_product.sub_title
     *
     * @mbg.generated
     */
    public void setSub_title(String sub_title) {
        this.sub_title = sub_title == null ? null : sub_title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yj_product.original_price
     *
     * @return the value of yj_product.original_price
     *
     * @mbg.generated
     */
    public Float getOriginal_price() {
        return original_price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yj_product.original_price
     *
     * @param original_price the value for yj_product.original_price
     *
     * @mbg.generated
     */
    public void setOriginal_price(Float original_price) {
        this.original_price = original_price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yj_product.promote_price
     *
     * @return the value of yj_product.promote_price
     *
     * @mbg.generated
     */
    public Float getPromote_price() {
        return promote_price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yj_product.promote_price
     *
     * @param promote_price the value for yj_product.promote_price
     *
     * @mbg.generated
     */
    public void setPromote_price(Float promote_price) {
        this.promote_price = promote_price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yj_product.stock
     *
     * @return the value of yj_product.stock
     *
     * @mbg.generated
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yj_product.stock
     *
     * @param stock the value for yj_product.stock
     *
     * @mbg.generated
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yj_product.category_id
     *
     * @return the value of yj_product.category_id
     *
     * @mbg.generated
     */
    public Integer getCategory_id() {
        return category_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yj_product.category_id
     *
     * @param category_id the value for yj_product.category_id
     *
     * @mbg.generated
     */
    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yj_product.create_date
     *
     * @return the value of yj_product.create_date
     *
     * @mbg.generated
     */
    public Date getCreate_date() {
        return create_date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yj_product.create_date
     *
     * @param create_date the value for yj_product.create_date
     *
     * @mbg.generated
     */
    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }
}