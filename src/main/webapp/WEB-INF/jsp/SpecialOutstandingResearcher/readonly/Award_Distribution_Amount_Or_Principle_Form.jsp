<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML>
<html lang="zh">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/FormStyle.css">
<link rel="stylesheet" type="text/css" href="/css/PrintPageStyle.css">

<div class="content" style="width: 90%;">
    <p class="file_title">國立臺北科技大學獎勵特殊優秀研究人才獎勵金分配金額或原則表</p>
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
            <tbody style="text-align: center;" class="no-print">
                <tr>
                    <td colspan="6" style="background-color:rgb(255, 255, 240);" width="100%">
                        <input type="button" width="10%" value="回目錄" name="go_to_catalog" onclick="location.href='SpecialOutstandingResearcherCatalog'">
                        <button type="button" name="return_last_page" onclick="rejectApply()">退件</button>
                        <button type="button" name="confirm" onclick="approveApply()">審查完成</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
</div>
<script>
    var latest_data = ${latest_data} ;

    function load(){
        showData() ;

    }

    $(document).ready( load() );

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
        html_of_item += "<td colspan='1' width='16%'><input name='year"+i+"' size='6' maxlength='40' style='width: 2rem;' readonly>年<br><input name='month"+i+"' size='6' maxlength='40' style='width: 1rem;' readonly>月</td>" ;
        html_of_item += "<td colspan='1' width='20%'><textarea style='resize:none;width:100%;height:75px;' name='principle"+i+"' maxlength='300' onkeyup='wordsTotal()' readonly></textarea></td>" ;
        html_of_item += "</tr>" ;

        return html_of_item ;
    }


    function showData(){
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
                    window.location.href = "/ApprovedRewardList";
                    window.open('SpecialOutstandingResearcherPrint', 'TheWindow');
                }
            });
        }
    }

    function rejectApply(){
        if (confirm("確定要退件?"))
            window.location.href="/ReasonForReturn";
    }
</script>
</html>
