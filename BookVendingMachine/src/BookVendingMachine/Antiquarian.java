package BookVendingMachine;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
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
			inventory.write(this.book.getId() + "#");
			inventory.write(this.book.getTitle() + "#");
			inventory.write(this.book.getAuthor() + "#");
			inventory.write(this.book.getPages() + "\n");
			
			inventory.close();
		}
		catch(Exception error)
		{
			return;
		}	
	}
	public void removeBook()
	{
		try
		{
			FileReader file = new FileReader("BookInventory.txt");
			BufferedReader inventory = new BufferedReader(file);
			String bookCoded = Integer.toString(this.book.getId());
			bookCoded = bookCoded.concat("#");
			bookCoded = bookCoded.concat(this.book.getTitle());
			bookCoded = bookCoded.concat("#");
			bookCoded = bookCoded.concat(this.book.getAuthor());
			bookCoded = bookCoded.concat("#");
			bookCoded = bookCoded.concat(Integer.toString(this.book.getPages()));
			String row;
			/*while((row = inventory.readLine()) != null)
			{
				String bookInfo[] = row.split("#"); 
				for (int i = 0; i < bookInfo.length; i++) 
				{
					 System.out.println(bookInfo[i]);
				}
			}*/
			boolean flag = true;
			while(flag == true && (row = inventory.readLine()) != null)
			{
				if(row.equals(bookCoded) == true)
				{
					File inputFile = new File("BookInventory.txt");
					File tempFile = new File("temporaryInvetory.txt");

					BufferedReader reader = new BufferedReader(new FileReader(inputFile));
					BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
					String currentLine;
					boolean firstBookOccurence = false;

					while((currentLine = reader.readLine()) != null)
					{
					    if(currentLine.equals(row) && firstBookOccurence == false)
					    {
					    	firstBookOccurence = true;
					    }
					    else
					    {
					    	writer.write(currentLine + System.getProperty("line.separator"));
					    }
					}
					writer.close(); 
					reader.close();
					boolean successful = tempFile.renameTo(inputFile);
					if(successful == true)
					{
						System.out.println("Book remvoed successfully.");
					}
					else
					{
						System.out.println("An error accured. Book was not removed.");
					}
					flag = false;
				}
			}
			
			inventory.close();
		}
		catch(Exception error)
		{
			return;
		}
		
	}
}
