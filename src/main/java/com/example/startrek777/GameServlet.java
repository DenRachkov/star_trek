package com.example.startrek777;


import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;


@WebServlet(name = "GameServlet", value = "/game")
public class GameServlet extends HttpServlet {
    private Question start;
    private boolean finish;
    private int numberOfGames;
    @Override
    public void init(ServletConfig config) throws ServletException {
        start = new Dialog().q7;
        super.init(config);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("question", start.getText());

        List<String> answers = new ArrayList<>();
        if (start.isWinner() || start.isLooser()) {
            finish = true;

        } else {
            for (Answer answer : start.getAnswers()) {
                answers.add(answer.getText());
            }

        }
        User user = (User) req.getSession().getAttribute("user");
        req.setAttribute("name", user.getName());
        req.setAttribute("ip", user.getIp());
        req.setAttribute("numberOfGames", user.getNumberOfGames());
        req.setAttribute("answers", answers);
        req.setAttribute("finish", finish);


        getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);

        if (finish == true){

            numberOfGames = numberOfGames + 1;
            user.setNumberOfGames(numberOfGames);
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        if (!start.isWinner() && !start.isLooser() && !isNull(req.getParameter("nextQuestion"))) {
            start = start.getAnswers().get(Integer.parseInt(req.getParameter("nextQuestion"))).getNextQuestion();
            resp.sendRedirect("game");
        } else {
            start = new Dialog().q7;
            finish = false;

            resp.sendRedirect("index.jsp");


        }

    }

}





