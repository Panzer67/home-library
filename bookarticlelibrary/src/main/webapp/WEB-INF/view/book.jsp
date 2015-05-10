<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />

<div class="wrapper">
    
    <div class="librarytable">
        <table>
            <tr>
                <td>
                    
                </td>
                <td>
                    Book
                </td>
            </tr>
            <tr>
                <td>
                    Title
                </td>
                <td>
                    ${book.title}
                </td>
            </tr>    
            <tr>    
                <td>
                    Author(s)
                </td>
                <td>
                    <c:forEach var="author" items="${book.getAuthors()}" varStatus="status">
                        <a href="<c:url value="/authors/author/${author.id}" />" >${author.firstname}&nbsp;${author.lastname}</a></br>
                    </c:forEach>
                </td>
            </tr>
            <tr>
                <td>
                    ISBN
                </td>
                <td>
                    ${book.isbn}
                </td>
            </tr>
            <tr>
                <td>
                    Publisher
                </td>
                <td>
                    ${book.publisher}
                </td>
            </tr>
        </table>
    </div>    
</div>
<jsp:include page="footer.jsp" />