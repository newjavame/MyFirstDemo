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
        <title>登录</title>
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

<script>
  window.onload = function(){
    var oForm = document.getElementById('loginForm');
    var oUser = document.getElementById('user');
    var oPswd = document.getElementById('pswd');
    var oRemember = document.getElementById('remember');
    //页面初始化时，如果帐号密码cookie存在则填充
    if(getCookie('user') && getCookie('pswd')){
      oUser.value = getCookie('user');
      oPswd.value = getCookie('pswd');
      oRemember.checked = true;
    }
    //复选框勾选状态发生改变时，如果未勾选则清除cookie
    oRemember.onchange = function(){
      if(!this.checked){
        delCookie('user');
        delCookie('pswd');
      }
    };
    //表单提交事件触发时，如果复选框是勾选状态则保存cookie
    oForm.onsubmit = function(){
      if(remember.checked){
        setCookie('user',oUser.value,7); //保存帐号到cookie，有效期7天
        setCookie('pswd',oPswd.value,7); //保存密码到cookie，有效期7天
      }
    };
  };
  //设置cookie
  function setCookie(name,value,day){
    var date = new Date();
    date.setDate(date.getDate() + day);
    document.cookie = name + '=' + value + ';expires='+ date;
  };
  //获取cookie
  function getCookie(name){
    var reg = RegExp(name+'=([^;]+)');
    var arr = document.cookie.match(reg);
    if(arr){
      return arr[1];
    }else{
      return '';
    }
  };
  //删除cookie
  function delCookie(name){
    setCookie(name,null,-1);
  };
</script>
    </head>

    <body class="sign-bg">
        <div class="sign clearfix">
            <div class="top clearfix">
                <a href="index" class="fl fanhui">返回首页</a>
                <a href="admin/adminlogin.jsp" class="fl fanhui">管理员登录</a>
                <p class="fr">
                    还没有商城账号？
                    <a href="register.jsp" class="zhuce ra3">
                        注册
                    </a>
                </p>
            </div>
            <div class="bottom clearfix box-s ra10">
                <div class="sign-logo clearfix">
                    <img src="img/yuanlogo.png"/>
                </div>
                <div class="error-box"><font color="red">${msg }</font></div>
                <form action="login!loginCheck.action" method="post" id="loginForm">
                <div class="content clearfix">
                    <ul>
                        <li>
                            <span class="fl"></span>
                            <input type="text" name="userName" id="user" value="" placeholder="用户名" class="fl shuru" />
                        </li>
                        <li>
                            <span class="fl mima"></span>
                            <input type="password" name="password" id="pswd" value="" placeholder="密   码" class="fl shuru" />
                        </li>
                        <li class="jizhu">
                            <div class="radiothree fl">
                                <label>
                                    <input type="checkbox" id="remember" name="" value="">
                                    <div class="option"></div>
                                    <p class="opt-text fl ml20">记住密码</p>
                                </label>
                            </div>
                            <a href="#" class="wjmima fr">
                                忘记密码？
                            </a>
                        </li>
                    </ul>
                    <input type="submit" class="sign-btn ra5" value="点击登录"></input>
                </div>
                </form>
            </div>
            <div class="xia clearfix">
                <p>Copyright ? 2018-2020 文客书屋. All Rights Reserved.</p>
            </div>
        </div>
    </body>
</html>
