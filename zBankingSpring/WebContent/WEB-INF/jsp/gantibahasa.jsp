<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
html {
    background-color: #003399; /* For browsers that do not support gradients */
	background-image: linear-gradient(to right, white , #003399);
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
  background-color: white;
  background-image: linear-gradient(to right, white , #003398);
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
.center {
	margin-left: auto;
	margin-right: auto;
}

</style>

<title><spring:message code="gantibhs.msg" text="default text"/></title>
</head>
<body>
	<div class="header">
		<img src="https://4.bp.blogspot.com/-KN_4k5k3v_0/WgO5w1MKHsI/AAAAAAAAEok/kxpDLpCmd2o7c8jYgDb786G1h34fVNHCQCLcBGAs/s1600/bca.png" alt="bcalogo" width="100px" height="70px" />
		<div class="header-right">
			<a href="success"><spring:message code="success.msg" text="default text"/></a>
			<a href="pembelian"><spring:message code="buy.msg" text="default text" /></a>
			<a href="pembayaran"><spring:message code="pay.msg" text="default text" /> </a>
			<a href="kartukredit"><spring:message code="credit.msg" text="default text" /></a> 
			<a href="administrasi" class="active"><spring:message code="admin.msg" text="default text"/></a>
			<a href="logout">LOG OUT</a>
		</div>
	</div>
	<div style="padding-left: 20px; padding-top:20px">
		<p><spring:message code="gantibhs.msg" text="default text"/><p><br />
		<a href="?lang=en" onclick="return check1();" class="button glow-button">English</a>
		<a href="?lang=ind" onclick="return check2();" class="button glow-button">Indonesia</a>
		<form>
		<c:set var="val"><spring:message code="toEng.msg" text="default text"/></c:set>
		<input type="hidden" id="toeng" value="${val}"/>
		<c:set var="val2"><spring:message code="toInd.msg" text="default text"/></c:set>
		<input type="hidden" id="toind" value="${val2}"/>
		</form>	
	</div>
</body>
<script type="text/javascript">
function check1(){
	var a = document.getElementById('toeng').value;
	return alert(a);
}
function check2(){
	var a = document.getElementById('toind').value;
	return alert(a);
}
</script>
</html>