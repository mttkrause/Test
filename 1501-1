import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class pw_check 
{
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException
{
		
		BufferedReader bf = new BufferedReader(new FileReader("dictionary.txt"));
		String line;
		int linelength;
		node tree= new node();
		while ((line = bf.readLine()) != null) 
		{
			linelength = line.length();
		    if(!(linelength<2) && !(linelength>5))// ignores 1 letter words because 1 letter words do not reduce the complexity of the password
		    {
		    	addtotree(line, tree);
		    }
		}
		bf.close();
		char[][] allcombos;
		int lettercount=0;
		int numbercount=0;
		int specialcharactercount = 0;
		Scanner input = new Scanner(System.in);
		char[] passwordarray;
		boolean ispassword = true;
		do
		{
		System.out.println("please enter a password to test");
		String password = input.next();
		input.close();
		if (password.equals("exit"))
			break;
		passwordarray = password.toCharArray();
		for (int i = 0; i< passwordarray.length; i++)
		{
			if ((int) passwordarray[i] > 96 && (int) passwordarray[i]<123)
				lettercount++;
			if ((int) passwordarray[i] > 47 && (int) passwordarray[i]<58)
				numbercount++; 
			if (passwordarray[i] == '!' || passwordarray[i] == '@' || passwordarray[i] == '$' || passwordarray[i] == '%'|| passwordarray[i] == '&' || passwordarray[i] == '*')
				specialcharactercount++;
		}
		if((lettercount + numbercount + specialcharactercount == 5) && lettercount >= 1 &&  numbercount >= 1 && specialcharactercount >= 1 ) 
		 { 
			allcombos = buildallwordpermutations(passwordarray);
		if(passwordtest(allcombos[1], tree) && passwordtest(allcombos[2], tree) && passwordtest(allcombos[3], tree) )
			System.out.println("your password is a good password");
				
		 }
		else
			System.out.println("your password is not a good password.");
		}while (true);
		

}
	
	
	
	

	private static char[][] buildallwordpermutations(char[] passwordarray) 
	{
		char[][] listperms = new char[4][];
		listperms[0] = passwordarray;
		listperms[1] = downsize(listperms[0]);
		listperms[2] = downsize(listperms[1]);
		listperms[3] = downsize(listperms[2]);
		return listperms;
	}





	private static char[] downsize(char[] cs) 
	{
		char[] array = new  char[cs.length-1];
		int i;
	for( i = 1; i<cs.length; i++);	
	{
	if (cs[i] == '7')
		array[i-1] = 't';
	else if (cs[i] == '4')
		array[i-1] = 'a';
	else if (cs[i] == '0')
		array[i-1] = 'o';
	else if (cs[i] == '3')
		array[i-1] = 'e';
	else if (cs[i] == '5')
		array[i-1] = 's';
	else
		array[i-1] = cs[i];
	}
	return array;
	}





	private static boolean passwordtest(char[] passwordarray, node tree) 
	{
		for (int i = 0; i< passwordarray.length; i++)
		{
		node firstnode = searchlevel(tree,passwordarray[i]);
		if(firstnode.isword)// sees if the letter is the end of the word
			return false;
		else tree = firstnode.child;
		}
		return true;
	}




	private static node searchlevel(node tree, char c) 
	{
		if(tree.data ==c )
			return tree;
		else 
			if(tree.next !=null)
			return searchlevel(tree.next, c);
		return null;
		
	}







	private static void addtotree(String line, node tree) 
	{
		char[] cArray = line.toCharArray();
		for (int i = 0; i<cArray.length; i++)
		{
			boolean islast= false;
			if (i==cArray.length-1)
				 islast = true;
			makenode(cArray[i],tree, islast);
				
		}
	}

	private static void makenode(char c, node thisnode, boolean islast) 
	{
		if(thisnode.data == c)
			makenode(c, thisnode.child, islast);
		else 
		if (thisnode.next == null)
		{
			thisnode.next = new node (thisnode, c);
			thisnode.next.isword = true;
		}
		else
		makenode(c,thisnode.next, islast);
	}
}
