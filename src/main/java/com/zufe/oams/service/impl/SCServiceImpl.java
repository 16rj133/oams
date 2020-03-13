package com.zufe.oams.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zufe.oams.exception.WorkException;
import com.zufe.oams.mapper.SCMapper;
import com.zufe.oams.pojo.SC;
import com.zufe.oams.service.SCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SCServiceImpl extends ServiceImpl<SCMapper, SC> implements SCService{
    @Autowired
    private SCMapper scMapper;
    @Override
    public int addSC(String courseid, String studentid) {
        int code = 200;
        SC sc = new SC();
        sc.setCourseid(courseid);
        sc.setStudentid(studentid);
        SC sc1  = scMapper.selectOne(sc);
        if (sc1 != null) {
            code = 400;
       }
       else
        {
            System.out.println(sc);
            scMapper.insert(sc);
            code = 200;
        }
       return code;
    }
}
