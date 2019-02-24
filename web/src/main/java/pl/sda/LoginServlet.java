package pl.sda;

import pl.sda.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    private final UserService userService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession(true);
//        httpSession.setAttribute("USER", );
        boolean login = userService.loginUser(request.getParameter("login"),request.getParameter("password").toCharArray());
        if (login){
            request.getRequestDispatcher("/userPage.jsp").include(request, response);
        }else{
            request.getRequestDispatcher("/index.jsp").include(request,response);
        }
    }




}
