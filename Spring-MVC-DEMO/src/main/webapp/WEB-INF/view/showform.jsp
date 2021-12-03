<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
    <title>Student-Registration</title>
</head>
<body>
   <form:form action="processform" modelAttribute="student">
             First Name : <form:input path="firstName"/><br><br>
             Last Name : <form:input path="lastName"/>
      <br><br>
      Country:
             <form:select path="country">
             <form:options items="${student.countryOptions}"/>
             </form:select>
       city:
           <form:select path="city">
           <form:option value="Hyderabad" label="Hyd"/>
           <form:option value="Warangal" label="Warangal"/>
           <form:option value="Ranga Reddy" label="Ranga Reddy"/>
           </form:select>
       <br><br>

       Favorite Language:
           JAVA <form:radiobutton path="favoriteLanguage" value="JAVA"/>
           CPP<form:radiobutton path="favoriteLanguage" value="CPP"/>
           C<form:radiobutton path="favoriteLanguage" value="C"/>

       <br><br>
       Favorite OS:
            Linux <form:checkbox path="operatingSystems" value="Linux"/>
            MAC<form:checkbox path="operatingSystems" value="MAC"/>
            Windows<form:checkbox path="operatingSystems" value="Windows"/>
       <br><br>
            <input type="submit" value="Submit"/>
   </form:form>
</body>
</html>