package Lessons.Lesson3;

//интерфейс Comparable служит для описания способа сравнения объектов  для их дальнейшего
//упорядочивания. Данный интерфейс указывает что объекты этого типа могут быть упорядочены.
public class Cat implements Comparable {
  private final String name;
  private final int age;

  public Cat(String name, int age) {
    this.name = name;
    this.age = age;
  }

  //В  интерфейсе  Comparable  описан  метод  compareTo(Object  o),  который  отвечает  за  сравнение
  //объектов  нашего  класса.  Если  метод  compareTo()  вернет  положительное  число,  значит  текущий
  //объект (this) больше o, если отрицательное - this меньше o, если вернул 0, значит объекты равны
  //между собой.
  @Override
  public int compareTo(Object o) {
    //    Cat another = (Cat) o;
    //    if (this.age > another.age) {
    //      return 1;
    //    }
    //    if (this.age < another.age) {
    //      return -1;
    //    }
    //    return 0;

    //Указанную выше реализацию метода compareTo можно сократить до:
    return this.age - ((Cat) o).age;
  }

  @Override
  public String toString() {
    return "Cat [" + name + "]";
  }
}
