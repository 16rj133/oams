package com.zufe.oams.mapper;

import com.zufe.oams.pojo.StudentPaperAnswer;
import com.zufe.oams.pojo.StudentPaperAnswerExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentPaperAnswerMapper {
    int countByExample(StudentPaperAnswerExample example);

    int deleteByExample(StudentPaperAnswerExample example);

    int deleteByPrimaryKey(Integer answerId);

    int insert(StudentPaperAnswer record);

    int insertSelective(StudentPaperAnswer record);

    List<StudentPaperAnswer> selectByExample(StudentPaperAnswerExample example);

    StudentPaperAnswer selectByPrimaryKey(Integer answerId);

    int updateByExampleSelective(@Param("record") StudentPaperAnswer record, @Param("example") StudentPaperAnswerExample example);

    int updateByExample(@Param("record") StudentPaperAnswer record, @Param("example") StudentPaperAnswerExample example);

    int updateByPrimaryKeySelective(StudentPaperAnswer record);

    int updateByPrimaryKey(StudentPaperAnswer record);

    int selectSingleCorrectCount(StudentPaperAnswer record);

    int selectMultipleCorrectCount(StudentPaperAnswer record);

    int selectJudgeCorrectCount(StudentPaperAnswer record);

    int selectFillCorrectCount(StudentPaperAnswer record);
}