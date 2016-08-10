package com.leo.api;

/**
 * 日期
 * 
 * @author leo
 *
 */
public class Date {
	private final int value;
	
	/**
	 * 测试方法
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println(new Date(2008, 2, 29));
			System.out.println(new Date(2016, 13, 56).getMaxDaysByMonth());
		} catch (InvalidDateException e) {
			System.out.println("Wa！InvalidDateException Warning！");
			System.out.println("Message："+e.getMessage());
			System.out.println("InvalidDate is : "+e.getInvalidDate());
			e.printStackTrace();
		}
	}
	
	/**
	 * 创建一个日期
	 * @param y
	 * @param m
	 * @param d
	 * @throws InvalidDateException 
	 */
	public Date(int y,int m,int d) throws InvalidDateException {
		this.value = y*512 + m*32 + d;
		if(this.year()<=0)
			throw new InvalidDateException("非法日期-年份非法",this.toString());
		if(this.month()<=0||this.month()>12)
			throw new InvalidDateException("非法日期-月份非法",this.toString());
		if(this.day()!=this.getMaxDaysByMonth())
			throw new InvalidDateException("非法日期-日号非法",this.toString());
	}
	
	/**
	 * 根据月份返回该月份的最大天数
	 * @return
	 */
	public int getMaxDaysByMonth() {
		String m1 = "13578";
		String m2 = "469";
		String month = String.valueOf(this.month());
		if(m1.contains(month)||"10".equals(month)||"12".equals(month)) 
			return 31;
		if(m2.contains(month)||"11".equals(month))
			return 30;
		if("2".equals(month)) {
			if(this.isLeapYear()) return 29;
			else return 28;
		}
		return -1;
	}
	
	/**
	 * 判断当前年份是否是闰年
	 * @return
	 */
	public boolean isLeapYear() {
		return this.year()%4==0 ? true : (this.year()%400==0 ? true : false);
	}
	/**
	 * 判断当前年份是否是平年
	 * @return
	 */
	public boolean isCommonYear() {
		return !this.isLeapYear();
	}
	
	/**
	 * 返回年
	 * @return
	 */
	public int year() {
		return value/512;
	}
	
	/**
	 * 返回月
	 * @return
	 */
	public int month() {
		return (value/32)%16;
	}
	
	/**
	 * 返回日
	 * @return
	 */
	public int day() {
		return value%32;
	}
	
	@Override
	public String toString() {
		return year()+"/"+month()+"/"+day();
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj) return true;
		if(obj==null) return false;
		if(this.getClass() != obj.getClass()) return false;
		Date that = (Date)obj;
		if(this.year() != that.year()) return false;
		if(this.month() != that.month()) return false;
		if(this.day() != that.day()) return false;
		return true;
	}
	
}

class  InvalidDateException extends Exception {
	private static final long serialVersionUID = 1L;
	private String invalidDate;
	public InvalidDateException() {
		super();
	}
	public InvalidDateException(String message) {
		super(message);
	}
	public InvalidDateException(String message,String invalidDate) {
		super(message);
		this.invalidDate = invalidDate;
	}
	public String getInvalidDate() {
		return invalidDate;
	}
}
