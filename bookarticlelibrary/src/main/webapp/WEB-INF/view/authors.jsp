<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />

<div class="wrapper">
        
        <div class="librarytable" >
                <table >
                    <tr>
                        <td>
                            No.
                        </td>
                        <td>
                            Author(s)
                        </td>
                        <td >
                            Article(s)
                        </td>
                        <td>
                            Book(s)
                        </td>
                    </tr>
                    <c:forEach var="author" items="${authorList}" varStatus="status" >
                    <tr>
                        <td>
                            ${status.count}
                        </td>
                        <td >
                            <a href="<c:url value="/authors/author/${author.id}" />" >${author.firstname}&nbsp;${author.lastname}</a>
                        </td>
                        <td>
                            ${fn:length(author.getArticles())}
                        </td>
                        <td>
                            ${fn:length(author.getBooks())}
                        </td>
                    </tr>
                    </c:forEach>                    
                   
                </table>
            </div>
</div>


<jsp:include page="footer.jsp" />