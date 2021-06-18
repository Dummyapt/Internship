package de.dummyapt.internship.controllers;

import de.dummyapt.internship.services.api.StatisticsServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsControllerREST {
    @Autowired
    private StatisticsServiceAPI statisticsService;

    @GetMapping("statsChart")
    public String showStats() {
        var stringBuilder = new StringBuilder();
        stringBuilder
                .append("<input type=\"number\" disabled id=\"s1\" value=\"").append(statisticsService.getStatisticsCountBy(1)).append("\">")
                .append("<a>").append(statisticsService.getStatisticsCountBy(2)).append("</a>")
                .append("<a>").append(statisticsService.getStatisticsCountBy(3)).append("</a>")
                .append("<a>").append(statisticsService.getStatisticsCountBy(4)).append("</a>")
                .append("<a>").append(statisticsService.getStatisticsCountBy(5)).append("</a>")
                .append("<a>").append(statisticsService.getStatisticsCountBy(6)).append("</a>");
        return stringBuilder.toString();
    }
}