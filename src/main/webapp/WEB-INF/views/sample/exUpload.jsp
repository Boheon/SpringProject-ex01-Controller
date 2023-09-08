<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Insert title here</title>
</head>
<body>
<form
        action="/sample/exUploadPost"
        <%--무조건 post get은 문자열 보낼때사용은 가능--%>
        method="post"
        <%--인코딩타입--%>
        enctype="multipart/form-data"
>
    <div>
        <input type="file" name="files" multiple="multiple"/>
    </div>
<%--    <div>--%>
<%--        <input type="file" name="files"/>--%>
<%--    </div>--%>
<%--    <div>--%>
<%--        <input type="file" name="files"/>--%>
<%--    </div>--%>
<%--    <div>--%>
<%--        <input type="file" name="files"/>--%>
<%--    </div>--%>
<%--    <div>--%>
<%--        <input type="file" name="files"/>--%>
<%--    </div>--%>
<%--    <div>--%>
<%--        <input type="submit"/>--%>
<%--    </div>--%>


</form>
</body>
</html>