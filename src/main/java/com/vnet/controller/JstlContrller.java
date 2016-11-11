package com.vnet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JstlContrller {

	@RequestMapping(value = "/baseEl")
	public String toBaseEl() {
		return "el/baseEl";
	}

	@RequestMapping(value = "/coreEl")
	public String toCoreEl() {
		return "el/coreEl";
	}

	@RequestMapping(value = "/fmtEl")
	public String toFmtEl() {
		return "el/fmtEl";
	}

	@RequestMapping(value = "/fnEl")
	public String toFnEl() {
		return "el/fnEl";
	}

	@RequestMapping(value = "/mytag")
	public String toMytag() {
		return "el/mytag";
	}

	@RequestMapping(value = "/sqlEl")
	public String toSqlEl() {
		return "el/sqlEl";
	}

	@RequestMapping(value = "/xmlEl")
	public String toXmlEl() {
		return "el/xmlEl";
	}

}
