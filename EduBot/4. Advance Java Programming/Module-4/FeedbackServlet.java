import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String feedback = request.getParameter("feedback");

        if (name == null || name.isEmpty() || email == null || email.isEmpty() || feedback == null || feedback.isEmpty()) {
            request.setAttribute("errorMessage", "All fields are required.");
            request.getRequestDispatcher("feedbackForm.jsp").forward(request, response);
        } else {
            request.setAttribute("name", name);
            request.setAttribute("email", email);
            request.setAttribute("feedback", feedback);
            
            HttpSession session = request.getSession();
            session.setAttribute("successMessage", "Feedback submitted successfully!");

            request.getRequestDispatcher("displayFeedback.jsp").forward(request, response);
        }
    }
}
