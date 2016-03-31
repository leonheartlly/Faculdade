<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Produto</title>
</head>
<body>
<form action="incluiProduto" method="post">
<table>

	 <tr>
		<td>Valor do Vetor:
	</tr>
	<td><input type="text" name="valor" size="20"
		maxlength="10"></td>
	</tr>
	<!-- <tr>
		<td>Valor Unitário:
	</tr>
	<td><input type="text" name="txtValorUnitario" size="20"
		maxlength="10"></td>
	</tr>
	<tr>-->
		<td><input type="submit" value="Salvar"></td>
		<td><input type="reset" value="Limpar"></td>
	</tr>

</table>

</form>
</body>
</html>