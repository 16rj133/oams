package com.zufe.oams.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.zufe.oams.dto.Constant;
import com.zufe.oams.dto.WorkSubmissionDto;
import com.zufe.oams.pojo.WorkSubmission;
import com.zufe.oams.mapper.WorkSubmissionMapper;
import com.zufe.oams.util.BaseUtil;
import com.zufe.oams.service.WorkSubmissionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WorkSubmissionServiceImpl extends ServiceImpl<WorkSubmissionMapper, WorkSubmission> implements WorkSubmissionService {
    @Autowired
    private WorkSubmissionMapper workSubmissionMapper;

    @Override
    public Page<WorkSubmissionDto> findWorkSubmission(Page page, String workNo, String keyword, String teacherNo,
                                                      String courseNo, String studentNo, String status, String classesNo) {
        List<WorkSubmissionDto> workSubmissionDtoList = workSubmissionMapper.selectWorkSubmission(page, workNo,
                keyword,teacherNo,courseNo,studentNo,status,classesNo);
        for (WorkSubmissionDto workSubmissionDto : workSubmissionDtoList) {
            workSubmissionDto.setStatus(BaseUtil.getStatusValue(workSubmissionDto.getStatus()));
        }
        return page.setRecords(workSubmissionDtoList);
    }

    @Override
    public void addWorkSubmission(WorkSubmission workSubmission) {
        WorkSubmission tempWorkSubmission = workSubmissionMapper
                .selectByWorkNoStudentNo(workSubmission.getWorkNo(),workSubmission.getStudentNo());
        if (tempWorkSubmission != null) {
            tempWorkSubmission.setSubmissionTime(LocalDateTime.now());
            tempWorkSubmission.setStatus(Constant.STATE_YTJ);
            tempWorkSubmission.setAddress(workSubmission.getAddress());
            workSubmissionMapper.updateById(tempWorkSubmission);
        } else {
            workSubmission.setSubmissionTime(LocalDateTime.now());
            workSubmission.setStatus(Constant.STATE_YTJ);
            workSubmissionMapper.insert(workSubmission);
        }
    }

    @Override
    public void correctingWork(String id, String grade) {
        workSubmissionMapper.correctionWork(id, grade);
    }

}
