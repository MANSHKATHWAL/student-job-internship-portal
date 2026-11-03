
<%@ include file="header.jspf" %>

<h1>Available Jobs & Internships</h1>

<div class="job-grid">

<%
java.sql.ResultSet rs =
    (java.sql.ResultSet)request.getAttribute("jobs");

while(rs.next()) {
%>

    <div class="job-card">

        <span class="tag">
            <%= rs.getString("job_type") %>
        </span>

        <h2>
            <%= rs.getString("title") %>
        </h2>

        <h4>
            <%= rs.getString("company") %>
        </h4>

        <p>
            Location:
            <%= rs.getString("location") %>
        </p>

        <p>
            <%= rs.getString("description") %>
        </p>

        <p>
            Eligibility:
            <%= rs.getString("eligibility") %>
        </p>

        <form method="post"
        action="${pageContext.request.contextPath}/portal">

            <input type="hidden"
            name="action"
            value="apply">

            <input type="hidden"
            name="jobId"
            value="<%= rs.getInt("id") %>">

            <button class="btn">
                Apply Now
            </button>

        </form>

    </div>

<%
}
rs.close();
%>

</div>

<%@ include file="footer.jspf" %>

