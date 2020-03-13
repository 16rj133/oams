package com.zufe.oams.service;

import com.zufe.oams.pojo.StudentPaperAnswer;

import java.util.List;
import java.util.Map;

public interface StudentWrongService {
    List<Map<String, Object>> getWrongAllPapers(String sno);
    List<Map<String, Object>> getWrongPapersByLangId(String sno, Integer langId);
    List<Map<String, Object>> getSingleQueListByWrongPaperId(String sno, Integer paperId);
    List<Map<String, Object>> getMultipleQueListByWrongPaperId(String sno, Integer paperId);
    List<Map<String, Object>> getJudgeQueListByWrongPaperId(String sno, Integer paperId);
    List<Map<String, Object>> getFillQueListByWrongPaperId(String sno, Integer paperId);
    int updatePaperAnswerIsCollect(StudentPaperAnswer studentPaperAnswer);
    List<Map<String, Object>> getAllCollections(String sno);
    List<Map<String, Object>> getCollectionsById(String sno, Integer queType);
    Map<String, Object> getSingleByAnswerId(Integer answerId);
    Map<String, Object> getMultipleByAnswerId(Integer answerId);
    Map<String, Object> getJudgeByAnswerId(Integer answerId);
    Map<String, Object> getFillByAnswerId(Integer answerId);
}
