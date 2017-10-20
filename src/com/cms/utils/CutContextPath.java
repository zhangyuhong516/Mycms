package com.cms.utils;

public class CutContextPath {

	public static String cutContext(String path)
	{
		String re=null;
		if(null!=path&&!"".equals(path))
		{
			int index=path.indexOf("uppics");
			re="../"+path.substring(index);
		}
		return re;
	}
}
