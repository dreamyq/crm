<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href=${pageContext.request.contextPath}/css/default.css
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href=${pageContext.request.contextPath}/js/easyui/themes/icon.css />
<link rel="stylesheet" type="text/css"
	href=${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css />
<script type="text/javascript"
	src=${pageContext.request.contextPath}/js/easyui/jquery.min.js></script>
<script type="text/javascript"
	src=${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js></script>
<script type="text/javascript"
	src=${pageContext.request.contextPath}/js/easyui/locale/easyui-lang-zh_CN.js></script>



<!-- <div id="tab-toolbar">
		<table cellpadding="10">
			<tr>
				<td>学生名称：<input class="easyui-textbox" name="name" id="nameSS"></td>
				<td>跟踪者：<select id="userId2SS" class="easyui-combobox" name="userId2" style="width:150px;">   
						    <option></option>   
						    <option>bitem2</option>   
						    <option>bitem3</option>  
						</select>  
				</td>
				<td>跟踪开始时间：<input class= "easyui-datebox" name="creatTime" id="creatTimeMINSS">-<input class= "easyui-datebox" name="creatTime" id="creatTimeMAXSS"></td>
			</tr>
			<tr>
				<td>回访情况：<input class="easyui-textbox" name="remark" id="remarkSS"></td>回访情况
				<td>跟踪方式：<input class="easyui-textbox" name="p_name" id="p_nameSS"></td>
				<td><span class="easyui-linkbutton" iconCls="icon-search" onclick="search()">搜索</span>&nbsp;&nbsp;
					<span class="easyui-menubutton" data-options="menu:'#mm',iconCls:'icon-edit'">更多操作</span>
					<div id="mm" style="width: 150px;">
						<div data-options="iconCls:'icon-remove'" onclick="deletes()">批量删除</div>
					</div>
				</td>
			</tr>
		</table>
	</div> -->
<style type="text/css">
.easyui-textbox {
	height: 30px;
}
</style>

</head>
<body>
	<%-- 数据表格 --%>
	<table id="tab"></table>
	<%-- 数据表格-工具条 --%>
	<div id="tab-toolbar">
		<table cellpadding="10">
			<tr>
				<td>姓名：<input class="easyui-textbox" name="name" id="nameSS"></td>
				<td>电话：<input class="easyui-textbox" name="phone" id="phoneSS"></td>
				<td>咨询师：<select id="userId2SS" class="easyui-combobox"
					name="userId2" style="width: 150px;">
						<option></option>
						<option>bitem2</option>
						<option>bitem3</option>
				</select>
				</td>
				<td>是否缴费：<select id="isPaySS" class="easyui-combobox"
					name="isPay" style="width: 100px;">
						<option value="">全部</option>
						<option value="1">是</option>
						<option value="0">否</option>
				</select>
				</td>
				<td>是否有效：<select id="isEffectiveSS" class="easyui-combobox"
					name="isEffective" style="width: 100px;">
						<option value="">全部</option>
						<option value="1">是</option>
						<option value="0">否</option>
				</select>
				</td>
				<td>回访情况：<select id="remarkSS" class="easyui-combobox"
					name="remark" style="width: 100px;">
						<option value="">全部</option>
						<option value="1">是</option>
						<option value="0">否</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>QQ：<input class="easyui-textbox" name="qq" id="qqSS"></td>
				<td colspan="2"><select class="easyui-combobox" id="dateTypeSS"
					name="dateType" style="width: 120px;">
						<option value="1">创建时间</option>
						<option value="2">第一次访问时间</option>
						<option value="3">上门时间</option>
				</select> <input class="easyui-datebox" name="creatTime" id="dateMINSS">-<input
					class="easyui-datebox" name="creatTime" id="dateMAXSS"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;<span class="easyui-linkbutton"
					iconCls="icon-search" onclick="search()">搜索</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span
					class="easyui-linkbutton" iconCls="icon-add" onclick="add()">添加</span>
				</td>
				<td><span class="easyui-menubutton"
					data-options="menu:'#mm',iconCls:'icon-edit'">更多操作</span>
					<div id="mm" style="width: 150px;">
						<div data-options="iconCls:'icon-remove'" onclick="deletes()">批量删除</div>
						<div data-options="iconCls:'icon-filter'" onclick="fenpeis()">批量分配</div>
					</div> &nbsp;&nbsp;&nbsp;&nbsp; <a href="javascript:void(0);"
					id="btnExport" class="easyui-linkbutton" iconCls='icon-print'>导出Excel</a>
				</td>
			</tr>
			<tr>
				<td><span class="easyui-linkbutton" iconCls="icon-cut"
					onclick="dongtai()">动态显示列</span></td>
			</tr>
		</table>
	</div>
	<%-- 批量分配窗口 --%>
	<div class="easyui-window"
		data-options="iconCls:'icon-save',closed:true,width:350,height:320"
		id="win-fenpei" title="批量分配">
		<%-- 修改-form表单 --%>
		<form id="form-update1">
			<table cellpadding="10">
				<tr>
					<td><table id="tab-fenpei" width="128"></table></td>
					<td><select id="ccc" class="easyui-combobox"
						style="width: 100px"></select></td>
				</tr>
			</table>
		</form>
	</div>
    <%--  添加的窗口  --%>
    <div id="win-add" class="easyui-window" title="添加学生" style="width:600px;height:400px"   
         data-options="iconCls:'icon-save',modal:true,closed:true">   
        <form id="form-add">
			<table cellpadding="10">
				<tr>
					<td>
					<label for="name">姓名:</label> 
					<input id="name-add" class="easyui-textbox" name="name" type="text" style="width:200px">
					</td>
					<td>
					<label for="sex">性别:</label> 
					<input id="sex-add" class="easyui-textbox" name="sex" type="text" style="width:200px">
					</td>
				</tr>
					<tr>
					<td>
					<label for="age">年龄:</label> 
					<input id="age-add" class="easyui-textbox" name="age" type="text" style="width:200px">
					</td>
					<td>
					<label for="phone">电话:</label> 
					<input id="phone-add" class="easyui-textbox" name="phone" type="text" style="width:200px">
					</td>
				</tr>
					<tr>
					<td>
					<label for="education">学历:</label> 
				<!-- 	<input id="education" class="easyui-textbox" name="education" type="text" style="width:200px"> -->
					<select id="education-add" class="easyui-combobox" name="education" style="width:200px;">   
    					<option value="未知">----未知-----</option>   
   					    <option value="大专">大专</option>   
   						<option value="本科">本科</option>   
    					<option value="研究生">研究生</option>   
    					<option value="博士">博士</option>   
					</select>
					</td>
					<td>
					<label for="state">状态:</label> 
					<input id="state-add" class="easyui-textbox" name="state" type="text" style="width:200px">
					</td>
				</tr>
					<tr>
					<td>
					<label for="sources">来源渠道:</label> 
					<!-- <input id="sources" class="easyui-textbox" name="sources" type="text" style="width:200px"> -->
						<select id="sources-add" class="easyui-combobox" name="sources" style="width:200px;">   
    					<option value="未知">----未知-----</option>   
   					    <option value="熟人介绍">熟人介绍</option>   
   						<option value="网上宣传">网上宣传</option>   
    					<option value="老师介绍">老师介绍</option>   
    					<option value="现场宣传">现场宣传</option>   
					</select>
					</td>
					<td>
					<label for="sourceSite">来源网站:</label> 
					<!-- <input id="sourceSite" class="easyui-textbox" name="sourceSite" type="text" style="width:200px"> -->
						<select id="sourceSite-add" class="easyui-combobox" name="sourceSite" style="width:200px;">   
    					<option value="未知">----未知-----</option>   
   					    <option value="百度">大专</option>   
   						<option value="搜狐">本科</option>   
    					<option value="腾讯">腾讯</option>   
    					<option value="抖音">抖音</option>   
					</select>
					</td>
				</tr>
					<tr>
					<td>
					<label for="sourcekeyword">来源关键字:</label> 
					<!-- <input id="sourcekeyword" class="easyui-textbox" name="sourcekeyword" type="text" style="width:200px"> -->
						<select id="sourcekeyword-add" class="easyui-combobox" name="sourcekeyword" style="width:200px;">   
    					<option value="未知">----未知-----</option>   
   					    <option value="java">java</option>   
   						<option value="大数据">大数据</option>   
    					<option value="Python">Python</option>   
    					<option value="人工智能">人工智能</option>
    					<option value="全栈工程师">全栈工程师</option>
    					<option value="架构师">架构师</option>     
					</select>
					</td>
					<td>
					<label for="qq">学员qq:</label> 
					<input id="qq-add" class="easyui-textbox" name="qq" type="text" style="width:200px">
					</td>
				</tr>
					<tr>
					<td>
					<label for="weChat">微信号:</label> 
					<input id="weChat-add" class="easyui-textbox" name="weChat" type="text" style="width:200px">
					</td>
					<td>
					<label for="isReport">是否报备:</label> 
					<input id="isReport-add" class="easyui-textbox" name="isReport" type="text" style="width:200px">
					</td>
				</tr>
					<tr>
					<td>
					<label for="remark">在线备注:</label> 
					<input id="remark-add" class="easyui-textbox" name="remark" type="text" style="width:200px">
					</td>
				</tr>
				<tr>
				 <td>
				    <a  id="btn" onclick="submitAdd()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a> 
				 </td>
				</tr>
			</table>
		</form>
</div> 
	<%-- 查看的窗口  --%>
	<div id="win-detail" class="easyui-window" title="添加学生" style="width:600px;height:400px"   
         data-options="iconCls:'icon-save',modal:true,closed:true">   
        <form id="form-detail">
			<table cellpadding="10">
				<tr>
					<td>
					<label for="name">姓名:</label> 
					<input id="name-detail" class="easyui-textbox" name="name" type="text" style="width:200px">
					</td>
					<td>
					<label for="sex">性别:</label> 
					<input id="sex-detail" class="easyui-textbox" name="sex" type="text" style="width:200px">
					</td>
				</tr>
					<tr>
					<td>
					<label for="age">年龄:</label> 
					<input id="age-detail" class="easyui-textbox" name="age" type="text" style="width:200px">
					</td>
					<td>
					<label for="phone">电话:</label> 
					<input id="phone-detail" class="easyui-textbox" name="phone" type="text" style="width:200px">
					</td>
				</tr>
					<tr>
					<td>
					<label for="education">学历:</label> 
					<select id="education-detail" class="easyui-combobox" name="education" style="width:200px;">   
    					<option value="未知">----未知-----</option>   
   					    <option value="大专">大专</option>   
   						<option value="本科">本科</option>   
    					<option value="研究生">研究生</option>   
    					<option value="博士">博士</option>   
					</select>
					</td>
					<td>
					<label for="state">状态:</label> 
					<input id="state-detail" class="easyui-textbox" name="state" type="text" style="width:200px">
					</td>
				</tr>
					<tr>
					<td>
					<label for="sources">来源渠道:</label> 
						<select id="sources-detail" class="easyui-combobox" name="sources" style="width:200px;">   
    					<option value="未知">----未知-----</option>   
   					    <option value="熟人介绍">熟人介绍</option>   
   						<option value="网上宣传">网上宣传</option>   
    					<option value="老师介绍">老师介绍</option>   
    					<option value="现场宣传">现场宣传</option>   
					</select>
					</td>
					<td>
					<label for="sourceSite">来源网站:</label> 
						<select id="sourceSite-detail" class="easyui-combobox" name="sourceSite" style="width:200px;">   
    					<option value="未知">----未知-----</option>   
   					    <option value="百度">大专</option>   
   						<option value="搜狐">本科</option>   
    					<option value="腾讯">腾讯</option>   
    					<option value="抖音">抖音</option>   
					</select>
					</td>
				</tr>
					<tr>
					<td>
					<label for="sourcekeyword">来源关键字:</label> 
						<select id="sourcekeyword-detail" class="easyui-combobox" name="sourcekeyword" style="width:200px;">   
    					<option value="未知">----未知-----</option>   
   					    <option value="java">java</option>   
   						<option value="大数据">大数据</option>   
    					<option value="Python">Python</option>   
    					<option value="人工智能">人工智能</option>
    					<option value="全栈工程师">全栈工程师</option>
    					<option value="架构师">架构师</option>     
					</select>
					</td>
					<td>
					<label for="qq">学员qq:</label> 
					<input id="qq-detail" class="easyui-textbox" name="qq" type="text" style="width:200px">
					</td>
				</tr>
					<tr>
					<td>
					<label for="weChat">微信号:</label> 
					<input id="weChat-detail" class="easyui-textbox" name="weChat" type="text" style="width:200px">
					</td>
					 <td>
					<label for="isReport">是否报备:</label> 
					<input id="isReport-detail" class="easyui-textbox" name="isReport" type="text" style="width:200px">
					</td> 
				</tr>
					<tr>
					<td>
					<label for="remark">在线备注:</label> 
					<input id="remark-detail" class="easyui-textbox" name="remark" type="text" style="width:200px">
					</td>
				</tr> 
				<!-- 分界线 -->
				 <tr>
				   <td>咨询师录入：</td>
				   </tr>
				   	<tr>
					<td>
					<label for="name">姓名:</label> 
					<input id="name-detail" name="name" type="text" style="width:100px">
					</td>
					<td>
					<label for="course">课程方向:</label> 
					<input id="course-detail" name="course" type="text" style="width:100px">
					</td>
					<td>
					<label for="qq">打分:</label> 
					<input id="scoring-detail" name="scoring" type="text" style="width:100px">
					</td>
				</tr>
				
				<tr>
				<td>
				<label for="isEffective">是否有效:</label> 
				<select id="isEffective-detail" class="easyui-combobox" name="isEffective" style="width:100px;">   
    			<option value="是">是</option>   
    			<option value="否">否</option> 
				</td>
				<td>
				<label for="invalidReason">无效原因:</label> 
				<input id="invalid_reason-detail" name="invalidReason" type="text" style="width:170px">
				</td>
				</tr>
				
				<tr>
				<td>
				<label for="isVisit">是否回访:</label> 
				<select id="isVisit-detail" class="easyui-combobox" name="isVisit" style="width:100px;">   
    			<option value="是">是</option>   
    			<option value="否">否</option> 
				</td>
				<td>
				<label for="firstVisitTime">首访时间:</label> 
				<input class="easyui-datetimebox" name="firstVisitTime"     
        data-options="showSeconds:false" value="3/4/2010 2:3" style="width:130px"> 
				</td>
			 	<td>
				<label for="is_door">是否上门:</label> 
				<select id="is_door-detail" class="easyui-combobox" name="is_door" style="width:100px;">   
    			<option value="是">是</option>   
    			<option value="否">否</option> 
				</td>
				<td>
				 
				<label for="doorTime">上门时间:</label> 
				<input class="easyui-datetimebox" name="doorTime"     
        data-options="showSeconds:false" value="3/4/2010 2:3" style="width:130px"> 
				</td>
				
				</tr>
				
				 <tr>
				<td>
				  <label for="depositAmount">定金金额:</label> 
				  <input id="depositAmount-detail" name="depositAmount" type="text" style="width:170px">
				</td>
				 <td>
				<label for="depositTime">定金时间:</label> 
				<input class="easyui-datetimebox" id="depositTime-detail" name="depositTime"     
        data-options="showSeconds:false"  style="width:130px"> 
				</td> 
				</tr>
				<tr>
				<td>
				<label for="isPay">是否缴费:</label> 
				<select id="isPay-detail" class="easyui-combobox" name="isPay" style="width:100px;">   
    			<option value="是">是</option>   
    			<option value="否">否</option> 
				</td>
				<td>
				<label for="payTime">缴费时间:</label> 
				<input class="easyui-datetimebox" name="payTime"     
        data-options="showSeconds:false" value="3/4/2010 2:3" style="width:130px"> 
				</td>
				<td>
				  <label for="amount">缴费金额:</label> 
				  <input id="amount-detail" name="amount" type="text" style="width:170px">
				</td>
				<td>
				<label for="isRefund">是否退费:</label> 
				<select id="isRefund-detail" class="easyui-combobox" name="isRefund" style="width:100px;">   
    			<option value="是">是</option>   
    			<option value="否">否</option> 
    			</select>
				</td>
				<td>
				  <label for="refundReason">退费原因:</label> 
				  <input id="refundReason-detail" name="refundReason" type="text" style="width:170px">
				</td>
				</tr> 
				
				<tr>
				<td>
				<label for="isClassEntry">是否进班:</label> 
				<select id="isClassEntry-detail" class="easyui-combobox" name="isClassEntry" style="width:100px;">   
    			<option value="是">是</option>   
    			<option value="否">否</option> 
    			</select>
				</td>  
				 
				<td>
				<label for="classEntryTime">进班时间:</label> 
				<input class="easyui-datetimebox" name="classEntryTime"     
        data-options="showSeconds:false"  style="width:140px"> 
				</td> 
			 <td>
				  <label for="classEntryRemark1">进班备注:</label> 
				  <input id="classEntryRemark-detail" name="classEntryRemark" type="text" style="width:170px">
				</td>  
			<td>
				  <label for="amount">咨询师备注:</label> 
				  <input id="amount-detail" name="amount" type="text" style="width:170px">
				</td>
				
				</tr>
               
			</table>
		</form>
</div> 
    <%-- 修改的窗口 --%>
    <div id="win-update" class="easyui-window" title="修改学生" style="width:600px;height:400px"   
         data-options="iconCls:'icon-save',modal:true,closed:true">   
        <form id="form-update">
			<table cellpadding="10">
				<tr>
				    <td style="display: none;">
					<label for="name">studentId:</label> 
					<input id="student_id-update" class="easyui-textbox" name="studentId" type="text" style="width:200px">
					</td>
					<td>
					<label for="name">姓名:</label> 
					<input id="name-update" class="easyui-textbox" name="name" type="text" style="width:200px">
					</td>
					 <td>
					<label for="sex">性别:</label> 
					<input id="sex-update" class="easyui-textbox" name="sex" type="text" style="width:200px">
					</td> 
				</tr>
					<tr>
					<td>
					<label for="age">年龄:</label> 
					<input id="age-update" class="easyui-textbox" name="age" type="text" style="width:200px">
					</td>
					<td>
					<label for="phone">电话:</label> 
					<input id="phone-update" class="easyui-textbox" name="phone" type="text" style="width:200px">
					</td>
				</tr>
					<tr>
					<td>
					<label for="education">学历:</label> 
					<select id="education-update" class="easyui-combobox" name="education" style="width:200px;">   
    					<option value="未知">----未知-----</option>   
   					    <option value="大专">大专</option>   
   						<option value="本科">本科</option>   
    					<option value="研究生">研究生</option>   
    					<option value="博士">博士</option>   
					</select>
					</td>
					<td>
					<label for="state">状态:</label> 
					<input id="state-update" class="easyui-textbox" name="state" type="text" style="width:200px">
					</td>
				</tr>
					<tr>
					<td>
					<label for="sources">来源渠道:</label> 
						<select id="sources-update" class="easyui-combobox" name="sources" style="width:200px;">   
    					<option value="未知">----未知-----</option>   
   					    <option value="熟人介绍">熟人介绍</option>   
   						<option value="网上宣传">网上宣传</option>   
    					<option value="老师介绍">老师介绍</option>   
    					<option value="现场宣传">现场宣传</option>   
					</select>
					</td>
					<td>
					<label for="sourceSite">来源网站:</label> 
						<select id="sourceSite-update" class="easyui-combobox" name="sourceSite" style="width:200px;">   
    					<option value="未知">----未知-----</option>   
   					    <option value="百度">大专</option>   
   						<option value="搜狐">本科</option>   
    					<option value="腾讯">腾讯</option>   
    					<option value="抖音">抖音</option>   
					</select>
					</td>
				</tr>
					<tr>
					<td>
					<label for="sourcekeyword">来源关键字:</label> 
						<select id="sourcekeyword-update" class="easyui-combobox" name="sourcekeyword" style="width:200px;">   
    					<option value="未知">----未知-----</option>   
   					    <option value="java">java</option>   
   						<option value="大数据">大数据</option>   
    					<option value="Python">Python</option>   
    					<option value="人工智能">人工智能</option>
    					<option value="全栈工程师">全栈工程师</option>
    					<option value="架构师">架构师</option>     
					</select>
					</td>
					<td>
					<label for="qq">学员qq:</label> 
					<input id="qq-update" class="easyui-textbox" name="qq" type="text" style="width:200px">
					</td>
				</tr>
					<tr>
					<td>
					<label for="weChat">微信号:</label> 
					<input id="weChat-update" class="easyui-textbox" name="weChat" type="text" style="width:200px">
					</td>
					 <td>
					<label for="isReport">是否报备:</label> 
					<input id="isReport-update" class="easyui-textbox" name="isReport" type="text" style="width:200px">
					</td> 
				</tr>
					<tr>
					<td>
					<label for="remark">在线备注:</label> 
					<input id="remark-update" class="easyui-textbox" name="remark" type="text" style="width:200px">
					</td>
				</tr> 
				<!-- 分界线 -->
				 <tr>
				   <td>咨询师录入：</td>
				   </tr>
				   	<tr>
					<td>
					<label for="name">姓名:</label> 
					<input id="name-update" name="name" type="text" style="width:100px">
					</td>
					<td>
					<label for="course">课程方向:</label> 
					<input id="course-update" name="course" type="text" style="width:100px">
					</td>
					<td>
					<label for="qq">打分:</label> 
					<input id="scoring-update" name="scoring" type="text" style="width:100px">
					</td>
				</tr>
				
				<tr>
				<td>
				<label for="isEffective">是否有效:</label> 
				<select id="isEffective-update" class="easyui-combobox" name="isEffective" style="width:100px;">   
    			<option value="是">是</option>   
    			<option value="否">否</option> 
				</td>
				<td>
				<label for="invalidReason">无效原因:</label> 
				<input id="invalid_reason-update" name="invalidReason" type="text" style="width:170px">
				</td>
				</tr>
				
				<tr>
				<td>
				<label for="isVisit">是否回访:</label> 
				<select id="isVisit-update" class="easyui-combobox" name="isVisit" style="width:100px;">   
    			<option value="是">是</option>   
    			<option value="否">否</option> 
				</td>
				<td>
				<label for="firstVisitTime">首访时间:</label> 
				<input class="easyui-datetimebox" name="firstVisitTime"     
        data-options="showSeconds:false" value="3/4/2010 2:3" style="width:130px"> 
				</td>
			 	<td>
				<label for="is_door">是否上门:</label> 
				<select id="is_door-update" class="easyui-combobox" name="is_door" style="width:100px;">   
    			<option value="是">是</option>   
    			<option value="否">否</option> 
				</td>
				<td>
				 
				<label for="doorTime">上门时间:</label> 
				<input class="easyui-datetimebox" name="doorTime"     
        data-options="showSeconds:false" value="3/4/2010 2:3" style="width:130px"> 
				</td>
				</tr>
				 <tr>
				<td>
				  <label for="depositAmount">定金金额:</label> 
				  <input id="depositAmount-update" name="depositAmount" type="text" style="width:170px">
				</td>
				 <td>
				<label for="depositTime">定金时间:</label> 
				<input class="easyui-datetimebox" id="depositTime-update" name="depositTime"     
        data-options="showSeconds:false"  style="width:130px"> 
				</td> 
				</tr>
				<tr>
				<td>
				<label for="isPay">是否缴费:</label> 
				<select id="isPay-update" class="easyui-combobox" name="isPay" style="width:100px;">   
    			<option value="是">是</option>   
    			<option value="否">否</option> 
				</td>
				<td>
				<label for="payTime">缴费时间:</label> 
				<input class="easyui-datetimebox" name="payTime"     
        data-options="showSeconds:false" value="3/4/2010 2:3" style="width:130px"> 
				</td>
				<td>
				  <label for="amount">缴费金额:</label> 
				  <input id="amount-update" name="amount" type="text" style="width:170px">
				</td>
				<td>
				<label for="isRefund">是否退费:</label> 
				<select id="isRefund-update" class="easyui-combobox" name="isRefund" style="width:100px;">   
    			<option value="是">是</option>   
    			<option value="否">否</option> 
				</td>
				<td>
				  <label for="refundReason">退费原因:</label> 
				  <input id="refundReason-update" name="refundReason" type="text" style="width:170px">
				</td>
				</tr> 
				
				<tr>
				<td>
				<label for="isClassEntry">是否进班:</label> 
				<select id="isClassEntry-update" class="easyui-combobox" name="isClassEntry" style="width:100px;">   
    			<option value="是">是</option>   
    			<option value="否">否</option> 
				</td>  
				 
				<td>
				<label for="classEntryTime">进班时间:</label> 
				<input class="easyui-datetimebox" name="classEntryTime"     
        data-options="showSeconds:false"  style="width:140px"> 
				</td> 
			 <td>
				  <label for="classEntryRemark1">进班备注:</label> 
				  <input id="classEntryRemark-update" name="classEntryRemark" type="text" style="width:170px">
				</td>  
			<td>
				  <label for="amount">咨询师备注:</label> 
				  <input id="amount-update" name="amount" type="text" style="width:170px">
				</td>
				
				</tr>
                <tr>
				 <td>
				    <a  id="btn" onclick="submitUpdate()" class="easyui-linkbutton" data-options="iconCls:'icon-save'">修改</a> 
				 </td>
				</tr> 
			</table>
		</form>
</div> 
<%--跟踪的窗口--%>
<div id="win-TailAfter" class="easyui-window" title="跟踪学生" style="width:600px;height:400px"   
         data-options="iconCls:'icon-save',modal:true,closed:true"> 
         <form id="form-TailAfter"  method="post">
          <table>
            <tr>
             <td>
               <label for="tailAfterTime">跟踪时间:</label> 
               <input class="easyui-datetimebox" name="tailAfterTime"     
        data-options="required:true,showSeconds:false"  style="width:150px">  
             </td>
            </tr>
             <tr>
             <td>
              <label for="tailAfterWay">跟踪方式:</label>
               	  <select id="isClassEntry-detail" class="easyui-combobox" name="tailAfterWay" style="width:100px;">   
    			<option value="上门">上门</option>   
    			<option value="QQ">QQ</option>
    			<option value="电话">电话</option>   
    			</select>
             </td>
            </tr>
             <tr>
             <td>
              <label for="content">回访内容:</label>
               	<input id="content-detail" class="easyui-textbox" name="content" type="text" style="width:200px">
             </td>
            </tr>
             <tr>
             <td>
              <label for="remark">回访情况:</label>
              <select id="isClassEntry-detail" class="easyui-combobox" name="remark" style="width:100px;">   
    			<option value="有效">有效</option>   
    			<option value="非常有效">非常有效</option>
    			<option value="无效">无效</option>   
    			<option value="下次跟进">下次跟进</option> 
    			</select>
             </td>
            </tr>
              <td>
               <label for="nextTailAfterTime">下次跟踪时间:</label> 
               <input class="easyui-datetimebox" name="nextTailAfterTime"     
        data-options="required:true,showSeconds:false"  style="width:150px">  
             </td>
            </tr>
              <tr>
             <td><a id="btn" href="javascript:submitTailAfter()" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a></td>
            </tr>
          </table>
         </form>
         </div>
	<%-- 动态显示列窗口 --%>
	<div class="easyui-window"
		data-options="iconCls:'icon-save',closed:true,width:500,height:300"
		id="win-dongtai" title="动态显示列">
		<table cellpadding="10" id="tab-dongtai">
			<!-- 创建时间、学员姓名、学员电话、性别、年龄、
					学历、个人状态、来源渠道、来源网址、来源关键词、姓名（咨询）、
					所在区域、微信、学员QQ、来源部门、是否报备、课程方向、是否有效、
					打分、是否回访、首次回访时间、是否上门、上门时间、无效原因、是否缴费、缴费时间、金额、
					是否退费、是否进班、进班时间、进班备注、退费原因、定金金额、定金时间 -->
					
					<!-- studentId name age phone education	state sources sourceSite sourcekeyword	
					qq	weChat	isReport	remark	userId1	userId2	creatTime	area	course	isEffective	
					scoring	isVisit	firstVisitTime	isDoor	doorTime	invalidReason	isPay	payTime	amount	
					isRefund	classEntryTime	isClassEntry	classEntryRemark	refundReason	depositAmount	
					depositTime	enteringName	dynamic -->
			<tr>														
				<td>
					ID<input type="checkbox" onclick="dongtai2()" name="studentId" value="ID" />
					姓名<input type="checkbox" onclick="dongtai2()" name="name" value="姓名" />
					年龄<input type="checkbox" onclick="dongtai2()" name="age" value="年龄" />
					手机号<input type="checkbox" onclick="dongtai2()" name="phone" value="手机号" />
					学历<input type="checkbox" onclick="dongtai2()" name="education" value="学历" />
					个人状态<input type="checkbox" onclick="dongtai2()" name="state" value="个人状态" />&nbsp;
					来源渠道<input type="checkbox" onclick="dongtai2()" name="sources" value="来源渠道" />&nbsp;
					来源网址<input type="checkbox" onclick="dongtai2()" name="sourceSite" value="来源网址" />
					
				</td>
			</tr>
			<tr>														
				<td>
					来源关键词<input type="checkbox" onclick="dongtai2()" name="sourcekeyword" value="来源关键词" />
					学员QQ<input type="checkbox" onclick="dongtai2()" name="qq" value="学员QQ" />
					微信<input type="checkbox" onclick="dongtai2()" name="weChat" value="微信" />
					是否报道 <input type="checkbox" onclick="dongtai2()" name="isReport" value="是否报道" />
					备注<input type="checkbox" onclick="dongtai2()" name="remark" value="备注" />
					网络咨询师<input type="checkbox" onclick="dongtai2()" name="userId1" value="网络咨询师" />
					咨询师<input type="checkbox" onclick="dongtai2()" name="userId2" value="咨询师" />
				</td>
			</tr>
			<tr>														
				<td>
					创建时间<input type="checkbox" onclick="dongtai2()" name="creatTime" value="创建时间" />&nbsp;
					地区<input type="checkbox" onclick="dongtai2()" name="area" value="地区" />&nbsp;&nbsp;
					课程方向<input type="checkbox" onclick="dongtai2()" name="course" value="课程方向" />&nbsp;
					地区<input type="checkbox" onclick="dongtai2()" name="area" value="地区" />&nbsp;&nbsp;
					是否有效<input type="checkbox" onclick="dongtai2()" name="isEffective" value="是否有效" />&nbsp;
					打分<input type="checkbox" onclick="dongtai2()" name="scoring" value="打分" />&nbsp;
					是否回访<input type="checkbox" onclick="dongtai2()" name="isVisit" value="是否回访" />&nbsp;
				</td>
			</tr>
			<tr>														
				<td>
					首次回访时间<input type="checkbox" onclick="dongtai2()" name="firstVisitTime" value="首次回访时间" />&nbsp;
					是否上门<input type="checkbox" onclick="dongtai2()" name="isDoor" value="是否上门" />
					上门时间<input type="checkbox" onclick="dongtai2()" name="doorTime" value="上门时间" />&nbsp;
					无效原因<input type="checkbox" onclick="dongtai2()" name="invalidReason" value="无效原因" />
					是否缴费<input type="checkbox" onclick="dongtai2()" name="isPay" value="是否缴费" />&nbsp;
					缴费时间<input type="checkbox" onclick="dongtai2()" name="payTime" value="缴费时间" />
				</td>
			</tr>
			<tr>														
				<td>
					是否退费<input type="checkbox" onclick="dongtai2()" name="isRefund" value="是否退费" />&nbsp;&nbsp;
					进班时间<input type="checkbox" onclick="dongtai2()" name="classEntryTime" value="进班时间" />&nbsp;&nbsp;
					是否进班<input type="checkbox" onclick="dongtai2()" name="isClassEntry" value="是否进班" />&nbsp;&nbsp;
					进班备注<input type="checkbox" onclick="dongtai2()" name="classEntryRemark" value="进班备注" />&nbsp;&nbsp;
					退费原因<input type="checkbox" onclick="dongtai2()" name="refundReason" value="退费原因" />&nbsp;
					定金金额<input type="checkbox" onclick="dongtai2()" name="depositAmount" value="定金金额" />
					
				</td>
			</tr>
			<tr>														
				<td>
					金额<input type="checkbox" onclick="dongtai2()" name="amount" value="金额" />
					定金时间<input type="checkbox" onclick="dongtai2()" name="depositTime" value="定金时间" />
					录入人<input type="checkbox" onclick="dongtai2()" name="enteringName" value="录入人" />
					动态的<input type="checkbox" onclick="dongtai2()" name="dynamic" value="动态的" />
				</td>
			</tr>
		</table>
	</div>

</body>

<!-- 动态显示列+数据表格+搜索 -->
<script type="text/javascript">
	/* 设置tab-dongtai里面复选框的值为已显示列 */
	function dongtai() {
		var html = new Array()
		for (var i = 1; i < columns[0].length - 1; i++) {
			if (columns[0][i].hidden !== true) {
				html[i - 1] = columns[0][i].title;
			}
		}
		var che = $("#tab-dongtai :checkbox");

		for (var i = 0; i < che.length; i++) {
			for (var k = 0; k < html.length; k++) {
				if (che[i].value == html[k]) {
					var name = che[i].name;//已显示的列名
					$("#tab-dongtai :checkbox[name='" + name + "']").attr("checked", "checked");//设置为已选中
					break;
				}
			}
		}
		$("#win-dongtai").window("open");
	}
	/* 根据tab-dongtai里面复选框的选中值显示列 */
	function dongtai2() {
		var che = $("#tab-dongtai :checkbox");
		var columns = [[{field : "xz",checkbox : true}]];
		for (var i = 0; i < che.length; i++) {
			if (che[i].checked) {
				columns[0][columns[0].length] = {field : che[i].name ,title : che[i].value};
			}
		}
		columns[0][columns[0].length] = {field : "cz",title : "操作",formatter : function(value, row, index) {return "<span onclick='update(" + index+ ")'>修改</span>&nbsp;&nbsp;"+ "<span onclick='del(" + index + ")'>删除</span>"}};
		$("#tab").datagrid({
			columns : columns
		});
	}
	$(function() {
		paging();
	});
	var columns = [ [
			{
				field : 'xz',
				checkbox : true
			},
			{
				field : 'studentId',
				title : 'ID'
			},
			{
				field : 'name',
				title : '姓名'
			},
			{
				field : 'age',
				title : '年龄'
			},
			{
				field : 'phone',
				title : '手机号'
			},
			{
				field : 'education',
				title : '学历'
			},
			{
				field : 'state',
				title : '个人状态'
			},
			{
				field : 'sources',
				title : '来源渠道'
			},
			{
				field : 'sourceSite',
				title : '来源网址'
			},
			{
				field : 'sourcekeyword',
				title : '来源关键词'
			},
			{
				field : 'qq',
				title : '学员QQ'
			},
			{
				field : 'weChat',
				title : '微信'
			},
			{
				field : 'cz',
				title : '操作',
				formatter : function(value, row, index) {
					return "<span onclick='update(" + index
							+ ")'>修改</span>&nbsp;&nbsp;"
							+ "<span onclick='del(" + index + ")'>删除</span>&nbsp;&nbsp;"+"<span onclick='detail(" + index + ")'>查看</span>&nbsp;&nbsp;"+"<span onclick='TailAfter(" + index + ")'>跟纵</span>&nbsp;&nbsp";
				}
			} ] ];
	function paging() {
		$("#tab").datagrid({
			url : "pageData",
			title : "跟踪信息",
			method : "post",
			toolbar : "#tab-toolbar",
			pagination : true,
			columns : columns
		});
	}
	function search() {
		$("#tab").datagrid("load", {
			name : $("#nameSS").val(),
			phone : $("#phoneSS").val(),
			userId2 : $("#userId2SS").combobox("getValue"),
			isPay : $("#isPaySS").combobox("getValue"),
			isEffective : $("#isEffectiveSS").combobox("getValue"),
			remark : $("#remarkSS").combobox("getValue"),
			qq : $("#qqSS").val(),
			dateType : $("#dateTypeSS").val(),
			creatTime : $("#dateMINSS").val(),
			firstVisitTime : $("#dateMAXSS").val(),
		});
	}
</script>
<!-- 批量分配 -->
<script type="text/javascript">
	function fenpeis() {
		var row = $("#tab").datagrid("getSelections");
		var ids = "";
		if (row.length > 0) {
			for (var i = 0; i < row.length; i++) {
				ids += row[i].studentId;
				if (row.length - 1 != i) {
					ids += ","
				}
			}
		} else {
			$.messager.alert("系统信息", "请选择数据");
			return;
		}
		$("#tab-fenpei").datagrid({
			url : "fenpeis",
			title : "学生分配信息",
			method : "post",
			queryParams : {
				ids : ids
			},
			columns : [ [ {
				field : 'name',
				title : '学生名字'
			}, {
				field : 'phone',
				title : '咨询师'
			} ] ]
		});
		$("#win-fenpei").window("open");
	}
	$('#ccc').combobox({
		url : '../user/selectZiXunShis',
		valueField : 'userId',
		textField : 'loginName',
		onSelect : function(rec) {
			var row = $("#tab-fenpei").datagrid("getRows");
			var ids = "";
			for (var i = 0; i < row.length; i++) {
				ids += row[i].studentId;
				if (row.length - 1 != i) {
					ids += ","
				}
			}
			$.post("updatefenpeis", {
				ids : ids,
				userId : rec.userId
			}, function(res) {
				if (res > 1) {
					$.messager.alert("系统信息", "批量分配成功");
				} else {
					$.messager.alert("系统信息", "未知错误");
				}
				$("#win-fenpei").window("close");
				$("#tab").datagrid("reload"); //通过调用reload方法，让datagrid刷新显示数据
			});
		}
	});
</script>
<!-- 查 改 删 批删 -->
<script type="text/javascript">
	function update(index) {
		var row = $("#tab").datagrid("getData").rows[index];
		$("#form-update").form("load", row);
		$("#win-update").window("open");
	}

	function submitUpdate() {
		/* if (!isNaN($("#t_type-update").combobox("getValue"))) {//用户修改下拉框则id传给t_type
			$("#t_id-update").val($("#t_type-update").combobox("getValue"));
		} */
		var data=$("#form-update").serializeArray();
	/* 	data.push({
			 "name":"student_id",
			"value":$("#tab").datagrid("getSelected").student_id
		}); */
		$.post("update.do", data, function(
				res) {
			if (res) {
				$.messager.alert("系统信息", "修改成功");
				$("#win-update").window("close");
				$("#tab").datagrid("reload"); //通过调用reload方法，让datagrid刷新显示数据
			}
		}, "json");
	}
	function detail(index) {
		var row = $("#tab").datagrid("getData").rows[index];
		$("#form-detail").form("load", row);
		$("#win-detail").window("open");
	}
	function add() {
		$("#win-add").window("open");
	}
	function submitAdd() {
		var data = $("#form-add").serializeArray();//获取form表单数据
	/* 	data.push({
			"name" : "t_id",
			"value" : $("#t_type-add").combobox("getValue")
		}); */
		$.post("add", data, function(res) {
			if (res) {
				$.messager.alert("系统信息", "添加成功");
				$("#win-add").window("close");
				$("#tab").datagrid("reload"); //通过调用reload方法，让datagrid刷新显示数据
			}
		}, "json");
	}

	function del(index) {
		var row = $("#tab").datagrid("getData").rows[index];
		$.post("delete", {
			studentId : row.studentId
		}, function(res) {
			if (res > 0) {
				$.messager.alert("系统信息", "删除成功");
				$("#tab").datagrid("reload"); //通过调用reload方法，让datagrid刷新显示数据
			} else {
				$.messager.alert("系统信息", "删除失败");
			}
		});
	}

	function deletes() {
		var row = $("#tab").datagrid("getSelections");
		var ids = "";
		if (row.length > 0) {
			for (var i = 0; i < row.length; i++) {
				ids += row[i].studentId;
				if (row.length - 1 != i) {
					ids += ","
				}
			}
		} else {
			$.messager.alert("系统信息", "请选择数据");
			return;
		}
		$.post("deletes", {
			ids : ids
		}, function(res) {
			if (res > 0) {
				$.messager.alert("系统信息", "删除成功");
				$("#tab").datagrid("reload"); //通过调用reload方法，让datagrid刷新显示数据
			} else {
				$.messager.alert("系统信息", "删除失败");
			}
		});
	}
	//跟踪弹出的窗口
	function TailAfter(index) {
		$("#win-TailAfter").window("open");
	}
	function  submitTailAfter() {
		var data=$("#form-TailAfter").serializeArray();
		
		alert(2);
			data.push({
				 "name":"studentId",
				  "value":$("#tab").datagrid("getSelected").studentId
	});
	 data.push({
				 "name":"userId",
				  "value":"<%=session.getAttribute("user_id")%>"
	}); 
		$.post('/crm/TailAfter/add.do',data,function(res){
			if(res>0){
				$("#win-TailAfter").window("close");
				$.messager.alert("系统信息", "跟踪成功");
			}
			
		})
	}
	$(document).ready(function() {
		queryXzqh();
	});

	function queryXzqh() {
		$("#t_type-update").combobox({
			url : "productType/list.do",//获取数据
			method : "post",
			valueField : 't_id',
			textField : 't_type'
		});
		$("#t_type-add").combobox({
			url : "productType/list.do",//获取数据
			method : "post",
			valueField : 't_id',
			textField : 't_type'
		});
	}
</script>
<!-- 导出Exc表格 -->
<script type="text/javascript">
	function JSONToCSVConvertor(JSONData, ReportTitle, ShowLabel) {
		//如果jsondata不是对象，那么json.parse将分析对象中的json字符串。
		var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData)
				: JSONData;
		var CSV = '';

		//在第一行拼接标题
		CSV += ReportTitle + '\r\n\n';

		//产生数据标头
		if (ShowLabel) {
			var row = "";
			//此循环将从数组的第一个索引中提取标签
			for ( var index in arrData[0]) {

				//现在将每个值转换为字符串和逗号分隔
				row += index + ',';
			}

			row = row.slice(0, -1);

			//添加带换行符的标签行
			CSV += row + '\r\n';
		}

		//第一个循环是提取每一行
		for (var i = 0; i < arrData.length; i++) {
			var row = "";

			//2nd loop will extract each column and convert it in string comma-seprated
			for ( var index in arrData[i]) {
				row += '"' + arrData[i][index] + '",';
			}

			row.slice(0, row.length - 1);

			//add a line break after each row
			CSV += row + '\r\n';
		}

		if (CSV == '') {
			alert("Invalid data");
			return;
		}

		//Generate a file name
		var fileName = "我的学生_";
		//this will remove the blank-spaces from the title and replace it with an underscore
		fileName += ReportTitle.replace(/ /g, "_");

		//Initialize file format you want csv or xls
		//var uri = 'data:text/csv;charset=utf-8,' + escape(CSV);
		var uri = 'data:text/csv;charset=utf-8,\ufeff' + encodeURI(CSV);

		// Now the little tricky part.
		// you can use either>> window.open(uri);
		// but this will not work in some browsers
		// or you will not get the correct file extension    

		//this trick will generate a temp <a /> tag
		var link = document.createElement("a");
		link.href = uri;

		//set the visibility hidden so it will not effect on your web-layout
		link.style = "visibility:hidden";
		link.download = fileName + ".csv";

		//this part will append the anchor tag and remove it after automatic click
		document.body.appendChild(link);
		link.click();
		document.body.removeChild(link);
	}

	$("#btnExport").click(function() {
		var data = JSON.stringify($('#tab').datagrid('getData').rows);
		if (data == '')
			return;

		JSONToCSVConvertor(data, "数据信息", true);
	});
</script>
</html>