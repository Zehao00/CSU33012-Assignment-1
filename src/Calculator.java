import java.util.Stack;

public class Calculator 
{
    int finalResult = 0;
	public Calculator (String expression)
	{
		String [] exp = expression.split("");             //Turn the expression into string array (e.g. "12+1" -> ["1", "2", "+", "1"])
		
		String number = "";                               //variable to store every char of the integer string  (e.g. "1","2","3" -> "123") 
 		Stack<Integer> operand = new Stack<Integer>();    //stack for operand
		Stack<String> operator = new Stack<String>();     //stack for operator
	
		for(int i = 0; i < exp.length; i++)
		{
			if(exp[i].equals("+"))                           //check if the current char is "+"
			{
				if(number != "")                             //check if we catch a operand
				{
					operand.push(Integer.parseInt(number));  //we get the complete number, push it into operand stack
					number = "";                             //reset
				}
				
				if(operator.empty() == false && operator.peek().equals("*"))  //Multiplication has the first priority in this calculator
				{
					int number1 = operand.pop();                              //get the first number
					int number2 = operand.pop();                              //get the second number
					int result = multiplication(number1, number2);            //do the multiplication
					operand.push(result);                                     //push the result into operand stack
					operator.pop();                                           //pop "*" out of operator stack
				}
				
				if(operator.empty() == false && operator.peek().equals("-"))  //Subtraction has the second priority in this calculator
				{
					int number1 = operand.pop();                              //get the first number
					int number2 = operand.pop();                              //get the second number
					int result = subtraction(number2, number1);               //do the subtraction
					operand.push(result);                                     //push the result into operand stack
					operator.pop();                                           //pop "-" out of operator stack
				}
				operator.push("+");                                           //push "+" into operator stack
			}
			
			else if(exp[i].equals("-"))                                       //check if the current char is "-"
			{
				if(number != "")                                              //check if we catch a operand
				{
					operand.push(Integer.parseInt(number));                   //we get the complete number, push it into operand stack
					number = "";                                              //reset
				}
				
				if(operator.empty() == false && operator.peek().equals("*"))  //Multiplication has the first priority in this calculator
				{
					int number1 = operand.pop();                              //get the first number
					int number2 = operand.pop();                              //get the second number
					int result = multiplication(number1, number2);            //do the multiplication
					operand.push(result);                                     //push the result into operand stack
					operator.pop();                                           //pop "*" out of operator stack
				}
				operator.push("-");                                           //push "-" into operator stack
			}
			
			else if(exp[i].equals("*"))                                       //check if the current char is "*"
			{
				if(number != "")                                              //check if we catch a operand
				{
					operand.push(Integer.parseInt(number));                   //we get the complete number, push it into operand stack
					number = "";                                              //reset
				}
					operator.push(exp[i]);	                                  //push "*" into operator stack
			}
			else
			{
				number = number + exp[i];                                     //concatenate every char of the integer together to get the complete number
			}
		}
           operand.push(Integer.parseInt(number));                            //we get the complete number, push it into operand stack
           number = "";                                                       //reset
           
    	while(operator.empty() == false)                                      //loop until operator stack don't contain any operator
		{
			String tmp = operator.pop();                                      //pop the last operator out of stack
			
			if(tmp.equals("+"))                                               //if the last operator is "+"
			{
				int number1 = operand.pop();                                  //get the first number
				int number2 = operand.pop();                                  //get the second number
				int result = addition(number1, number2);                      //do the addition
				operand.push(result);                                         //push the result into operand stack
			}
			else if(tmp.equals("-"))                                          //if the last operator is "-"
			{
				int number1 = operand.pop();                                  //get the first number
				int number2 = operand.pop();                                  //get the second number
				int result = subtraction(number2, number1);                   //do the subtraction
				operand.push(result);                                         //push the result into operand stack
			}
			else if(tmp.equals("*"))                                          //if the last operator is "*"
			{
				int number1 = operand.pop();                                  //get the first number
				int number2 = operand.pop();                                  //get the second number
				int result = multiplication(number1, number2);                //do the multiplication
				operand.push(result);                                         //push the result into operand stack
			}
		}
		
    	finalResult = operand.pop();                                          //get the final answer out of the stack
		System.out.println(toString(finalResult));                            // test
	}
	
	
	public int addition(int a, int b)
	{
		return (a+b);                            
	}
	
	
	public int subtraction(int a, int b)
	{
		return (a-b);
	}
	
	
	public int multiplication(int a, int b)
	{
		return (a*b);
	}

	public String toString(int finalResult)
	{
		return String.valueOf(finalResult);
	}
}
