package com.zufe.oams.service;

import com.baomidou.mybatisplus.service.IService;
import com.zufe.oams.pojo.SC;

public interface SCService extends IService<SC> {
    int addSC(String courseid,String studentid);
}
