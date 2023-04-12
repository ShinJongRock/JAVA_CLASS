<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<html>
<head>
  <title>JSTL: Core Library</title>
</head>
<body bgcolor="#FFFFFF">

<h3>&lt;c:set&gt;</h3>
<c:set value="Hello World" var="msg" />

msg : ${msg} <BR>
msg : <%= pageContext.getAttribute("msg")  %><BR>
</body>
</html>