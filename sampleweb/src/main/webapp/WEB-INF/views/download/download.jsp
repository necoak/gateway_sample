<%--
  Created by IntelliJ IDEA.
  User: yos
  Date: 2018/02/24
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ダウンロード</title>
</head>
<body>

<div>
    <h2>ファイルダウンロード</h2>
    <form:form method="POST" action="${pageContext.request.contextPath}/download">
        <input type="submit" name="filedownload" value="POSTでダウンロード"/>
    </form:form>
</div>

</body>
</html>
