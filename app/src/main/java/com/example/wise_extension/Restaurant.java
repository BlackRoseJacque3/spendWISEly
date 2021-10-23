package com.example.wise_extension;

import java.util.Random;

public class Restaurant {
    MenuElements[] listOfMenuElements = new MenuElements[]{};
    String name;
    double average;

    //Getters
    public String getName(){ return name; }
    public double getAverage(){ return average; }

    //Setters
    public void setName(String newName){ this.name = newName;}
    public void setAverage(double newAverage) {this.average = newAverage;}

    public static void GeneratingRestaurants(Restaurant[] newlist){
        Restaurant[] listofRestaurants = new Restaurant[]{};
        for(int i=0;i<20;i++){

            listofRestaurants[i].setName("Restaurant" + i);

            Random rand = new Random();
            int upperBound = 35;
            int upperBound2 = 50;

            int price = rand.nextInt(upperBound);
            int howMany = rand.nextInt(upperBound2);

            // First item in the menu
            MenuElements food1 = new MenuElements();
            food1.setName("Pizza Prosciutto et Funghi");
            food1.setPrice(price);
            food1.setHowMany(howMany);
            food1.setDayOfWeek("Wednesday");
            listofRestaurants[i].listOfMenuElements[0] = food1;

            // 2nd item in the menu
            food1.setName("Pasta Carbonara");
            food1.setPrice(price);
            food1.setHowMany(howMany);
            food1.setDayOfWeek("Monday");
            listofRestaurants[i].listOfMenuElements[1] = food1;

            // 3rd item in the menu
            food1.setName("Soup a la creme");
            food1.setPrice(price);
            food1.setHowMany(howMany);
            food1.setDayOfWeek("Tuesday");
            listofRestaurants[i].listOfMenuElements[2] = food1;

            // 4th item in the menu
            food1.setName("Caesar Salad");
            food1.setPrice(price);
            food1.setHowMany(howMany);
            food1.setDayOfWeek("Thursday");
            listofRestaurants[i].listOfMenuElements[3] = food1;

            // 5th item in the menu
            food1.setName("Water");
            food1.setPrice(price);
            food1.setHowMany(howMany);
            food1.setDayOfWeek("Wednesday");
            listofRestaurants[i].listOfMenuElements[4] = food1;

            // 6th item in the menu
            food1.setName("Fruit Juice");
            food1.setPrice(price);
            food1.setHowMany(howMany);
            food1.setDayOfWeek("Friday");
            listofRestaurants[i].listOfMenuElements[5] = food1;

            // 7th item in the menu
            food1.setName("Day's menu");
            food1.setPrice(price);
            food1.setHowMany(howMany);
            food1.setDayOfWeek("Wednesday");
            listofRestaurants[i].listOfMenuElements[6] = food1;

            // 8th item in the menu
            food1.setName("Kids' menu");
            food1.setPrice(price);
            food1.setHowMany(howMany);
            food1.setDayOfWeek("Wednesday");
            listofRestaurants[i].listOfMenuElements[7] = food1;

            // 9th item in the menu
            food1.setName("Beer");
            food1.setPrice(price);
            food1.setHowMany(howMany);
            food1.setDayOfWeek("Wednesday");
            listofRestaurants[i].listOfMenuElements[8] = food1;

            // 10th item in the menu
            food1.setName("Wine");
            food1.setPrice(price);
            food1.setHowMany(howMany);
            food1.setDayOfWeek("Wednesday");
            listofRestaurants[i].listOfMenuElements[9] = food1;
        }
        newlist = listofRestaurants;
    }
}