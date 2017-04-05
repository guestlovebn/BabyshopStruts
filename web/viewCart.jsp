<%-- 
    Document   : viewCart
    Created on : Apr 4, 2017, 11:09:29 AM
    Author     : FIA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello</h1>
        <table>
            <s:iterator value="product" var="p">
                <tr>
                    <td><s:property value="name"/></td>
                    <td><s:property value="price"/></td>
                </tr>
            </s:iterator>
        </table>
        <p>Total: <s:property value="totalAmount"/></p>
        <a href="index.jsp">Continue</a>
    </body>
</html>
