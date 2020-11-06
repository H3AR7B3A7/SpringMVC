<%--@elvariable id="result" type="int"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
    <style>
        body {
            text-align: center;
            font-size: 150%;
        }
    </style>
</head>
<body>

<%--JSP-script:--%>
<%--Result of addition = <%= request.getAttribute("result")%>--%>
<%--Expression language:--%>
Result of addition = ${result}

</body>
</html>
