<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />

<div class="wrapper">
    <h2>Book</h2>
    <table border="1">
        <th>No</th>
        <th>Title</th>
        <th>Author(s)</th>
        <th>ISBN</th>
        <th>Actions</th>


        <tr>
            <td></td>
            <td>${book.title}</td>
            <td><c:forEach var="author" items="${book.getAuthors()}" varStatus="status">${author.firstname}&nbsp;${author.lastname}</br></c:forEach></td>
            <td>${book.isbn}</td>
            <td>
                <a href="editbook/${book.id}">Edit</a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="deletebook/${book.id}">Delete</a>
            </td>
        </tr>

    </table>   	
</div>
<jsp:include page="footer.jsp" />