package pl.studies.sporthub.service;

public interface BaseApplicationService<D extends AbstractDto> {

    Long add(final D dto);

    D load(final Long id);

    void delete(final Long id);

    void update(final D dto);

}
