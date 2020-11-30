package coronavirus.coronavirustracker.controllers;


import coronavirus.coronavirustracker.models.LocationStats;
import coronavirus.coronavirustracker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/")
    public String home(Model model){
        List<LocationStats> allStats = coronaVirusDataService.getAllStats();
        int totalReportedCases = allStats.stream().mapToInt(stats -> stats.getLatestTotalCases()).sum();
        int totalNewReportedCases = allStats.stream().mapToInt(stats -> stats.getNewCases()).sum();
        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalNewReportedCases", totalNewReportedCases);


        return "home";
    }
}
