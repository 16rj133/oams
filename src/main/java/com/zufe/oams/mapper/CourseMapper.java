package com.zufe.oams.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.zufe.oams.pojo.Course;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper extends BaseMapper<Course> {

    Course selectByCourseId(@Param("courseid") String courseid);

    List<Course> selectCourse(Pagination page,
                              @Param("keyword") String keyword,
                              @Param("tid") String tid,
                              @Param("type") String type,
                              @Param("courseid") String course_id);

    List<Course> selectByTeacher(@Param("tid") String tid);

    void deleteByCourseid(@Param("courseid") String courseid);
}
