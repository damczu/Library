package pl.sda;

import pl.sda.domain.model.dto.UserAddDto;
import pl.sda.service.UserService;
import pl.sda.service.exception.LoginExistsException;
import pl.sda.service.exception.PersonDataNotCreatedException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private final UserService userService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession(true);
        httpSession.setAttribute("USER", newUser(request));
        request.getRequestDispatcher("/userPage.jsp").forward(request, response);
    }

    private Integer newUser(HttpServletRequest httpRequest) {
        UserAddDto userAddDto = new UserAddDto();
        userAddDto.setFirstName(httpRequest.getParameter("firstName"));
        userAddDto.setLastName(httpRequest.getParameter("lastName"));
        userAddDto.setEmail(httpRequest.getParameter("email"));
        userAddDto.setPhone(httpRequest.getParameter("phone"));
        userAddDto.setLogin(httpRequest.getParameter("login"));
        userAddDto.setPassword(httpRequest.getParameter("password").toCharArray());
        try {
            return userService.addUser(userAddDto);
        } catch (LoginExistsException e) {
            e.printStackTrace();
        } catch (PersonDataNotCreatedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
