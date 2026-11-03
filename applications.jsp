
<%@ include file="header.jspf" %>

<h1>My Applications</h1>

<div class="panel">

<table>

    <tr>
        <th>Job Title</th>
        <th>Company</th>
        <th>Applied Date</th>
        <th>Status</th>
    </tr>

<%
java.sql.ResultSet rs =
    (java.sql.ResultSet)request.getAttribute("applications");

while(rs.next()) {
%>

    <tr>

        <td>
            <%= rs.getString("title") %>
        </td>

        <td>
            <%= rs.getString("company") %>
        </td>

        <td>
            <%= rs.getTimestamp("applied_on") %>
        </td>

        <td>
            <span class="tag">
                <%= rs.getString("status") %>
            </span>
        </td>

    </tr>

<%
}
rs.close();
%>

</table>

</div>

<%@ include file="footer.jspf" %>

