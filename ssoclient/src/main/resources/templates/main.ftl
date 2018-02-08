<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>主页</title>
    <link rel="stylesheet" href="/css/bootstrap.css" type="text/css">
    <script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="/js/boostrap.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#logoutBtn").click(function () {
                window.location.href="${logoutUrl}";
            })
        })
    </script>
</head>
<body>
<h1 align="center">WELCOME!</h1>
<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-8">
        ${username}
        <h3>欢迎查看我们的主页!</h3>
        <button class="btn-danger btn-lg" id="logoutBtn">退出</button>
    </div>
    <div class="col-md-1"></div>
</div>
</body>
</html>







