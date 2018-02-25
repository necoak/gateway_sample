<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Home</title>
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>
<body>
    <div id="wrapper">
        <h1>サンプルのトップページ</h1>
        <p>The time on the server is ${serverTime}.</p>
    </div>
    <form:form method="GET" action="${pageContext.request.contextPath}/download">
        <input type="submit" value="ダウンロードページへ"/>
    </form:form>

    <form:form method="GET" action="${pageContext.request.contextPath}/upload">
        <input type="submit" value="アップロードページへ"/>
    </form:form>

</body>
</html>
