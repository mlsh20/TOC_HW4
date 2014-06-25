/*
  Name:鍾明芬
  Student ID:F74004038
  Read data.json and save the data into JSONArray json.
  Deal with road names and check whether this road is already in the jList,if yes,add information about the road,or add this new road's information into jList.
  Finally,find the roads has the max different trade month and print them out.
*/

import java.net.*;
import java.io.*;
import org.json.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class myJson{

        public myJson(String filename) throws Exception{
                JSONArray json = new JSONArray(new JSONTokener(new FileReader(new File(filename))));//read data.json and save the data into JSONArray json
                JSONObject jo;
                List[] jList = new List[json.length()];//Declare the List array(jList) for Price data.
                for(int i=0;i<json.length();i++)
                {
                        jList[i] = new List();//Initial jList
                }
                String name;//the road's name after process
                int month;//trade record's month
                int price;//the trade price
                int max=0;//the road's number which has the max different trade month
                int i=0,k=0;//temp numbers

                for (i=0;i<json.length();i++){
                        jo = json.getJSONObject(i);
                        name=findString(jo.getString("土地區段位置或建物區門牌"));//get the road's name
                        if(name.compareTo("no")!=0){
                                for(k=0;k<i;k++){
                                        if(jList[k].getName().compareTo(name)==0){//the road is already in the jList
                                                jList[k].setList(name,jo.getInt("交易年月"),jo.getInt("總價元"));//add information
                                                break;
                                        }
                                        else if(jList[k].getName().compareTo("Initial")==0){//the road is new for the jList
                                                jList[k].setList(name,jo.getInt("交易年月"),jo.getInt("總價元"));//add information
                                                break;
                                        }
                                }
                        }
                }
                for(i=0;i<k;i++){
                        if(jList[max].getML()<jList[i].getML())
                        {
                                max=i;//find out which road has the max number of different trade month
                        }
                }
                for(i=0;i<k;i++){
                        if(jList[i].getML()==jList[max].getML()){//if there has the same number of different trade month , print them out
                                jList[i].printAns();
                        }
                }

        }

        public String findString(String input){//cut the road's information
                int i,k;
                String output=" ";
                if(input.contains("路")){
                        i=input.lastIndexOf("路");
                        output = input.substring(0,i+1);
                }
                else if(input.contains("街")){
                        i=input.lastIndexOf("街");
                        output = input.substring(0,i+1);
                }
                else if(input.contains("大道")){
                        i=input.lastIndexOf("道");
                        k=input.lastIndexOf("大");
                        if (i==k+1){
                                output = input.substring(0,i+1);
                        }
                }
                else if(input.contains("巷")){
                        i=input.lastIndexOf("巷");
                        output = input.substring(0,i+1);
                }
                else{
                        output = "no";
                }
                return output;
        }
}
