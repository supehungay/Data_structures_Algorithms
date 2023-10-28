package week3.Formula;

public class FormulaEval<T> extends LinkedListStack<T> {

	public double eval(String formula)
	{
        LinkedListStack<Double> operand = new LinkedListStack<>();
        LinkedListStack<String> operator = new LinkedListStack<>();

		String arr[] = formula.split(" ");



        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("+") || arr[i].equals("-") || arr[i].equals("*") || arr[i].equals("/")) {
                operator.push(arr[i]);
            } else if (checkIsNumber(arr[i])) {
                operand.push(Double.parseDouble(arr[i]));
            } else if (arr[i].equals(")")) {
                double num1 = operand.pop();
                double num2 = operand.pop();
                String oper = operator.pop();
                operand.push(calculator(num2, num1, oper));
            }
        }
 
		return operand.pop();
	}
    
    public static double calculator(double num2, double num1, String oper) {
        double calc = 0;
        switch (oper) {
            case "+":
                calc = num2 + num1;
                break;
            case "-":
                calc = num2 - num1;
                break;

            case "*":
                calc = num2 * num1;
                break;

            case "/":
                calc = num2 / num1;
                break;
        }
        return calc;
    }

    public static boolean checkIsNumber(String num) {
        if (num == null) {
            return false;
        } 

        try {
            double check = Double.parseDouble(num);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "( ( 50 - ( ( 8 - 4 ) * ( 2 + 3 ) ) ) + ( 3 * 4 ) )";
    
        FormulaEval test = new FormulaEval();
        System.out.println(test.eval(s));

        
        // System.out.println(calculator(5, 1, "*"));
    }
}
