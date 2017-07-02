import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.io.*;

public class scrap {

	static String names[]=new String[5];
	static String yor[]=new String[5];
	static String mlinks[]=new String[5];
	static int ch ;
	

    public static void choice() throws IOException {

	Scanner ab=new Scanner(System.in);
	System.out.println("Enter the name of the movie you want to search for and let me do the rest !");
	String n=ab.nextLine();
	

        // Make a URL to the web page
        URL url = new URL("http://www.imdb.com/search/title?title="+n);

        // Get the input stream through URL Connection
        URLConnection con = url.openConnection();
        InputStream is =con.getInputStream();

        // Once you have the Input Stream, it's just plain old Java IO stuff.

        // For this case, since you are interested in getting plain-text web page
        // I'll use a reader and output the text content to System.out.

        // For binary content, it's better to directly read the bytes from stream and write
        // to the target file.


        BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String s ="";
        String line = null;

        // read each line and write to System.out
        while ((line = br.readLine()) != null) {
            //System.out.println(line);
			s+=line;
        }
		System.out.println("The results are as follows ! Please choose one to proceed . ");
		
		int sp=0;
		int t=0;
		for(int a=0;a<5;a++)
			{
				int q=s.indexOf("lister-item-index unbold text-primary",t);
				if(q <=-1)
						break;
				String p=s.substring(q-3,q+200);
				int yy=s.indexOf("lister-item-year text-muted unbold",sp);
				String year=s.substring(yy+37,yy+41);
				int i=p.indexOf("<a href");
								if(i <=-1)
						break;
				String m=p.substring(i,i+100);
				String moviename=m.substring(m.indexOf("adv_li_tt")+11 , m.lastIndexOf("</a>"));
				String link=m.substring(m.indexOf("/") , m.lastIndexOf("?"));
				System.out.println((a+1)+" "+ moviename+" "+year);
				//System.out.println(link);
				names[a]=moviename;
				mlinks[a]=link;
				yor[a]=year;
				t=q+100;
				sp=yy+42;
			}


			System.out.println("Please choose a movie from the above list !");
			 ch=ab.nextInt();
	}
}



