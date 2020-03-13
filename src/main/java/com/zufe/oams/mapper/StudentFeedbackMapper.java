package com.zufe.oams.mapper;

import com.zufe.oams.pojo.StudentFeedback;
import com.zufe.oams.pojo.StudentFeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentFeedbackMapper {
    int countByExample(StudentFeedbackExample example);

    int deleteByExample(StudentFeedbackExample example);

    int deleteByPrimaryKey(Integer feedbackId);

    int insert(StudentFeedback record);

    int insertSelective(StudentFeedback record);

    List<StudentFeedback> selectByExample(StudentFeedbackExample example);

    StudentFeedback selectByPrimaryKey(Integer feedbackId);

    int updateByExampleSelective(@Param("record") StudentFeedback record, @Param("example") StudentFeedbackExample example);

    int updateByExample(@Param("record") StudentFeedback record, @Param("example") StudentFeedbackExample example);

    int updateByPrimaryKeySelective(StudentFeedback record);

    int updateByPrimaryKey(StudentFeedback record);
}