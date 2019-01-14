import java.util.ArrayList;
import java.util.NoSuchElementException;
public class MyStack <AnyType>{ 
	ArrayList<AnyType> stack=new ArrayList<>();
	static int top=-1;
	
	public void push(AnyType e)
	{
		stack.add(++top,e);
		
	}
	public AnyType pop()
	{
		return stack.remove(top--);
	}
	public boolean isEmpty()
	{
		if(top==-1)
			return true;
		else
			return false;
	}
	public boolean isFull()
	{
		if(top==stack.size())
			return true;
		else
			return false;
	}
	
	 public String toString( )
	    {
	        StringBuilder sb = new StringBuilder( " " );

	        for( AnyType x : stack )
	            sb.append( x + " " );
	        
	        return new String( sb );
	    }
	 public static void main(String args[])
	 {
		 MyStack<Character> s=new MyStack<>();
		 //String input="[{([({})])}]";			//Balanced nested braces
		 String input="[{}(())()(]";			//Unbalanced braces;
		 char e;
		 //System.out.println(input.length());
		 for(int i=0;i<input.length();i++)
		 {
			 e = input.charAt(i);
			 if(e=='['||e=='{'||e=='(')
			 {
				 s.push(e);
				 System.out.println("Pushed onto stack "+ e + " top = "+ top);
			 }
			 else if(e==']')
			 {
				 System.out.println("popping "+ e + " top = "+ top);
				 if(s.pop()!='[')
				 {
					 System.out.println("MISMATCH BRACE");
					 break;
				 }
				 if(s.isEmpty())
				 {
					 System.out.println("EMPTY STACK");
					 break;
				 }
			 }
			 else if(e=='}')
			 {
				 System.out.println("popping "+e +" top = "+ top);
				 if(s.pop()!='{')
				 {
					 System.out.println("MISMATCH BRACE [");
					 break;
				 }
				 if(s.isEmpty())
				 {
					 System.out.println("EMPTY STACK {");
					 break;
				 }
			 }
			 else if(e==')')
			 {
				 System.out.println("popping "+e+" top = "+ top);
				 if(s.pop()!='(')
				 {
					 System.out.println("MISMATCH BRACE (");
					 break;
				 }
				 if(s.isEmpty())
				 {
					 System.out.println("EMPTY STACK");
					 break;
				 }
			 }
			 else
				 throw new NoSuchElementException(e+" is an invalid element."); 
			 
		 }
		 if(s.isEmpty())
			 System.out.println("SYMBOLS ARE BALANCED");
	 }

}
