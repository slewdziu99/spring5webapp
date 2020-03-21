package pl.adam.guru.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.adam.guru.springframework.spring5webapp.domain.Publisher;

/**
 * Created by aslazinski on 2020-03-14.
 */
public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
