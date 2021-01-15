package com.example.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cases")
public class MyController {

	@PostMapping("/")
	public String getCaseID(@RequestBody String s) {
		
		s = s.replaceAll("\\d\\d:\\d\\d", "x");
		
		Pattern p = Pattern.compile("([1-9]\\d{14,})");
		Matcher m = p.matcher(s);
		
		String output = "| where IncidentId in~ (";
		
		
		
        while(m.find()) {
            //System.out.println(m.group());
        	output += "\"" + m.group() + "\",";
        }
		
        output = output.substring(0,output.length()-1) + ")";
		
        return output;
	}
	
}
