<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="com.google.gson.*" %>

<%  /*避免瀏覽器因cache而無法看到最新資料*/
    response.setHeader("Pragma","no-cache");
    response.setHeader("Cache-Control","no-cache");
    response.setDateHeader("Expires", 0);
%>
<%
    Object latest_data = request.getAttribute( "latest_data" );
%>
<!DOCTYPE HTML>
<html lang="zh">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
<link rel="stylesheet" type="text/css" href="/css/FormStyle.css">
<div class="container">
    <p style="font-weight:bold;font-size:20px;text-align: center;">國立臺北科技大學傑出論文績效說明表(表B)</p>
</div>
<div class="container" style="margin: 0px auto;width: 80%;">
    <form id="c001_form">
        <table border="1" cellpadding="6" cellspacing="1" align="center" class="inputForm">
            <thead style="text-align: center;">
            <%--            <tr>--%>
            <%--                <td colspan="4" width="50%">申請人姓名(中/英文):<input name="applicant_name" size="20" maxlength="40"></td>--%>
            <%--                <td colspan="3" width="40%">系所/職稱:<input name="dep_job" size="20" maxlength="40"></td>--%>
            <%--                <td colspan="1" width="10%"></td>--%>
            <%--            </tr>--%>
            <tr>
                <td colspan="2" width="40%">Journal Papers<br>
                    請依序填寫：姓名、著作名稱、期刊名稱、卷數、頁數、發表年份(SCI/SSCI,Impact Factor;Scopus CiteScore Rank,領域別) 並以＊註記該篇所有之通訊作者，檢附每篇論文首頁與以Scopus資料庫為主之證明文件。範例:AAA*, BBB, CCC, “Synergistic oooooooooocomposites,“Optics Express,Vol.127(2), pp1047-1053, May,2018. (SCI, Impact Factor =7.3;CiteScore Rank: 5/88=5.7%,Optics )
                </td>
                <td colspan="1" width="30%">共同著作授權同意書</td>
                <td colspan="1" width="30%">該篇論文首頁</td>
            </tr>
            </thead>
            <tbody id="data_table" style="text-align: center;">

            </tbody>
            <tbody >
            <tr>
                <td colspan="4" style="background-color:rgb(255, 255, 240);text-align: center">
                    <input type="button" width="10%" value="回目錄" name="return_last_page" onclick="goBack()">
                    <button type="button" name="return_last_page" onclick="location.href='ReasonForReturn'">退件</button>
                    <button type="button" name="confirm" onclick="commit()">審查完成</button>
                </td>
            </tr>
            </tbody>

        </table>
    </form>

</div>

<div id="uploadHomeDiv" style="text-align:center;position:fixed; left:0px; top:0px; width:100%;height:100%; background-color:rgba(10, 10, 10, 0.6);display:none;">
    <div style="width:600px; background-color:#fff; padding:20px; border-radius:10px;margin:10% auto;">
        <form method="post" action="PaperPerformanceDescriptionUpload?func=paper_home" enctype="multipart/form-data" id="uploadHomeForm">
            <p style="text-align:left;font-weight:bold;font-size:20px;">請上傳「該篇論文首頁」</p>
            <input name="upload_paper_id" style="display:none;">
            <input name="upload_book_name" style="display:none;">
            <input name="upload_scholarly_journals_name" style="display:none;" >
            <input name="upload_publish_time" style="display:none;">
            <table border="1" width="100%" align="center" style="border-spacing:0px;text-align:center;margin-left:auto;margin-right:auto;" class="inputForm">
                <tbody>
                <tr>

                    <td class="filedname" style="text-align:center;">
                        <input type="file" name="paper_home" accept=".pdf"/>
                    </td>
                </tr>
                </tbody>
            </table><br>
            <p>
                <button type="submit" style="width:80px;">送出</button>
                <button type="button" onclick="cancelShowNote()" style="width:80px;">取消</button>
            </p>
        </form>
    </div>
</div>

<div id="uploadJointDiv" style="text-align:center;position:fixed; left:0px; top:0px; width:100%;height:100%; background-color:rgba(10, 10, 10, 0.6);display:none;">
    <div style="width:600px; background-color:#fff; padding:20px; border-radius:10px;margin:10% auto;">
        <form method="post" action="PaperPerformanceDescriptionUpload?func=joint_authorization_agreement" enctype="multipart/form-data" id="uploadJointForm">
            <p style="text-align:left;font-weight:bold;font-size:20px;">請上傳「共同著作授權同意書」</p>
            <input name="upload_paper_id" style="display:none;">
            <input name="upload_book_name" style="display:none;">
            <input name="upload_scholarly_journals_name" style="display:none;" >
            <input name="upload_publish_time" style="display:none;">
            <table border="1" width="100%" align="center" style="border-spacing:0px;text-align:center;margin-left:auto;margin-right:auto;" class="inputForm">
                <tbody>
                <tr>
                    <td class="filedname" style="text-align:center;">
                        <input type="file" name="joint_authorization_agreement" accept=".pdf"/>
                    </td>
                </tr>
                </tbody>
            </table><br>
            <p>
                <button type="submit" style="width:80px;">送出</button>
                <button type="button" onclick="cancelShowNote()" style="width:80px;">取消</button>
            </p>
        </form>
    </div>
</div>

