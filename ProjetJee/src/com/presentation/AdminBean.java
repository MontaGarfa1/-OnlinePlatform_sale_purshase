package com.presentation;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import com.util.Test;

@ManagedBean(name = "adminBean")
@SessionScoped
public class AdminBean {
	public static Logger log = Logger.getLogger(AdminBean.class);

	
	@PostConstruct
	public void initBean() {
	}
	
	public String connecter() {
		log.info("Admin Connected");
		
		return "admin";
	}

}
