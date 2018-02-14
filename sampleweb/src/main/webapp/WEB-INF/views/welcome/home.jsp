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
        <h1>Hello world!</h1>
        <p>The time on the server is ${serverTime}.</p>
    </div>
    <div>
        <h2>ファイルダウンロード</h2>
        <form:form method="POST" action="${pageContext.request.contextPath}/postdl">
            <input type="submit" value="POSTでダウンロード"/>
        </form:form>
    </div>
</body>
</html>
