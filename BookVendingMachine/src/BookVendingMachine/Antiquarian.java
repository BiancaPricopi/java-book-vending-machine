package BookVendingMachine;

public class Antiquarian
{
	private Book book = new Book();
	public void addNewBook(String title, String author, int pages)
	{
		this.book.setTitle(title);
		this.book.setAuthor(author);
		this.book.setPages(pages);
		this.book.incrementId();
		registerBook();
	}
	private void registerBook()
	{
		
	}
	public void removeBook()
	{
		
	}
}
