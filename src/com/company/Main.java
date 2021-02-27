package com.company;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String []args){
        int[][] array = makeRandomArray(10);
        print(array);
    }
    public static int[][] makeRandomArray(int n){
        Random random = new Random(); //Генератор случайных чисел
        int[][] array=new int[n][]; //Массив массивов случайных чисел
        Set<Integer> sizesSet=new HashSet<>(); //Сет для генерации неповторяющихся размеров
        //Генерация неповторяющихся размеров массивов
        while(sizesSet.size()<n){
            //sizesSet.add(Math.abs(random.nextInt())); //Для неограниченных значений
            //Ограничение для проверки работы:
            sizesSet.add(Math.abs(random.nextInt(20)));
        }
        //Формирование и заполнение массивов случайными чисами
        int i=0;
        for(int size: sizesSet){
            array[i]=new int[size];
            for(int j=0;j<size;j++){
                //array[i][j]=random.nextInt();   //Для неограниченных значений
                //Ограничение для проверки работы:
                array[i][j]=random.nextInt(100);
            }
            i++;
        }
        //Сортировка массивов
        for(int index=0;index<array.length;index++){
            if(index%2==0) ascendingSort(array[index]);
            else descendingSort(array[index]);
        }
        return array;
    }
    //Сортировка по возрастанию
    public static void ascendingSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            int j = i - 1;
            while(j>=0) {
                if (value < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
                j--;
            }
            array[j + 1] = value;
        }
    }
    //Сортировка по убыванию
    public static void descendingSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            int j = i - 1;
            while(j>=0) {
                if (value > array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
                j--;
            }
            array[j + 1] = value;
        }
    }
    //Вывод на экран
    public static void print(int[][] array){
        for(int index=0;index<array.length;index++){ ;
            for(int j=0;j<array[index].length;j++){
                //array[i][j]=random.nextInt();
                //Ограничение для проверки работы:
                System.out.print(array[index][j]+" ");
            }
            System.out.println();
        }
    }
}
