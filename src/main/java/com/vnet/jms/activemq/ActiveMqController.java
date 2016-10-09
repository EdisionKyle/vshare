package com.vnet.jms.activemq;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/mq")
public class ActiveMqController {

	// private static final Log log =
	// LogFactory.getLog(ActiveMqController.class);

/*	@Resource
	private SenderMq senderMq;
	@Resource
	private Destination mqServer;

	@RequestMapping(value = "/sendMsg", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> sendMsg() {
		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < 2; i++) {
			try {
				System.out.println(new Date() + " --客户端发送消息中..." + (i + 1));
				senderMq.sendTextMessage(mqServer, new Date()
						+ " --dnf尊敬的勇士，非常抱歉，您的网络出现异常，请重新登陆！" + (i + 1));
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
		map.put("message", "操作成功");
		return map;
	}
*/
}
