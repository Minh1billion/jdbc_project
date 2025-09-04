package vn.iotstar.controller;
import vn.iotstar.service.UserService;
import vn.iotstar.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;


@WebServlet("/forgot-password")
public class ForgotPasswordController extends HttpServlet {
    private UserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/views/forgot-password.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String email = req.getParameter("email");
        String newPassword = req.getParameter("newPassword");

        String alertMsg = "";

        if (!service.checkExistEmail(email)) {
            alertMsg = "Email không tồn tại!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/forgot-password.jsp").forward(req, resp);
            return;
        }

        boolean success = service.updatePassword(email, newPassword);
        if (success) {
            resp.sendRedirect(req.getContextPath() + "/login?msg=reset_success");
        } else {
            alertMsg = "Có lỗi xảy ra!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/forgot-password.jsp").forward(req, resp);
        }
    }
}

