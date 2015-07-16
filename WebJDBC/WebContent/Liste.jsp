<%@ page import="com.loncoto.webfirstjdbc.beans.Client"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des clients</title>
</head>
<body>
<table border = 1>
<tr><th>Nom</th>
<th>Email</th><th>action</th></tr>
<%List<Client> clients = (List<Client>)request.getAttribute("client");
for (Client c : clients){%>
<tr><td><%=c.getNom()%></td>
<td><%=c.getEmail()%></td>
<td><form action="ClientServlet" method="post" >
<input type=hidden value=<%=c.getId()%>>
<input type=submit value="editer">
</form>
</td></tr>
<%}%>
</table>
</body>
</html>