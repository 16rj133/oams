package com.zufe.oams.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zufe.oams.pojo.SC;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SCMapper extends BaseMapper<SC> {
    SC selectSC (@Param("courseid") String courseid,
             @Param("studentid") String studentid);
}
