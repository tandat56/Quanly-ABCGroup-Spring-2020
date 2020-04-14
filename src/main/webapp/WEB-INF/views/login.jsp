<%@ page pageEncoding="utf-8" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
</head>
<body>

<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-TAGCODE" height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->
<div class="page_loader"></div>

<!-- Login 4 start -->
<div class="login-4">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="form-section">
                    <div class="logo-2">              
                    </div>
                  <div class="main-div">
					<c:if test="${param.incorrectAccount != null}">
					<div class="alert alert-danger">	
							Username or password incorrect
					</div>
						</c:if>
						<c:if test="${param.accessDenied != null}">
					<div class="alert alert-danger">	
							you Not authorize
					</div>
				</c:if>
				</div>
                    <h3>Sign into your account</h3>
                    <form action="j_spring_security_check" id="formLogin" method="post">
                        <div class="form-group form-box">
                            <input type="text" class="input-text" id="userName" name="j_username" placeholder="Email Address or User Name">
                        </div>
                        <div class="form-group form-box">
                            <input type="password" name="j_password" class="input-text" placeholder="Password">
                        </div>
                        <div class="form-group mb-0 clearfix">
                            <button type="submit" class="btn-md btn-theme float-left">Login</button>
                            <a href="forgot-password-4.html" class="forgot-password">Forgot Password</a>
                        </div>
                        <div class="extra-login clearfix">
                            <span>Or Login With</span>
                        </div>
                        <div class="clearfix"></div>
                        <ul class="social-list">
                            <li><a href="#" class="facebook-color"><i class="fa fa-facebook facebook-i"></i><span>Facebook</span></a></li>
                            <li><a href="#" class="twitter-color"><i class="fa fa-twitter twitter-i"></i><span>Twitter</span></a></li>
                            <li><a href="#" class="google-color"><i class="fa fa-google google-i"></i><span>Google</span></a></li>
                        </ul>
                    </form>
                    <p>Don't have an account? <a href="register-4.html" class="thembo"> Register here</a></p>
                </div>
            </div>
        </div>
    </div>
</div>s

</body>
</html>