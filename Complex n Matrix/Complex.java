package com.company;

public class Complex
{
    /*
    класс содержит переменную trigonomentric_form, которая отвечает за форму, 
    в которой находится число в данный момент: false, если в алгебраической, true -
    в тригонометрической, это позволяет совершать арифметические операции с
    комплексными числами, находящимися в разных формах
    переменные a и b - в случае алгебраической формы два действительных числа, с помощью
    них комплексное число представляется как: a+b*i
    при тригонометрической форме: a(cosb + i*sinb)
    */
    private double a, b;
    private boolean trigonomentric_form;
    public Complex(double a, double b, boolean trigonomentric_form) {
        this.a = a; 
        this.b = b; 
        this.trigonomentric_form = trigonomentric_form;
    }
    public Complex() {
        this.a = 0.0; 
        this.b = 0.0; 
        this.trigonomentric_form = false;
    }
    public Complex add(Complex arg) {
        if (this.trigonomentric_form == true) {
            this.toStandard();
        }
        if (arg.trigonomentric_form == true) {
            arg.toStandard();
        }
        return new Complex(this.a + arg.a, this.b + arg.b, false);
    }
    public Complex subtract(Complex arg) {
        if (this.trigonomentric_form == true) {
            this.toStandard();
        }
        if (arg.trigonomentric_form == true) {
            arg.toStandard();
        }
        return new Complex(this.a - arg.a, this.b - arg.b, false);
    }
    public Complex multiply(double arg) {
        if (this.trigonomentric_form == true) {
            this.toStandard();
        }
        double result_a = this.a * arg;
        double result_b = this.b * arg;
        return new Complex(result_a, result_b, false);
    }
    public Complex multiply(Complex arg) {
        if (this.trigonomentric_form == true) {
            this.toStandard();
        }
        if (arg.trigonomentric_form == true) {
            arg.toStandard();
        }
        double result_a = this.a * arg.a - this.b * arg.b;
        double result_b = this.a * arg.b + arg.a * this.b;
        return new Complex(result_a, result_b, false);
    }
    public Complex divide(Complex arg) {
        if (this.trigonomentric_form == true) {
            this.toStandard();
        }
        if (arg.trigonomentric_form == true) {
            arg.toStandard();
        }
        double result_a = (this.a * arg.a + this.b * arg.b) /
        (arg.a * arg.a + arg.b * arg.b);
        double result_b = (arg.a * this.b - this.a * arg.b) /
        (arg.a * arg.a + arg.b * arg.b);
        return new Complex(result_a, result_b, false);
    }
    public void toTrigonometric() {
        if (this.trigonomentric_form == false) {
            double tmp = Math.toDegrees(Math.atan(this.b/this.a));
            this.a = Math.sqrt(this.a * this.a + this.b * this.b);
            this.b = tmp;
            this.trigonomentric_form = true;
        }
    }
    public void toStandard() {
        if (this.trigonomentric_form == true) {
            double tmp = this.a;
            this.a = Math.cos(Math.toRadians(this.b));
            this.b = Math.sin(Math.toRadians(this.b));
            this.a = this.a * tmp;
            this.b = this.b * tmp;
            this.trigonomentric_form = false;
        }
    }
    public void printComplex() {
        double round_a = Math.round(a * 100.0) / 100.0;
        double round_b = Math.round(b * 100.0) / 100.0;
        if (this.trigonomentric_form == true) {
            System.out.println(round_a + "(cos(" + round_b + ")+sin(" + round_b 
            + ")*i)");
        } else {
            if (round_b >= 0) {
                System.out.println(round_a + "+" + round_b + "*i");
            } else {
                System.out.println(round_a + "" + round_b + "*i");
            }
        }
    }
    public double returnFirst() {
        return this.a;
    }
    public double returnSecond() {
        return this.b;
    }
}

