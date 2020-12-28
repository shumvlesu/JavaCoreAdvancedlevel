package HomeWorks.HomeWork1;

public class Main {
  public static void main(String[] args) {

    //1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
    // Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).

    //2. Создайте два класса: беговая дорожка и стена, при прохождении через которые,
    // участники должны выполнять соответствующие действия (бежать или прыгать),
    // результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).

    //3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.

    //4. * У препятствий есть длина (для дорожки) или высота (для стены),
    // а участников ограничения на бег и прыжки. Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.

    boolean result;

    Moving[] myArrays = {new Cat("Васька", 1.5, 200), new Human("Миша", 2.40, 500), new Robot("11010000101001001101000110010001110100001011010011010000101111101101000110000000", 10, 1000)};
    Obstacle[] obstacles = {new Wall(2), new Track(300), new Wall(6)};

    System.out.println("Начинаем соревнование:");
    for (Moving myArray : myArrays) {
      System.out.println(myArray.toString() + " начинает соревнование:");
      for (Obstacle obstacle : obstacles) {
        if (obstacle instanceof Wall) {
          result = myArray.jump(obstacle);
          System.out.println(result ? "Стена пройдена!" : "Стена не пройдена :(");
          if (!result) break;
        } else if (obstacle instanceof Track) {
          result = myArray.run(obstacle);
          System.out.println(result ? "Дорожка пройдена!" : "Дорожка не пройдена :(");
          if (!result) break;
        } else {
          System.out.println("Неизвестный тип препятствия!");
        }
      }
    }


  }


}