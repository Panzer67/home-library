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
                    Journals
                </td>
                <td>
                    Article(s)
                </td>
            </tr>
            <c:forEach var="journal" items="${journalList}" varStatus="status" >
                <tr>
                    <td>
                        ${status.count}
                    </td>
                    <td>
                        <a href="<c:url value="/journals/journal/${journal.id}" />" >${journal.journal_name}</a>
                    </td>
                    <td>
                        ${fn:length(journal.getArticles())}
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>      
</div>

<jsp:include page="footer.jsp" />