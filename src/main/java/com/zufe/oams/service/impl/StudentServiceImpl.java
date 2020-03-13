package com.zufe.oams.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.zufe.oams.pojo.Student;
import com.zufe.oams.exception.WorkException;
import com.zufe.oams.mapper.StudentMapper;
import com.zufe.oams.service.StudentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public void addStudent(Student student) {
        Student student1 = studentMapper.selectById(student.getId());
        if (student1 != null) {
            throw new WorkException("该学号已存在");
        }
        student.setPassword(student.getId());
        student.setClassesNo("012");//测试所用
        studentMapper.insert(student);
    }

    @Override
    public void updateStudent(Student student) {
        Student student1 = studentMapper.selectById(student.getId());
        if (student1 != null && !student1.getId().equals(student.getId())) {
            throw new WorkException("该学号已存在");
        }
        Student oldStudent = studentMapper.selectById(student.getId());
        if (StringUtils.isEmpty(student.getPassword())) {
            student.setPassword(oldStudent.getPassword());
        }
        studentMapper.updateById(student);
    }

    @Override
    public Page<Student> findAll(Page page, String keyword, String type, String id) {
        List<Student> studentList = studentMapper.selectStudent(page, keyword,type, id);
        for (Student student : studentList) {
            //System.out.println(student);
            student.setPassword("");
        }
        return page.setRecords(studentList);
    }

}
