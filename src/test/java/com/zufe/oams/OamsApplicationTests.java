package com.zufe.oams;

import com.zufe.oams.mapper.AdminMapper;
import com.zufe.oams.mapper.CourseMapper;
import com.zufe.oams.pojo.Admin;
import com.zufe.oams.pojo.Course;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OamsApplicationTests {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private CourseMapper courseMapper;

    @Test
    public void select() {
       /* Admin admin = new Admin();
        admin.setId("20001");
        admin.setPassword("123456789");
        //String pass =  adminMapper.selectById(admin.getId()).getPassword();
        List<Admin> list = adminMapper.selectList(null);
        adminMapper.updatePassword("20001","123456789");*/

        /*System.out.println(list.size());
        System.out.println("success");*/
        Course course = new Course();
        course.setCourseId("1");
        course.setCourseName("123");
        course.setTid("20200001");
        courseMapper.insert(course);
    }



}
