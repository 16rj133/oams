package com.zufe.oams.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.zufe.oams.annotation.Access;
import com.zufe.oams.dto.Response;
import com.zufe.oams.pojo.Teacher;
import com.zufe.oams.util.ResponseUtil;
import com.zufe.oams.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @CrossOrigin
    @GetMapping(value = "api/teacher")
    @ResponseBody
    public Response findAll(@RequestParam(value = "currentPage") String currentPage,
                            @RequestParam(value = "size") String size,
                            @RequestParam(value = "keyword") String keyword,
                            // @RequestParam(value = "classesNo",required = false) String classesNo,
                            @RequestParam(value = "type",required = false) String type,
                            @RequestParam(value = "id",required = false) String id) {
        Page page = new Page(Integer.parseInt(currentPage),Integer.parseInt(size));
        Page<Teacher> teacherPage = teacherService.findAll(page, keyword, type, id);
        System.out.println(teacherPage);
        return ResponseUtil.success(teacherPage);
    }

    @GetMapping("/{id}")
    public Response getOne(@PathVariable("id") String id) {
        Teacher teacher = teacherService.selectById(id);
        return ResponseUtil.success(teacher);
    }

    @CrossOrigin
    @PostMapping(value = "api/teacher/add")
    @ResponseBody
    public Response addTeacher(@RequestBody Teacher teacher) {
       // System.out.println("接收123");
        teacherService.addTeacher(teacher);

        //作为测试标准
        return ResponseUtil.success();
    }

    @CrossOrigin
    @PostMapping(value = "api/teacher/delete/{id}")
    @ResponseBody
    public Response deleteOne(@PathVariable("id") String id) {
        //System.out.println(id+"666");
        teacherService.deleteById(id);
        return ResponseUtil.success();
    }

    @CrossOrigin
    @PostMapping(value = "api/teacher/update")
    @ResponseBody
    public Response updateTeacher(@RequestBody Teacher teacher) {
        teacherService.updateTeacher(teacher);
        System.out.println("666");
        return ResponseUtil.success();
    }
}

