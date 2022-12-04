package com.example.startrek777;

import lombok.Data;

import java.util.List;
@Data
public class Page {
    private boolean isEnd;
    private int numberPage;
    private String header;
    private List<String> action;


}
