package com.zufe.oams.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.zufe.oams.dto.Response;
import com.zufe.oams.dto.WorkReleaseDto;
import com.zufe.oams.pojo.WorkRelease;
import com.zufe.oams.util.ResponseUtil;
import com.zufe.oams.service.WorkReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WorkReleaseController {
    @Autowired
    private WorkReleaseService workReleaseService;

    @CrossOrigin
    @GetMapping(value = "api/workrelease")
    @ResponseBody
    public Response queryWorkRelease(@RequestParam(value = "currentPage") String currentPage,
                                     @RequestParam(value = "size") String size,
                                     @RequestParam(value = "keyword",required = false) String keyword,
                                     @RequestParam(value = "teacherNo",required = false) String teacherNo,
                                     @RequestParam(value = "studentNo",required = false) String studentNo
                                     ) {
        Page page = new Page(Integer.parseInt(currentPage),Integer.parseInt(size));
        Page<WorkReleaseDto> workReleasePage = workReleaseService.findAll(page, keyword, teacherNo, studentNo);
       // System.out.println("666"+studentNo);
        System.out.println(workReleasePage);
        return ResponseUtil.success(workReleasePage);
    }

    @CrossOrigin
    @PostMapping(value = "api/workrelease/add")
    @ResponseBody
    public Response addWorkRelease(@RequestBody WorkRelease workRelease) {
        workReleaseService.addWorkRelease(workRelease);
        return ResponseUtil.success();
    }

}

