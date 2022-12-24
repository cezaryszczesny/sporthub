package pl.studies.sporthub.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository
public class BaseRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public <E> E load(final Class<E> clazz, final Long id) {
        return entityManager.find(clazz, id);
    }

}