<script>
    //var latest_data = ${latest_data} ;
    latest_data
    var latest_data = <%=latest_data%> ;

    function goBack() {
        switch ("${reward_type}") {
            case "特聘教授":
                location.href="DistinguishedProfessorCatalog";
                break;
            case "傑出研究獎":
                window.history.back();
                break;
            case "講座教授/榮譽講座教授":
                window.history.back();
                break;
            case "年輕學者獎":
                location.href="JuniorResearchInvestigatorCatalog";
                break;
            case "陽光獎助金論文獎勵":
                location.href="SunshineScholarshipCatalog";
                break;
            case "優秀人才申請":
            case "獎勵特殊優秀研究人才":
                location.href="SpecialOutstandingResearcherCatalog";
                break;
            case "績優教師聘任研究人員":
                location.href="TeacherHireResearcherCatalog";
                break;
        }
    }

    function commit(){
        let send = confirm('送出後無法取消，確定要送出嗎?');
        if (!send) {
            return;
        }
        $.ajax({
            type: 'POST',
            url: 'SendApply',
            dataType: 'text',
            data: "",
            contentType: 'application/text',
            success: function(){
                alert("送出完成");
                window.location.href="RewardPendingList";
            },
            error:function() {
                alert("送出失敗");
            }
        });
    }

    function downloadFile1( index ) {
        var path = "File?func=joint_authorization_agreement&id=" + $("input[name='paper_id"+index+"']").val() ;
        window.open(path);
    }

    function downloadFile2( index ) {
        var path = "File?func=paper_home&id=" + $("input[name='paper_id"+index+"']").val() ;
        window.open(path);
    }

    function load(){
        showDatas() ;
    }

    $(document).ready( load() );

    function makeNewItemHtml( i ) {
        var paper_performence = latest_data["paper_performance_list"];

        var html_of_item = "";
        html_of_item += "<tr>" ;

        html_of_item += "<td colspan='2' style='text-align: left;'>姓名:<input name='author_name" + i + "' size='10' maxlength='40' readonly><br>" ;
        html_of_item += "著作名稱:<input name='book_name" + i + "' size='10' maxlength='40' readonly><br>" ;
        html_of_item += "期刊名稱:<input name='scholarly_journals_name" + i +"' size='10' maxlength='40' readonly><br>" ;
        html_of_item += "卷數:<input name='total_roll" + i + "' size='5' maxlength='5' readonly><br>" ;
        html_of_item += "頁數:<input name='total_page" + i + "' size='5' maxlength='5' readonly><br>" ;
        html_of_item += "發表年份:<input name='publish_time" + i + "' size='15' maxlength='40' readonly>" ;
        html_of_item += "<input name='paper_id" + i + "' style='display: none' readonly>" ;
        html_of_item += "</td>" ;

        if ( paper_performence[i]["joint_authorization_agreement_file_path"] != "" && paper_performence[i]["joint_authorization_agreement_file_path"] != null ) {
            html_of_item += "<td colspan='1' style='text-align: center;'><input value='檢視' type='button' width='10%' name='enable_upload' onclick='downloadFile1("+i+")' >" ;
            html_of_item += "</td>" ;
        }
        else {
            html_of_item += "<td colspan='1' style='text-align: center;'><a style='color: #EB1D1D'>查無檔案</a>" ;
            html_of_item += "</td>" ;
        }

        if ( paper_performence[i]["paper_home_file_path"] != "" && paper_performence[i]["paper_home_file_path"] != null ) {
            html_of_item += "<td colspan='1' style='text-align: center;'><input value='檢視' type='button' width='10%' name='enable_upload' onclick='downloadFile2("+i+")' >" ;
            html_of_item += "</td>" ;
        }
        else {
            html_of_item += "<td colspan='1' style='text-align: center;'><a style='color: #EB1D1D'>查無檔案</a>" ;
            html_of_item += "</td>" ;
        }

        html_of_item += "</tr>" ;


        return html_of_item ;
    }

    function datasFromTable(){
        latest_data["paper_performance_list"] = [];
        var i=0;
        while($("input[name='author_name"+i+"']").length>0){
            var item = {};
            item.author_name = $("input[name='author_name"+i+"']").val();
            item.book_name = $("input[name='book_name"+i+"']").val();
            item.scholarly_journals_name = $("input[name='scholarly_journals_name"+i+"']").val();
            item.total_roll = $("input[name='total_roll"+i+"']").val();
            item.total_page = $("input[name='total_page"+i+"']").val();
            item.publish_time = $("input[name='publish_time"+i+"']").val();

            latest_data["paper_performance_list"].push(item);
            i++;
        }

        latest_data["fwci_value_past_five_year"] = $('input[name="fwci_value_past_five_year"]').val() ;
        latest_data["fwci_value_past_five_year"] = $('label[id="total_point"]').text() ;

    }

    function showDatas(){
        var html = "";
        var paper_performence = latest_data["paper_performance_list"];

        for(var i=0;i<paper_performence.length;i++){
            var h = "";
            h += makeNewItemHtml( i ) ;
            html+=h;
        }
        if(html=="")
            html = "<tr></tr>";
        $("#data_table").html(html);

        for(var i=0;i<paper_performence.length;i++){

            $("input[name='author_name"+i+"']").val(paper_performence[i].author_name);
            $("input[name='book_name"+i+"']").val(paper_performence[i].book_name);
            $("input[name='scholarly_journals_name"+i+"']").val(paper_performence[i].scholarly_journals_name);

            $("input[name='total_roll"+i+"']").val(paper_performence[i].total_roll);
            $("input[name='total_page"+i+"']").val(paper_performence[i].total_page);
            $("input[name='publish_time"+i+"']").val(paper_performence[i].publish_time);

            $("input[name='paper_id"+i+"']").val(paper_performence[i].paper_id);
        }

    }




</script>
</html>
