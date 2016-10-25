package ch.thesurvey.persistence.dao;

import ch.thesurvey.model.IModel;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Abstract class for daos
 * implements IDao
 * @author Samuel Alfano
 * @date 25.10.2016
 * @version v0.1
 */
abstract class AbstractDao implements IDao {


    @Override
    public void add(IModel model) {
        
    }

    @Override
    public IModel findById(Integer id) {
        return null;
    }

    @Override
    public List<IModel> findAll() {return null;}

    @Override
    public boolean update(IModel model) {
        return false;
    }

    @Override
    public boolean remove(Integer id) {
        return false;
    }
}
