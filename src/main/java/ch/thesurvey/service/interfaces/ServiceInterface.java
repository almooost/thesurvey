package ch.thesurvey.service.interfaces;

import ch.thesurvey.model.interfaces.ModelInterface;

import java.util.List;

/**
 * General service interface
 * @author Samuel Alfano
 * @date 11.11.2016
 * @version v0.1
 */
public interface ServiceInterface {

    ModelInterface findById(Integer id);

    List<ModelInterface> findAll(ModelInterface model);

    void persist(ModelInterface model);

    void remove(ModelInterface model);
}
