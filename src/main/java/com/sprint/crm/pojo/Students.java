package com.sprint.crm.pojo;

import java.util.Date;

public class Students extends StudentsExt {
    private Integer studentId;

    private String name;//姓名

    private Integer age;//性别

    private String phone;//电话

    private String education;

    private String state;

    private String sources;

    private String sourceSite;

    private String sourcekeyword;

    private String qq;//qq

    private String weChat;//微信

    private String isReport;

    private String remark;

    private Integer userId1;//网络咨询师

    private Integer userId2;//咨询师

    private String creatTime;//创建时间

    private String area;

    private String course;

    private String isEffective;//是否有效

    private String scoring;

    private String isVisit;

    private String firstVisitTime;//第一次访问时间

    private String isDoor;

    private String doorTime;

    private String invalidReason;

    private String isPay;//是否缴费

    private String payTime;//缴费时间

    private String amount;

    private String isRefund;

    private String classEntryTime;//进班时间

    private String isClassEntry;

    private String classEntryRemark;

    private String refundReason;

    private String depositAmount;

    private String depositTime;//定金时间

    private String enteringName;

    private String dynamic;

	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Students(Integer studentId, String name, Integer age, String phone, String education, String state,
			String sources, String sourceSite, String sourcekeyword, String qq, String weChat, String isReport,
			String remark, Integer userId1, Integer userId2, String creatTime, String area, String course,
			String isEffective, String scoring, String isVisit, String firstVisitTime, String isDoor, String doorTime,
			String invalidReason, String isPay, String payTime, String amount, String isRefund, String classEntryTime,
			String isClassEntry, String classEntryRemark, String refundReason, String depositAmount, String depositTime,
			String enteringName, String dynamic) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.education = education;
		this.state = state;
		this.sources = sources;
		this.sourceSite = sourceSite;
		this.sourcekeyword = sourcekeyword;
		this.qq = qq;
		this.weChat = weChat;
		this.isReport = isReport;
		this.remark = remark;
		this.userId1 = userId1;
		this.userId2 = userId2;
		this.creatTime = creatTime;
		this.area = area;
		this.course = course;
		this.isEffective = isEffective;
		this.scoring = scoring;
		this.isVisit = isVisit;
		this.firstVisitTime = firstVisitTime;
		this.isDoor = isDoor;
		this.doorTime = doorTime;
		this.invalidReason = invalidReason;
		this.isPay = isPay;
		this.payTime = payTime;
		this.amount = amount;
		this.isRefund = isRefund;
		this.classEntryTime = classEntryTime;
		this.isClassEntry = isClassEntry;
		this.classEntryRemark = classEntryRemark;
		this.refundReason = refundReason;
		this.depositAmount = depositAmount;
		this.depositTime = depositTime;
		this.enteringName = enteringName;
		this.dynamic = dynamic;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSources() {
		return sources;
	}

	public void setSources(String sources) {
		this.sources = sources;
	}

	public String getSourceSite() {
		return sourceSite;
	}

	public void setSourceSite(String sourceSite) {
		this.sourceSite = sourceSite;
	}

	public String getSourcekeyword() {
		return sourcekeyword;
	}

	public void setSourcekeyword(String sourcekeyword) {
		this.sourcekeyword = sourcekeyword;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWeChat() {
		return weChat;
	}

	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}

	public String getIsReport() {
		return isReport;
	}

	public void setIsReport(String isReport) {
		this.isReport = isReport;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getUserId1() {
		return userId1;
	}

	public void setUserId1(Integer userId1) {
		this.userId1 = userId1;
	}

	public Integer getUserId2() {
		return userId2;
	}

	public void setUserId2(Integer userId2) {
		this.userId2 = userId2;
	}

	public String getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getIsEffective() {
		return isEffective;
	}

	public void setIsEffective(String isEffective) {
		this.isEffective = isEffective;
	}

	public String getScoring() {
		return scoring;
	}

	public void setScoring(String scoring) {
		this.scoring = scoring;
	}

	public String getIsVisit() {
		return isVisit;
	}

	public void setIsVisit(String isVisit) {
		this.isVisit = isVisit;
	}

	public String getFirstVisitTime() {
		return firstVisitTime;
	}

	public void setFirstVisitTime(String firstVisitTime) {
		this.firstVisitTime = firstVisitTime;
	}

	public String getIsDoor() {
		return isDoor;
	}

	public void setIsDoor(String isDoor) {
		this.isDoor = isDoor;
	}

	public String getDoorTime() {
		return doorTime;
	}

	public void setDoorTime(String doorTime) {
		this.doorTime = doorTime;
	}

	public String getInvalidReason() {
		return invalidReason;
	}

	public void setInvalidReason(String invalidReason) {
		this.invalidReason = invalidReason;
	}

	public String getIsPay() {
		return isPay;
	}

	public void setIsPay(String isPay) {
		this.isPay = isPay;
	}

	

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getIsRefund() {
		return isRefund;
	}

	public void setIsRefund(String isRefund) {
		this.isRefund = isRefund;
	}

	

	public String getIsClassEntry() {
		return isClassEntry;
	}

	public void setIsClassEntry(String isClassEntry) {
		this.isClassEntry = isClassEntry;
	}

	public String getClassEntryRemark() {
		return classEntryRemark;
	}

	public void setClassEntryRemark(String classEntryRemark) {
		this.classEntryRemark = classEntryRemark;
	}

	public String getRefundReason() {
		return refundReason;
	}

	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}

	public String getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(String depositAmount) {
		this.depositAmount = depositAmount;
	}



	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getClassEntryTime() {
		return classEntryTime;
	}

	public void setClassEntryTime(String classEntryTime) {
		this.classEntryTime = classEntryTime;
	}

	public String getDepositTime() {
		return depositTime;
	}

	public void setDepositTime(String depositTime) {
		this.depositTime = depositTime;
	}

	public String getEnteringName() {
		return enteringName;
	}

	public void setEnteringName(String enteringName) {
		this.enteringName = enteringName;
	}

	public String getDynamic() {
		return dynamic;
	}

	public void setDynamic(String dynamic) {
		this.dynamic = dynamic;
	}

	@Override
	public String toString() {
		return "Students [studentId=" + studentId + ", name=" + name + ", age=" + age + ", phone=" + phone
				+ ", education=" + education + ", state=" + state + ", sources=" + sources + ", sourceSite="
				+ sourceSite + ", sourcekeyword=" + sourcekeyword + ", qq=" + qq + ", weChat=" + weChat + ", isReport="
				+ isReport + ", remark=" + remark + ", userId1=" + userId1 + ", userId2=" + userId2 + ", creatTime="
				+ creatTime + ", area=" + area + ", course=" + course + ", isEffective=" + isEffective + ", scoring="
				+ scoring + ", isVisit=" + isVisit + ", firstVisitTime=" + firstVisitTime + ", isDoor=" + isDoor
				+ ", doorTime=" + doorTime + ", invalidReason=" + invalidReason + ", isPay=" + isPay + ", payTime="
				+ payTime + ", amount=" + amount + ", isRefund=" + isRefund + ", classEntryTime=" + classEntryTime
				+ ", isClassEntry=" + isClassEntry + ", classEntryRemark=" + classEntryRemark + ", refundReason="
				+ refundReason + ", depositAmount=" + depositAmount + ", depositTime=" + depositTime + ", enteringName="
				+ enteringName + ", dynamic=" + dynamic + "]";
	}

}