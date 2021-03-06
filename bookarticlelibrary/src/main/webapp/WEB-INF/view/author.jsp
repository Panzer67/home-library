<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />

<div class="wrapper">    
    <div class="librarytable">
        <table>
            <tr>
                <td>
                    No.
                </td>
                <td>
                    Author
                </td>
            </tr>
            <tr>
                <td>
                    
                </td>
                <td>
                    ${author.firstname}&nbsp;${author.lastname}
                </td>
            </tr>
        </table>
    </div>
    			      
    <c:choose>
        <c:when test="${fn:length(author.getArticles()) == 0 }">
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
                            Journal
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
                    <c:forEach var="article" items="${author.getArticles()}" varStatus="status">
                        <tr>
                            <td>
                                ${status.count}
                            </td>
                            <td>
                                <a href="<c:url value="/articles/article/${article.id}" />" >${article.title}</a>
                            </td>
                            <td>
                                <a href="<c:url value="/journals/journal/${article.getJournal().id}" /> " >${article.getJournal().journal_name}</a>
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
    <c:choose> 

        <c:when test="${fn:length(author.getBooks()) == 0 }" >
            <h3>No Books</h3>
        </c:when>
        <c:otherwise>
            <h3>Book(s)</h3>
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
                            ISBN
                        </td>
                        <td>
                            Publisher
                        </td>
                    </tr>
                    <c:forEach var="book" items="${author.getBooks()}" varStatus="status">
                        <tr>
                            <td>
                                ${status.count}
                            </td>
                            <td>
                                <a href="<c:url value="/books/book/${book.id}" /> " >${book.title}</a>
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
        </c:otherwise>
    </c:choose>
</div>


<jsp:include page="footer.jsp" />