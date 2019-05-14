package com.sprint.crm.pojo;

import java.util.Date;

public class TailAfter {
    private Integer id;

    private Integer studentId;
    private Integer  userId;
    private String tailAfterTime;
    private String content;//跟踪内容
    private String nextTailAfterTime;//下次跟踪时间
    private String tailAfterWay;//回访方式
    private String remark;//跟踪情况
	public TailAfter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TailAfter(Integer id, Integer studentId, Integer userId, String tailAfterTime, String content,
			String nextTailAfterTime, String tailAfterWay, String remark) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.userId = userId;
		this.tailAfterTime = tailAfterTime;
		this.content = content;
		this.nextTailAfterTime = nextTailAfterTime;
		this.tailAfterWay = tailAfterWay;
		this.remark = remark;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	

	public String getTailAfterTime() {
		return tailAfterTime;
	}

	public void setTailAfterTime(String tailAfterTime) {
		this.tailAfterTime = tailAfterTime;
	}

	public String getNextTailAfterTime() {
		return nextTailAfterTime;
	}

	public void setNextTailAfterTime(String nextTailAfterTime) {
		this.nextTailAfterTime = nextTailAfterTime;
	}

	public String getTailAfterWay() {
		return tailAfterWay;
	}

	public void setTailAfterWay(String tailAfterWay) {
		this.tailAfterWay = tailAfterWay;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "TailAfter [id=" + id + ", studentId=" + studentId + ", userId=" + userId + ", tailAfterTime="
				+ tailAfterTime + ", content=" + content + ", nextTailAfterTime=" + nextTailAfterTime
				+ ", tailAfterWay=" + tailAfterWay + ", remark=" + remark + "]";
	}
    
	
   
}