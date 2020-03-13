package com.zufe.oams.service;

import java.util.List;
import java.util.Map;

public interface TeacherBankManageService {
    List<Map<String, Object>> getSingleList();
    List<Map<String, Object>> searchSingleList(String content, Integer langId, String composeFlag);
    int deleteSingle(Integer singleId);
    int insertSingleInfo(Map<String, Object> obj);
    int updateSingleInfo(Map<String, Object> obj);
    int insertSingleList(List<Map<String, Object>> singleList);

    List<Map<String, Object>> getMultipleList();
    List<Map<String, Object>> searchMultipleList(String content, Integer langId, String composeFlag);
    int deleteMultiple(Integer multipleId);
    int insertMultipleInfo(Map<String, Object> obj);
    int updateMultipleInfo(Map<String, Object> obj);
    int insertMultipleList(List<Map<String, Object>> multipleList);

    List<Map<String, Object>> getJudgeList();
    List<Map<String, Object>> searchJudgeList(String content, Integer langId, String composeFlag);
    int deleteJudge(Integer judgeId);
    int insertJudgeInfo(Map<String, Object> obj);
    int updateJudgeInfo(Map<String, Object> obj);
    int insertJudgeList(List<Map<String, Object>> judgeList);

    List<Map<String, Object>> getFillList();
    List<Map<String, Object>> searchFillList(String content, Integer langId, String composeFlag);
    int deleteFill(Integer fillId);
    int insertFillInfo(Map<String, Object> obj);
    int updateFillInfo(Map<String, Object> obj);
    int inserFillList(List<Map<String, Object>> fillList);
}
