
<%@ include file="header.jspf" %>

<section class="hero">

    <div>
        <h1>
            Find Your Next
            <span>Opportunity</span>
        </h1>

        <p>
            Discover jobs and internships.
            Apply online and track your
            applications in one place.
        </p>

        <a class="btn"
        href="${pageContext.request.contextPath}/portal?action=register">
            Get Started
        </a>

        <a class="btn"
        href="${pageContext.request.contextPath}/portal?action=login">
            Login
        </a>
    </div>

    <div class="hero-card">

        <h2>CareerConnect</h2>

        <h3>Your Career Journey</h3>

        <p>Explore opportunities.</p>
        <p>Apply for jobs.</p>
        <p>Build your future.</p>

    </div>

</section>

<section class="features">

    <div class="feature">
        <h3>Find Jobs</h3>
        <p>Explore available job opportunities.</p>
    </div>

    <div class="feature">
        <h3>Find Internships</h3>
        <p>Get practical industry experience.</p>
    </div>

    <div class="feature">
        <h3>Track Applications</h3>
        <p>Monitor your application status.</p>
    </div>

</section>

<%@ include file="footer.jspf" %>
