<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE HTML>
<html lang="zh">
<script src="js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/FormStyle.css">
<link rel="stylesheet" type="text/css" href="css/PrintPageStyle.css">

<div class="content" style="width: 90%;">
    <p class="file_title">國立臺北科技大學獎勵特殊優秀研究人才獎勵金分配金額或原則表</p>
    <form method="post" id="c001_form">
        <table border="1" cellpadding="6" cellspacing="1" width="100%" align="center" style="border-spacing:0px;" class="inputForm">
            <thead>
                    <th colspan="1" width="15%">申請人/共同申請人</th>
                    <th colspan="1" width="15%">姓名</th>
                    <th colspan="1" width="15%">所屬學院與系所</th>
                    <th colspan="1" width="15%">職稱</th>
                    <th colspan="1" width="15%">到校年月</th>
                    <th colspan="1" width="15%">獎勵金分配金額或原則(限200字)</th>
                    <th colspan="1" width="10%"class="no-print"></th>
                </thead>
            <tbody id="data_table" style="text-align: center;">
            </tbody>
            <tbody style="text-align: center;" class="no-print">
                <tr>
                    <td colspan="7" width="100%">
                        <input type="button" name="add_new_contract" value="新增" onclick="add_new_item()">
                    </td>
                </tr>
                <tr>
                    <td colspan="7" style="background-color:rgb(255, 255, 240);" width="100%">
                        <input type="button" width="10%" value="回上頁" name="return_last_page" onclick="javascript:location.href='SpecialOutstandingResearcherCatalog'">
                        <input type="button" width="10%" value="暫存" name="save_the_page" onclick="saveData()">
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

    function removeData(index){
        dataFromTable();
        if(confirm("您確定要刪除此筆資料嗎?")){
            latest_data["award_distribution_amount_or_principle_list"].splice(index,1);
            showData();
            calculateTotal();
        }
        showData();
    }

    function add_new_item(){
        dataFromTable();
        var item = {};
        item.applicant_type = "";
        item.name = "";
        item.college_and_department = "";
        item.job = "";
        item.year = "";
        item.month = "";
        item.principle = "" ;
        latest_data["award_distribution_amount_or_principle_list"].push(item);
        showData();

    }


    function makeNewItemHtml( i ) {
        var html_of_item = "";
        html_of_item += "<tr>" ;

        html_of_item += "<td colspan='1' width='15%'><select name='applicant_type"+i+"' >" +
                        "<option value='' selected disabled hidden>請選擇</option>" +
                        "<option value='績優教師'>績優教師</option>" +
                        "<option value='聘任單位主管'>聘任單位主管</option>" +
                        "<option value='研究人員'>研究人員</option>" +
                        "</select></td>" ;
        html_of_item += "<td colspan='1' width='15%'><input name='name"+i+"' size='10' maxlength='40'></td>";
        html_of_item += "<td colspan='1' width='15%'><input name='college_and_department"+i+"' size='10' maxlength='40' ></td>" ;
        html_of_item += "<td colspan='1' width='15%'><input name='job"+i+"' size='10' maxlength='40'></td>" ;
        html_of_item += "<td colspan='1' width='15%'><input name='year"+i+"' size='6' maxlength='40' style='width: 2rem;' >年<br><input name='month"+i+"' size='6' maxlength='40' style='width: 1rem;' >月</td>" ;
        html_of_item += "<td colspan='1' width='15%'><textarea style='resize:none;width:100%;height:75px;' name='principle"+i+"' maxlength='300' onkeyup='wordsTotal()' ></textarea></td>" ;
        html_of_item += "<td colspan='1' width='10%' class='no-print'><input type='button' name='delete_contract"+i+"' value='刪除' onclick='removeData("+i+" )'></td>" ;
        html_of_item += "</tr>" ;

        return html_of_item ;
    }



    function dataFromTable(){
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

    function InputFormToJson() {
        let inputNumber = 0;
        let dataNumber = 0;
        const inputList = latest_data["award_distribution_amount_or_principle_list"];
        for(let i=0; i<inputList.length; i++){
            let inputJson = inputList[i];
            let inputJsonKeys = Object.keys(inputJson);
            for(let j=0; j<inputJsonKeys.length; j++){
                let key = inputJsonKeys[j];
                inputNumber++;
                if(inputJson[key] && inputJson[key].length>0){
                    dataNumber++;
                }
            }
        }
        latest_data["fill_rate"] = dataNumber/inputNumber;
        latest_data["project_id"] = ${projectId}  ;

        return JSON.stringify(latest_data) ;
    }

    function saveData(){
        dataFromTable();

        $.ajax({
            type: 'POST',
            url: 'AwardDistributionAmountOrPrincipleForm',
            dataType: 'text',
            data: { "data": InputFormToJson()},
            //contentType: 'application/text',
            success: function(data){
                alert('success');
                location.reload();
            },
            error:function(data){
                alert("error")
            }
        });
    }
</script>
</html>
