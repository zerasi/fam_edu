package com.zerasi.dao;

import com.zerasi.entity.UserComment;
import com.zerasi.entity.UserCommentExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserCommentMapper {
    int countByExample(UserCommentExample example);

    int deleteByExample(UserCommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserComment record);

    int insertSelective(UserComment record);

    List<UserComment> selectByExample(UserCommentExample example);

    UserComment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserComment record, @Param("example") UserCommentExample example);

    int updateByExample(@Param("record") UserComment record, @Param("example") UserCommentExample example);

    int updateByPrimaryKeySelective(UserComment record);

    int updateByPrimaryKey(UserComment record);
}