<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2021/1/20
  Time: 下午 02:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>選獎項</title>
    <link rel="stylesheet" type="text/css" href="/css/FormStyle.css">


</head>
<body>
    <div class="content" style="width: 60%">
        <form>
            <p style="text-align:left;font-weight:bold;font-size:20px;">新增計畫： </p>
            <table>
                <tr>
                    <td class="metadata">選擇申請獎項</td>
                    <td>
                        <select>
                            <option>測試</option>
                            <option>績優教師聘任研究人員</option>
                            <option>講座教授/榮譽講座教授</option>
                            <option>特聘教授</option>
                            <option>傑出研究獎</option>
                            <option>年輕學者獎</option>
                            <option>獎勵特殊優秀研究人才</option>
                            <option>獎勵新聘特殊優秀研究人才</option>
                            <option>陽光獎助金論文獎勵</option>
                        </select>
                    </td>
                </tr>
                <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)"><button type="button" onclick="commit()">新增獎項</button></td></tr>
            </table>
        </form>
    </div>

</body>
</html>
