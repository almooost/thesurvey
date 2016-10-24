package ch.thesurvey.controller;

import ch.thesurvey.model.IModel;
import ch.thesurvey.persistence.dao.IDao;

import java.util.List;

/**
 * Created by sam on 23.10.16.
 */
public interface IController {

    List<IModel> getModels();

    IDao getDao();

    IModel get(IModel model);

    boolean add(IModel model);

    boolean update(IModel model);

    boolean remove(IModel model);
}
