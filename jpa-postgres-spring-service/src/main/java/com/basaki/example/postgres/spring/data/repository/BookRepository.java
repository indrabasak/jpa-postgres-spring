package com.basaki.example.postgres.spring.data.repository;

import com.basaki.example.postgres.spring.data.entity.BookEntity;
import com.basaki.example.postgres.spring.model.Genre;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

/**
 * {@code BookRepository} exposes all CRUD operations on a data of type
 * {@code Book}.
 * <p/>
 *
 * @author Indra Basak
 * @since 3/8/17
 */
public interface BookRepository extends CrudRepository<BookEntity, UUID> {

    List<BookEntity> findByTitleIgnoreCase(String title);

    List<BookEntity> findByTitleIgnoreCaseAndAuthorIgnoreCase(String title,
            String author);

    List<BookEntity> findByTitleIgnoreCaseAndAuthorIgnoreCaseAndGenre(
            String title,
            String author,
            Genre genre);

    List<BookEntity> findByTitleIgnoreCaseAndGenre(String title, Genre genre);

    List<BookEntity> findByAuthorIgnoreCase(String author);

    List<BookEntity> findByAuthorIgnoreCaseAndGenre(String author, Genre genre);

    List<BookEntity> findByGenre(Genre genre);
}
