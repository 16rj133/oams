package com.zufe.oams.service;

import com.zufe.oams.pojo.Student;

import java.util.List;
import java.util.Map;

public interface TeacherStudentService {
    int updateStudentInfo(Student student);
    int insertStudentInfo(Student student);
    List<Map<String, Object>> getScoresList();
    List<Map<String, Object>> getPapersList();
    int deleteScore(String sno, Integer paperId);
    List<Map<String, Object>> searchScoresList(String sno, Integer paperId);
    Map<String, Object> getChartData(Integer paperId);
}
