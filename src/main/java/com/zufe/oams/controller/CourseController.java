package com.zufe.oams.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.zufe.oams.annotation.Access;
import com.zufe.oams.dto.Response;
import com.zufe.oams.pojo.Course;
import com.zufe.oams.util.ResponseUtil;
import com.zufe.oams.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author null123
 * @since 2018-04-07
 */
@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @CrossOrigin
    @GetMapping(value = "api/course")
    @ResponseBody
    public Response findAll(@RequestParam(value = "currentPage") String currentPage,
                            @RequestParam(value = "size") String size,
                            @RequestParam(value = "keyword",required = false) String keyword,
                            @RequestParam(value = "tid",required = false) String tid,
                            @RequestParam(value = "type",required = false) String type,
                            @RequestParam(value = "id",required = false) String id) {
        Page page = new Page(Integer.parseInt(currentPage),Integer.parseInt(size));
        Page<Course> coursePage = courseService.findAll(page, keyword, tid,type, id);
        System.out.println(coursePage);
        return ResponseUtil.success(coursePage);
    }

    @CrossOrigin
    @PostMapping(value = "api/course/add")
    @ResponseBody
    public Response addCourse(@RequestBody Course course) {
        // System.out.println("接收123");
        Course course1 = new Course();
        //当时报错是因为可能接受的属性有问题，可以自己重新建一个，然后接受
        course1.setCourseId(course.getCourseId());
        course1.setCourseName(course.getCourseName());
        course1.setTid(course.getTid());
        courseService.addCourse(course1);

        //作为测试标准
        return ResponseUtil.success();
    }

    @CrossOrigin
    @PostMapping(value = "api/course/delete/{courseid}")
    @ResponseBody
    public Response deleteOne(@PathVariable("courseid") String courseid) {
        //System.out.println(id+"666");
        Course course = new Course();
        course.setCourseId(courseid);
        courseService.deleteCourse(courseid);
        System.out.println(courseid);
        return ResponseUtil.success();
    }

    @CrossOrigin
    @PostMapping(value = "api/course/update")
    @ResponseBody
    public Response updateCourse(@RequestBody Course course) {
        courseService.updateCourse(course);
        System.out.println("666");
        return ResponseUtil.success();
    }
}

