package gifmaker;
// Uses code by Zeheng Li on 04-25-2014

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;

public class GifMaker {
	
	public static void makeGifs(File outputFile, BufferedImage[] nextImage, long timeper) throws Exception{
		// create a new BufferedOutputStream with the last argument
		ImageOutputStream output = new FileImageOutputStream(outputFile);
		// create a gif sequence with the type of the first image
		GifSequenceWriter writer = new GifSequenceWriter(output, nextImage[0].getType(), timeper, true);
		// write out the first image to our sequence...
		writer.writeToSequence(nextImage[0]);
		for (int i = 1; i < nextImage.length; i++) {
			writer.writeToSequence(nextImage[i]);
		}

		writer.close();
		output.close();
	}

}
