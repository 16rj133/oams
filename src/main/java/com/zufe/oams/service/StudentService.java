package com.zufe.oams.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.zufe.oams.pojo.Student;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author null123
 * @since 2018-04-07
 */
public interface StudentService extends IService<Student> {

    Page findAll(Page page, String keyword, String type, String id);

    void addStudent(Student student);

    void updateStudent(Student student);
}
