<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />

<div class="wrapper">
    <h1>Authors</h1>    
    <table border="1">
        <th>No</th>			        	
        <th>Author(s)</th>			        		        	
        <th>Articles</th>
        <th>Books</th>
            ${fn:length(authorList)}
        <c:forEach var="author" items="${authorList}" varStatus="status" >
            <tr>
                <td>${status.count}</td>								
                <td><a href="<c:url value="/authors/author/${author.id}" />" >${author.firstname}&nbsp;${author.lastname}</a></td>
                <td>${fn:length(author.getArticles())}</td>					
                <td>${fn:length(author.getBooks())}</td>
            </tr>
        </c:forEach>
    </table>   	
</div>


<jsp:include page="footer.jsp" />