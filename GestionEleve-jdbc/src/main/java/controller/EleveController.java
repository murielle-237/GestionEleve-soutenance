package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import entities.Eleve;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/eleve/*")
public class EleveController extends HttpServlet {

    private TemplateEngine templateEngine;

    private static final List<Eleve> eleves = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        // Configuration de Thymeleaf
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("/templates/");  // les fichiers HTML doivent être dans src/main/resources/templates/
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setCacheable(false);

        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
    }
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String path = req.getPathInfo();
    
    if (path == null || path.equals("/") || path.equals("/list")) {
        getForm(req, resp);
    } else if (path.equals("/delete")) {
        deleteEleve(req, resp);
    } else if (path.equals("/update")) {
        updateEleve(req, resp);
    } else {
        resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Page not found");
    }
}

private void getForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    JakartaServletWebApplication app = JakartaServletWebApplication.buildApplication(getServletContext());
                IWebExchange exchange = app.buildExchange(req, resp);
                 WebContext context = new WebContext(exchange);  
    context.setVariable("eleves", eleves); // Assurez-vous que 'eleves' est une List<Eleve> accessible ici
    templateEngine.process("eleve", context, resp.getWriter());
}



private void deleteEleve(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String id = req.getParameter("id");
    if (id != null) {
        try {
            int idInt = Integer.parseInt(id);
            eleves.removeIf(eleve -> eleve.getId_eleve() == idInt);
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID invalide");
            return;
        }
    }
    resp.sendRedirect(req.getContextPath() + "/eleve/list");
}

private void updateEleve(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String id = req.getParameter("id");
    if (id != null) {
        try {
            int idInt = Integer.parseInt(id);
            Eleve eleve = eleves.stream()
                                 .filter(e -> e.getId_eleve() == idInt)
                                 .findFirst()
                                 .orElse(null);
            if (eleve != null) {
                JakartaServletWebApplication app = JakartaServletWebApplication.buildApplication(getServletContext());
                IWebExchange exchange = app.buildExchange(req, resp);
                 WebContext context = new WebContext(exchange);             
                    context.setVariable("eleve", eleve);
                templateEngine.process("eleve/update", context, resp.getWriter());
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Élève non trouvé");
            }
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID invalide");
        }
    } else {
        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID d'élève manquant");
    }
}
  






















    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String email = req.getParameter("email");
        String adresse = req.getParameter("adresse");
        String telephone = req.getParameter("telephone");
        String date_naissance = req.getParameter("date_naissance");
        String matricule = req.getParameter("matricule");

        Eleve eleve = new Eleve(
                eleves.size() + 1,
                nom,
                prenom,
                date_naissance,
                adresse,
                email,
                telephone,
                matricule,
                1 // Id_classe, à adapter selon votre logique
                
        );

        eleves.add(eleve);
         getForm(req, resp);
    }
}
