package org.webapi.utility;

public class MathTool
{
	/**
	 * 求两组经纬度之间的距离
	 * 
	 * @param lat
	 * @param lng
	 * @param desLat
	 * @param desLng
	 * @return
	 */
	public static double calcDistance(double lat, double lng, Double desLat, Double desLng)
	{
		if (lat == 0 || lng == 0 || desLat == null || desLng == null || desLat == 0 || desLng == 0)
		{
			return 0;
		}

		double earth_padius = 6378.137;
		double radLat1 = Math.toRadians(lat);
		double radLat2 = Math.toRadians(desLat);
		double a = radLat1 - radLat2;
		double b = Math.toRadians(lng) - Math.toRadians(desLng);

		double dis = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
		dis = dis * earth_padius;
		// dis = Math.rint(dis * 100000) / 100;
		dis = Math.rint(dis * 1000);

		return dis;
	}
	
	private static double rad(double i)
	{
		double PI = 3.14159265358979324;
		return i * PI / 180.0;
	}

	/**
	 * 
	 * @param lat1 中心经度
	 * @param lng1 中心纬度
	 * @param lat2 要比较的经度
	 * @param lng2 要比较的纬度
	 * @return
	 */
	public static double getDistance(double lat1, double lng1, double lat2, double lng2)
	{
		double earth_padius = 6378.137;
		double radLat1;
		double radLat2;
		double a;
		double b;
		double s;

		if (lat1 == 0 || lat2 == 0 || lng1 == 0 || lng2 == 0)
		{
			return 0;
		}

		radLat1 = rad(lat1);
		radLat2 = rad(lat2);
		a = rad(lat1) - rad(lat2);
		b = rad(lng1) - rad(lng2);
		s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
		s = s * earth_padius;
		s = Math.round(s * 1000);
		return s;
	}
}
