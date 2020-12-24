package HomeWorks.HomeWork1;

public class Cat implements Moving{

  String name;

  public Cat(String name) {
    this.name = name;
  }


  @Override
  public String toString() {
    return "Кот по кличке:"+this.name;
  }

  @Override
  public void run() {

  }

  @Override
  public void jump() {

  }
}
