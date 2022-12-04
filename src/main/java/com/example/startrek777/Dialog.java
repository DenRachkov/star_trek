package com.example.startrek777;

import lombok.Builder;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;


@Builder
@Data
class Question {
    private String text;
    private List<Answer> answers;
    private boolean isEnd;

}

@Builder
@Data
class Answer {
    private String text;
    private Question nextQuestion;

}


public class Dialog {
    public static List<Answer> answers = new ArrayList<>();

    static {
        Answer answer1 = Answer.builder()
                .text("Рассказать правду")
                .build();

        Answer answer2 = Answer.builder()
                .text("Солгать о себе")
                .build();

        Answer answer3 = Answer.builder()
                .text("Отказаться подниматься на мостик")
                .build();

        Answer answer4 = Answer.builder()
                .text("Подняться на мостик")
                .build();

        Answer answer5 = Answer.builder()
                .text("Отклонить вызов")
                .build();

        Answer answer6 = Answer.builder()
                .text("Принять вызов")
                .build();

        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);
        answers.add(answer4);
        answers.add(answer5);
        answers.add(answer6);


        Question q1 = Question.builder()
                .text("Тебя вернули домой. Победа!")
                .build();

        Question q2 = Question.builder()
                .text("Тебя разоблачили. Поражение!")
                .build();

        Question q3 = Question.builder()
                .text("Ты поднялся на мостик. Ты кто?")
                .answers(List.of(
                        answers.get(0),
                        answers.get(1)
                ))
                .build();

        Question q4 = Question.builder()
                .text("Ты не пошел на переговоры. Поражение!")
                .build();

        Question q5 = Question.builder()
                .text("Ты принял вызов. Поднимаешься на мостик к капитану?")
                .answers(List.of(
                        Answer.builder()
                                .text("Отказаться подниматься на мостик")
                                .nextQuestion(q4)
                                .build(),
                        Answer.builder()
                                .text("Подняться на мостик")
                                .nextQuestion(q3)
                                .build()
                ))
                .build();

        Question q6 = Question.builder()
                .text("Ты отклонил вызов. Поражение!")
                .build();

        Question q7 = Question.builder()
                .text("Ты потерял память. Принять вызов НЛО???")
                .answers(List.of(
                        Answer.builder()
                                .text("Отклонить вызов")
                                .nextQuestion(q6)
                                .build(),
                        Answer.builder()
                                .text("Принять вызов")
                                .nextQuestion(q5)
                                .build()
                ))
                .build();

        answers.get(0).setNextQuestion(q1);
        answers.get(1).setNextQuestion(q2);
        answers.get(2).setNextQuestion(q4);
        answers.get(3).setNextQuestion(q3);
        answers.get(4).setNextQuestion(q6);
        answers.get(5).setNextQuestion(q5);


    }
}




