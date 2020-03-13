package com.zufe.oams.service;

import com.zufe.oams.pojo.ProgramingLanguage;

import java.util.List;
import java.util.Map;

public interface AdminSubjectService {
    List<Map<String, Object>> getSubjectsList();
    List<Map<String, Object>> searchSubjectsList(String langName, String langDesc,
                                                 String langCreatedBy, String isRecommend);
    int insertSubjectInfo(ProgramingLanguage programingLanguage);
    int updateSubjectInfo(ProgramingLanguage programingLanguage);
    int deleteSubject(Integer langId);
}
