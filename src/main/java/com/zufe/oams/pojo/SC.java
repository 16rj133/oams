package com.zufe.oams.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("sc")
public class SC {
    @TableField("courseid")
    String courseid;
    @TableField("studentid")
    String studentid;

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    @Override
    public String toString() {
        return "SC{" +
                "courseid='" + courseid + '\'' +
                ", studentid='" + studentid + '\'' +
                '}';
    }
}
