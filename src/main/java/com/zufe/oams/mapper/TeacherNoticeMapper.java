package com.zufe.oams.mapper;

import com.zufe.oams.pojo.TeacherNotice;
import com.zufe.oams.pojo.TeacherNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherNoticeMapper {
    int countByExample(TeacherNoticeExample example);

    int deleteByExample(TeacherNoticeExample example);

    int deleteByPrimaryKey(Integer noticeId);

    int insert(TeacherNotice record);

    int insertSelective(TeacherNotice record);

    List<TeacherNotice> selectByExample(TeacherNoticeExample example);

    TeacherNotice selectByPrimaryKey(Integer noticeId);

    int updateByExampleSelective(@Param("record") TeacherNotice record, @Param("example") TeacherNoticeExample example);

    int updateByExample(@Param("record") TeacherNotice record, @Param("example") TeacherNoticeExample example);

    int updateByPrimaryKeySelective(TeacherNotice record);

    int updateByPrimaryKey(TeacherNotice record);
}