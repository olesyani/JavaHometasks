public class Main
{
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
	}
}
