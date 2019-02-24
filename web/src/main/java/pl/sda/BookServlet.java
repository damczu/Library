package pl.sda;

import pl.sda.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/BookServlet")
public class BookServlet extends HttpServlet {

    private final BookService bookService;

    public BookServlet(BookService bookService) {
        this.bookService = bookService;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        bookService.getBooksDtoWithOffset(0,15);
    }
}
