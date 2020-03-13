package com.zufe.oams.service;

import com.zufe.oams.pojo.Paper;
import com.zufe.oams.pojo.ProgramingLanguage;
import com.zufe.oams.pojo.StudentHomeRotationImg;
import com.zufe.oams.pojo.StudentPaperScore;

import java.util.List;
import java.util.Map;

public interface StudentHomeService {
    List<StudentHomeRotationImg> getRotationImages();
    List<ProgramingLanguage> getLanguagesInfo();
    ProgramingLanguage getLanguageInfoById(Integer langId);
    List<Paper> getPapersInfo(Integer langId);
    Paper getPapersInfoByPaperId(Integer paperId);
    Map<String, Integer> getPaperQueNumByPaperId(Integer paperId);
    int insertStudentPaperScore(StudentPaperScore studentPaperScore);
    List<Map<String, Object>> getSingleQueListByPaperId(Integer paperId);
    List<Map<String, Object>> getMultipleQueListByPaperId(Integer paperId);
    List<Map<String, Object>> getJudgeQueListByPaperId(Integer paperId);
    List<Map<String, Object>> getFillQueListByPaperId(Integer paperId);
    int insertPaperAnswerAndPaperScore(String sno, Integer paperId, List<String> singleAnswers,
                                       List<List<String>> multipleAnswers, List<String> judgeAnswers,
                                       List<String> fillAnswers, int timeUsed);
    List<StudentPaperScore> getCurrentPaperStatus(String sno, Integer paperId);
    Map<String, Object> getScoreReport(String sno, Integer paperId);
}
