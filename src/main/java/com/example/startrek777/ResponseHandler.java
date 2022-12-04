package com.example.startrek777;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseHandler {
    public static void handlerResponse(HttpServletRequest req, HttpServletResponse resp) {
        int numberAnswer;
        if (req.getParameter("numberAnswer") == null) {
            numberAnswer = 0;

        } else {
            numberAnswer = Integer.parseInt(req.getParameter("numberAnswer"));
        }


        Question question = createQuestion(numberAnswer);

        req.setAttribute("isEnd", question.isEnd());
        req.setAttribute("header", question.getText());
        req.setAttribute("action", question.getAnswers());
    }

    private static Question createQuestion(int numberAnswer) {
        return Dialog.answers.get(numberAnswer).getNextQuestion();
    }
}


