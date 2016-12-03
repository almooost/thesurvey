package ch.thesurvey.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Initialize app at startup
 * @author Samuel Alfano
 * @date 23.10.2016
 * @version v0.2
 */
public class AppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        // disable start of second context from jersy
        servletContext.setInitParameter("contextConfigLocation", "<NONE>");

        // Create the 'root' Spring application context
        //AnnotationConfigWebApplicationContext rootContext =
        //        new AnnotationConfigWebApplicationContext();
        //rootContext.register(ApplicationConfiguration.class);


        // Manage the lifecycle of the root application context
        //servletContext.addListener(new ContextLoaderListener(rootContext));


        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherContext =
                new AnnotationConfigWebApplicationContext();

        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/thesurvey/");

    }
}
