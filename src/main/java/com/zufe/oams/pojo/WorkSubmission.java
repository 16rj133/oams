package com.zufe.oams.pojo;

import java.io.Serializable;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author null123
 * @since 2018-04-07
 */
@TableName("worksubmission")
public class WorkSubmission extends Model<WorkSubmission> {

    private static final long serialVersionUID = 1L;

    private String id;
    @TableField("workno")
    private String workNo;
    @TableField("studentno")
    private String studentNo;
    @TableField("address")
    private String address;
    @TableField("submissiontime")
    private LocalDateTime submissionTime;
    @TableField("status")
    private String status;

    @TableField("grade")
    private int grade;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(LocalDateTime submissionTime) {
        this.submissionTime = submissionTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "WorkSubmission{" +
        "id=" + id +
        ", workNo=" + workNo +
        ", studentNo=" + studentNo +
        ", address=" + address +
        ", submissionTime=" + submissionTime +
        ", status=" + status +
        ", grade=" + grade +
        "}";
    }
}
