package com.zufe.oams.service;

import com.zufe.oams.pojo.StudentHomeRotationImg;

import java.util.List;
import java.util.Map;

public interface AdminRotationImgService {
    List<Map<String, Object>> getRotationImgsList();
    List<Map<String, Object>> searchRotationImgsList(String imgTitle, String admName);
    int insertRotationImgInfo(StudentHomeRotationImg studentHomeRotationImg);
    int updateRotationImgInfo(StudentHomeRotationImg studentHomeRotationImg);
    int deleteRotationImgInfo(Integer imgId);
}
