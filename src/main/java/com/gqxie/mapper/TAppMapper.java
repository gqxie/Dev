package com.gqxie.mapper;

import com.gqxie.entity.TApp;
import com.gqxie.entity.TAppExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TAppMapper
{
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