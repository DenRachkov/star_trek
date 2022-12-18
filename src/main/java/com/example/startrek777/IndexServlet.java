package com.example.startrek777;

import com.oracle.wls.shaded.org.apache.bcel.generic.IfInstruction;

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
        if (userRepository.isExists(name)) {
            user = userRepository.fetchByUsername(name);

        } else {
            user = new User();
            user.setName(name);
            user.setIp(ip);

            userRepository.save(user);

        }

        if (session.getAttribute("name") != null) {

            resp.sendRedirect("game");
        }

        session.setAttribute("user", user);

        System.out.println(user);

        resp.sendRedirect("game");

    }
}
