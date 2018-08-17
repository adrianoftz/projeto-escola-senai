<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"></jsp:include>

<br/>
<h3 align="center">Cadastro de Turma</h3>
<br>
<form action='/turma/add' method='post'>

    <table class='table'>

        <tr>
            <td><b>Periodo</b></td>
            <td><input type='text' name='periodo' class='form-control' required/></td>
        </tr>

        <tr>
            <td><b>Numero</b></td>
            <td><input type='number' name='numero' class='form-control' required/></td>
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