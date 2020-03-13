package com.zufe.oams.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.zufe.oams.dto.Response;
import com.zufe.oams.dto.WorkSubmissionDto;
import com.zufe.oams.pojo.WorkSubmission;
import com.zufe.oams.util.ResponseUtil;
import com.zufe.oams.service.WorkSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author null123
 * @since 2018-04-07
 */
@RestController
public class WorkSubmissionController {
    @Autowired
    private WorkSubmissionService workSubmissionService;

    @CrossOrigin
    @GetMapping(value = "api/worksubmission")
    @ResponseBody
    public Response queryWorkSubmission(@RequestParam(value = "currentPage") String currentPage,
                                        @RequestParam(value = "size") String size,
                                        @RequestParam(value = "workNo",required = false) String workNo,
                                        @RequestParam(value = "keyword",required = false) String keyword,
                                        @RequestParam(value = "teacherNo",required = false) String teacherNo,
                                        @RequestParam(value = "courseNo",required = false) String courseNo,
                                        @RequestParam(value = "status",required = false) String status,
                                        @RequestParam(value = "studentNo",required = false) String studentNo,
                                        @RequestParam(value = "classesNo",required = false) String classesNo) {
        Page page = new Page(Integer.parseInt(currentPage),Integer.parseInt(size));
        Page<WorkSubmissionDto> workSubmissionDtoPage = workSubmissionService.findWorkSubmission(page, workNo, keyword,
                teacherNo,courseNo,studentNo,status,classesNo);
        return ResponseUtil.success(workSubmissionDtoPage);
    }

    @CrossOrigin
    @PostMapping(value = "api/worksubmission/add")
    @ResponseBody
    public Response addWorkSubmission(@RequestBody WorkSubmission workSubmission) {
        System.out.println(workSubmission);
        workSubmissionService.addWorkSubmission(workSubmission);
        return ResponseUtil.success();
    }

    @CrossOrigin
    @PostMapping(value = "api/worksubmission/correcting")
    @ResponseBody
    public Response correctingWork(@RequestBody Map<String, String> map) {
        String id = map.get("id");
        String grade = map.get("grade");
        workSubmissionService.correctingWork(id,grade);
        return ResponseUtil.success();
    }
}

