package com.zufe.oams.service;

import com.zufe.oams.pojo.StudentFeedback;
import com.zufe.oams.pojo.TeacherNotice;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StudentProfileService {
    int studentSendFeedback(String content, Date createTime, String sno, String stuName);
    int getAdminReplyCount(String sno, String feedbackStatus);
    int updateFeedbackStatusBySno(String sno, String feedbackStatus);
    List<StudentFeedback> getFeedbackInfoBySno(String sno, String feedbackStatus);
    List<TeacherNotice> getTeacherNotice();
    List<Map<String, Object>> getPaperScoreInfoBySno(String sno);
}
