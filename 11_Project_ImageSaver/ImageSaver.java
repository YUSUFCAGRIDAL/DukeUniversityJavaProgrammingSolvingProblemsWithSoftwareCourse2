/**
 * Make copies of all images selected within a directory (or folder).
 * 
 * @author YUSUF ÇAĞRI DAL
 */
import edu.duke.*;
import java.io.File;

public class ImageSaver {
	public void doSave() {
		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()) {
			ImageResource image = new ImageResource(f);
			String fname = image.getFileName(); 
			String newName = "copy-" + fname; //fname is the old name
			image.setFileName(newName); //set the new name that we created
			image.draw(); //program draws the images that we selected and print them to UI
			image.save(); //save the file
		}
	}
}
