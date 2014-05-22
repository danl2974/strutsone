package com.dl2974.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
 
import com.dl2974.struts.MainForm;

public class MainAction extends Action {
	
	public ActionForward execute(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
	        throws Exception {
	 
			MainForm mForm = (MainForm) form;
			
			Mongo m = new Mongo();
			m.setCollection("dantest");
			Long collcount = m.getCount();
			
			mForm.setMessage("Dan... count: " + String.valueOf(collcount) );
	 
			return mapping.findForward("success");
		}

}
