package com.fyytest.recode_school.mapper;

import com.fyytest.recode_school.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

@Mapper
public interface StudentMapper {
    //    全部查找显示
//    List<Student> getStudents();

    //    方法：根据起始行数查找学生信息  分页显示
//    @Param() xml文件用别名
    List<Student> getStudents(@Param("sname") String sname, @Param("gid") Long gid, @Param("startNum") Integer startNum, @Param("pageSize") Integer pageSize);

    //查询数据库中数据总条数
    Integer getStudentCount(@Param("sname") String sname, @Param("gid") Long gid);

    //    修改学生语句 针对某个学生进行修改
    Integer updateStudent(Student student);

    //    添加学生信息
    Integer add(Student student);

    Integer delete(@Param("id") Long id);
}
