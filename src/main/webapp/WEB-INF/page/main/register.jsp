<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>登录</title>

    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.1.0/css/font-awesome.min.css">

    <link rel='stylesheet' href='${pageContext.request.contextPath}/assets/css/jquery-ui.css'>
    <link rel='stylesheet prefetch' href='${pageContext.request.contextPath}/assets/css/bootstrap.min.css'>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css" media="screen"
          type="text/css"/>

    <script src="${pageContext.request.contextPath}/assets/js/modernizr.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/jquery.1.9.1.min.js"></script>

   <script>
       $(function(){

       });
   </script>
</head>

<body>

<body class="login-page">
<div class="login-form">

    <div class="login-content">

        <div class="form-login-error">
            <h3>Invalid login</h3>

            <p>Enter <strong>demo</strong>/<strong>demo</strong> as login and password.</p>
        </div>

        <form method="post" role="form" id="form_login">

            <div class="form-group">

                <div class="input-group">
                    <div class="input-group-addon">
                        <i class="fa fa-user"></i>
                    </div>

                    <input type="text" class="form-control" name="username" id="username" placeholder="请填写用户名"
                           autocomplete="off"/>
                </div>

            </div>

            <div class="form-group">

                <div class="input-group">
                    <div class="input-group-addon">
                        <i class="fa fa-key"></i>
                    </div>

                    <input type="password" class="form-control" name="password" id="password" placeholder="请输入密码"
                           autocomplete="off"/>
                </div>

            </div>

            <div class="form-group">

                <div class="input-group">
                    <div class="input-group-addon">
                        <i class="fa fa-key"></i>
                    </div>

                    <input type="password" class="form-control" name="repassword" id="repassword" placeholder="请再次输入密码"
                           autocomplete="off"/>
                </div>

            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block btn-login">
                    <i class="fa fa-sign-in"></i>
                    注册用户
                </button>
            </div>

            <!-- Implemented in v1.1.4 -->
            <div class="form-group">
                <em>- or -</em>
            </div>

            <!--

            You can also use other social network buttons
            <div class="form-group">

                <button type="button" class="btn btn-default btn-lg btn-block btn-icon icon-left twitter-button">
                    Login with Twitter
                    <i class="entypo-twitter"></i>
                </button>

            </div>

            <div class="form-group">

                <button type="button" class="btn btn-default btn-lg btn-block btn-icon icon-left google-button">
                    Login with Google+
                    <i class="entypo-gplus"></i>
                </button>

            </div> -->
        </form>

        <div style="text-align:center;clear:both;">
        </div>

    </div>

</div>
</div>

</body>
</body>
</html>