<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Info about flat</title>


    <form action="/information" method="get">

        <p>Input id your flat</p>
        <input type="text"  placeholder="id your flat" name="idFlat">

        <input type="submit">
    </form>

    Your address : <p>${address}</p>

    Citizen of your flat:

    <br>
    <table border="1">
        <c:forEach items="${citizen}" var="citizen">
            <tr>
                <td> ${citizen.pib} </td>

            </tr>
        </c:forEach>
    </table>

    <a href="/addResidents"> Add recidents</a>



</head>
<body>

</body>
</html>