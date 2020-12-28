package HomeWorks.HomeWork1;

public class Cat implements Moving{

  String name;
  double jump_meter;
  double run_meter;

  public Cat(String name, double jump_meter, double run_meter) {
    this.name = name;
    this.jump_meter = jump_meter;
    this.run_meter = run_meter;
  }

  @Override
  public String toString() {
    return "Кот по кличке: "+this.name;
  }

  @Override
  public boolean run(Obstacle track) {
    return this.run_meter >= track.getLongTrack();
  }

  @Override
  public boolean jump(Obstacle wall) {
    return this.jump_meter >= wall.getHeightWall();
  }
}
