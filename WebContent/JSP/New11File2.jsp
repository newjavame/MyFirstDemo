<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <%@ taglib prefix="s" uri="/struts-tags" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
        <meta name="renderer" content="webkit|ie-comp|ie-stand">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta content="text/html; charset=utf-8">
        <meta http-equiv="Cache-Control" content="no-siteapp" />
        <title>注册</title>
        <meta name="viewport" content="width=device-width,initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <meta http-equiv="Cache-Control" content="no-siteapp">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <meta name="keywords" content="">
        <meta name="description" content="">
        <link rel="stylesheet" type="text/css" href="css/page.css" />
        <link rel="stylesheet" type="text/css" href="css/base.css" />
        <script src="js/jquery-1.8.3.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="js/jquery.SuperSlide.2.1.js"></script>
    </head>

    <body class="sign-bg">
        <div class="sign clearfix">
            <div class="top clearfix">
                <a href="index.jsp" class="fl fanhui">返回首页</a>
                <p class="fr">
                    已有商城账号？
                    <a href="login.jsp" class="zhuce ra3">
                        登录
                    </a>
                </p>
            </div>
            <div class="bottom clearfix box-s ra10">
                <div class="sign-logo clearfix">
                    <img src="img/yuanlogo.png"/>
                </div>
                <div class="error-box"><font color="red">${msg }</font></div>
                <form action="register!registerCheck.action" method="post">
                <div class="content clearfix">
                    <ul>
                        <li>
                            <span class="fl"></span>
                            <input type="text" name="userName" id="" value="" placeholder="用户名"" class="fl shuru" />
                        </li>
                        <li>
                            <span class="fl mima"></span>
                            <input type="password" name="password" value="" placeholder="密码" class="fl shuru" />
                        </li>
                        <li>
                            <span class="fl mima"></span>
                            <input type="text" name="tel" value="" placeholder="电话号"" class="fl shuru" />
                        </li>
                        <li>
                            <span class="fl mima"></span>
                            <input type="text" name="address"  value="" placeholder="地址" class="fl shuru" />
                        </li>
                        <li>
                            <span class="fl mima"></span>
                            <input type="text" name="email"  value="" placeholder="邮编" class="fl shuru" />
                        </li>
                        <li class="jizhu">
                            <div class="radiothree fl">
                                <label>
                                    <input type="checkbox" name="" value="">
                                    <div class="option"></div>
                                    <p class="opt-text fl ml20">我已阅读并同意<a href="zcxy.html">《文客书屋用户注册协议》</a></p>
                                </label>
                            </div>
                        </li>
                    </ul>
                    <input type="submit" value="立即注册"  class="sign-btn zhuce-btn ra5"/>
                </div>
                </form>
            </div>
            <div class="xia clearfix">
                <p>Copyright ? 2018-2020 锟侥匡拷锟斤拷锟斤拷. All Rights Reserved.</p>
            </div>
        </div>
    </body>
</html>