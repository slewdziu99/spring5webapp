package pl.adam.guru.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.adam.guru.springframework.spring5webapp.domain.Author;

/**
 * Created by aslazinski on 2020-03-14.
 */
public interface AuthorRepository extends CrudRepository<Author,Long> {
}
