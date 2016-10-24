package ch.thesurvey.persistence.dao;

import ch.thesurvey.model.IModel;

import java.util.List;

/**
 * Created by sam on 23.10.16.
 */
public interface IDao {

    void add(IModel model);

    IModel findById(Integer id);

    List<IModel> findAll();

    boolean update(IModel model);

    boolean remove(Integer id);
}
