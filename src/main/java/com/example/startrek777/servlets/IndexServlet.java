package com.example.startrek777.servlets;

import com.example.startrek777.User;
import com.example.startrek777.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "indexServlet", value = "/index")
public class IndexServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(IndexServlet.class);
    private UserRepository userRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        userRepository = (UserRepository) servletContext.getAttribute("userRepository");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();

        String name = req.getParameter("name");
        String ip = req.getRemoteAddr();

        User user;
        logger.info("Checking the user name");

        if (userRepository.isExists(name)) {
            user = userRepository.fetchByUsername(name);
            logger.info("User: " + name + " - exists ");

        } else {
            user = new User();
            user.setName(name);
            user.setIp(ip);

            logger.info("User: " + name + " does not exist.");
            logger.info("Creating a new user");

            userRepository.save(user);
        }

        if (session.getAttribute("name") != null) {

            resp.sendRedirect("game");
        }

        session.setAttribute("user", user);

        resp.sendRedirect("game");

    }
}
