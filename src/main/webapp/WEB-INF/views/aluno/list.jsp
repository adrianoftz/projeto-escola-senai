<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"></jsp:include>

<br/>
<h3 align="center">Alunos</h3>
<br>
<c:choose>
    <c:when test="${teste}">
        <div class="alert alert-primary" role="alert" align="center">
            Nenhum registro de Aluno encontrado!
        </div>
    </c:when>
    <c:otherwise>
        <table class="table table-hover">

            <thead>
            <tr>
                <th><b>Nome</b></th>
                <th><b>Matricula</b></th>
                <th><b>Data de Nascimento</b></th>
                <th class="text-center"><b>Turma</b></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="aluno">
                <tr>
                    <td><c:out value="${aluno.nome}"></c:out></td>
                    <td><c:out value="${aluno.matricula}"></c:out></td>
                    <td><c:out value="${aluno.dataNascimento}"></c:out></td>
                    <td class="text-center"><c:out value="${aluno.turma.numero} - ${aluno.turma.periodo}"></c:out></td>

                    <td class="text-right">
                        <a href="/aluno/${aluno.id}/edit">
                            <button type="submit" class="btn btn-primary">Editar</button>
                        </a>
                        <a href="/aluno/${aluno.id}/delete">
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