package ch.thesurvey.persistence.dao.interfaces;

import ch.thesurvey.model.interfaces.ModelInterface;

import java.util.List;

/**
 * Created by sam on 11.11.16.
 */
public interface DaoInterface {

    ModelInterface findById(Integer id);

    List<ModelInterface> findAll(ModelInterface model );

    void persist(ModelInterface model);

    void remove(ModelInterface model);
}
