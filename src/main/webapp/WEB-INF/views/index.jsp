<%--
  Created by IntelliJ IDEA.
  User: RLWS_5871
  Date: 2019/4/17
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="static/css/style.css">
    <script type="text/javascript" src="static/js/jquery.min.js"></script>
    <script type="text/javascript" src="static/js/vector.js"></script>
    <script type="text/javascript">
        $(function () {
            // Victor("container", "output");   //登录背景函数
            // $("#entry_name").focus();
            // $(document).keydown(function (event) {
            //     if (event.keyCode == 13) {
            //         $("#entry_btn").click();
            //     }
            // });
        });
    </script>
</head>
<body>
    <div id="container">
        <div id="output">
            <div class="containerT">
                <h1>用户登录</h1>
                <form class="form" id="entry_form" action="/login" method="post">
                    <input type="text" placeholder="用户名" id="entry_name" name="email">
                    <input type="password" placeholder="密码" id="entry_password" name="password">
                    <input type="hidden" id="requestUrl" name="requestUrl" value="${requestUrl}">
                    <input type="hidden" id="condition" name="condition" value="${condition}">
                    <button id="entry_btn">登录</button>
                    <div id="prompt" class="prompt"></div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>