package com.yl.hz.mybatis.mapper;

import com.yl.hz.mybatis.model.StudentDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    List<StudentDO> queryByAge(Integer age);
}
