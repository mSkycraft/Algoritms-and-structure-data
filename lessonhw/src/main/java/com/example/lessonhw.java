package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


class lessonhw{

    public static class Notebook{
        public int price;
        public int ram;
        public BRANDS brand;

        Notebook(int p,int r, BRANDS b){
            this.price = p;
            this.ram = r;
            this.brand = b;
        }
        public int getPrice() {return price;}
        public int getRam() {return ram;}
        public BRANDS getBrand() {return brand;}

        @Override
        public String toString() {
            return "Notebook [price=" + price 
                                + ", ram=" + ram 
                                +", brand=" + brand
                                + "]\n";
        }
    };
    public static final int[] PRICES = new int[]{100, 200, 300, 400, 500, 600, 700, 800};
    public static final int[] RAMS = new int[]{4, 8, 16, 20, 24, 28, 32};
    public enum BRANDS {Lenuvo, Asos, MacNote, Eser, Xamiou};

    public static void main(String[] args) {
        List<Notebook> notebooks = new ArrayList<>();
        Random rnd = new Random();
        for(int i =0; i < 10000; i++){
            notebooks.add(new Notebook(
                PRICES[rnd.nextInt(PRICES.length)],
                RAMS[rnd.nextInt(RAMS.length)],
                BRANDS.values()[rnd.nextInt(5)]));
        }
        System.out.println(notebooks.size());
        for (int i=0; i<10;i++) {
            System.out.printf("%d %d %s\n",notebooks.get(i).getPrice(),notebooks.get(i).getRam(),notebooks.get(i).getBrand());
        }
        System.out.println("Сортировка");
        notebooks.sort(Comparator.comparing(Notebook::getPrice).thenComparing(Notebook::getRam).thenComparing(Notebook::getBrand));;

        for (Notebook notebook : notebooks) {
            System.out.printf("%d %d %s\n",notebook.getPrice(),notebook.getRam(),notebook.getBrand());
        }
        
    }
}