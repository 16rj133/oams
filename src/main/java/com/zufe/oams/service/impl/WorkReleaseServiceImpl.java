package com.zufe.oams.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.zufe.oams.dto.WorkReleaseDto;
import com.zufe.oams.pojo.WorkRelease;
import com.zufe.oams.mapper.WorkReleaseMapper;
import com.zufe.oams.util.BaseUtil;
import com.zufe.oams.util.DateUtil;
import com.zufe.oams.service.WorkReleaseService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class WorkReleaseServiceImpl extends ServiceImpl<WorkReleaseMapper, WorkRelease> implements WorkReleaseService {

    @Autowired
    private WorkReleaseMapper workReleaseMapper;


    @Override
    public void addWorkRelease(WorkRelease workRelease) {
        String workNo = DateUtil.formatNowDate() + workRelease.getCourseNo();
        workRelease.setWorkNo(workNo);
        workRelease.setReleaseTime(LocalDateTime.now());
        workReleaseMapper.insert(workRelease);
    }

    @Override
    public Page<WorkReleaseDto> findAll(Page page, String keyword, String teacherNo, String studentNo) {
        List<WorkReleaseDto> workReleaseList;
        if (teacherNo!=null) {
            System.out.println(teacherNo);
            workReleaseList = workReleaseMapper.selectWorkRelease(page, keyword, teacherNo);
        }else {
            workReleaseList = workReleaseMapper.selectWorkReleaseForStudent(page, keyword, studentNo);
            workReleaseList.removeIf(workReleaseDto -> workReleaseDto.getStatus().equals("2"));
            for (WorkReleaseDto workReleaseDto : workReleaseList) {
                System.out.println(workReleaseDto);
                workReleaseDto.setStatus(BaseUtil.getStatusValue(workReleaseDto.getStatus()));
            }
        }
        return page.setRecords(workReleaseList);
    }
}
