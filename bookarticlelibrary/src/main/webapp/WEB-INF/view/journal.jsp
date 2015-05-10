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
                    Journal
                </td>
            </tr>
            <tr>
                <td>

                </td>
                <td>
                    ${journal.journal_name}
                </td>
            </tr>
        </table>
    </div>    
    <c:choose>
        <c:when test="${fn:length(journal.getArticles()) == 0 }">
            <h3>No Articles</h3>
        </c:when>
        <c:otherwise>
            <h3>Article(s)</h3>
            <div class="librarytable">
                <table>
                    <tr>
                        <td>
                            No.
                        </td>
                        <td>
                            Title
                        </td>
                        <td>
                            Author(s)
                        </td>
                        <td>
                            Volume
                        </td>
                        <td>
                            Issue
                        </td>
                        <td>
                            Year
                        </td>
                        <td>
                            Pages
                        </td>                        
                    </tr>
                    <c:forEach var="article" items="${journal.getArticles()}" varStatus="status">
                        <tr>
                            <td>
                                ${status.count}
                            </td>
                            <td>
                                <a href="<c:url value="/articles/article/${article.id}" />">${article.title}</a>
                            </td>
                            <td>
                                <c:forEach var="author" items="${article.getAuthors()}" varStatus="status">
                                    <a href="<c:url value="/authors/author/${author.id}" />" >${author.firstname}&nbsp;${author.lastname}</a></br> 
                                </c:forEach>
                            </td>
                            <td>
                                ${article.volume}
                            </td>
                            <td>
                                ${article.issue}
                            </td>
                            <td>
                                ${article.year}
                            </td>
                            <td>
                                ${article.pages}
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>            
        </c:otherwise>
    </c:choose>
</div>
<jsp:include page="footer.jsp" />