package ch.thesurvey.service;

import ch.thesurvey.model.IModel;
import ch.thesurvey.persistence.dao.IDao;

import java.util.List;

/**
 * Created by sam on 23.10.16.
 */
public class AbstractService implements IService {

    protected IDao dao;

    public void setDao(IDao dao){
        this.dao = dao;
    }

    @Override
    public void add(IModel model) {
        dao.add(model);
    }

    @Override
    public IModel findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<IModel> findAll() {
        return dao.findAll();
    }

    @Override
    public boolean update(IModel model) {
        return dao.update(model);
    }

    @Override
    public boolean remove(Integer id) {
        return dao.remove(id);
    }
}
