<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="com.google.gson.*" %>

<%@ page import="Bean.Project.RewardProject" %>
<%  /*避免瀏覽器因cache而無法看到最新資料*/
    response.setHeader("Pragma","no-cache");
    response.setHeader("Cache-Control","no-cache");
    response.setDateHeader("Expires", 0);
%>

<!DOCTYPE HTML>
<html lang="zh">
<link rel="stylesheet" type="text/css" href="/css/FormStyle.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style type="text/css">
        body{
            text-align-last: center;
        }
        thead{
            background-color: rgb(255, 255, 240);
        }
        th{
            border-style: solid;
            border-width: thin;
        }
        .left{
            text-align-last: left;
        }
</style>
<div class="content">
	<h2>特聘教授</h2>
    <table >
        <thead>
            <tr  >
                <td>申請表名稱</td>
            </tr>
        </thead>
        <tbody>
        <tr>
            <td class="left"><a style="color:blue" href="DistinguishedProfessorForm">特聘教授申請表</a></td>
        </tr>
        <tr>
            <td class="left"><a style="color:blue" href="DistinguishedProfessorAppDocInstructions" >審查資料(填寫說明)</a></td>
        </tr>
        <tr>
            <td class="left"><a style="color:blue" href="DistinguishedProfessorTableA" >近五年內發表之期刊論文統計表(表A)</a></td>
        </tr>
       <tr>
            <td class="left"><a style="color:blue" href="PaperPerformanceDescriptionForm">傑出論文績效說明表(表B)</a></td>
        </tr>
        <tr>
            <td class="left"><a style="color:blue" href="PaperPerformanceDescriptionUpload">論文績效說明表(表B)-上傳檔案</a></td>
        </tr>
        </tbody>
        
    </table>
    <br>
	<div style="text-align: center;" class="edit">
        <input type="button" name="return_last_page" value="回上頁"  onclick="javascript:location.href='/RewardList'">
        <input type="button" name="commit" value="提出申請" onclick="sendApply()">
    </div>
    <div style="text-align: center;" class="review">
        <input type="button" name="return_last_page" value="回上頁"  onclick="javascript:location.href='/RewardPendingList'">
        <input type="button" name="reject" value="退件" onclick="rejectApply()">
        <input type="button" name="approve" value="審查完成" onclick="approveApply()">
    </div>
</div>
<script>
	function sendApply(){
	    if (confirm("確定要送出申請?")) {
	        $.ajax({
	            type: 'POST',
	            url: '/SendApply',
	            dataType: 'text',
	            data: "",
	            contentType: 'application/text',
	            success: function (data) {
	                alert('申請成功');
	                window.location.href = "/TraceProgress";
	            }
	        });
	    }
	};
	
	function approveApply(){
	    if (confirm("確定要確認審理?")) {
	        $.ajax({
	            type: 'POST',
	            url: '/ApproveApply',
	            dataType: 'text',
	            data: "",
	            contentType: 'application/text',
	            success: function (data) {
	                alert('確認審理成功');
	                window.location.href = "/RewardPendingList";
	            }
	        });
	    }
	};
	
	function rejectApply(){
	    if (confirm("確定要退件?"))
	        window.location.href="/ReasonForReturn";
	};
	
	$(document).ready(function () {
	    $(".review").hide();
	    $(".edit").hide();
	    if(${readonly}){
	        $(".review").show();
	    }
	    else{
	        $(".edit").show();
	    }
	})

</script>
</html>
