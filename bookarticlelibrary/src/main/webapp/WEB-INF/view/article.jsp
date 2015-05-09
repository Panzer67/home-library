<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />

<div class="wrapper">
    <h2>Article</h2>
    <table border="1">
        <th>No</th>
        <th>Title</th>
        <th>Author(s)</th>
        <th>Journal</th>
        <th>Actions</th>			        	

        <tr>
            <td></td>
            <td>${article.title}</td>
            <td><c:forEach var="author" items="${article.getAuthors()}" varStatus="status" >${author.firstname}&nbsp;${author.lastname}</br></c:forEach></td>
            <td>${article.getJournal().journal_name}</td>
            <td>
                <a href="<c:url value="editarticle/${article.id}" /> ">Edit</a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="<c:url value="deletearticle/${article.id}" /> ">Delete</a>
            </td>
        </tr>

    </table>   	
</div>
<jsp:include page="footer.jsp" />
