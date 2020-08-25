<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="ISO-8859-1">
<style>
@charset "ISO-8859-1";

* {
	box-sizing: border-box;
}
html {
    background-color: #003399; /* For browsers that do not support gradients */
	background-image: linear-gradient(to right, white , #003399);
}
.button {
  text-decoration: none;
  color: white;
  background: #258ce6;
  padding: 15px 40px;
  border-radius: 15px;
  font-weight: normal;
  text-transform: uppercase;
  transition: all 0.2s ease-in-out;
}

.glow-button:hover {
  color: rgba(255, 255, 255, 1);
  box-shadow: 0 5px 15px rgba(0,0,255,0.3);
}

.header {
	overflow: hidden;
	height: 100px;
	background-color: #003399; /* For browsers that do not support gradients */
	background-image: linear-gradient(to right, white , #003399);
	padding: 15px 15px;
}

.header a {
	float: left;
	color: black;
	text-align: center;
	padding: 12px;
	text-decoration: none;
	font-size: 18px;
	line-height: 25px;
	border-radius: 4px;
}

.header a:hover {
	background-color: #aee1e8;
	color: black;
}

.header a.active {
	background-color: dodgerblue;
	color: white;
}

.header-right {
	float: right;
}

@media screen and (max-width: 500px) {
	.header a {
		float: none;
		display: block;
		text-align: left;
	}
	.header-right {
		float: none;
	}
}

.center {
	margin-left: auto;
	margin-right: auto;
}
.login-box h2 {
  margin: 0 0 30px;
  padding: 0;
  color: white;
  text-align: center;
}
.login-box {
  position: absolute;
  top: 50%;
  left: 50%;
  width: 400px;
  padding: 40px;
  transform: translate(-50%, -50%);
  background: black;
  box-sizing: border-box;
  box-shadow: 0 15px 25px rgba(0, 0, 0, 0.6);
  border-radius: 10px;
}
.login-box .user-box {
  position: relative;
}

.login-box .user-box input {
  width: 100%;
  padding: 10px 0;
  font-size: 20px;
  color: white;
  margin-bottom: 30px;
  border: none;
  border-bottom: 1px solid #fff;
  outline: none;
  background: transparent;
}
.login-box .user-box label {
  position: absolute;
  top: 0;
  left: 0;
  padding: 10px 0;
  font-size: 20px;
  color: white;
  pointer-events: none;
  transition: 0.5s;
}

.login-box .user-box input:focus ~ label, .login-box .user-box input:valid ~ label {
  top: -20px;
  left: 0;
  color: white;
  font-size: 20px;
}

.login-box form a {
  position: relative;
  display: inline-block;
  padding: 10px 20px;
  color: white;
  font-size: 20px;
  text-decoration: none;
  text-transform: uppercase;
  overflow: hidden;
  transition: 0.5s;
  margin-top: 40px;
  letter-spacing: 4px;
}
</style>
<title><spring:message code="tologinpage.msg" text="default text" /></title>
</head>
<body>
	<div class="header">
		<img src="https://4.bp.blogspot.com/-KN_4k5k3v_0/WgO5w1MKHsI/AAAAAAAAEok/kxpDLpCmd2o7c8jYgDb786G1h34fVNHCQCLcBGAs/s1600/bca.png" alt="bcalogo" width="100px" height="70px" />
	</div>
	<div class="login-box">
	<a href="?lang=en" style="color:white;">English</a> || <a href="?lang=ind" style="color:white;">Indonesia</a>
		<h2>L O G I N</h2>
		<form:form method="post" action="processLogin">
		<div class="user-box">
			<form:input path="username" />
			<form:label path="username">Username</form:label>
		</div>
		<div class="user-box">
			<form:password path="pw" />
			<form:label path="pw">Password</form:label>
		</div>
		<span></span>
		<span></span>
		<span></span>
			<input type="submit" value="Login" class="center button glow-button"/>
		</form:form>
		<c:choose>
			<c:when test="${not empty errors}">
				<table>
					<tr>
						<td style="font-style: italic; color: red;"><p>
								<spring:message code="error.msg" text="default text" />
							</p></td>
					</tr>
				</table>
			</c:when>
			<c:otherwise></c:otherwise>
		</c:choose>
	</div>
</body>
</html>