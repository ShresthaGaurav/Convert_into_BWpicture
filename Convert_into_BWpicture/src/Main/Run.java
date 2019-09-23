package Main;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.imageio.ImageIO;

import Interface.Image_color;
import Interface.Image_imple;
import Model.Image;

public class Run {
	Image image = new Image();
	String path ;
	public static void main(String[] args) {
		new Run().Getimage();
	}

	private void Getimage() {
		Scanner scanner = new Scanner(System.in);
	
		System.out.println("Enter Image full path\n");
		path= (scanner.next());
		System.out.println("Enter edit image name\n");
		String oldimg = (scanner.next());
		System.out.println("Enter new image name\n");
		String newimg = (scanner.next());
		scanner.close();
		image.setOldimg(new Run().checkFile(oldimg));
		image.setNewimg(new Run().checkFile(newimg));
//		image.setPath(path);
		if(checkPath(path)) {
		
		if((checkType(image.getPath().concat(image.getOldimg())))==true) {
			Image_color ic = new Image_imple();
			ic.Check_image(image);
		}
		else {
			System.out.println("please check edit  file name " +image.getPath().concat(image.getOldimg()));
		}}else {
			System.out.println("please check   file path "+image.getPath());
		}
		

	}

	private String checkFile(String img) {
		if (!img.contains(".jpg")) {
			img = img.concat(".jpg");
		} else if (!img.contains("\\")) {
			img = "\\" + img;
		}
		return img;
	}

	private boolean checkType(String name) {

		File f = new File(name);
		try {
			return ImageIO.read(f) != null;
		} catch (Exception e) {
			return false;
		}
	}

	private boolean checkPath(String paths) {
		try {
			
			paths=paths.replace(image.getOldimg(), "");
			Path p = Paths.get(paths);
			image.setPath(paths);
			
			
			return Files.exists(p);
		
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}
}