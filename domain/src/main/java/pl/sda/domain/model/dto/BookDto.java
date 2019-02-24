package pl.sda.domain.model.dto;

import pl.sda.domain.model.Category;

import java.util.List;

public class BookDto {
    public String title;
    public String author;
    public List<Integer> authorIdList;
    public String isbn;
    public Category category;
}
