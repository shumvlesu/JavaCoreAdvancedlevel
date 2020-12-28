package HomeWorks.HomeWork1;

public class Track implements Obstacle{

  private int longTrack;

  public Track(int longTrack) {
    this.longTrack = longTrack;
  }

  @Override
  public int getLongTrack() {
    return longTrack;
  }

  @Override
  public int getHeightWall() {
    return 0;
  }
}
