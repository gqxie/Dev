package com.gqxie.dao;

import com.gqxie.entity.TApp;
import com.gqxie.entity.TAppExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAppMapper {
    long countByExample(TAppExample example);

    int deleteByExample(TAppExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TApp record);

    int insertSelective(TApp record);

    List<TApp> selectByExample(TAppExample example);

    TApp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TApp record, @Param("example") TAppExample example);

    int updateByExample(@Param("record") TApp record, @Param("example") TAppExample example);

    int updateByPrimaryKeySelective(TApp record);

    int updateByPrimaryKey(TApp record);
}