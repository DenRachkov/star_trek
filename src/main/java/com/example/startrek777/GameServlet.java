package com.example.startrek777;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;


@WebServlet(name = "gameServlet", value = "/game")
public class GameServlet extends HttpServlet {
    private Question start;
    private boolean finish;

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
        req.setAttribute("answers", answers);
        req.setAttribute("finish", finish);

        getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (!start.isWinner() && !start.isLooser() && !isNull(req.getParameter("nextQuestion"))) {
            start = start.getAnswers().get(Integer.parseInt(req.getParameter("nextQuestion"))).getNextQuestion();
        }
        resp.sendRedirect("game");

    }

}


