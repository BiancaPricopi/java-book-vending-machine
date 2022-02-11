package BookVendingMachine;

public class Book 
{
	private int id = 0;
	private String title;
	private String author;
	private int pages;
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle()
	{
		return this.title;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public String getAuthor()
	{
		return this.author;
	}
	public void setPages(int pages)
	{
		this.pages = pages;
	}
	public int getPages()
	{
		return this.pages;
	}
}
