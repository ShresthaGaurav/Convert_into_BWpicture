package Interface;

import java.io.File;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import Model.Image;

public class Image_imple implements Image_color {

	@Override
	public void Check_image(Image i) {
		
		try {
			File input = new File(i.getPath().concat(i.getOldimg()));// read file

			BufferedImage image = ImageIO.read(input);// ImageIO-image read bufferedImage store image data in ram
			BufferedImage result = new BufferedImage( // describe image with its image data
					image.getWidth(), // image width
					image.getHeight(), // image height

					BufferedImage.TYPE_BYTE_BINARY);// take image type but no color model argument
			Graphics2D graphic = result.createGraphics(); // define
			graphic.drawImage(image, 0, 0, Color.WHITE, null);// used for image color
			graphic.dispose();

			File output = new File(i.getPath() + i.getNewimg()); // create new file
			ImageIO.write(result, "jpg", output); // image write

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
