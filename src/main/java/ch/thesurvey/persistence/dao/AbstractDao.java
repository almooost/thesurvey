package ch.thesurvey.persistence.dao;

import ch.thesurvey.model.IModel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by sam on 23.10.16.
 */
public class AbstractDao implements IDao {

    @PersistenceContext
    protected EntityManager entityManager;

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
