
<%@ include file="header.jspf" %>

<h1>
    Welcome, <%= session.getAttribute("userName") %>!
</h1>

<p>Student Dashboard</p>

<div class="stats">

    <div class="stat">
        <h3>Available Jobs</h3>

        <strong>
            <%= request.getAttribute("jobCount") %>
        </strong>
    </div>

    <div class="stat">
        <h3>My Applications</h3>

        <strong>
            <%= request.getAttribute("applicationCount") %>
        </strong>
    </div>

    <div class="stat">
        <h3>Account</h3>
        <strong>Active</strong>
    </div>

</div>

<div class="panel">

    <h2>Quick Actions</h2>

    <p>
        <a class="btn"
        href="${pageContext.request.contextPath}/portal?action=jobs">
            Find Jobs
        </a>
    </p>

    <p>
        <a class="btn"
        href="${pageContext.request.contextPath}/portal?action=applications">
            My Applications
        </a>
    </p>

    <p>
        <a class="btn"
        href="${pageContext.request.contextPath}/portal?action=admin">
            Add Job (Demo Admin)
        </a>
    </p>

</div>

<%@ include file="footer.jspf" %>

