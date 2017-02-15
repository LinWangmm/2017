package com.example.mxyc.wangluo;



import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
/*
 * ͼƬѹ��
 **/
public class HttpBitmap {

	public HttpBitmap() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static Bitmap getBitmap(String url,int reswidth,int reshight)
	{
		byte []data =Httpurl.getByteArray(url);
		//�������Ĳ�������
		BitmapFactory.Options options = new BitmapFactory.Options();
		//Ϊ���ڽ�����У����������ڴ�ռ䡣���ǿ��Ի��ԭʼͼƬ�ĳߴ�
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeByteArray(data, 0, data.length, options);
		//�ƶ�����֮���ͼƬѹ�����
		options.inSampleSize=calucIamgeSamlpleSize(options, 100, 100);
		options.inJustDecodeBounds = false;
	    return BitmapFactory.decodeByteArray(data, 0,data.length, options);

	}

	public static int calucIamgeSamlpleSize(BitmapFactory.Options options,
			int reswidth, int reshight) {
		final int height = options.outHeight;
		final int width = options.outWidth;
		int inSampleSize = 1;

		if (height > reshight || width > reswidth) {

			// Calculate ratios of height and width to requested height and
			// width
			final int heightRatio = Math.round((float) height
					/ (float) reshight);
			final int widthRatio = Math.round((float) width / (float) reswidth);

			// Choose the smallest ratio as inSampleSize value, this will
			// guarantee
			// a final image with both dimensions larger than or equal to the
			// requested height and width.
			inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
		}

		return inSampleSize;

	}
}
