package com.zufe.oams.controller;

import com.zufe.oams.dto.Response;
import com.zufe.oams.service.SCService;
import com.zufe.oams.service.impl.SCServiceImpl;
import com.zufe.oams.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class SCController {
    @Autowired
    private SCService scService;

    @CrossOrigin
    @PostMapping(value = "api/sc/add")
    @ResponseBody
    public Response joinCourse(@RequestBody Map<String, String> map) {
        String courseid = map.get("courseid");
        String studentid = map.get("studentid");
        System.out.println(courseid+studentid);
        int code = scService.addSC(courseid,studentid);
        System.out.println(code);
        return ResponseUtil.success(code);
    }
}
