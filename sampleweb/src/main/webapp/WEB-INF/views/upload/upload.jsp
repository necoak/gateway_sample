<%--
  Created by IntelliJ IDEA.
  User: yos
  Date: 2018/02/25
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ファイルアップロード</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>
<body>

<form:form
        action="${pageContext.request.contextPath}/upload" method="post"
        modelAttribute="fileUploadForm" enctype="multipart/form-data"> <!-- (1) (2) -->
    <table>
        <tr>
            <th width="35%">File to upload</th>
            <td width="65%">
                <form:input type="file" path="file" /> <!-- (3) -->
                <form:errors path="file" />
            </td>
        </tr>
        <tr>
            <th width="35%">Description</th>
            <td width="65%">
                <form:input path="description" />
                <form:errors  path="description" />
            </td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td><form:button>Upload</form:button></td>
        </tr>
    </table>
</form:form>

<a href="${pageContext.request.contextPath}/">Topに戻る</a>
</body>
</html>
