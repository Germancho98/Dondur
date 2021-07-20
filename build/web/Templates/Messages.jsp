<%-- 
    Document   : Messages
    Created on : 29-jul-2017, 17:53:02
    Author     : Matthew
--%>


<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Util.MessageType"%>
<%@page import="Util.Messages"%>
<%

    if (session.getAttribute("Messages") != null) {
        List<Messages> messages;
        messages = (List<Messages>) session.getAttribute("Messages");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <script src="../Js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="../Js/materialize.min.js" type="text/javascript"></script>
    <script>

        <%
            if (messages != null && messages.size() > 0) {
                for (Messages msg : messages) {
                    if (msg.getLevel() == MessageType.Confirmation) {
        %>
            Materialize.toast('<%out.print(msg.getMessage());%>', 3000, 'rounded');

        <%
    } else if (msg.getLevel() == MessageType.Alert) {
        %>
        Materialize.toast('<%out.print(msg.getMessage());%>', 3000, 'rounded');

        <%
    } else if (msg.getLevel() == MessageType.Error) {
        %>
        Materialize.toast('<%out.print(msg.getMessage());%>', 3000, 'rounded');

        <%
                }
            }
        }
        %>

    </script>


    
</html>
<%
        session.setAttribute("Messages", null);
    }

%>