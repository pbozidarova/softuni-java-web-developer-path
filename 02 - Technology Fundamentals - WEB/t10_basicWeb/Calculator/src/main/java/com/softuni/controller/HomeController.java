package com.softuni.controller;

import com.softuni.entity.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("operator", "+");
		model.addAttribute("view", "views/calculatorForm");
		return "base-layout";
	}

	@PostMapping("/")
	public String calculate(Model model,
							@RequestParam String leftOperand,
							@RequestParam String rightOperand,
							@RequestParam String operator
							){
		Double num1;
		Double num2;

		try{
			num1 = Double.parseDouble(leftOperand);
		}catch(NumberFormatException ex){
			num1 = 0.0;
		}

		try{
			num2 = Double.parseDouble(rightOperand);
		}catch(NumberFormatException ex){
			num2 = 0.0;
		}

		boolean isZero = false;
		if(operator.equals("/") && num2 == 0) {
			isZero = true;
		}

		Calculator calculator = new Calculator(num1, operator, num2);

		double result = calculator.calculateResult();

		model.addAttribute("leftOperand", calculator.getLeftOperant());
		model.addAttribute("rightOperand", calculator.getRightOperant());
		model.addAttribute("operator", calculator.getOpearator());
		model.addAttribute("result", calculator.calculateResult());
		model.addAttribute("flag", isZero);

		model.addAttribute("view", "views/calculatorForm");
		return "base-layout";
	}
}
