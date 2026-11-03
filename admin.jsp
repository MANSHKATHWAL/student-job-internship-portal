
<%@ include file="header.jspf" %>

<div class="form-card wide">

    <h2>Add New Job / Internship</h2>

    <form action="${pageContext.request.contextPath}/portal"
          method="post">

        <input type="hidden"
               name="action"
               value="addJob">

        <label>Job Title</label>
        <input type="text" name="title" required>

        <label>Company Name</label>
        <input type="text" name="company" required>

        <label>Location</label>
        <input type="text" name="location" required>

        <label>Job Type</label>
        <select name="jobType">
            <option>Job</option>
            <option>Internship</option>
        </select>

        <label>Description</label>
        <textarea name="description" required></textarea>

        <label>Eligibility</label>
        <input type="text" name="eligibility" required>

        <button class="btn">
            Add Listing
        </button>

    </form>

</div>

<%@ include file="footer.jspf" %>

