package com.example.wise_extension;

public class MenuElements {
        String name;
        float price;
        int howMany;
        String dayOfWeek;

        //Getters
        public String getName(){
            return name;
        }
        public float getPrice(){
            return price;
        }
        public int getHowMany(){
            return howMany;
        }
        public String getDayOfWeek(){
            return dayOfWeek;
        }

        //Setters
        public void setName(String newName){ this.name = newName; }
        public void setPrice(float newPrice){ this.price = newPrice; }
        public void setHowMany(int newMany){
            this.howMany = newMany;
        }
        public void setDayOfWeek(String newDay){
            this.dayOfWeek = newDay;
        }
}
