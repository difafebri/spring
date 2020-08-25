<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="ISO-8859-1">
<style>
@charset "ISO-8859-1";

* {box-sizing: border-box;}

body { 
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
  text-align: center;
}

table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

th {
  background-color: #a55ffa;
  color: white;
}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}

label {
  padding: 12px 12px 12px 0;
  display: inline-block;
}

input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border: 10px solid white;
  background-color: #d9ecff;
  padding: 50px;
}

.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}

.col-75 {
  float: left;
  width: 75%;
  margin-top: 6px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
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
  
  .col-25, .col-75, input[type=submit] {
    width: 100%;
    margin-top: 0;
  }
}
</style>
<title><spring:message code="transaksi.msg" text="default text"/></title>
</head>
<body>
<div class="header">
	<img src="https://4.bp.blogspot.com/-KN_4k5k3v_0/WgO5w1MKHsI/AAAAAAAAEok/kxpDLpCmd2o7c8jYgDb786G1h34fVNHCQCLcBGAs/s1600/bca.png" alt="bcalogo" width="100px" height="70px" />
		<div class="header-right">
			<a href="success"><spring:message code="success.msg" text="default text"/></a>
			<a href="pembelian"><spring:message code="buy.msg" text="default text" /></a>
			<a href="pembayaran"><spring:message code="pay.msg" text="default text" /> </a>
			<a href="kartukredit" class="active"><spring:message code="credit.msg" text="default text" /></a> 
			<a href="administrasi"><spring:message code="admin.msg" text="default text"/></a>
			<a href="logout">LOG OUT</a>
		</div>
</div>
<div style="padding-left:20px">
	<table class="center">
		<tr><th>Username</th>
		<th><spring:message code="namamerchant.msg" text="default text"/></th>
		<th><spring:message code="nominal.msg" text="default text"/></th>
		<th><spring:message code="tgl.msg" text="default text"/></th>
	</tr>
    <c:forEach var="trans" items="${listTran}"> 
    <tr>
    	<td>${trans.username}</td>
    	<td>${trans.namaMerchant}</td>
    	<td>${trans.nominalTransaksi}</td>
    	<td>${trans.tanggalTransaksi}</td>
    </tr>
    </c:forEach>
    </table>
</div>
</body>
</html>