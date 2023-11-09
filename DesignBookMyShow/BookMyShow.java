package DesignBookMyShow;

public class BookMyShow {
	
	MovieController movieController;
	TheatreController theatreController;
	
	BookMyShow()
	{
		movieController = new MovieController();
        theatreController = new TheatreController();
		
	}
	public static void main(String[] args)
	{
		BookMyShow bookMyShow = new BookMyShow();
		
		//bookMyShow.initialize();
		
		
	}
//	void initialize()
//	{
//		createMovies();
//		
//		createTheatres();
//	}

}
