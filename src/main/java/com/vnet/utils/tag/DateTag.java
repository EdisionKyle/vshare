package com.vnet.utils.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class DateTag implements Tag {
	private PageContext pageContext;
	private Tag tag;

	/**
	 * 标签初始化功能。
	 */
	public int doEndTag() throws JspException {
		try {
			// 定义日期。
			Date date = new Date();
			// 日期格式
			SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy年MM月dd日");
			pageContext.getOut().print(dateFormater.format(date));

		} catch (IOException e) {
			e.printStackTrace();
		}

		return Tag.EVAL_PAGE;
	}

	/**
	 * 标签开始
	 */
	public int doStartTag() throws JspException {
		return Tag.SKIP_BODY;
	}

	public Tag getParent() {

		return null;
	}

	public void release() {

	}

	public void setPageContext(PageContext arg0) {
		this.pageContext = arg0;

	}

	public void setParent(Tag arg0) {
		this.setTag(arg0);
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

}
