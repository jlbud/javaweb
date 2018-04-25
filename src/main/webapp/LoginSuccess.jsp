<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息界面</title>
</head>
<body>
<div style="padding-left: 10px;">
    <div class="panel panel-default">
        <div class="panel-heading" style="font-size: 18px;">用户信息</div>
        <table class="table" style="text-align: center;">
            <thead>
            <tr style="text-align: center;">
                <th style="width: 45px;">编号</th>
                <th style="width: 75px;">用户名</th>
                <th style="width: 75px;">密码</th>
                <th style="width: 145px;">真实姓名</th>
                <th style="width: 45px;">性别</th>
                <th style="width: 145px;">邮件</th>
                <th style="width: 145px;">联系电话</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${currentUser.id }</td>
                <td>${currentUser.username}</td>
                <td>${currentUser.password }</td>
                <td>${currentUser.truename }</td>
                <td>${currentUser.sex }</td>
                <td>${currentUser.email }</td>
                <td>${currentUser.phone }</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>