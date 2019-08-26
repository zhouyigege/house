
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../admin/js/jquery-1.8.3.js"></script>
    <script language="JavaScript">
        $(function () {
            var Is=document.getElementsByTagName("li")
            for (var i=0;i<Is.length;i++){
                alert(Is[i].innerText)
            }
        })

    </script>
</head>
<body>
<ui>
    <li>张三:123</li>
    <li>张4:123</li>
    <li>张5:123</li>
    <li>张6:123</li>
    <li>张7:123</li>
</ui>
</body>
</html>
