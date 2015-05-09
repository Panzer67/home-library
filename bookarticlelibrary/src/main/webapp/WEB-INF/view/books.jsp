<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />

<div class="wrapper">
    <h1>Books</h1>
    <table border="1">
        <th>No</th>
        <th>Title</th>
        <th>Author(s)</th>
        <th>ISBN</th>

        ${fn:length(bookList)}
        <c:forEach var="book" items="${bookList}" varStatus="status" >

            <tr>
                <td>${status.count}</td>
                <td><a href="<c:url value="/books/book/${book.id}" />" >${book.title}</a></td>
                <td><c:forEach var="author" items="${book.getAuthors()}" varStatus="status">${author.firstname}&nbsp;${author.lastname}</br></c:forEach></td>
            <td>${book.isbn}</td>

            </tr>
        </c:forEach>
    </table>   	
</div>


<jsp:include page="footer.jsp" />