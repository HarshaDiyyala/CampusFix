package com.campusfix.servlet;

import java.io.IOException;
import com.campusfix.model.Issue;
import com.campusfix.store.IssueStore;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/home"})
public class CampusFixServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("issues", IssueStore.all());
        request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if ("report".equals(action)) {
            String name = clean(request.getParameter("name"));
            String email = clean(request.getParameter("email"));
            String category = clean(request.getParameter("category"));
            String location = clean(request.getParameter("location"));
            String description = clean(request.getParameter("description"));
            if (name.isBlank() || email.isBlank() || category.isBlank() || location.isBlank() || description.isBlank()) {
                request.setAttribute("error", "Please complete every field before submitting.");
                request.setAttribute("issues", IssueStore.all());
                request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
                return;
            }
            Issue issue = IssueStore.add(name, email, category, location, description);
            response.sendRedirect(request.getContextPath() + "/home?submitted=" + issue.getId());
            return;
        }
        if ("update".equals(action)) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                Issue issue = IssueStore.find(id);
                if (issue != null) {
                    String status = request.getParameter("status");
                    if ("Reported".equals(status) || "In Progress".equals(status) || "Resolved".equals(status)) {
                        issue.setStatus(status);
                    }
                    issue.setAdminNote(clean(request.getParameter("note")));
                }
            } catch (Exception ignored) { }
            response.sendRedirect(request.getContextPath() + "/home?view=admin");
            return;
        }
        response.sendRedirect(request.getContextPath() + "/home");
    }

    private String clean(String value) { return value == null ? "" : value.trim(); }
}
