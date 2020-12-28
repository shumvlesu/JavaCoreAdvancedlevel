package HomeWorks.HomeWork1;

public class Wall implements Obstacle{

  private int heightWall; //высота стены

  public Wall(int heightWall) {
    this.heightWall = heightWall;
  }

  @Override
  public int getHeightWall() {
    return heightWall;
  }

  @Override
  public int getLongTrack() {
    return 0;
  }
}
