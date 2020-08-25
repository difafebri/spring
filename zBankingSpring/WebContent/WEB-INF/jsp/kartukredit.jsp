<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="ISO-8859-1">
<style>
@charset "ISO-8859-1";

* {box-sizing: border-box;}

body {
  text-align: center; 
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.button {
  text-decoration: none;
  color: rgba(255, 255, 255, 0.8);
  background: rgb(145, 92, 182);
  padding: 15px 40px;
  border-radius: 4px;
  font-weight: normal;
  text-transform: uppercase;
  transition: all 0.2s ease-in-out;
}

.glow-button:hover {
  color: rgba(255, 255, 255, 1);
  box-shadow: 0 5px 15px rgba(145, 92, 182, .4);
}

.header {
  overflow: hidden;
  background-color: #f1f1f1;
  padding: 20px 10px;
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

.header a.logo {
  font-size: 25px;
  font-weight: bold;
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
</style>
<title><spring:message code="credit.msg" text="default text"></spring:message></title>
</head>
<body>
<div class="header">
		<img src="https://4.bp.blogspot.com/-KN_4k5k3v_0/WgO5w1MKHsI/AAAAAAAAEok/kxpDLpCmd2o7c8jYgDb786G1h34fVNHCQCLcBGAs/s1600/bca.png" alt="bcalogo" width="100px" height="70px" />
		<div class="header-right">
			<a href="success"><spring:message code="success.msg" text="default text" /></a>
			<a href="pembelian"><spring:message code="buy.msg" text="default text" /></a>
			<a href="pembayaran"><spring:message code="pay.msg" text="default text" /> </a> 
			<a href="kartukredit" class="active"><spring:message code="credit.msg" text="default text" /></a> 
			<a href="administrasi"><spring:message code="admin.msg" text="default text" /></a> 
			<a href="logout">LOG OUT</a>
		</div>
	</div>
	<div style="padding-left: 20px; padding-top:100px;">
		<a href="tagihan" class="button glow-button"><spring:message code="tagihan.msg" text="default text" /></a>
		<a href="transaksi" class="button glow-button"><spring:message code="transaksi.msg" text="default text" /></a>
	</div>
</body>
</html>