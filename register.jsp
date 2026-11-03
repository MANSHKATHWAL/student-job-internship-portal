
<%@ include file="header.jspf" %>

<div class="form-card">

    <h2>Student Registration</h2>

    <form action="${pageContext.request.contextPath}/portal"
          method="post">

        <input type="hidden"
               name="action"
               value="register">

        <label>Full Name</label>
        <input type="text"
               name="name"
               required>

        <label>Email</label>
        <input type="email"
               name="email"
               required>

        <label>Password</label>
        <input type="password"
               name="password"
               minlength="6"
               required>

        <label>Course</label>
        <input type="text"
               name="course"
               placeholder="BCA / MCA / B.Tech"
               required>

        <button class="btn" type="submit">
            Register
        </button>

    </form>

    <p>
        Already registered?
        <a href="${pageContext.request.contextPath}/portal?action=login">
            Login
        </a>
    </p>

</div>

<%@ include file="footer.jspf" %>

