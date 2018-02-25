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
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>
</head>
<body>

<div>
    <h2>ファイルダウンロード</h2>

    <div>
        <form:form method="POST" action="${pageContext.request.contextPath}/download">
            <c:forEach var="downloadfile" items="${downloadfiles}">
                <div>
                    <input type="submit" name="filedownload" value="${downloadfile.getName()}"/>
                </div>
            </c:forEach>
        </form:form>
    </div>
</div>

<a href="${pageContext.request.contextPath}/">Topに戻る</a>

</body>
</html>
