import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class imdb extends scrap {

    public static void main(String[] args) throws IOException {
	
	choice();
        // Make a URL to the web page
	String link="http://www.imdb.com"+mlinks[ch-1];
        URL url = new URL(link);
        // Get the input stream through URL Connection
        URLConnection con = url.openConnection();
        InputStream is =con.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String s ="";
        String line = null;

        // read each line and write to System.out
        while ((line = br.readLine()) != null) {
            //System.out.println(line);
			s+=line;
        }
		


		


			System.out.print("Movie Name : "+names[ch-1]);
			System.out.print(" ("+yor[ch-1]+")");

		
		System.out.println();
		System.out.print("Summary :");
		int a=s.indexOf("summary_text");
		if(a!=-1)
		{
			String rank=s.substring(a+57,s.indexOf("div",a)-14);
			System.out.print(rank);
		}
		System.out.println();
		System.out.print("Initial release date : ");
		int y1=s.indexOf("See more release dates");
		if(y1!=-1)
		{
			String rank=s.substring(y1+25,s.indexOf("<meta",y1));
			System.out.print(rank);
		}
		System.out.println();
		System.out.print("Current Rating : ");
		int y2=s.indexOf("ratingValue");
		if(y2!=-1)
		{
			String rank=s.substring(y2+28,(s.indexOf("<span",y2))-2);
			System.out.print(rank);
			System.out.println();
		}
		System.out.print("Director : ");
		int y4=s.indexOf("director");
		if(y4!=-1)
		{
			String rank=s.substring(y4+149,s.indexOf("</",y4+149));
			System.out.print(rank);
		}
		System.out.println();
		System.out.print("Cast : ");
		int y3=s.indexOf("actors");
		for(int s1=0;s1<=2;s1++)
		{
			 
			if(y3!=-1)
			{
				String rank=s.substring(y3+150,s.indexOf("</",y3+150));
				System.out.print(" "+rank+" ");
				y3=s.indexOf("actors",y3+150);
			}
		}
			System.out.println();
		int x=s.indexOf("Top Rated Indian Movies #");
		if(x!=-1)
		{
			String rank=s.substring(x,x+29);
			String rankf=rank.substring(0, rank.indexOf("<"));
			System.out.println(rankf);
		}
		

		
    }
}

