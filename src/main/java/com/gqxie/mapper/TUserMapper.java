package com.gqxie.mapper;

import com.gqxie.entity.TUser;
import com.gqxie.entity.TUserExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 用户相关操作
 *
 * @author xieguoqiang
 * @date 2017年11月28日14:38:03
 */
public interface TUserMapper
{
    long countByExample(TUserExample example);

    int deleteByExample(TUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUser record);

    int insertSelective(TUser record);

    List<TUser> selectByExample(TUserExample example);

    TUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByExample(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
}