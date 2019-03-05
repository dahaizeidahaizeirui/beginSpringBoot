package com.edityj.chapter2.typehander;

import com.edityj.chapter2.EnumType.SexEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes(value = SexEnum.class)
public class SexTypeHander extends BaseTypeHandler<SexEnum> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, SexEnum sexEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,sexEnum.getId());

    }

    /**
     * 通过列名读取性别
     * @param resultSet 查询结果
     * @param s 列名
     * @return
     * @throws SQLException
     */
    @Override
    public SexEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int sex = resultSet.getInt(s);
        if(sex !=1 && sex!=0){
            return null;
        }
        return SexEnum.getSexById(sex);
    }

    @Override
    public SexEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int sex = resultSet.getInt(i);
        if(sex !=1 && sex!=0){
            return null;
        }
        return SexEnum.getSexById(sex);
    }

    @Override
    public SexEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int sex = callableStatement.getInt(i);
        if(sex !=1 && sex!=0){
            return null;
        }
        return SexEnum.getSexById(sex);
    }
}
