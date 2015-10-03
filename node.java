

public class node {
	public node next;
	public node last;
	public char data = '/';
	public boolean isword;
	public  node child;
public node()
{
	this.next = null;
	this.last = null;
	this.isword = false;
	this.data = '/';
}
public node (char c)
{
	this.data = c;
}
public node(node last, char c)
{
	this.last = last;
	this.data = c;
}

public void setnext(node n)
{
	this.next = n;
	next.last = this;
}
public node getchild()
{
	return this.child;
}
public void addchild(node n)
{
	this.child = n;
}
public char getdata()
{
	return this.data;
}

}
