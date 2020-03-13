package com.zufe.oams.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.zufe.oams.pojo.Course;
import com.zufe.oams.exception.WorkException;
import com.zufe.oams.mapper.CourseMapper;
import com.zufe.oams.service.CourseService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author null123
 * @since 2018-04-07
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public void addCourse(Course course) {
        Course course1 = courseMapper.selectByCourseId(course.getCourseId());
        if (course1 != null) {
            throw new WorkException("该课程号已存在");
        }
        courseMapper.insert(course);
    }

    @Override
    public Page<Course> findAll(Page page, String keyword, String tid,
                                String type, String id) {
        List<Course> courseList = courseMapper.selectCourse(page, keyword,tid,type, id);
        /*for (Course course : courseList) {
            System.out.println(course);
        }*/
        return page.setRecords(courseList);

    }

    @Override
    public void updateCourse(Course course) {
        Course course1 = courseMapper.selectByCourseId(course.getCourseId());
        if (course1 != null && !course1.getCourseId().equals(course.getCourseId())) {
            throw new WorkException("该课程号已存在");
        }
        courseMapper.updateById(course);
    }

    @Override
    public void deleteCourse(String courseid) {
        courseMapper.deleteByCourseid(courseid);
    }

    @Override
    public List<Course> findByTeacher(String tid) {
        List<Course> courseList = courseMapper.selectByTeacher(tid);
        return courseList;
    }
}
