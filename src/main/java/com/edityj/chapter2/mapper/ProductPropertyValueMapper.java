package com.edityj.chapter2.mapper;

import com.edityj.chapter2.pojo.ProductPropertyValue;
import com.edityj.chapter2.pojo.ProductPropertyValueExample;
import java.util.List;

public interface ProductPropertyValueMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yj_product_property_value
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yj_product_property_value
     *
     * @mbg.generated
     */
    int insert(ProductPropertyValue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yj_product_property_value
     *
     * @mbg.generated
     */
    int insertSelective(ProductPropertyValue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yj_product_property_value
     *
     * @mbg.generated
     */
    List<ProductPropertyValue> selectByExample(ProductPropertyValueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yj_product_property_value
     *
     * @mbg.generated
     */
    ProductPropertyValue selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yj_product_property_value
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ProductPropertyValue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yj_product_property_value
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ProductPropertyValue record);
}