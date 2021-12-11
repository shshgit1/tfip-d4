package day4workshop;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;



public class Cookie {
    public boolean isLogin=false;    
   public String storeUsers=new String("C:\\Users\\sha\\Documents\\tfip-java-assignments\\tfip-d4\\tfip-d4\\cookie\\src\\main\\java\\day4workshop\\ck\\users.txt");
   

    public static void main(String[] args) {
        
    }

  
        public String returnCookie() throws IOException{
            List<String> readread=new ArrayList<>();
            String ss;
            readread=Files.readAllLines(Paths.get("tfip-d4\\cookie\\src\\main\\java\\day4workshop\\ck\\cookie_file.txt"));
            double rand = (Math.random()*readread.size());
            int x = (int) rand;
            ss=readread.get(x);
            return ss; 
          
        }

        public void login(String loginDetail) throws IOException{
            FileWriter fw=new FileWriter(storeUsers,true);// the true appends the line instead of rewriting the file
           
            fw.write(loginDetail +"\n");
            this.isLogin=true;
            fw.close();
         

        }

    
}
