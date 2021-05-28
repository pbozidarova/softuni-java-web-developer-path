package com.softuni.entity;

public class Calculator {
    private double leftOperant;
    private String opearator;
    private double rightOperant;

    public Calculator(double leftOperant, String opearator, double rightOperant) {
        this.leftOperant = leftOperant;
        this.opearator = opearator;
        this.rightOperant = rightOperant;
    }


    public double getLeftOperant() {
        return leftOperant;
    }

    public String getOpearator() {
        return opearator;
    }

    public double getRightOperant() {
        return rightOperant;
    }

    public double calculateResult(){
        double result = 0.0;

        switch (this.opearator){
            case "+":
                result = this.leftOperant + this.rightOperant;
                break;
            case "-":
                result = this.leftOperant - this.rightOperant;
                break;
            case "*":
                result = this.leftOperant * this.rightOperant;
                break;
            case "/":
                result = this.leftOperant / this.rightOperant;
                break;
            default:
                    result = 0.0;
                    break;

        }

        return result;
    }

}
