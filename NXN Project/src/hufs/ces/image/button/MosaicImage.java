/**
 * Created on Sep 3, 2012
 * @author cskim -- hufs.ac.kr, Dept of CSE
 * Copy Right -- Free for Educational Purpose
 */
package hufs.ces.image.button;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author cskim
 *
 */
public class MosaicImage extends JFrame {

	private JPanel contentPane;

	private static final int ROWS = 20;
	private static final int SIZE = ROWS*ROWS;

	private JButton[] tiles = new JButton[SIZE];
	private BufferedImage[] imageData = new BufferedImage[SIZE];
	private BufferedImage tileImage = null;

	int scrHeight = 0;
	int scrWidth = 0;
    int bWidth = 0;
    int bHeight = 0;
    
    int[] Flag = new int[SIZE];
    
	/**
	 * Launch the application.
	 */
    
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try 
				{
					MosaicImage frame = new MosaicImage();
					frame.setVisible(true);
				}
				catch (Exception exception) 
				{
					exception.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 */
	public MosaicImage() {
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(ROWS, ROWS, 0, 0));
		initialize();
	}

	void initialize(){
		scrHeight = this.getHeight();
		scrWidth = this.getWidth();
		//System.out.println("w="+scrWidth+" h="+scrHeight);
		try 
		{
			tileImage = ImageIO.read(getClass().getResource("a.png"));
		} 
		catch (IOException IOe) 
		{
			// TODO Auto-generated catch block
			IOe.printStackTrace();
		}
		int one_tile_Width = tileImage.getWidth()/ROWS;
		int one_tile_Height =  tileImage.getHeight()/ROWS;
        bWidth = scrWidth/ROWS;
        bHeight = scrHeight/ROWS;

        for (int i=0; i<ROWS; ++i){
        	for (int j=0; j<ROWS; ++j){
        		imageData[ROWS*i+j] = 
        		tileImage.getSubimage(j*one_tile_Width, i*one_tile_Height, one_tile_Width, one_tile_Height);
        	}
        }
        
        for(int i = 0; i<SIZE;i++)
        	Flag[i] = 0;
       
		for (int i = 0; i<SIZE; i++){
			Color col = getAverageColor(imageData[i]);
			tiles[i] = new JButton();
			tiles[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent event) {
					// TODO Auto-generated method stub
					for(int j = 0; j<SIZE;j++){
						Color bcol = getAverageColor(imageData[j]);
						if( event.getSource() == tiles[j]){
							if(Flag[j] == 0){
								tiles[j].setIcon(new ImageIcon(OneColorBufferedImage.getBufferedImage(bWidth, bHeight, col)));
								Flag[j] = 1;
							}
							else{
								tiles[j].setIcon(new ImageIcon(imageData[j]));
								Flag[j] = 0;
							}
						}
					}
				}
			});
			
			tiles[i].setIcon(new ImageIcon(imageData[i]));
			contentPane.add(tiles[i]);
		}
	}
	
	Color getAverageColor(BufferedImage tile){
		int tile_width = tile.getWidth();
		int tile_height =  tile.getHeight();
		double pixSize = tile_width*tile_height;
		double Red = 0;
		double Green = 0;
		double Blue = 0;
		Color pixColor = null;
		for (int i=0; i<tile_height; ++i){
			for (int j=0; j<tile_width; ++j){
				pixColor = new Color(tile.getRGB(i,j));
				Red += pixColor.getRed();
				Green += pixColor.getGreen();
				Blue += pixColor.getBlue();
			}
		}
		int Red_avg = (int)(Red/pixSize);
		int Green_avg = (int)(Green/pixSize);
		int Blue_avg = (int)(Blue/pixSize);
		return new Color(Red_avg, Green_avg, Blue_avg);
	}
}