package com.example.startrek777;

import java.util.List;

public class Dialog {
    Question q1 = Question.builder()
            .text("Тебя разоблачили. Ты проиграл!")
            .isLooser(true)
            .build();

    Question q2 = Question.builder()
            .text("Ты не пошел на переговоры. Это провал и поражение!")
            .isLooser(true)
            .build();

    Question q3 = Question.builder()
            .text("Твою ложи разоблачили. Прощай!")
            .isLooser(true)
            .build();

    Question q4 = Question.builder()
            .text("Тебя вернули домой. Победа!")
            .isWinner(true)
            .build();

    Question q5 = Question.builder()
            .text("Ты поднялся на мостик. Ты кто?")
            .answers(List.of(
                    Answer.builder()
                            .text("Солгать о себе")
                            .nextQuestion(q3)
                            .build(),
                    Answer.builder()
                            .text("Рассказать правду о себе")
                            .nextQuestion(q4)
                            .build()
            ))
            .build();

    Question q6 = Question.builder()
            .text("Ты принял вызов. Поднимаешься на мостик к капитану?")
            .answers(List.of(
                    Answer.builder()
                            .text("Отказаться")
                            .nextQuestion(q2)
                            .build(),
                    Answer.builder()
                            .text("Подняться")
                            .nextQuestion(q5)
                            .build()
            ))
            .build();

    Question q7 = Question.builder()
            .text("Ты потерял память. Принять вызов НЛО?")
            .answers(List.of(
                    Answer.builder()
                            .text("Отклонить вызов")
                            .nextQuestion(q1)
                            .build(),
                    Answer.builder()
                            .text("Принять вызов")
                            .nextQuestion(q6)
                            .build()
            ))
            .build();
}
