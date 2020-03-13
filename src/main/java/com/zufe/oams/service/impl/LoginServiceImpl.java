package com.zufe.oams.service.impl;

import com.zufe.oams.mapper.ClassesMapper;
import com.zufe.oams.dto.PasswordVO;
import com.zufe.oams.dto.User;
import com.zufe.oams.pojo.Admin;
import com.zufe.oams.pojo.Student;
import com.zufe.oams.pojo.Teacher;
import com.zufe.oams.exception.WorkException;
import com.zufe.oams.mapper.AdminMapper;
import com.zufe.oams.mapper.StudentMapper;
import com.zufe.oams.mapper.TeacherMapper;
import com.zufe.oams.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public User login(String id, String password) {

        User user = new User();
        Admin admin = adminMapper.selectById(id);
        //System.out.println(666);
        if (admin != null && admin.getPassword().equals(password)) {
            user.setId(admin.getId());
            user.setType("0");
            user.setName(admin.getName());
            return user;
        }
        Teacher teacher = teacherMapper.selectById(id);
        if (teacher != null && teacher.getPassword().equals(password)) {
            user.setId(teacher.getId());
            user.setType("1");
            user.setName(teacher.getName());
            return user;
        }
        Student student = studentMapper.selectById(id);
        if (student != null && student.getPassword().equals(password)) {
            user.setId(student.getId());
            user.setType("2");
            user.setName(student.getName());
            user.setSex(student.getSex());
            user.setClassesName(classesMapper.selectById(student.getClassesNo()).getCname());
            return user;
        }
        throw new WorkException("用户名或密码错误");
    }

    @Override
    public void changePassword(PasswordVO passwordVO) {
        String id = passwordVO.getId();
        String oldPassword = passwordVO.getOldPassword();
        String newPassword = passwordVO.getNewPassword();
        switch (passwordVO.getType()) {
            case "0" : {
               Admin admin = adminMapper.selectById(id);
               if (admin != null && admin.getPassword().equals(oldPassword)) {
                   //adminMapper.updatePassword(id, newPassword);
                   return;
               }
               break;
            }
            case "1" : {
                Teacher teacher = teacherMapper.selectById(id);
                if (teacher != null && teacher.getPassword().equals(oldPassword)) {
                    teacherMapper.updatePassword(id, newPassword);
                    return;
                }
                break;
            }
            case "2" : {
                Student student = studentMapper.selectById(id);
                if (student != null && student.getPassword().equals(oldPassword)) {
                    studentMapper.updatePassword(id, newPassword);
                    return;
                }
                break;
            }
            default : {
                break;
            }
        }
        throw new WorkException("原密码错误");
    }
}
