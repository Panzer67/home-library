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
                    Article
                </td>
            </tr>
            <tr>
                <td>
                    Title
                </td>
                <td>
                    ${article.title}
                </td>
            </tr>
            <tr>
                <td>
                    Author(s)
                </td>
                <td>
                    <c:forEach var="author" items="${article.getAuthors()}" varStatus="status" >
                        <a href="<c:url value="/authors/author/${author.id}" />" >${author.firstname}&nbsp;${author.lastname}</a></br>
                    </c:forEach>
                </td>
            </tr>
            <tr>
                <td>
                    Journal
                </td>
                <td>
                    <a href="<c:url value="/journals/journal/${article.getJournal().id}" />" >${article.getJournal().journal_name}</a>
                </td>
            </tr>
            <tr>
                <td>
                    Volume
                </td>
                <td>
                    ${article.volume}
                </td>
            </tr>
            <tr>
                <td>
                    Issue
                </td>
                <td>
                    ${article.issue}
                </td>
            </tr>
            <tr>
                <td>
                    Year
                </td>
                <td>
                    ${article.year}
                </td>
            </tr>
            <tr>
                <td>
                    Pages
                </td>
                <td>
                    ${article.pages}
                </td>
            </tr>
        </table>
    </div>     
</div>
<jsp:include page="footer.jsp" />
