package com.company;

public class Main {
	public static void main(String[] args) {
		Complex a = new Complex(5, 10, false); //a представлено в алгебраической форме
        	Complex b = new Complex(-1, 9, true); //b в тригонометрической
        	//возможности программы:
        	System.out.println("a and b in standard (alg) form:");
        	a.printComplex();
        	b.toStandard();
        	b.printComplex();
        	System.out.println("a + b:");
        	Complex result = a.add(b);
        	result.printComplex();
        	System.out.println("a + b in trigonomentric form:");
        	result.toTrigonometric();
        	result.printComplex();
        	System.out.println("a - b:");
        	result = a.subtract(b);
        	result.printComplex();
        	System.out.println("a - b in trigonomentric form:");
        	result.toTrigonometric();
        	result.printComplex();
        	System.out.println("a * b:");
        	result = a.multiply(b);
        	result.printComplex();
        	System.out.println("a / b:");
        	result = a.divide(b);
        	result.printComplex();
        
	        Matrix a_matr = new Matrix(2, 2);
	        Matrix b_matr = new Matrix(2, 2);
	        Matrix res_matr = new Matrix();
	        double k = 1.0;
	        System.out.println("Both matrixes look like this:");
	        for (int i = 0; i < 2; i++) {
	            System.out.println(i+1 + " row:");
	            for (int j = 0; j < 2; j++) {
	                a_matr.setElement(i, j, new Complex(k, k, false));
	                b_matr.setElement(i, j, new Complex(k, k, false));
	                Complex arg = a_matr.getElement(i, j);
	                arg.printComplex();
	                k = k + 1;
	            }
	        }
	        System.out.println("The result of addition:");
	        res_matr = a_matr.add(b_matr);
	        res_matr.printMatrix();
	        System.out.println("The result of subraction:");
	        res_matr = a_matr.subtract(b_matr);
	        res_matr.printMatrix();
	        System.out.println("The result of multiplication:");
	        res_matr = a_matr.multiply(b_matr);
	        res_matr.printMatrix();
	        System.out.println("The result of multiplication transposed:");
	        res_matr = res_matr.transpose();
	        res_matr.printMatrix();
	        System.out.println("The determinate of previous result:");
	        result = res_matr.determinate(res_matr.returnRows());
	        result.printComplex();
	        System.out.println("The determinate of 3x3 matrix:");
	        Matrix new_matr = new Matrix(3, 3);
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                new_matr.setElement(i, j, new Complex(0, 0, false));
	            }
	        }
	        new_matr.setElement(0, 0, new Complex(1, 3, false));
	        new_matr.setElement(1, 1, new Complex(4, 2, false));
	        new_matr.setElement(2, 2, new Complex(1, 1, false));
	        result = new_matr.determinate(new_matr.returnRows());
	        result.printComplex();
	}
}
