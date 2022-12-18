package com.example.startrek777;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
class Question {
    private String text;
    private List<Answer> answers;
    private boolean isWinner;
    private boolean isLooser;

}
