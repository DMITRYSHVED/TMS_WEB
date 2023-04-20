<HTML>
<HEAD>
    <title>
        DATE TASK
    </title>
</HEAD>
<body>
<form action="${pageContext.request.contextPath}/date" method="post">
    <input name="day" type="number" placeholder="MONTHDAY"/>
    <input name="month" type="number" placeholder="MONTH"/>
    <input name="year" type="number" placeholder="YEAR"/>
    <button type="submit"> SUBMIT</button>
</form>
<p>
    WEEKDAY: ${weekDay}
</p>
</body>
</HTML>