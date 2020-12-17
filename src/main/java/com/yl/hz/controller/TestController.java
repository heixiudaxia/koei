package com.yl.hz.controller;

import com.yl.hz.mybatis.mapper.StudentMapper;
import com.yl.hz.mybatis.model.MyResult;
import com.yl.hz.mybatis.model.StudentDO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private StudentMapper studentMapper;

    @ResponseBody
    @RequestMapping("/getstudent")
    public MyResult<List<StudentDO>> getStudent(Integer age) {
        List<StudentDO> studentList = studentMapper.queryByAge(age);
        return MyResult.success(studentList);
    }

}
