<%--
  Created by 蓝鸥科技有限公司  www.lanou3g.com.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>表格数据</title>

    <link href="../../css/demo.css"
          rel="stylesheet"
          type="text/css">

    <script src="../../scripts/boot.js"
            type="text/javascript"></script>

</head>

<body>

<div>
    <div id="toolBar"
         class="mini-toolbar"
         style="width: 80%;border-bottom: 0;padding: 0">

        <table>
            <tr>
                <td style="white-space:nowrap;">
                    <input id="key"
                           class="mini-textbox"
                           emptyText="请输入名字"
                           onenter="onKeyEnter">

                    <a class="mini-button"
                       onclick="search()">查询</a>
                </td>
            </tr>
        </table>

    </div>

    <div id="datagrid1"
         class="mini-datagrid"
         style="width: 80%;height: 60%"
         url="">

        <div property="columns">
            <div field="id" width="120">学生编号</div>
            <div field="username" width="120">学生姓名</div>
            <div field="address" width="120">学生地址</div>
        </div>

    </div>


</div>


<script>
    mini.parse();

    var datagrid = mini.get("datagrid1");

    function onKeyEnter() {
        search();
    }

    function search() {
        var key = mini.get("key").val();
        datagrid.load({username:key});
    }


</script>

</body>
</html>
