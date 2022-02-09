<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE HTML>
<html lang="zh">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://malsup.github.io/jquery.form.js"></script>
<link rel="stylesheet" type="text/css" href="css/FormStyle.css">
<link rel="stylesheet" type="text/css" href="css/PrintPageStyle.css">

<div class="content" style="width: 90%;">
    <p class="file_title">其他附件上傳</p>
    <form method="post">
        <table border="1" cellpadding="3" cellspacing="1" width="100%" align="center" style="border-spacing:0px;" class="inputForm">
            <thead>
                <th colspan="1" width="15%">附件描述</th>
                <th colspan="1" width="15%">附件上傳</th>
            </thead>
            <tbody id="data_table" style="text-align: center;">
            </tbody>
            <tbody style="text-align: center;" class="no-print">
                <tr>
                    <td colspan="3" width="100%">
                        <input type="button" name="add_new_contract" value="新增" onclick="add_new_item()">
                    </td>
                </tr>
                <tr>
                    <td colspan="3" style="background-color:rgb(255, 255, 240);" width="100%">
                        <input type="button" width="10%" value="回上頁" name="return_last_page" onclick="javascript:history.back()">
                        <input type="button" id="save" name="save" value="暫存" onclick="commit()"/>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
</div>

<div id="uploadJointDiv" style="text-align:center;position:fixed; left:0px; top:0px; width:100%;height:100%; background-color:rgba(10, 10, 10, 0.6);display:none;">
    <div style="width:600px; background-color:#fff; padding:20px; border-radius:10px;margin:10% auto;">
        <form method="post" action="OtherFileUpload?func=save_other_files" enctype="multipart/form-data" id="uploadJointForm" name = "uploadJointForm">
            <p style="text-align:left;font-weight:bold;font-size:20px;">請上傳相關證明文件</p>
            <input name="upload_paper_id" style="display:none;">
            <input name="upload_doc_description" style="display:none;">
            <table border="1" width="100%" align="center" style="border-spacing:0px;text-align:center;margin-left:auto;margin-right:auto;" class="inputForm">
                <tbody>
                <tr>
                    <td class="filedname" style="text-align:center;">
                        <input type="file" name="other_file" accept=".pdf"/>
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
    var latest_data = ${latest_data} ;


    function load(){
        latest_data["DeletedOtherFileList"] = [];
        showData();
    }

    $(document).ready(load());

    function removeData(index){
        dataFromTable();
        if(confirm("您確定要刪除此筆資料嗎?")){
            latest_data["DeletedOtherFileList"].push(latest_data["OtherFileList"][index]);
            latest_data["OtherFileList"].splice(index,1);
        }
        showData();
    }

    function add_new_item(){
        dataFromTable();
        var item = {};
        item.description = "";
        item.documentId = "";
        latest_data["OtherFileList"].push(item);
        showData();

    }


    function makeNewItemHtml( i ) {
        var otherFileList = latest_data["OtherFileList"];
        var html_of_item = "";
        html_of_item += "<tr>" ;
        html_of_item += "<td colspan='1' width='45%'>";
        html_of_item += "<input id ='doc_description" + i + "' name='doc_description" + i + "' size='40' maxlength='100' >" ;
        html_of_item += "<input name='paper_id_" + i + "' style='display: none' readonly>" ;
        html_of_item += "<input name='doc_file_path_" + i + "' style='display: none' readonly>" ;
        html_of_item += "</td>" ;
        if (otherFileList[i].documentId && otherFileList[i].documentId !== "" && otherFileList[i].docFilePath && otherFileList[i].docFilePath !== "") {
            let doc_uuid =  String(otherFileList[i].documentId) !== '' ? otherFileList[i].documentId : i;
            html_of_item += "<td colspan='1' style='text-align: center;' width='35%'><input value='重新上傳' type='button' width='10%' name='enable_upload' onclick='operator1(";
            html_of_item += `\"`;
            html_of_item += doc_uuid ;
            html_of_item += `\",` ;
            html_of_item += i ;
            html_of_item += ")' >";
            html_of_item += "<input value='檢視' type='button' width='10%' name='enable_upload' onclick='downloadCertifiedDoc(" ;
            html_of_item += `\"`;
            html_of_item += doc_uuid ;
            html_of_item += `\"` ;
            html_of_item += ")' >";
            html_of_item += "</td>" ;
        }
        else {
            let doc_uuid = String(otherFileList[i].documentId);
            html_of_item += "<td colspan='1' style='text-align: center;' width='35%'><input value='上傳' type='button' width='10%' name='enable_upload' onclick='operator1(";
            html_of_item += `\"`;
            html_of_item += doc_uuid ;
            html_of_item += `\",` ;
            html_of_item += i ;
            html_of_item += ")'></td>";
        }
        html_of_item += "<td colspan='1' width='20%' class='no-print'><input type='button' name='delete_contract"+i+"' value='刪除' onclick='removeData("+i+" )'></td>" ;
        html_of_item += "</tr>" ;

        return html_of_item ;
    }

    function operator1(doc_uuid,index) {
        $("input[name='upload_paper_id']").val($("input[name='paper_id_" + index + "']").val());
        $("input[name='upload_doc_description']").val($("input[name='doc_description" + index + "']").val());
        $("#uploadJointDiv").show();
    }
    function downloadCertifiedDoc(doc_uuid) {
        var path = "File?func=download_other_files&id=" + doc_uuid ;
        window.open(path);
    }
    function dataFromTable(){
        latest_data["OtherFileList"] = [];
        var i=0;
        while($("input[name='doc_description" + i + "']").length>0){
            var item = {};
            item.description = $("input[name='doc_description" + i + "']").val();
            item.documentId = $("input[name='paper_id_"+ i +"']").val();
            item.docFilePath = $("input[name='doc_file_path_"+ i +"']").val();
            latest_data["OtherFileList"].push(item);
            i++;
        }

    }

    function showData(){
        var html = "";
        var data_of_other_files = latest_data["OtherFileList"];

        for(var i=0; i<data_of_other_files.length; i++){
            var h = "";
            h += makeNewItemHtml( i );
            html+=h;
        }

        if(html=="")
            html = "<tr></tr>";
        $("#data_table").html(html);

        for(var i=0; i<data_of_other_files.length; i++){
            $("input[name='doc_description"+i+"']").val(data_of_other_files[i].description);
            $("input[name='paper_id_"+i+"']").val(data_of_other_files[i].documentId);
            $("input[name='doc_file_path_"+i+"']").val(data_of_other_files[i].docFilePath);
        }

    }

    function InputFormToJson() {
        dataFromTable();
        console.log(JSON.stringify(latest_data));
        return JSON.stringify(latest_data);
    }

    function cancelShowNote(){
        $("#uploadJointDiv").hide();
    }

    $(function(){
        $('#uploadJointForm').ajaxForm({

            success: function(data1) {
                //返回資料處理
                new Promise((resolve, reject) => {
                    resolve(commit());
                }).then(result=>{
                    location.reload() ;
                });
            },
            error: function (data2) {
                alert("錯誤") ;
                // location.reload() ;
            }

        });

    });

    function commit(){
        let result = $.Deferred();
        $.ajax({
            type: 'POST',
            url: 'OtherFileUpload',
            dataType: 'text',
            data: InputFormToJson(),
            contentType: 'application/json',
            success: function(data){
                alert('存檔成功');
                result.resolve(true);
            }
        });
        return result;
    }
</script>
</html>
