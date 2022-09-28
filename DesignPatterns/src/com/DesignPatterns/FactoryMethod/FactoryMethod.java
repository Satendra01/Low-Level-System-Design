package com.DesignPatterns.FactoryMethod;



class DecodedImage {
	private String image;

	public DecodedImage(String image) {
		super();
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	@Override
	public String toString() {
		return "DecodedImage [image=" + image + "]";
	}
	
}

interface ImageReader
{
	DecodedImage getDecodedImage();
}



class GifReader implements ImageReader{
	DecodedImage decodedImage;
	
	GifReader(String image)
	{
		decodedImage=new DecodedImage(image);
	}

	@Override
	public DecodedImage getDecodedImage() {
		return decodedImage;
	}
	
	
}

class JpegReader implements ImageReader{
	DecodedImage decodedImage;
	
	JpegReader(String image)
	{
		decodedImage=new DecodedImage(image);
	}

	@Override
	public DecodedImage getDecodedImage() {
		return decodedImage;
	}
	
	
}

public class FactoryMethod {
	public static void main(String...args)
	{
		String input="jpeg";
		ImageReader imageReader=null;
		DecodedImage decodedImage=null;
		
		if(input=="gif")
		{
			imageReader=new GifReader("gif");
		}
		else if(input=="jpeg")
		{
			imageReader=new JpegReader("jpeg");
		}
		decodedImage=imageReader.getDecodedImage();
		System.out.println(decodedImage);
	}
}
