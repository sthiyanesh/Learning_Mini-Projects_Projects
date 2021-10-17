import java.io.*;
public class copyContent {
	public static void main(String[] args) throws Exception{
        if(args.length<2){
            System.out.println("Enter the Nmae of Files in CommandLine\nSyntax: java copyContent file1.txt file2.txt");
            System.exit(0);
        }
		File x = new File(args[0]);
		File y = new File(args[1]);
		FileInputStream in = new FileInputStream(x);
		FileOutputStream out = new FileOutputStream(y);
		try {
			int n;
			while ((n = in.read()) != -1)
				out.write(n);
		}
		finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
		System.out.println("File Copied");
	}
}