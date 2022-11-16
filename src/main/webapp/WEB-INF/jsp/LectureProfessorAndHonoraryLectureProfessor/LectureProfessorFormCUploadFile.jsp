<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE HTML>
<html lang="zh">
<script src="lib/jquery.min.js"></script>
<script src="lib/jquery.form.js"></script>
<link rel="stylesheet" type="text/css" href="css/FormStyle.css">
<link rel="stylesheet" type="text/css" href="css/PrintPageStyle.css">

<div class="content" style="width: 90%;">
    <p class="file_title">近五年內傑出績效說明表-附件上傳</p>
    <form method="post" id="c001_form">
        <table border="1" cellpadding="2" cellspacing="1" width="100%" align="center" style="border-spacing:0px;" class="inputForm">
            <thead>
                    <th colspan="1" width="15%">附件上傳類型</th>
                    <th colspan="1" width="15%">證明文件上傳</th>
                </thead>
            <tbody id="data_table" style="text-align: center;">
            </tbody>
            <tbody style="text-align: center;" class="no-print">
                <tr>
                    <td class="teacher" colspan="2" width="100%">
                        <input  type="button" name="add_new_contract" value="新增" onclick="add_new_item()">
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="background-color:rgb(255, 255, 240);" width="100%">
                        <input type="button" width="10%" value="回上頁" name="return_last_page" onclick="javascript:location.href='LectureProfessorCatalog'">
<%--                        <input type="button" width="10%" value="暫存" name="save_the_page" onclick="saveData()">--%>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
</div>

