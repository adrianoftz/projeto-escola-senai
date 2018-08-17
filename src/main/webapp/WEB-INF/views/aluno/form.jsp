<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"></jsp:include>

<br/>
<h3 align="center">Cadastro de Aluno</h3>
<br>
<form action='/aluno/add' method='post'>

    <table class='table'>

        <tr>
            <td><b>Nome</b></td>
            <td><input type='text' name='nome' class='form-control' required/></td>
        </tr>

        <tr>
            <td><b>Matricula</b></td>
            <td><input type='number' name='matricula' class='form-control' required/></td>
        </tr>

        <tr>
            <td><b>Data de Nascimento</b></td>
            <td><input type='text' name='dataNascimento' class='form-control' size="20" required/></td>

        </tr>

        <tr>
            <td><b>Turma</b></td>
            <td>
                <select id="turma" name="turma" class="custom-select">
                    <option>Escolha uma Turma</option>
                    <c:forEach items="${turmas}" var="turma">
                        <option value="${turma.id}">${turma.numero} - ${turma.periodo}</option>
                    </c:forEach>
                </select>
            </td>

        </tr>


        <tr>
            <td></td>
            <td>
                <button type="submit" class="btn btn-primary float-right">Cadastrar</button>
            </td>
        </tr>

    </table>
    <b><c:out value="${mensage}"></c:out></b>
</form>

</div>

<jsp:include page="../footer.jsp"></jsp:include>