package com.zufe.oams.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.zufe.oams.dto.WorkReleaseDto;
import com.zufe.oams.pojo.WorkRelease;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author null123
 * @since 2018-04-07
 */
public interface WorkReleaseService extends IService<WorkRelease> {

    void addWorkRelease(WorkRelease workRelease);

    Page<WorkReleaseDto> findAll(Page page, String keyword, String teacherNo, String studentNo);
}
