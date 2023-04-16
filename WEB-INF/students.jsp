<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<HEAD>
    <title> STUDENTS_LIST</title>
    <link rel="stylesheet" href="../styles.css">
</HEAD>
<BODY>
<h2>WELCOME, ${sessionScope.user.name}</h2>
<h3> Number of visits: ${sessionScope.count}</h3>
<p>ADD STUDENT</p>
<form action="${pageContext.request.contextPath}/students" method="post">
    <input name="name" placeholder="NAME"/>
    <input name="surname" placeholder="SURNAME"/>
    <input name="town" placeholder="TOWN"/>
    <input name="age" type="number" placeholder="AGE"/>
    <button type="submit">Submit</button>
</form>
<table>
    <thead>
    </thead>
    <tbody>
    <tr>
        <th> NAME</th>
        <th> SURNAME</th>
        <th> TOWN</th>
        <th> AGE</th>
    </tr>
    <c:forEach var="student" items="${studentsList}">
        <c:if test="${student.age>10}">
            <tr>
                <td><c:out value="${student.name}"/></td>
                <td><c:out value="${student.surname}"/></td>
                <td><c:out value="${student.town}"/></td>
                <td><c:out value="${student.age}"/></td>
            </tr>
        </c:if>
    </c:forEach>
    </tbody>
</table>
</BODY>
</HTML>