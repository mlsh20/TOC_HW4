/*
  Name:Áé©úªâ
  Student ID:F74004038
  Call read1 to parse data from URL to data.json.
  Call myJson to find out the answer.
*/

import java.net.*;
import java.io.*;
import org.json.*;

public class TocHw4{
        public static void main(String[] arg) throws Exception{
                String web1 = arg[0];/*"http://www.datagarage.io/api/5365dee31bc6e9d9463a0057"*///UTF-8
                String file = "data.json";
                read1 read = new read1(web1);
                myJson j = new myJson(file);
        }
}
