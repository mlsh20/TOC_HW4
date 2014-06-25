/*
  Name:鍾明芬
  Student ID:F74004038
  Parse data from URL , save them to data.json
*/


import java.net.*;
import java.io.*;
public class read1{
    public read1( String strURL ) {
        int chunksize = 4096;
        String line = null;
        byte[] chunk = new byte[chunksize];
        int count;
        try  {
                URL pageUrl = new URL(strURL );
                BufferedReader bis = new BufferedReader(new InputStreamReader(pageUrl.openStream(), "UTF-8"));// 讀入網頁(位元串流)
                BufferedWriter bw = new BufferedWriter(new FileWriter("data.json", false));//寫檔導向
                //System.out.println("read1() running " );
                while ((line = bis.readLine()) != null) {
                        bw.write(line); // 寫入檔案
                }
                bis.close();
                bw.close();
                //System.out.println("Done");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
