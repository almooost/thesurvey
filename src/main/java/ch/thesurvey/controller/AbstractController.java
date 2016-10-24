package ch.thesurvey.controller;

import ch.thesurvey.model.IModel;
import ch.thesurvey.persistence.dao.IDao;

import java.util.List;

/**
 * Created by sam on 23.10.16.
 */
public class AbstractController implements IController{


    protected List<IModel> models;
    protected IDao dao;

    @Override
    public List<IModel> getModels() {
        return models;
    }

    @Override
    public IDao getDao() {
        return dao;
    }

    @Override
    public IModel get(IModel model) {
        if(models.contains(model)){
            for (IModel tempModel: models) {
                if(tempModel.equals(model))
                    return tempModel;
            }
        }
        return null;
    }

    @Override
    public boolean add(IModel model) {
        return models.add(model);

    }

    @Override
    public boolean update(IModel model) {
        IModel tempModel = get(model);
        if(tempModel != null){
            models.set(models.indexOf(tempModel), model);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(IModel model) {
        return models.remove(model);
    }
}
