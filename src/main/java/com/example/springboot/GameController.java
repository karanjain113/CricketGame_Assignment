package com.example.springboot;

import matchC.Match;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {

    @RequestMapping("/")
    public String index() {
        return "<h2>Cricket Match</h2>\n" +
                "\n" +
                "<form action=\"/result\">\n" +
                "  Team1 name:<br>\n" +
                "  <input type=\"text\" name=\"Team1\" value=\"\">\n" +
                "  <br>\n" +
                "  Team2 name:<br>\n" +
                "  <input type=\"text\" name=\"Team2\" value=\"\">\n" +
                "  <br>\n" +
                "  Overs:<br>\n" +
                "  <input type=\"text\" name=\"Overs\" value=\"\">\n" +
                "  <br><br>\n" +
                "  <input type=\"submit\" value=\"Submit\">\n" +
                "</form> ";
    }
    @RequestMapping("/result")
    @ResponseBody
    public Match post(@RequestParam("Team1") String TeamA, @RequestParam("Team2") String TeamB, @RequestParam("Overs") String Overs)
    {
        Match m=new Match(TeamA,TeamB,Integer.parseInt(Overs));
        m.startMatch();
        return m;
    }
}