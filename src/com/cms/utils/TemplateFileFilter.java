package com.cms.utils;

import java.io.File;
import java.io.FilenameFilter;

public class TemplateFileFilter 
{
	public static String[] getTemplateFiles(String realpath,final String pattern)
	{
		File f=new File(realpath);
		String[] re=null;
		re=f.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				if(name.indexOf(pattern)!=-1)
				return true;
				else 
				return false;
						
			}
		});
		return re;
		
	}
}
