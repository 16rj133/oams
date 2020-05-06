package com.zufe.oams.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.zufe.oams.annotation.Access;
import com.zufe.oams.dto.Response;
import com.zufe.oams.dto.User;
import com.zufe.oams.pojo.Student;
import com.zufe.oams.util.ResponseUtil;
import com.zufe.oams.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @CrossOrigin
    @GetMapping(value = "api/student")
    @ResponseBody
    public Response findAll(@RequestParam(value = "currentPage") String currentPage,
                            @RequestParam(value = "size") String size,
                            @RequestParam(value = "keyword") String keyword,
                           // @RequestParam(value = "classesNo",required = false) String classesNo,
                            @RequestParam(value = "type",required = false) String type,
                            @RequestParam(value = "id",required = false) String id) {
        Page page = new Page(Integer.parseInt(currentPage),Integer.parseInt(size));
        Page<Student> studentPage = studentService.findAll(page, keyword, type, id);
        //System.out.println(studentPage);
        return ResponseUtil.success(studentPage);
    }

   /* @GetMapping("/{id}")
    public Response getOne(@PathVariable("id") String id) {
        Student student = studentService.selectById(id);
        return ResponseUtil.success(student);
    }*/

    @CrossOrigin
    @PostMapping(value = "api/student/add")
    @ResponseBody
    public Response addStudent(@RequestBody Student student) {
        studentService.addStudent(student);

        //System.out.println("666");//作为测试标准
        return ResponseUtil.success();
    }

    @CrossOrigin
    @PostMapping(value = "api/student/delete/{id}")
    @ResponseBody
    public Response deleteOne(@PathVariable("id") String id) {
        //System.out.println(id+"666");
        studentService.deleteById(id);
        return ResponseUtil.success();
    }

    @CrossOrigin
    @PostMapping(value = "api/student/update")
    @ResponseBody
    public Response updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        System.out.println(666);
        return ResponseUtil.success();
    }


}

