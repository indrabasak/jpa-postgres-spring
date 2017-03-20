package com.basaki.example.postgres.spring.service;

import com.basaki.example.postgres.spring.data.entity.BookEntity;
import com.basaki.example.postgres.spring.data.repository.BookRepository;
import com.basaki.example.postgres.spring.error.DataNotFoundException;
import com.basaki.example.postgres.spring.error.InvalidSearchException;
import com.basaki.example.postgres.spring.model.Book;
import com.basaki.example.postgres.spring.model.BookRequest;
import com.basaki.example.postgres.spring.model.Genre;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * {@code BookService} service provides data access service for {@code Book}.
 * <p/>
 *
 * @author Indra Basak
 * @sice 3/8/17
 */
@Service
@Slf4j
public class BookService {

    @Autowired
    private BookRepository repo;

    private Mapper mapper;

    @Autowired
    public BookService(BookRepository repo, Mapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public Book create(BookRequest request) {
        Assert.notNull(request.getTitle(), "Title can't be null!");
        Assert.notNull(request.getAuthor(), "Author can't be null!");
        Assert.notNull(request.getGenre(), "Genre can't be null!");

        BookEntity entity = mapper.map(request, BookEntity.class);
        entity = repo.save(entity);
        Book book = mapper.map(entity, Book.class);

        return book;
    }

    public Book getById(UUID id) {
        BookEntity entity = repo.findOne(id);
        Book book = mapper.map(entity, Book.class);

        return book;
    }

    public List<Book> get(String title, String author, Genre genre) {
        if (title != null && author == null && genre == null) {
            return map(repo.findByTitleIgnoreCase(title));
        } else if (title != null && author != null && genre == null) {
            return map(repo.findByTitleIgnoreCaseAndAuthorIgnoreCase(title, author));
        } else if (title != null && author != null && genre != null) {
            return map(repo.findByTitleIgnoreCaseAndAuthorIgnoreCaseAndGenre(title, author, genre));
        } else if (title == null && author != null && genre == null) {
            return map(repo.findByAuthorIgnoreCase(author));
        } else if (title == null && author != null && genre != null) {
            return map(repo.findByAuthorIgnoreCaseAndGenre(author, genre));
        } else if (title != null && author == null && genre != null) {
            return map(repo.findByTitleIgnoreCaseAndGenre(title, genre));
        } else if (title == null && author == null && genre != null) {
            return map(repo.findByGenre(genre));
        } else {
            throw new InvalidSearchException(
                    "Specify at least one search critera!");
        }
    }

    public void delete(UUID id) {
        repo.delete(id);
    }

    public void deleteAll() {
        repo.deleteAll();
    }

    private List<Book> map(List<BookEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            throw new DataNotFoundException(
                    "No books found with the search criteria!");
        }

        return entities.stream().map(
                r -> mapper.map(r, Book.class)).collect(
                Collectors.toList());
    }
}
