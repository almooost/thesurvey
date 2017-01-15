package ch.thesurvey.controller;

import ch.thesurvey.model.Evaluation;
import ch.thesurvey.model.interfaces.EvaluationInterface;
import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.service.interfaces.EvaluationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Serves paths for evaluations
 * @author Samuel Alfano
 * @date 28.10.2016
 * @version v0.2
 */
@Controller
@RequestMapping(value = "/app/evaluations/")
public class EvaluationController {

    @Autowired
    EvaluationServiceInterface evaluationService;

    List<ModelInterface> evaluationList;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getSurvey(ModelMap model,
                            HttpSession httpSession){

        evaluationList = evaluationService.findAll(new Evaluation());

        model.addAttribute("evaluationList", evaluationList);
        model.addAttribute("site","evaluation");
        return "index";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editEvaluation(@RequestParam(value = "id", required = true, defaultValue = "")String id,
                               ModelMap model,
                               HttpSession httpSession){

        ModelInterface evaluation = null;

        if(id.matches("^[\\d+]$")) {
            evaluation = evaluationService.findById(Integer.parseInt(id));
        }

        model.addAttribute("evaluation", evaluation);
        model.addAttribute("site","evaluation_edit");
        return "index";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newEvaluation(ModelMap model,
                            HttpSession httpSession){

        Evaluation evaluation = new Evaluation();

        model.addAttribute("evaulation",evaluation);

        model.addAttribute("site", "evaluation_new");
        return "index";
    }

    @RequestMapping(value = "/persist", method = RequestMethod.POST)
    public String addEvaluation(@ModelAttribute Evaluation evaluation,
                            ModelMap model,
                            HttpSession httpSession){

        evaluation.setStatus(1);
        evaluationService.persist(evaluation);
        evaluationList = evaluationService.findAll(new Evaluation());

        httpSession.setAttribute("info", "Auswertung gespeichert.");

        model.addAttribute("site", "evaluations");
        model.addAttribute("id", evaluation.getId());
        model.addAttribute("name", evaluation.getName());

        model.addAttribute("evaluationList", evaluationList);
        return "redirect:/surveys/evaluations";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteEvaluation(@RequestParam(value = "id", required = true) String id,
                               ModelMap model,
                               HttpSession httpSession){

        ModelInterface evaluation = evaluationService.findById(Integer.parseInt(id));

        if (evaluation instanceof EvaluationInterface && evaluation.getName() != null) {
            evaluationService.remove(evaluation);
            httpSession.setAttribute("info", "Auswertung gelöscht");
        } else
            httpSession.setAttribute("info", "Auswertung konnte nicht gelöscht werden!");

        evaluationList = evaluationService.findAll(new Evaluation());

        model.addAttribute("site", "evaluations");
        model.addAttribute("evaluationList",evaluationList);
        return "redirect:";
    }

    @RequestMapping(value = "/download/{id}", produces = "text/csv")
    public void downloadCSV(HttpServletResponse response,
                            @RequestParam(value = "id", required = true) String id,
                            ModelMap model,
                            HttpSession httpSession) throws IOException {

        response.setContentType("text/csv");

        String csvFileName = "books.csv";

        // creates mock data
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                csvFileName);
        response.setHeader(headerKey,headerValue);

        ModelInterface evaluation = new Evaluation();
        evaluation.setId(Integer.parseInt(id));

        evaluationList = evaluationService.findAll(evaluation);



        // uses the Super CSV API to generate CSV data from the model data
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);

        String[] header = { "ID", "Name", "Beschreibung", "Start Datum", "End Datum"};

        csvWriter.writeHeader(header);

        for (ModelInterface eval : evaluationList) {
            csvWriter.write(eval, header);
        }

        csvWriter.close();

        httpSession.setAttribute("info", "Auswertung zum Download vorbereitet");
    }
}
