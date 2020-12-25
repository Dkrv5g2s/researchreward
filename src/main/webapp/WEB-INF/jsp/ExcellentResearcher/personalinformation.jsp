<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/11/29
  Time: 下午 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>個人基本資料</title>
    <link rel="stylesheet" type="text/css" href="/RRS/css/FormStyle.css">
    <script>
        function commit(){
            $.ajax({
                type: 'POST',
                url: '/PersonalInformation',
                dataType: 'json',
                data: JSON.stringify(InputToJson()),
                contentType: 'application/json',
                success: function(data){
                    alert('success');
                }
            });

        };

        function InputToJson(){
            var data = {};


            for (var j=0; j<document.getElementsByTagName("input").length; j++) {
                if (document.getElementsByTagName("input")[j].type=='checkbox' && document.getElementsByTagName("input")[j].checked == false){
                    continue;
                }else {
                    data[ document.getElementsByTagName("input")[j].name] = document.getElementsByTagName("input")[j].value;
                }

            }



            return data;
        }
    </script>
</head>
<body>
    <div class="content">
        <form>
            <table>
                <tbody>
                    <tr>
                        <td class="metadata">單位</td>
                        <td>
                            <input type="text" name="college" required>學院
                            <input type="text" name="department" required>系(所)
                        </td>
                    </tr>
                    <tr>
                        <td class="metadata">起聘年月</td>
                        <td>
                            <input type="number" name="hiredYear" required>年
                            <input type="number" name="hiredMonth" required>月
                        </td>
                    </tr>
                    <tr>
                        <td class="metadata">任職本校年資</td>
                        <td>
                            <input type="number" name="year" required>年
                            <input type="number" name="month" required>個月
                        </td>
                    </tr>
                    <tr>
                        <td class="metadata">中文姓名</td>
                        <td><input type="text" name="cname" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">英文姓名</td>
                        <td><input type="text" name="ename" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">職稱</td>
                        <td><input type="text" name="title" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">國籍</td>
                        <td><input type="text" name="country" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">性別</td>
                        <td><input type="text" name="gender" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">最高學歷</td>
                        <td>
                            學校名稱:<input type="text" name="schoolName" required>
                            主修學門系所:<input type="text" name="major" required>
                            學位:<input type="text" name="degree" required><br>
                            畢業年月:<input type="number" name="graduateYear" required>年
                            <input type="number" name="graduateMonth" required>月
                        </td>
                    </tr>
                    <tr>
                        <td class="metadata">重要經歷</td>
                        <td>
                            服務機構:<input type="text" name="ServiceOrganization" required>
                            服務部門:<input type="text" name="ServiceDepartment" required>
                            職稱:<input type="text" name="pastTitle" required><br>
                            起迄年月:<input type="number" name="pastYear" required>年
                            <input type="number" name="pastMonth" required>月
                        </td>
                    </tr>
                    <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)">申請獎勵等級及符合資格</td></tr>
                    <tr>
                        <td class="metadata">一年內曾執行科技部計畫</td>
                        <td>計畫名稱:<input type="text" name="planName" required>
                        計畫編號:<input type="text" name="planNumber" required>
                        執行期間:<input type="date" name="startTime" required>至<input type="date" name="lastTime" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">獎助資格(請檢附證明文件)</td>
                        <td>
                            <input type="checkbox" name="qualification1" value="true">非曾任或非現任國內學術研究機構編制內之專任教學、研究人員。
                            <input type="checkbox" name="qualification2" value="true">於正式納編前五年間均任職於國外學術研究機構。
                        </td>
                    </tr>
                    <tr>
                        <td class="metadata">申請獎勵等級及額度</td>
                        <td>
                            <select name="level">
                                <option value="prof">教授級</option>
                                <option value="ap">副教授級</option>
                                <option value="asst">助理教授級</option>
                            </select>
                            每月獎勵額度<input type="number" name="price" required>萬元
                        </td>
                    </tr>
                    <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)"><button type="button" onclick="commit()">存檔</button></td></tr>
                </tbody>
            </table>
        </form>
    </div>

</body>
</html>