<div id="uploadJointDiv" style="text-align:center;position:fixed; left:0px; top:0px; width:100%;height:100%; background-color:rgba(10, 10, 10, 0.6);display:none;">
    <div style="width:600px; background-color:#fff; padding:20px; border-radius:10px;margin:10% auto;">
        <form method="post" action="LectureProfessorFormCUploadFile?func=save_certified_documents" enctype="multipart/form-data" id="uploadJointForm" name = "uploadJointForm">
            <p style="text-align:left;font-weight:bold;font-size:20px;">請上傳相關證明文件</p>
            <input name="upload_paper_id" style="display:none;">
            <input name="upload_doc_type" style="display:none;">
            <table border="1" width="100%" align="center" style="border-spacing:0px;text-align:center;margin-left:auto;margin-right:auto;" class="inputForm">
                <tbody>
                <tr>
                    <td class="filedname" style="text-align:center;">
                        <input type="file" name="certified_document" accept=".pdf"/>
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
<script src="js/Function.js"></script>
<script>
    var latest_data = ${latest_data} ;
    var read_only = ${readonly};


    function load(){
        if (read_only) {
            $(".teacher").remove();
            $("#main_table").prop("cellpadding", "2");
            $("#main_table_button").prop("colspan", "2");
        }

        showData() ;
    }

    $(document).ready( load() );

    function removeData(index){
        dataFromTable();
        if(confirm("您確定要刪除此筆資料嗎?")){
            latest_data["LectureProfessorUploadList"].splice(index,1);
            showData();
            calculateTotal();
        }
        showData();
    }

    function add_new_item(){
        dataFromTable();
        var item = {};
        item.doc_type = "";
        item.document_id="";
        latest_data["LectureProfessorUploadList"].push(item);
        showData();

    }


    function makeNewItemHtml( i ) {
        var lectureProfessorUploadList = latest_data["LectureProfessorUploadList"];
        console.log("lectureProfessorUploadList:",lectureProfessorUploadList)
        var html_of_item = "";
        html_of_item += "<tr>" ;
        html_of_item += "<td colspan='1' width='15%'><select id ='doc_type" + i + "' name='doc_type" +i+ "' >" ;
        html_of_item += "<option value='' selected disabled hidden>請選擇</option>";
        html_of_item += "<option value='type1_diploma'>一、	被推薦人選之學經歷</option>";
        html_of_item += "<option value='type2_complete_list_of_treatises'>二、	完整論著目錄、重要論著抽印本。</option>";
        html_of_item += "<option value='type3_proof_of_specific_academic_achievement'>三、	具體學術成就證明。</option>";
        html_of_item += "<option value='type4_proof_of_specific_technical_achievement'>四、	具體專業技術成果證明。</option>";
        html_of_item += "<option value='type5_other_relevant_supporting_documents'>五、	其他相關之證明文件及教學研究計畫。</option>";
        html_of_item += "<option value='type6_the_most_representative_research'>六、	最具代表性研究成果至多10篇</option>";
        html_of_item += "<option value='type7_important_contributions_of_mine'>七、	請簡述上述代表性研究成果內個人之重要貢獻。</option>";
        html_of_item += "</select>" ;
        html_of_item += "<input name='paper_id_"+i+"' style='display: none' readonly>" ;
        html_of_item += "</td>" ;
        if ( lectureProfessorUploadList[i].document_id != "" && lectureProfessorUploadList[i].document_id != null ) {

            let doc_uuid =  String(lectureProfessorUploadList[i].document_id) !== '' ? lectureProfessorUploadList[i].document_id:i;
            html_of_item += "<td colspan='1' style='text-align: center;'>" +
                "<button value='重新上傳' type='button' width='10%' name='enable_upload' onclick='operator1(";
            html_of_item += `\"`;
            html_of_item += doc_uuid ;
            html_of_item += `\",` ;
            html_of_item += i ;
            html_of_item += ")' ></button>";
            html_of_item += "<input value='檢視' type='button' width='10%' name='enable_upload' onclick='downloadCertifiedDoc(" ;
            html_of_item += `\"`;
            html_of_item += doc_uuid ;
            html_of_item += `\"` ;
            html_of_item += ")' >";
            html_of_item += "</td>" ;
        }
        else {
            let doc_uuid = String(lectureProfessorUploadList[i].document_id) !== undefined ? String(lectureProfessorUploadList[i].document_id):String(i);
            html_of_item += "<td colspan='1' style='text-align: center;'>" ;
            if (read_only) {
                html_of_item += "<a style='color: #EB1D1D'>未上傳檔案</a>" ;
            }

            html_of_item += "<input value='上傳' type='button' width='10%' name='enable_upload' onclick='operator1(" ;
            html_of_item += `\"`;
            html_of_item += doc_uuid ;
            html_of_item += `\",` ;
            html_of_item += i ;
            html_of_item += ")'></td>";
        }
        html_of_item += "</tr>" ;

        return html_of_item ;
    }

    function operator1(doc_uuid,index) {
        $("input[name='upload_paper_id']").val($("input[name='paper_id_" + index + "']").val());
        let selectBox = document.getElementById("doc_type"+index);
        let doc_type = selectBox.options[selectBox.selectedIndex].value;

        $("input[name='upload_doc_type']").val(doc_type);
        $("#uploadJointDiv").show();
    }
    function downloadCertifiedDoc(doc_uuid ) {
        console.log(doc_uuid);
        var path = "File?func=download_certified_documents&id=" + doc_uuid ;
        window.open(path);
    }
    function dataFromTable(){
        latest_data["LectureProfessorUploadList"] = [];
        var i=0;
        while($("select[name='doc_type"+i+"']").length>0){
            var item = {};
            item.doc_type = $("select[name='doc_type"+i+"']").val();
            item.document_id = $("input[name='paper_id_"+ i +"']").val() ;
            latest_data["LectureProfessorUploadList"].push(item);
            i++;
        }

    }

    function showData(){
        var html = "";
        var data_of_certified_documents = latest_data["LectureProfessorUploadList"];

        for(var i=0;i<data_of_certified_documents.length;i++){
            var h = "";
            h += makeNewItemHtml( i ) ;
            html+=h;
        }

        if(html=="")
            html = "<tr></tr>";
        $("#data_table").html(html);
        setReadOnly(read_only);
        for(var i=0;i<data_of_certified_documents.length;i++){
            $("select[name='doc_type"+i+"']").val(data_of_certified_documents[i].doc_type);
            $("input[name='paper_id_"+i+"']").val(data_of_certified_documents[i].document_id);

            console.log('index:',i)
            console.log('type',data_of_certified_documents[i].doc_type)
            console.log('docID',data_of_certified_documents[i].document_id)
        }

    }

    function InputFormToJson() {
        let inputNumber = 0;
        let dataNumber = 0;
        const inputList = latest_data["LectureProfessorUploadList"];
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

    function cancelShowNote(){
        $("#uploadJointDiv").hide();
    }

    $(function(){
        $('#uploadJointForm').ajaxForm({

            success: function(data1) {
                //返回資料處理
                alert( "成功");
                location.reload() ;

            },
            error: function (data2) {
                alert("錯誤") ;
                // location.reload() ;
            }

        });

    });
</script>
</html>
