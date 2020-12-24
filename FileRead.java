import java.io.*;

public class FileRead {
    public static void main(String[] args) throws IOException, FileNotFoundException{
        File file = new File("SampleTextFile.txt");
        FileReader fr = new FileReader(file);
        BufferedReader in = new BufferedReader(fr);
        int cu = 0, cl = 0, cw = 0, cv = 0, cc = 0;
        String str = "";
        while((str=in.readLine())!=null){
            for(char ch: str.toCharArray()){
                if(Character.isWhitespace(ch)){
                    cw++;
                }
                if(Character.isLetter(ch)){
                    if(Character.isUpperCase(ch)){
                        cu++;
                    }
                    if(Character.isLowerCase(ch)){
                        cl++;
                    }
                    if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U'){
                        cv++;
                    }
                    else
                        cc++;
                }
            }
        }
        in.close();
        System.out.println("Number of Lower Case Letters: "+cl);
        System.out.println("Number of Upper Case Letters: "+cu);
        System.out.println("Number of Whitespaces: "+cw);
        System.out.println("Number of Vowels: "+cv);
        System.out.println("Number of Consonents: "+cc);
    }
}