package com.zerasi.dao;

import com.zerasi.entity.UserCourse;
import com.zerasi.entity.UserCourseExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserCourseMapper {
    int countByExample(UserCourseExample example);

    int deleteByExample(UserCourseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserCourse record);

    int insertSelective(UserCourse record);

    List<UserCourse> selectByExample(UserCourseExample example);

    UserCourse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserCourse record, @Param("example") UserCourseExample example);

    int updateByExample(@Param("record") UserCourse record, @Param("example") UserCourseExample example);

    int updateByPrimaryKeySelective(UserCourse record);

    int updateByPrimaryKey(UserCourse record);
}