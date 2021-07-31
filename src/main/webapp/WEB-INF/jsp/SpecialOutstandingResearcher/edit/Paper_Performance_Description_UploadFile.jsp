<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="com.google.gson.*" %>

<%@ page import="Bean.Project.RewardProject" %>
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
<script src="https://malsup.github.io/jquery.form.js"></script>
<link rel="stylesheet" type="text/css" href="/css/FormStyle.css">
<div class="container">
    <p class="table_b" style="font-weight:bold;font-size:20px;text-align: center;">國立臺北科技大學傑出論文績效說明表</p>
    <p class="table_c" style="font-weight:bold;font-size:20px;text-align: center;">研究績優教師執行第<input id="numOfPerformancePeriod" name="numOfPerformancePeriod" size="1" maxlength="4" style="font-weight:bold; font-size:20px; text-align:center; border:none; outline:none;" tabindex="-1" readonly>期績效說明表(申請第二期以上者填寫)</p>
    <p style="text-align:center;">※ 上傳檔案前，請先填寫績效說明表，填寫完成並存檔後此頁面會自動帶入您所填寫的資訊</p>
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
                    <input type="button" width="10%" value="回上頁" name="return_last_page" onclick="location.href='${catalogURL}'" >
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
    let tableCJson = ${tableCJson};
    let IsTableC = tableCJson.isTableC;


    function downloadFile1( index ) {
        var path = "File?func=joint_authorization_agreement&id=" + $("input[name='paper_id"+index+"']").val() ;
        window.open(path);
    }

    function downloadFile2( index ) {
        var path = "File?func=paper_home&id=" + $("input[name='paper_id"+index+"']").val() ;
        window.open(path);
    }

    function load(){
        showDatas();
        showSection();
    }

    function showSection(){
        $(".table_b").hide();
        $(".table_c").hide();

        if(IsTableC)
            $(".table_c").show();
        else
            $(".table_b").show();
    }

    $(document).ready( load() );

    function makeNewItemHtml( i ) {
        var paper_performence = latest_data["paper_performance_list"];

        var html_of_item = "";
        html_of_item += "<tr>" ;

        html_of_item += "<td colspan='2' style='text-align: left;'>姓名:<input name='author_name" + i + "' size='10' maxlength='40' readonly><br>" ;
        html_of_item += "著作名稱:<input name='book_name" + i + "' size='10' maxlength='150' readonly><br>" ;
        html_of_item += "期刊名稱:<input name='scholarly_journals_name" + i +"' size='10' maxlength='150' readonly><br>" ;
        html_of_item += "卷數:<input name='total_roll" + i + "' size='5' maxlength='5' readonly><br>" ;
        html_of_item += "頁數:<input name='total_page" + i + "' size='5' maxlength='5' readonly><br>" ;
        html_of_item += "發表年份:<input name='publish_time" + i + "' size='15' maxlength='4' readonly>" ;
        html_of_item += "<input name='paper_id" + i + "' style='display: none'  readonly>" ;
        html_of_item += "</td>" ;

        if ( paper_performence[i]["joint_authorization_agreement_file_path"] != "" && paper_performence[i]["joint_authorization_agreement_file_path"] != null ) {
            html_of_item += "<td colspan='1' style='text-align: center;'><input value='重新上傳' type='button' width='10%' name='enable_upload' onclick='operator1("+i+")' ><input value='檢視' type='button' width='10%' name='enable_upload' onclick='downloadFile1("+i+")' >" ;
            html_of_item += "</td>" ;
        }
        else {
            html_of_item += "<td colspan='1' style='text-align: center;'><input value='上傳' type='button' width='10%' name='enable_upload' onclick='operator1("+i+")' >" ;
            html_of_item += "</td>" ;
        }

        if ( paper_performence[i]["paper_home_file_path"] != "" && paper_performence[i]["paper_home_file_path"] != null ) {
            html_of_item += "<td colspan='1' style='text-align: center;'><input value='重新上傳' type='button' width='10%' name='enable_upload' onclick='operator2("+i+")' ><input value='檢視' type='button' width='10%' name='enable_upload' onclick='downloadFile2("+i+")' >" ;
            html_of_item += "</td>" ;
        }
        else {
            html_of_item += "<td colspan='1' style='text-align: center;'><input value='上傳' type='button' width='10%' name='enable_upload' onclick='operator2("+i+" )' >" ;
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

        if(IsTableC)
            $("input[id='numOfPerformancePeriod']").val(tableCJson.numOfPerformancePeriod);

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


    function checkDatas() {
        return true ;
    }


    function operator1(index) {
        $("input[name='upload_paper_id']").val($("input[name='paper_id" + index + "']").val());
        $("input[name='upload_book_name']").val($("input[name='book_name" + index + "']").val());
        $("input[name='upload_scholarly_journals_name']").val($("input[name='scholarly_journals_name" + index + "']").val());
        $("input[name='upload_publish_time']").val($("input[name='publish_time" + index + "']").val());

        $("#uploadJointDiv").show();

    }

    function operator2(index) {
        $("input[name='upload_paper_id']").val($("input[name='paper_id" + index + "']").val());
        $("input[name='upload_book_name']").val($("input[name='book_name" + index + "']").val());
        $("input[name='upload_scholarly_journals_name']").val($("input[name='scholarly_journals_name" + index + "']").val());
        $("input[name='upload_publish_time']").val($("input[name='publish_time" + index + "']").val());

        $("#uploadHomeDiv").show();

    }

    function cancelShowNote(){
        $("#uploadJointDiv").hide();
        $("#uploadHomeDiv").hide();
    }

    $(function(){
        $('#uploadHomeForm').ajaxForm({

            success: function(data1) {
                //返回資料處理
                alert( "成功");
                location.reload() ;
            },
            error: function (data2) {
                alert("錯誤") ;
                location.reload() ;
            }

        });

        $('#uploadJointForm').ajaxForm({

            success: function(data1) {
                //返回資料處理
                alert( "成功");
                location.reload() ;

            },
            error: function (data2) {
                alert("錯誤") ;
                location.reload() ;
            }

        });

    });

</script>
</html>
