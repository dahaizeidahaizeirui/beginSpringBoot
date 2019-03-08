package com.edityj.chapter2.pojo;

import java.util.Date;

public class Review {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yj_review.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yj_review.user_id
     *
     * @mbg.generated
     */
    private Integer user_id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yj_review.product_id
     *
     * @mbg.generated
     */
    private Integer product_id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yj_review.content
     *
     * @mbg.generated
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yj_review.create_date
     *
     * @mbg.generated
     */
    private Date create_date;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yj_review.id
     *
     * @return the value of yj_review.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yj_review.id
     *
     * @param id the value for yj_review.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yj_review.user_id
     *
     * @return the value of yj_review.user_id
     *
     * @mbg.generated
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yj_review.user_id
     *
     * @param user_id the value for yj_review.user_id
     *
     * @mbg.generated
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yj_review.product_id
     *
     * @return the value of yj_review.product_id
     *
     * @mbg.generated
     */
    public Integer getProduct_id() {
        return product_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yj_review.product_id
     *
     * @param product_id the value for yj_review.product_id
     *
     * @mbg.generated
     */
    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yj_review.content
     *
     * @return the value of yj_review.content
     *
     * @mbg.generated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yj_review.content
     *
     * @param content the value for yj_review.content
     *
     * @mbg.generated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yj_review.create_date
     *
     * @return the value of yj_review.create_date
     *
     * @mbg.generated
     */
    public Date getCreate_date() {
        return create_date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yj_review.create_date
     *
     * @param create_date the value for yj_review.create_date
     *
     * @mbg.generated
     */
    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }
}