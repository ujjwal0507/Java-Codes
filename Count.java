import java.io.*; 
  
class Count 
{ 
    public static void main(String args[])  throws Exception
    { 
        File file = new File("SampleTextFile.txt");
        FileReader fr = new FileReader(file);
        BufferedReader in = new BufferedReader(fr);
        String str = "", text = "";
        while((str=in.readLine())!=null){
            text+=str;
        }
        int upper = 0, lower = 0, number = 0, special = 0; 
  
        for(int i = 0; i < text.length(); i++) 
        { 
            char ch = text.charAt(i); 
            if (ch >= 'A' && ch <= 'Z') 
                upper++; 
            else if (ch >= 'a' && ch <= 'z') 
                lower++; 
            else if (ch >= '0' && ch <= '9') 
                number++; 
            else
                special++; 
        } 
  
        System.out.println("Lower case letters : " + lower); 
        System.out.println("Upper case letters : " + upper); 
        System.out.println("Number : " + number); 
        System.out.println("Special characters : " + special); 
    } 
} 