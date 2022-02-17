package BookVendingMachine;
import java.io.BufferedWriter;
import java.io.FileWriter;

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
		try
		{
			FileWriter file = new FileWriter("BookInventory.txt", true);
			BufferedWriter inventory = new BufferedWriter(file);
			inventory.write("#" + this.book.getId() + "#");
			inventory.write(this.book.getTitle() + "#");
			inventory.write(this.book.getAuthor() + "#");
			inventory.write(this.book.getPages() + "#\n");
			
			inventory.close();
		}
		catch(Exception error)
		{
			return;
		}	
	}
	public void removeBook()
	{
		
	}
}
