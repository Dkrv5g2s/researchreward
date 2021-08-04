<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="com.google.gson.*" %>

<%@ page import="Bean.Project.RewardProject" %>
<%  /*避免瀏覽器因cache而無法看到最新資料*/
    response.setHeader("Pragma","no-cache");
    response.setHeader("Cache-Control","no-cache");
    response.setDateHeader("Expires", 0);
%>
<%
    Gson gson = new Gson();
%>
<!DOCTYPE HTML>
<html lang="zh">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<div class="container" >
    <p style="font-weight:bold;font-size:20px;">國立臺北科技大學獎勵特殊優秀研究人才獎勵金分配金額或原則表</p>
</div>

<div class="container" >
    <form method="post" id="c001_form">
        <table border="1" cellpadding="6" cellspacing="1" width="100%" align="center" style="border-spacing:0px;" class="inputForm">
            <thead>
                    <th colspan="1" width="16%">申請人/共同申請人</th>
                    <th colspan="1" width="16%">姓名</th>
                    <th colspan="1" width="16%">所屬學院與系所</th>
                    <th colspan="1" width="16%">職稱</th>
                    <th colspan="1" width="16%">到校年月</th>
                    <th colspan="1" width="20%">獎勵金分配金額或原則(限200字)</th>

                </thead>
            <tbody id="data_table" style="text-align: center;">
            </tbody>
            <tbody style="text-align: center;">
                <tr>
                    <td colspan="6" style="background-color:rgb(255, 255, 240);" width="100%"><input type="button" width="10%" value="回上頁" name="return_last_page" onclick="javascript:location.href='SpecialOutstandingResearcherCatalog'"  ></td>
                </tr>
            </tbody>

        </table>
    </form>
</div>
<script>
    var latest_data = ${latest_data} ;


    function load(){
        showDatas() ;

    }

    $(document).ready( load() );


    function add_new_item(){
        datasFromTable();
        var item = {};
        item.applicant_type = "";
        item.name = "";
        item.college_and_department = "";
        item.job = "";
        item.year = "";
        item.month = "";
        item.principle = "" ;
        latest_data["award_distribution_amount_or_principle_list"].push(item);
        showDatas();

    }


    function makeNewItemHtml( i ) {
        var html_of_item = "";
        html_of_item += "<tr>" ;

        html_of_item += "<td colspan='1' width='16%'><select name='applicant_type"+i+"' disabled>" +
                        "<option value='' selected disabled hidden>請選擇</option>" +
                        "<option value='績優教師'>績優教師</option>" +
                        "<option value='聘任單位主管'>聘任單位主管</option>" +
                        "<option value='研究人員'>研究人員</option>" +
                        "</select></td>" ;
        html_of_item += "<td colspan='1' width='16%'><input name='name"+i+"' size='10' maxlength='40' readonly></td>";
        html_of_item += "<td colspan='1' width='16%'><input name='college_and_department"+i+"' size='10' maxlength='40' readonly></td>" ;
        html_of_item += "<td colspan='1' width='16%'><input name='job"+i+"' size='10' maxlength='40' readonly></td>" ;
        html_of_item += "<td colspan='1' width='16%'><input name='year"+i+"' size='6' maxlength='40' readonly>年<br><input name='month"+i+"' size='6' maxlength='40' readonly>月</td>" ;
        html_of_item += "<td colspan='1' width='20%'><textarea style='resize:none;width:100%;height:75px;' name='principle"+i+"' maxlength='300' onkeyup='wordsTotal()' readonly></textarea></td>" ;
        html_of_item += "</tr>" ;

        return html_of_item ;
    }



    function datasFromTable(){
        latest_data["award_distribution_amount_or_principle_list"] = [];
        var i=0;
        while($("select[name='applicant_type"+i+"']").length>0){
            var item = {};
            item.applicant_type = $("select[name='applicant_type"+i+"']").val();
            item.name = $("input[name='name"+i+"']").val();
            item.college_and_department = $("input[name='college_and_department"+i+"']").val();
            item.job = $("input[name='job"+i+"']").val();
            item.year = $("input[name='year"+i+"']").val();
            item.month = $("input[name='month"+i+"']").val();
            item.principle = $("textarea[name='principle"+i+"']").val();

            latest_data["award_distribution_amount_or_principle_list"].push(item);
            i++;
        }

    }

    function showDatas(){
        var html = "";
        var award_distribution_amount_or_principle = latest_data["award_distribution_amount_or_principle_list"];

        for(var i=0;i<award_distribution_amount_or_principle.length;i++){
            var h = "";
            h += makeNewItemHtml( i ) ;
            html+=h;
        }

        if(html=="")
            html = "<tr></tr>";
        $("#data_table").html(html);

        for(var i=0;i<award_distribution_amount_or_principle.length;i++){
            $("select[name='applicant_type"+i+"']").val(award_distribution_amount_or_principle[i].applicant_type);
            $("input[name='name"+i+"']").val(award_distribution_amount_or_principle[i].name);
            $("input[name='college_and_department"+i+"']").val(award_distribution_amount_or_principle[i].college_and_department);
            $("input[name='job"+i+"']").val(award_distribution_amount_or_principle[i].job);
            $("input[name='year"+i+"']").val(award_distribution_amount_or_principle[i].year);
            $("input[name='month"+i+"']").val(award_distribution_amount_or_principle[i].month);
            $("textarea[name='principle"+i+"']").val(award_distribution_amount_or_principle[i].principle);

        }
    }

    function checkDatas() {
        return true ;
    }

    function InputFormToJson() {
        latest_data["project_id"] = ${projectId}  ;

        return JSON.stringify(latest_data) ;
    }

    function saveDatas(){
        if(checkDatas()){
            datasFromTable();

            $.ajax({
                type: 'POST',
                url: 'AwardDistributionAmountOrPrincipleForm',
                dataType: 'text',
                data: { "data": InputFormToJson(), "func":"save" },   //JSON.stringify(InputToJson())
                //contentType: 'application/text',
                success: function(data){
                    alert('success');
                },
                error:function(data){
                    alert("error")
                }
            });

        }
        else{
            alert("有資料格式錯誤或未填寫");
        }
    }
</script>
</html>
