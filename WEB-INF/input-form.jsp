<html>
<head>
    <title>INPUT FORM</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/home" method="post">
    <input name="userName" placeholder="NAME">
    <input name="userSurname" placeholder="SURNAME">
    <button type="submit">SIGN IN</button>
</form>
</body>
</html>