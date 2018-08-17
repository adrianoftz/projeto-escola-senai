<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"></jsp:include>

<div class="container">

    <br/>
    <h3 align="center">Editar Aluno</h3>
    <form action='/aluno/update' method='post'>

        <table class='table'>

            <tr>
                <td><b>Nome</b></td>
                <td><input type='text' name='nome' class='form-control' value="${aluno.nome}"/></td>
            </tr>

            <tr>
                <td><b>Matricula</b></td>
                <td><input type='number' name='matricula' class='form-control' value="${aluno.matricula}"/></td>
            </tr>

            <tr>
                <td width="200"><b>Data de Nascimento</b></td>
                <td><input type='date' name='dataNascimento' class='form-control' size="20"
                           value="${aluno.dataNascimento}"/></td>
            </tr>

            <tr>
                <td><b>Turma</b></td>
                <td>
                    <select id="turma" name="turma" class="custom-select">
                        <option>Escolha uma Turma</option>
                        <c:forEach items="${turmas}" var="turma">
                            <c:choose>
                                <c:when test="${aluno.turma.id == turma.id}">
                                    <option value="${turma.id}" selected>${turma.numero} - ${turma.periodo}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${turma.id}">${turma.numero} - ${turma.periodo}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>

            </tr>

            <input type='hidden' id='id' rows='5' class='form-control' name='id' value="${aluno.id}"/>

            <tr>
                <td></td>
                <td>
                    <button type="submit" class="btn btn-primary">Salvar</button>
                </td>
            </tr>

        </table>
    </form>


</div>

<jsp:include page="../footer.jsp"></jsp:include>