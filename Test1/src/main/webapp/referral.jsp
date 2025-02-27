<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Referral</title>
</head>
<body>
	<% String code = (String) request.getAttribute("referralcode"); %>
<%= code %>  
<a href="index.html"><button>Go to Home</button></a>

</body>
</html>