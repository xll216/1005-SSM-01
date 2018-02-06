<%--
  Created by 蓝鸥科技有限公司  www.lanou3g.com.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h1>登录界面</h1>


<form action="/login" method="post">
    用户名：<input type="text" name="username">
    <br><br>

    密码：<input type="password" name="password">
    <br><br>

    <input type="submit" value="登录">
    <input type="reset" value="重置">

</form>

<c:if test="loginError !=null and loginError!=''">
    ${loginError}
</c:if>

</body>
</html>
