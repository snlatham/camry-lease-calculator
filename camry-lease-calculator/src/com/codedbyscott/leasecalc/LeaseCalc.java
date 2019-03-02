package com.codedbyscott.leasecalc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LeaseCalc {
	
	private final int startMileage = 50;
	private final int leasedMiles = 36000;
	private int remainingMiles = leasedMiles + startMileage;
	
	@RequestMapping("/processForm")
	public String processForm(HttpServletRequest request, Model model) {
		
		// read the parameter from the form
		int milesDriven = Integer.parseInt(request.getParameter("milesDriven"));
		
		// do something with it
		remainingMiles -= milesDriven;
		
		// return data to the model for the result page
		model.addAttribute("remainingMiles", remainingMiles);
		
		return "result";
	}
}
