<%@page import="com.wellsneargo.model.Transaction"%>
<%@page import="java.util.List"%>
<%@page import="com.wellsneargo.dao.TransactionDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>

	List of Operations:
	<br>
	<ul>
		<li><a href="viewBalance.jsp"> View balance</a></li>
		<li><a href="depositAmount.jsp"> Deposit Amount</a></li>
		<li><a href="withdrawAmount.jsp"> Withdraw Amount</a></li>
	</ul>

	<%
		TransactionDaoImpl daoImpl = new TransactionDaoImpl();

		List<Transaction> txs = daoImpl.getTransactions();
		request.setAttribute("txs", txs);
	%>

	<table>
		<tbody>
			<tr>
				<th>Transaction ID</th>
				<th>Transaction Type</th>
				<th>Transaction Amount</th>
				<th>Transaction Time</th>
			</tr>
			<c:forEach items="${txs}" var="tx">
				<tr>
					<td><c:out value="${tx.transaction_no}"></c:out></td>
					<td><c:out value="${tx.transaction_type}"></c:out></td>
					<td><c:out value="${tx.transaction_amount}"></c:out></td>
					<td><c:out value="${tx.transaction_time}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>