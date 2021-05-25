<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK" import="java.util.*,cn.edu.lingnan.dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>注册界面</title>
</head>
<title>普通用户注册</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Oleo+Script:400,700'>
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>

    <body>

        <div class="header">
            <div class="container">
                <div class="row">
                    <div class="logo span4">
                        <h1><a href="">声之乐 <span class="red">.</span></a></h1>
                    </div>
                    <div class="links span8">
                        <a class="home" href="" rel="tooltip" data-placement="bottom" data-original-title="Home"></a>
                        <a class="blog" href="" rel="tooltip" data-placement="bottom" data-original-title="Blog"></a>
                    </div>
                </div>
            </div>
        </div>

        <div class="register-container container">
            <div class="row">
                <div class="iphone span5">
                    <img src="assets/img/iphone.png" alt="">
                </div>
                <div class="register span6">
                    <form action="" method="post">
                        <h2>欢迎来到普通用户注册界面 <span class="red"><strong></strong></span></h2>
                        <label for="firstname">用户id</label>
                        <input type="text" id="firstname" name="firstname" placeholder="enter your first name...">
                        <label for="lastname">用户名</label>
                        <input type="text" id="lastname" name="lastname" placeholder="enter your first name...">
                        <label for="username">密码</label>
                        <input type="text" id="username" name="username" placeholder="choose a username...">
                        <label for="email">密码确认</label>
                        <input type="text" id="email" name="email" placeholder="enter your email...">
                        <button type="submit">注册</button>
                    </form>
                </div>
            </div>
        </div>

        <!-- Javascript -->
        <script src="assets/js/jquery-1.8.2.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/scripts.js"></script>
</body>
</html>