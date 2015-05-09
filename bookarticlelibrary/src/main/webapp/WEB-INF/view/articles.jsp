<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />

<div class="wrapper">
    <h1>Articles</h1>

    <table border="1">
        <th>No</th>
        <th>Title</th>
        <th>Author(s)</th>
        <th>Journal</th>
        <th>volume</th>
        <th>issue</th>
        <th>Year</th>
        <th>pages</th>

        ${fn:length(articleList)}
        <c:forEach var="article" items="${articleList}" varStatus="status" >

            <tr>
                <td>${status.count}</td>
                <td><a href="<c:url value="/articles/article/${article.id}" />">${article.title}</a></td>
                <td><c:forEach var="author" items="${article.getAuthors()}" varStatus="status">${author.firstname}&nbsp;${author.lastname}</br></c:forEach></td>
                <td>${article.getJournal().journal_name}</td>
                <td>${article.volume}</td>
                <td>${article.issue}</td>
                <td>${article.year}</td>
                <td>${article.pages}</td>

            </tr>
        </c:forEach>
    </table>   			
</div>


<jsp:include page="footer.jsp" />