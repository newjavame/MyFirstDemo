<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>iframe布局</title>
</head>
<body>
    <!--顶部导航-->
    <div id="nav" class="admin-iframe-header">
        <h1 class="logo"><a href="javascript:;">妖气山后台管理</a></h1>
        <div class="admin-iframe-nav">
            <ul class="navs">
                <li class="nav active"><a href="#">首页</a></li>
                <li class="nav"><a href="#">全局</a></li>
                <li class="nav"><a href="#">界面</a></li>
                <li class="nav"><a href="#">用户</a></li>
                <li class="nav"><a href="#">分类</a></li>
                <li class="nav"><a href="#">视频</a></li>
                <li class="nav"><a href="#">接口</a></li>
                <li class="nav"><a href="#">站长</a></li>
            </ul>
        </div>

        <!--右侧功能-->
        <div class="admin-iframe-header-right">
            <ul class="navs">
                <li class="nav">
                    <p class="pull-left margin-left-10">欢迎您，<span>管理员</span></p>
                    <label class="margin-left-10">|</label>
                    <a href="javascript:;">退出</a>
                </li>
                <li class="nav"><a href="javascript:;" target="_blank">站点首页</a></li>
            </ul>
        </div>
    </div>

    <!--左侧菜单-->
    <div class="admin-iframe-content">
        <div class="admin-iframe-menu">
            <ul class="menu">
                <li class="active"><a href="javascript:page('#');">管理中心</a></li>
                <li><a href="javascript:page('#');">自定义</a></li>
            </ul>

            <ul class="menu">
                <li class="menus">
                    <a href="javascript:;">SEO设置</a>
                    <ul class="menu">
                        <li><a href="javascript:page('#');">网站首页</a></li>
                        <li><a href="javascript:page('#');">分类检索页</a></li>
                    </ul>
                </li>
            </ul>

            <ul class="menu">
                <li class="menus">
                    <a href="javascript:;">七牛云上传设置</a>
                    <ul class="menu">
                        <li><a href="javascript:page('#');">上传海报</a></li>
                        <li><a href="javascript:page('#');">上传封面</a></li>
                    </ul>
                </li>
            </ul>
        </div>

        <!--载入页面-->
        <div class="admin-markdown">
            <iframe id="page" src="viewBook.jsp"></iframe>
        </div>
    </div>
</body>
<script>
    javaex.nav({
        id : "nav", // 导航的id
        isAutoSelected : true
    });

    // 控制页面载入
    function page(url) {
        $("#page").attr("src", url);
    }
    // 菜单保持高亮
    javaex.iframeMenu();
</script>
</html>