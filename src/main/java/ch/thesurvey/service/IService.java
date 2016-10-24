package ch.thesurvey.service;

import ch.thesurvey.model.IModel;

import java.util.List;

/**
 * Created by sam on 23.10.16.
 */
public interface IService {

    void add(IModel model);

    IModel findById(Integer id);

    List<IModel> findAll();

    boolean update(IModel model);

    boolean remove(Integer id);
}
