<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />

<div class="wrapper">    
    <div class="librarytable" >
        <table>
            <tr>
                <td>
                    No.
                </td>
                <td>
                    Title
                </td>
                <td >
                    Author(s)
                </td>
                <td>
                    ISBN
                </td>
                <td>
                    Publisher
                </td>
            </tr>
            <c:forEach var="book" items="${bookList}" varStatus="status" >
                <tr>
                    <td>
                       ${status.count} 
                    </td>
                    <td>
                       <a href="<c:url value="/books/book/${book.id}" />" >${book.title}</a> 
                    </td>
                    <td>
                        <c:forEach var="author" items="${book.getAuthors()}" varStatus="status"> 
                            <a href="<c:url value="/authors/author/${author.id}" />" >${author.firstname}&nbsp;${author.lastname}</a></br>                        
                        </c:forEach>
                    </td>
                    <td>
                        ${book.isbn}
                    </td>
                    <td>
                        ${book.publisher}
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>    
</div>


<jsp:include page="footer.jsp" />