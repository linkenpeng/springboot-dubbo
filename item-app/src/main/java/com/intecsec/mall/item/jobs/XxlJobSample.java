package com.intecsec.mall.item.jobs;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * @author Peter.Peng
 * @date 2020/10/14
 */
@Component
public class XxlJobSample {

	private static Logger logger = LoggerFactory.getLogger(XxlJobSample.class);


	/**
	 * 1、简单任务示例（Bean模式）
	 */
	@XxlJob(value = "demoJobHandler3", cron = "0 0/6 * ? * *", author = "leifeng")
	public ReturnT<String> demoJobHandler3(String param) throws Exception {
		XxlJobLogger.log("XXL-JOB, Hello World.");
		logger.info("XXL-JOB, Hello World.");
		System.out.println("XXL-JOB, Hello World.");
		return ReturnT.SUCCESS;
	}
}
