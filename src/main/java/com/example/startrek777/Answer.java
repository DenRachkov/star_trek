package com.example.startrek777;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public
class Answer {
    private String text;
    private Question nextQuestion;

}
