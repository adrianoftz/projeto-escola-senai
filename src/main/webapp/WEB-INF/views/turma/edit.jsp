<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"></jsp:include>

<div class="container">

    <br/>
    <h3 align="center">Editar Turma</h3>
    <form action='/turma/update' method='post'>

        <table class='table'>

            <tr>
                <td><b>Periodo</b></td>
                <td><input type='text' name='periodo' class='form-control' value="${turma.periodo}"/></td>
            </tr>

            <tr>
                <td><b>Número</b></td>
                <td><input type='number' name='numero' class='form-control' value="${turma.numero}"/></td>
            </tr>

            <input type='hidden' id='id' rows='5' class='form-control' name='id' value="${turma.id}"/>

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