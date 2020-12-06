package experiment;

public class Halfresearch {
	public static int binarySearch(int[] srcArray, int des)
	{
		int i=0;
		int j=srcArray.length-1;
		int m=(i+j)/2;
		while(i<=j)
		{
			if(srcArray[m]==des) break;
			if(srcArray[m]<des) i=m+1;
			if(srcArray[m]>des) j=m-1;
			m=(i+j)/2;
		}
		return m;
	}

}
