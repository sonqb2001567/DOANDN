package com.example.demo.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.TempDTO;
import com.example.demo.Service.TempService;
import com.example.demo.api.APIRequest;

@RestController
@RequestMapping("/api")
public class AdafruitController {

    @Autowired
    private APIRequest adafruitIOApi;
    
    @GetMapping(value = "/feed/{feedName}/{area_id}", produces = "application/json")
    public ResponseEntity<String> getFeedData(@PathVariable String feedName,@PathVariable int area_id ) throws ParseException {
        try {
            String data = adafruitIOApi.getLastData(feedName, area_id);           
            return new ResponseEntity<>(data, HttpStatus.OK);
            
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping(value = "/addtofeed/{feedName}/{value}")
    public void sentValueToFeed(@PathVariable String feedName, @PathVariable Integer value) {
    	Map<String, Object> data = new HashMap<>();
        data.put("value", value);
        try {
			adafruitIOApi.sendData(feedName, data);
		} catch (IOException e) {
		}
	}
}   
