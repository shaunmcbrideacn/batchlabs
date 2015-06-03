package com.batchdemo.it;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.batchdemo.service.PeopleSoftServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/batch/jobs/erp-job.xml",
		"/job-runner-context.xml" })
public class ErpJobTest {

	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void test() throws Exception {
		JobExecution jobExecution = jobLauncherTestUtils.launchJob();
		Assert.assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
		Assert.assertEquals(3, PeopleSoftServiceImpl.getQuantityprocessed());
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		long updateCount = jdbcTemplate.queryForObject("select count(*) from orders where processed = 'Y'", Long.class); 
		Assert.assertEquals(4L, updateCount);
	}

}
