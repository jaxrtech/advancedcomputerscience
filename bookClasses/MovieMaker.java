import java.awt.*;

public class MovieMaker{
  
public void makeRectangleMovie(String directory)
{
  int fps = 40;
  Picture p = null;
  Graphics g = null;
  FrameSequencer fSequencer = new FrameSequencer(directory);
  for (int i = 0; i < fps; i++)
  {
    p = new Picture(640,480);
    g = p.getGraphics();
    g.setColor(Color.magenta);
    g.fillOval(i*20, 100, 17, 17);
    fSequencer.addFrame(p);
  }  
  fSequencer.show();
  fSequencer.play(fps);
}

public void makeTickerTapeMovie(String directory, String message)
{
  int fps = 50;
  Picture p = null;
  Graphics g = null;
  FrameSequencer fSequencer = new FrameSequencer(directory);
  Font font = new Font ("Times New Roman", Font.BOLD, 8);

    for (int i = fps * 2; i > 0 ; i--)
  {
    p = new Picture(500,100);
    g = p.getGraphics();
    g.setColor(Color.magenta);
    g.setFont(font);
    g.drawString(message, 500 - (i * 10), 50);
    fSequencer.addFrame(p);
  }
  fSequencer.show();
  fSequencer.play(fps);
} 
public void moveMarksEye(String directory)
{
  String fName = "X:/1McDaniel/Media Comp/mediasources/blue-Mark.jpg";
  Picture markP = new Picture(fName);
  String bName = "X:/........yankee stadium";
  Picture yank = new Picture(bName);
  yank.explore();
  markP.explore();
  Picture target = null;
  FrameSequencer fSequencer = new FrameSequencer(directory);
  int fps = 30;
  for (int i = 0; i < fps; i++)
  {
    target = new Picture(yank);
    target.copy(markP,300,35,200,35,i*10,i*7);
    fSequencer.addFrame(target);
  }
  fSequencer.show();
  fSequencer.play(fps);
  }
public void moveButterfly(String directory)
{
  String fName = "X:/1McDaniel/Media Comp/mediasources/butterfly.jpg";
  Picture markP = new Picture(fName);
  String bName = "X:/1McDaniel/Media Comp/mediasources/church.jpg";
  Picture yank = new Picture(bName);
  yank.explore();
  markP.explore();
  Picture target = null;
  FrameSequencer fSequencer = new FrameSequencer(directory);
  int fps = 25;
  for (int i = 0; i < fps; i++)
  {
    target = new Picture(yank);
    target.copy(markP,0,50,0,62,i*12,i*10);
    fSequencer.addFrame(target);
  }
  fSequencer.show();
  fSequencer.play(fps);
  }

  public static void main(String[] args)
  {

    MovieMaker movieMaker = new MovieMaker();
    String dir = "c:";
    movieMaker.moveButterfly(dir);

  }
}
  