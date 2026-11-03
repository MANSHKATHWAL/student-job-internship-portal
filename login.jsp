
<%@ include file="header.jspf" %>

<div class="form-card">

    <h2>Student Login</h2>

    <% if(request.getParameter("error") != null) { %>
        <p style="color:red">
            Invalid email or password!
        </p>
    <% } %>

    <% if(request.getParameter("registered") != null) { %>
        <p style="color:green">
            Registration successful. Please login.
        </p>
    <% } %>

    <form action="${pageContext.request.contextPath}/portal"
          method="post">

        <input type="hidden"
               name="action"
               value="login">

        <label>Email</label>
        <input type="email"
               name="email"
               required>

        <label>Password</label>
        <input type="password"
               name="password"
               required>

        <button class="btn" type="submit">
            Login
        </button>

    </form>

</div>

<%@ include file="footer.jspf" %>


