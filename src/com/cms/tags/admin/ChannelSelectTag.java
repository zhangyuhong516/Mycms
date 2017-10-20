package com.cms.tags.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.cms.pojo.Channel;
import com.cms.service.ChannelService;
import com.cms.service.proxy.ProxyFacotry;

public class ChannelSelectTag extends SimpleTagSupport 
{
   private String fieldName;
   private String idName;
   private int defValue;
  
@Override
public void doTag() throws JspException, IOException
{
	 StringBuilder sb=new StringBuilder();
	 if(null==fieldName)fieldName="channel_list";
	 if(null==idName)idName="channel_list_id";
	 sb.append("<select id=\""+idName+"\" name=\""+fieldName+"\" >");
	  sb.append("<option>请选择栏目</option>");
	 ChannelService  cs=(ChannelService)ProxyFacotry.getProxy(ChannelService.class);
	 List<Channel> parents=null;
	 try {
		parents=cs.getParentChannel();
	    if(null!=parents&&parents.size()>0)
	    {
	    	for(Channel pa:parents)
	    	{
	    	sb.append("<optgroup label=\""+pa.getName()+"\">");
	    	  List<Channel> subs=cs.getsubChannel(pa.getId());
	    	  if(null!=subs&&subs.size()>0)
	    	  {
	    		  for(Channel sub:subs)
	    		  {
	    			  sb.append("<option value=\""+sub.getId()+"\">"+sub.getName()+"</option>");
	    		  }
	    	  }
	    	sb.append("</optgroup>");
	    	}
	    }
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
	 sb.append("</select>");
	 
/*	 <select>
    <optgroup label="新闻">
      <option>国内新闻</option>
      <option>国际新闻</option>
    </optgroup>
     <optgroup label="图片">
      <option>明星</option>
      <option>体育</option>
    </optgroup>
 </select>*/
	 
	 this.getJspContext().getOut().println(sb.toString());
}
public String getFieldName() {
	return fieldName;
}
public void setFieldName(String fieldName) {
	this.fieldName = fieldName;
}
public String getIdName() {
	return idName;
}
public void setIdName(String idName) {
	this.idName = idName;
}
public int getDefValue() {
	return defValue;
}
public void setDefValue(int defValue) {
	this.defValue = defValue;
}
   
   
   
   
   
   
}
