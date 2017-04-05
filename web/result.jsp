<%-- 
    Document   : result
    Created on : Apr 4, 2017, 11:11:34 AM
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
        <h1>Hello </h1>
        <table>
            <s:iterator value="products" var="p">
                <tr>
                    <td><s:property value="id"/></td>
                    <td><s:property value="name"/></td>
                    <td><s:property value="price"/></td>
                    <td><a href="addToCart?productId=<s:property value="id"/>">Add</td>
                </tr>
            </s:iterator>
        </table>
    </body>
</html>
