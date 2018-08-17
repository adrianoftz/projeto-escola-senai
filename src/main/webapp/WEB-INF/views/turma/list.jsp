<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"></jsp:include>

<br/>
<h3 align="center">Turmas</h3>
<br>
<c:choose>
    <c:when test="${teste}">
        <div class="alert alert-primary" role="alert" align="center">
            Nenhum registro de Turma encontrado!
        </div>
    </c:when>
    <c:otherwise>
        <table class="table table-hover">

            <thead>
            <tr>
                <th><b>Turma</b></th>
                <th><b>Periodo</b></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="turma">
                <tr>
                    <td><c:out value="${turma.numero}"></c:out></td>
                    <td><c:out value="${turma.periodo}"></c:out></td>

                    <td class="text-right">
                        <a href="/turma/${turma.id}/edit">
                            <button type="submit" class="btn btn-primary">Editar</button>
                        </a>
                        <a href="/turma/${turma.id}/delete">
                            <button type="submit" class="btn btn-primary">Excluir</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>
</div>

<jsp:include page="../footer.jsp"></jsp:include>