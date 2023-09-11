package hw1;

public class Printer {
	
	private int nextPage;
	private int pagesToPrint;
	private int totalPages;
	private int pagesLeft;
	private int amountInTray;
	private int oldAmount;
	private int trayCapacity;
	private int x;
	private int sheetsAvailble;
	
	//constructor for printer class
	
	public Printer(int trayCapacity) {
		
		nextPage = 0;
		pagesToPrint = 0;
		totalPages = 0;
		pagesLeft = 0;
		amountInTray = 0;
		oldAmount = 0;
		x = 0;
		sheetsAvailble = 0;
		
		this.trayCapacity = trayCapacity;
	}
	
	//Starts a new print job of x size
	
	public void startPrintJob(int documentPages) {
		
		nextPage = 0;
		pagesToPrint = documentPages;
		
	}
	
	//returns amount of paper in tray

	public int getSheetsAvailable() {
		
		return amountInTray;
		
	}
	
	//returns current page number being printed
	
	public int getNextPage() {
		
		return nextPage;
		
	}
	
	//returns total pages since printer initialized
	
	public int getTotalPages() {
		
		return totalPages;
		
	}
	
	//prints next page of print job
	
	public void printPage() {
		
		nextPage += Math.min(amountInTray, 1);
		totalPages += Math.min(amountInTray, 1);
		pagesLeft = pagesToPrint - nextPage;
		x = Math.min(pagesLeft, 1);
		nextPage = Math.min(nextPage, x * nextPage);
		amountInTray -= Math.min(amountInTray, 1);
	}
	
	//sets amount of paper to zero while storing old paper amount
	
	public void removeTray() {
		
		oldAmount = amountInTray;
		amountInTray = 0;
		
	}
	
	//replaces amount in tray to old value
	
	public void replaceTray() {
		
		amountInTray += oldAmount;
		
		oldAmount = 0;
	}
	
	//adds paper to tray
	
	public void addPaper(int sheets) {
		this.replaceTray();
		
		amountInTray = Math.min(amountInTray + sheets, trayCapacity);
		
		
	}
	
	//removes paper from tray
	
	public void removePaper(int sheets) {
		
		amountInTray = Math.max(0, amountInTray - sheets);
	}
	
	
	
}

