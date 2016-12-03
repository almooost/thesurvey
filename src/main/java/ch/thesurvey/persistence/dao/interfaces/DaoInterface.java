package ch.thesurvey.persistence.dao.interfaces;

import ch.thesurvey.model.interfaces.ModelInterface;

import java.util.List;

/**
 * General dao interface, serves basic methods for every dao class
 * @author Samuel Alfano
 * @date 25.10.2016
 * @version v0.1
 */
public interface DaoInterface {

    ModelInterface findById(Integer id);

    List<ModelInterface> findAll(ModelInterface model );

    void persist(ModelInterface model);

    void remove(ModelInterface model);
}
