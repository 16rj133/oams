package com.zufe.oams.service;

import com.zufe.oams.pojo.TeacherNotice;

import java.util.List;
import java.util.Map;

public interface TeacherNoticeService {
    List<Map<String, Object>> getNoticesList();
    List<Map<String, Object>> searchNoticeInfo(String noticeContent, String teaName);
    boolean noticeContentIsExist(String noticeContent);
    int insertNoticeInfo(TeacherNotice teacherNotice);
    int updateNoticeInfo(TeacherNotice teacherNotice);
    int deleteNotice(Integer noticeId);
}
