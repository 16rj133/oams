package com.zufe.oams.service;

import java.util.List;
import java.util.Map;

public interface TeacherPaperService {
    List<Map<String, Object>> getPapersList();
    List<Map<String, Object>> getLangOptions();
    List<Map<String, Object>> searchPapersList(String paperName, Integer langId, Integer paperType);
    int selectPaperScoreByPaperId(Integer paperId);
    int deletePaper(Integer paperId);
    Map<String, Object> getPaperQueDetailByPaperId(Integer paperId, Integer totalNum);
    int randomInsertPaperInfo(Map<String, Object> obj);
    Map<String, Object> getPaperQueDetailByLangId(Integer langId);
    int fixedInsertPaperInfo(Map<String, Object> obj);
}
