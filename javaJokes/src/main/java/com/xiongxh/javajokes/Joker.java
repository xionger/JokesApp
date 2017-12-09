package com.xiongxh.javajokes;

public class Joker {

    private String[] jokes = {
                    "Mother: How was school today, Patrick? \n"
                    + "\n" +
                    "Patrick: It was really great mum! Today we made explosives! \n" +
                    "\n" +
                    "Mother: Ooh, they do very fancy stuff with you these days. And what will you do at school tomorrow? \n" +
                    "\n" +
                    "Patrick: What school? "
                };

    public String tellJoke(){
        return jokes[0];
    }
}
