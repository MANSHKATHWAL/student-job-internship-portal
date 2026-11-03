
package com.aip.portal;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.*;

@WebServlet("/portal")
public class PortalServlet extends HttpServlet {

    private void openPage(
            HttpServletRequest req,
            HttpServletResponse res,
            String page)
            throws ServletException, IOException {

        req.getRequestDispatcher(
            "/WEB-INF/views/" + page + ".jsp"
        ).forward(req, res);
    }

    private boolean isLoggedIn(HttpServletRequest req) {

        HttpSession session = req.getSession(false);

        return session != null &&
            session.getAttribute("userId") != null;
    }

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse res)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if (action == null || action.equals("home")) {
            openPage(req, res, "home");
            return;
        }

        if (action.equals("register")) {
            openPage(req, res, "register");
            return;
        }

        if (action.equals("login")) {
            openPage(req, res, "login");
            return;
        }

        if (action.equals("logout")) {
            req.getSession().invalidate();
            res.sendRedirect(
                req.getContextPath() + "/portal"
            );
            return;
        }

        if (!isLoggedIn(req)) {
            res.sendRedirect(
                req.getContextPath() + "/portal?action=login"
            );
            return;
        }

        if (action.equals("dashboard")) {

            try (Connection con = DB.getConnection()) {

                Statement st = con.createStatement();

                ResultSet rs = st.executeQuery(
                    "SELECT COUNT(*) FROM jobs"
                );

                rs.next();

                req.setAttribute(
                    "jobCount", rs.getInt(1)
                );

                PreparedStatement ps = con.prepareStatement(
                    "SELECT COUNT(*) FROM applications WHERE student_id=?"
                );

                ps.setInt(1,
                    (Integer) req.getSession()
                    .getAttribute("userId")
                );

                rs = ps.executeQuery();
                rs.next();

                req.setAttribute(
                    "applicationCount", rs.getInt(1)
                );

            } catch (SQLException e) {
                throw new ServletException(e);
            }

            openPage(req, res, "dashboard");
            return;
        }

        if (action.equals("jobs")) {

            try (Connection con = DB.getConnection()) {

                PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM jobs ORDER BY posted_on DESC"
                );

                ResultSet rs = ps.executeQuery();

                req.setAttribute("jobs", rs);

                openPage(req, res, "jobs");
                return;

            } catch (SQLException e) {
                throw new ServletException(e);
            }
        }

        if (action.equals("applications")) {

            try (Connection con = DB.getConnection()) {

                PreparedStatement ps = con.prepareStatement(
                    "SELECT a.id,a.status,a.applied_on," +
                    "j.title,j.company FROM applications a " +
                    "JOIN jobs j ON a.job_id=j.id " +
                    "WHERE a.student_id=?"
                );

                ps.setInt(1,
                    (Integer) req.getSession()
                    .getAttribute("userId")
                );

                req.setAttribute(
                    "applications", ps.executeQuery()
                );

                openPage(req, res, "applications");
                return;

            } catch (SQLException e) {
                throw new ServletException(e);
            }
        }

        if (action.equals("admin")) {
            openPage(req, res, "admin");
            return;
        }

        res.sendRedirect(
            req.getContextPath() + "/portal?action=dashboard"
        );
    }

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String action = req.getParameter("action");

        try (Connection con = DB.getConnection()) {

            // STUDENT REGISTRATION

            if ("register".equals(action)) {

                PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO students(name,email,password,course) VALUES(?,?,?,?)"
                );

                ps.setString(1, req.getParameter("name"));
                ps.setString(2, req.getParameter("email"));
                ps.setString(3, req.getParameter("password"));
                ps.setString(4, req.getParameter("course"));

                ps.executeUpdate();

                res.sendRedirect(
                    req.getContextPath() +
                    "/portal?action=login&registered=1"
                );

                return;
            }

            // STUDENT LOGIN

            if ("login".equals(action)) {

                PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM students WHERE email=? AND password=?"
                );

                ps.setString(1, req.getParameter("email"));
                ps.setString(2, req.getParameter("password"));

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {

                    HttpSession session = req.getSession();

                    session.setAttribute(
                        "userId", rs.getInt("id")
                    );

                    session.setAttribute(
                        "userName", rs.getString("name")
                    );

                    res.sendRedirect(
                        req.getContextPath() +
                        "/portal?action=dashboard"
                    );

                } else {

                    res.sendRedirect(
                        req.getContextPath() +
                        "/portal?action=login&error=1"
                    );
                }

                return;
            }

            // OTHER ACTIONS REQUIRE LOGIN

            if (!isLoggedIn(req)) {
                res.sendRedirect(
                    req.getContextPath() +
                    "/portal?action=login"
                );
                return;
            }

            // APPLY FOR JOB

            if ("apply".equals(action)) {

                PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO applications(student_id,job_id) VALUES(?,?)"
                );

                ps.setInt(1,
                    (Integer) req.getSession()
                    .getAttribute("userId")
                );

                ps.setInt(2,
                    Integer.parseInt(req.getParameter("jobId"))
                );

                ps.executeUpdate();

                res.sendRedirect(
                    req.getContextPath() +
                    "/portal?action=applications"
                );

                return;
            }

            // ADD JOB

            if ("addJob".equals(action)) {

                PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO jobs(title,company,location,job_type,description,eligibility) VALUES(?,?,?,?,?,?)"
                );

                ps.setString(1, req.getParameter("title"));
                ps.setString(2, req.getParameter("company"));
                ps.setString(3, req.getParameter("location"));
                ps.setString(4, req.getParameter("jobType"));
                ps.setString(5, req.getParameter("description"));
                ps.setString(6, req.getParameter("eligibility"));

                ps.executeUpdate();

                res.sendRedirect(
                    req.getContextPath() +
                    "/portal?action=jobs"
                );

                return;
            }

        } catch (SQLException e) {

            throw new ServletException(
                "Database error: " + e.getMessage(), e
            );
        }
    }
}
