package com.zufe.oams.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.zufe.oams.annotation.Access;
import com.zufe.oams.dto.Response;
import com.zufe.oams.pojo.Classes;
import com.zufe.oams.service.ClassesService;
import com.zufe.oams.util.ResponseUtil;
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
public class ClassesController {

    @Autowired
    private ClassesService classesService;

    @CrossOrigin
    @GetMapping(value = "api/classes")
    @ResponseBody
    public Response findAll(@RequestParam(value = "currentPage") String currentPage,
                            @RequestParam(value = "size") String size,
                            @RequestParam(value = "keyword") String keyword,
                            // @RequestParam(value = "classesNo",required = false) String classesNo,
                            @RequestParam(value = "type",required = false) String type,
                            @RequestParam(value = "id",required = false) String id) {
        Page page = new Page(Integer.parseInt(currentPage),Integer.parseInt(size));
        Page<Classes> classesPage = classesService.findAll(page, keyword, type, id);
        //System.out.println(classesPage);
        return ResponseUtil.success(classesPage);
    }

    @CrossOrigin
    @PostMapping(value = "api/classes/add")
    @ResponseBody
    public Response addClasses(@RequestBody Classes classes) {
        // System.out.println("接收123");
        classesService.addClasses(classes);

        //作为测试标准
        return ResponseUtil.success();
    }

    @CrossOrigin
    @PostMapping(value = "api/classes/delete/{id}")
    @ResponseBody
    public Response deleteOne(@PathVariable("id") String id) {
        //System.out.println(id+"666");
        classesService.deleteById(id);
        return ResponseUtil.success();
    }

    @CrossOrigin
    @PostMapping(value = "api/classes/update")
    @ResponseBody
    public Response updateClasses(@RequestBody Classes classes) {
        classesService.updateClasses(classes);
        System.out.println("666");
        return ResponseUtil.success();
    }
}

