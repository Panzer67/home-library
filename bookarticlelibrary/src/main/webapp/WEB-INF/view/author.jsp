<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />

<div class="wrapper">
    <h2>Author</h2>

    <table border="1">

        <th>Author</th>	        			        	
        <th>Actions</th>   
        <tr>				        		
            <td>${author.firstname}&nbsp;${author.lastname}</td>								
            <td>
                <a href="<c:url value="editauthor/${author.id}" /> ">Edit</a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="<c:url value="deleteauthor/${author.id}" /> ">Delete</a>
            </td>
        </tr>

    </table>				      
    <c:choose>
        <c:when test="${fn:length(author.getArticles()) == 0 }">
            <h3>No Articles</h3>
        </c:when>
        <c:otherwise>
            <h3>Article(s)</h3>
            <table border="1">
                <th>No.</th>
                <th>Title</th>
                <th>Journal</th>
                <th>Volume</th>
                <th>Issue</th>
                <th>Year</th>
                <th>Pages</th>
                    <c:forEach var="article" items="${author.getArticles()}" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td><a href="<c:url value="/articles/article/${article.id}" />" >${article.title}</a></td>
                        <td>${article.getJournal().journal_name}</td>
                        <td>${article.volume}</td>
                        <td>${article.issue}</td>
                        <td>${article.year}</td>
                        <td>${article.pages}</td>
                    </tr>
                </c:forEach> 
            </table>
        </c:otherwise>
    </c:choose>
    <c:choose> 

        <c:when test="${fn:length(author.getBooks()) == 0 }" >
            <h3>No Books</h3>
        </c:when>
        <c:otherwise>
            <h3>Book(s)</h3>
            <table border="1">
                <th>No</th>
                <th>Title</th>			        			
                <th>ISBN</th>
                <th>Publisher</th>  
                    <c:forEach var="book" items="${author.getBooks()}" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td><a href="<c:url value="/books/book/${book.id}" /> " >${book.title}</a></td>
                        <td>${book.isbn}</td>
                        <td>${book.publisher}</td>						      				
                    </tr>
                </c:forEach> 
            </table>
        </c:otherwise>

    </c:choose>
</div>


<jsp:include page="footer.jsp" />