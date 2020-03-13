package com.zufe.oams.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.zufe.oams.pojo.Course;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author null123
 * @since 2018-04-07
 */
public interface CourseService extends IService<Course> {

    void addCourse(Course course);

    Page<Course> findAll(Page page, String keyword, String tid, String type, String id);

    void updateCourse(Course course);

    void deleteCourse(String courseid);

    List<Course> findByTeacher(String tid);
}
