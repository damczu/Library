package pl.sda;

import pl.sda.domain.model.dto.BookDto;
import pl.sda.service.BookService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/BookServlet")
public class BookServlet extends HttpServlet {

    private final BookService bookService;

    public BookServlet(BookService bookService) {
        this.bookService = bookService;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer page = Integer.parseInt(request.getParameter("page"));
        if (page == null) {
            page = 1;
        }
        List<BookDto> bookDtos = bookService.getBooksDtoWithOffset((page - 1) * 15, 15);

        request.setAttribute("booksDtos", bookDtos);
        request.getRequestDispatcher("/adminPage.jsp").forward(request,response);
    }
}
