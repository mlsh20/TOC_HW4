/*
  Name:鍾明芬
  Student ID:F74004038
  The class to save the road's informations.
*/

import java.net.*;
import java.io.*;

public class List {
        private String name;
        private int[] month=new int[13];
        private int maxPrice,minPrice;

        public List(){//Initialize the object
                name="Initial";
                maxPrice=0;
                minPrice=100000000;
        }

        public List(String name,int month,int price){//Initialize the object with input information.
                setList(name,month,price);
        }

        public String getName(){//get the road name
                return name;
        }

        public void setName(String name){//set the road name
                this.name=name;
        }

        public int getML(){//get the total number of different month
                int l=0;
                for (int i=0;i<12;i++){
                        if(this.month[i]!=0)
                                l++;
                }
                return l;
        }

        public void setMonth(int month){//set month
                int check=0;
                for (int i=0;i<12;i++){
                        if(this.month[i]==month)
                                check=1;//input month is already in the array
                }
                if(check==0)//input month is new for the array
                        this.month[getML()]=month;
        }

        public int getMax(){//get max price
                return this.maxPrice;
        }

        public int getMin(){//get min price
                return this.minPrice;
        }

        public void setPrice(int price){//set price
                if (this.maxPrice<price)
                        this.maxPrice=price;//update the maxPrice
                if (this.minPrice>price)
                        this.minPrice=price;//update the minPrice
        }

        public void setList(String name,int month,int price){//set object with input informations
                setName(name);
                setMonth(month);
                setPrice(price);
        }

        public void printList(){//print the object's informations
                System.out.println("Name = "+this.name);
                System.out.println("Max price = "+this.maxPrice);
                System.out.println("Min price = "+this.minPrice);
                System.out.print("Month = ");
                for(int i=0;i<getML();i++){
                        System.out.print(" "+month[i]);
                }
                System.out.println();
        }

        public void printAns(){//print out the answer
                System.out.println(this.name+", 最高成交價: "+this.maxPrice+", 最低成交價: "+this.minPrice);
        }
}
