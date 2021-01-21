package HomeWorks.HomeWork5;

import java.util.Arrays;

public class Main {
  //1. Необходимо написать два метода, которые делают следующее:
  //1) Создают одномерный длинный массив, например:
  //static final int size = 10000000;
  //static final int h = size / 2;
  //float[] arr = new float[size];
  //2) Заполняют этот массив единицами;
  //3) Засекают время выполнения: long a = System.currentTimeMillis();
  //4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
  //arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
  //5) Проверяется время окончания метода System.currentTimeMillis();
  //6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
  //Отличие первого метода от второго:
  //Первый просто бежит по массиву и вычисляет значения.
  //Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
  //
  //Пример деления одного массива на два:
  //System.arraycopy(arr, 0, a1, 0, h);
  //System.arraycopy(arr, h, a2, 0, h);
  //
  //Пример обратной склейки:
  //System.arraycopy(a1, 0, arr, 0, h);
  //System.arraycopy(a2, 0, arr, h, h);
  //
  //Примечание:
  //System.arraycopy() копирует данные из одного массива в другой:
  //System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника,
  //массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
  //По замерам времени:
  //Для первого метода надо считать время только на цикл расчета:
  //for (int i = 0; i < size; i++) {
  //arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
  //}
  //Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.

  static final int size = 10000000;
  static final int h = size / 2;

  public static void main(String[] args) {
    Main mainClass = new Main();
    mainClass.myMethod1();
    System.out.println();
    mainClass.myMethod2();
  }

  void myMethod1(){
    float[] arr = createAndFillAnArray();
    System.out.println("Начало 1го метода:\n");
    iteratingOverAnArray(arr);
  }

  void myMethod2(){
    float[] arr = createAndFillAnArray();
    float[] arr1 = new float[h];
    float[] arr2 = new float[h];
    System.out.println("Начало 2го метода:\n");
    long a = System.currentTimeMillis();
    System.arraycopy(arr, 0, arr1, 0, h);
    System.arraycopy(arr2, 0, arr, h, h);
    System.out.printf("Время разделения массива %s\n", System.currentTimeMillis()-a);


    Thread thread1 = new Thread(() ->this.iteratingOverAnArray(arr1,"1"));
    Thread thread2 = new Thread(() ->this.iteratingOverAnArray(arr2,"2"));

    thread1.setPriority(Thread.MIN_PRIORITY);
    thread2.setPriority(Thread.MAX_PRIORITY);
    thread1.start();
    thread2.start();

    try{
      thread1.join();
      thread2.join();
    } catch (InterruptedException e){
      System.out.printf("Сработало исключение в потоках. %s\n", e.getMessage());
    }

    long copyStartTime = System.currentTimeMillis();
    System.arraycopy(arr1, 0, arr, 0, h);
    System.arraycopy(arr2, 0, arr, h, h);
    long endTimeMethod = System.currentTimeMillis();
    System.out.printf("Время выполнния склейки массива %s\n", endTimeMethod - copyStartTime);
    System.out.printf("Завершение метода 2. Время выполнения %s\n", endTimeMethod - a);

  }

  float[] createAndFillAnArray(){
    float[] arr = new float[size];
    Arrays.fill(arr, 1.0f);
    return arr;
  }

  void iteratingOverAnArray(float[] arr){
    iteratingOverAnArray(arr, "");
  }

  void iteratingOverAnArray(float[] arr, String charNumArray){
    long b = System.currentTimeMillis();
    System.out.printf("Начало обработки массива: %d \n", b);
    for(int i = 0; i < arr.length; i++){
      arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }
    System.out.printf("Завершение обработки массива %s: Время выполнения заняло %s \n", charNumArray, System.currentTimeMillis() - b);
  }

}
