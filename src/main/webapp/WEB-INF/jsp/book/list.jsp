<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<p>List view</p>
<pre>
    <c:forEach items="${books}" var="book">
        ID: ${book.id}
        Name: ${book.name}
    </c:forEach>
</pre>
<p>foo</p>