package com.zufe.oams.service;

import com.zufe.oams.pojo.Teacher;

import java.util.List;
import java.util.Map;

public interface AdminTeacherService {
    Map<String, Object> insertTeacherInfoList(List<Map<String, Object>> teacherList);
    boolean tnoIsExist(String tno);
    List<Teacher> getTeachersList();
    int updateTeacherInfo(Teacher teacher);
    List<Teacher> searchTeacherInfo(String tno, String teaName, String teaSex);
    int insertTeacherInfo(Teacher teacher);
}
