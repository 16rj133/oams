package com.zufe.oams.service;

import com.zufe.oams.pojo.StudentFeedback;

import java.util.List;
import java.util.Map;

public interface AdminFeedbackService {
    List<Map<String, Object>> getFeedbacksList();
    int getUnReplyCount();
    List<Map<String, Object>> searchFeedbacksList(String feedbackContent,
                                                  String stuName,
                                                  String admAnswer,
                                                  String admName,
                                                  String feedbackStatus);
    int deleteFeedback(Integer feedbackId);
    int replyFeedback(StudentFeedback studentFeedback);
}
