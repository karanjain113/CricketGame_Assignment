package com.example.springboot;

import matchC.CricketMatch;
import matchC.service.CricketServiceImpl;
import matchC.service.GameService;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {

    private GameService cricketService=new CricketServiceImpl();



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
    public CricketMatch post(@RequestParam("Team1") String teamA, @RequestParam("Team2") String teamB, @RequestParam("Overs") String overs) {

        return cricketService.play(teamA,teamB,overs);
        //return transformToResponse(play);

    }


}