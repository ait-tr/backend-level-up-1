package de.ait.shop.servlets;

import de.ait.shop.config.ApplicationConfig;
import de.ait.shop.models.User;
import de.ait.shop.services.UsersService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 10/2/2023
 * WebExample
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class UsersServlet extends HttpServlet {

    private UsersService usersService;

    private Configuration freemarker;

    @Override
    public void init() throws ServletException {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        this.usersService = context.getBean(UsersService.class);
        this.freemarker = context.getBean(Configuration.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<User> users = usersService.getAllUsers();
//
//        Writer writer = response.getWriter();
//
//        writer.write("<table>");
//        for (User user : users) {
//            writer.write("<tr>");
//            writer.write("<td>" + user.getEmail() + "</td>");
//            writer.write("</tr>");
//
//        }
//        writer.write("</table>");
        Template template = freemarker.getTemplate("page.ftlh");

        Map<String, Object> attributes = Collections.singletonMap("username", "Marsel");

        try {
            template.process(attributes, response.getWriter());
        } catch (TemplateException e) {
            throw new IllegalStateException(e);
        }
    }
}
