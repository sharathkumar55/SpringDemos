<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student-Confirmation</title>
</head>
<body>
The Student is confirmed with Name:${student.firstName} ${student.lastName}<br><br>
Country : ${student.country}  <br><br> City: ${student.city} <br><br>
Favorite Language : ${student.favoriteLanguage}<br><br>
Favorite OS        :
<ul>
      <c:forEach var="temp" items="${student.operatingSystems}">
      <li>${temp}</li>
      </c:forEach>
</ul>
</body>
</html>