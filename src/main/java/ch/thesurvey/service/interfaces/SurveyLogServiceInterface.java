package ch.thesurvey.service.interfaces;

import ch.thesurvey.model.interfaces.SurveyLogInterface;

import java.util.List;

/**
 * Interface for survey log service
 * dao abstraction
 * @author Samuel Alfano
 * @date 22.11.2016
 * @version v0.1
 */
public interface SurveyLogServiceInterface{

    SurveyLogInterface findById(Integer id);

    List<SurveyLogInterface> findAll(SurveyLogInterface model);

    void persist(SurveyLogInterface model);

    void remove(SurveyLogInterface model);
}
