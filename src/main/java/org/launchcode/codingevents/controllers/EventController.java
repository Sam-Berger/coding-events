package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("events")
public class EventController {

    private static HashMap<String, String> events = new HashMap<>();

    public void populateEvents() {
        events.put("GDC", "A conference for games developers in Europe");
        events.put("CodeBase", "A places where coders build a sweet base and code");
        events.put("Code with Pride", "An event where the LGBTQ community can code together");

    }

    @GetMapping
    public String displayAllEvents(Model model) {
        populateEvents();
        model.addAttribute("events", events);
        return "events/index";
    }


//    @GetMapping
//    public String displayEvents() {
//        populateEvents();
//        return "events/index";
//    }
    @GetMapping("create")
    public String renderCreateEventForm() {
        return "events/create";
    }

    @PostMapping("create")
    public String createEvent(@RequestParam String eventName, @RequestParam String eventDescription) {
        events.put(eventName, eventDescription);
        return "redirect:";

    }
}
