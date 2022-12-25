package com.example.startrek777;

import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
public
class Question {
    private String text;
    private List<Answer> answers;
    private boolean isWinner;
    private boolean isLooser;

}
