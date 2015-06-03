package com.batchdemo.it;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/batch/jobs/new-customers.xml",
		"/job-runner-context.xml" })
public class NewCustomersJobTest {

	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;

	@Test
	public void test() throws Exception {
		JobExecution jobExecution = jobLauncherTestUtils.launchJob();
		Assert.assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
		Assert.assertEquals(4, jobExecution.getStepExecutions().size());
		int skipCount = 0;
		for (StepExecution stepExecution : jobExecution.getStepExecutions()) {
			skipCount += stepExecution.getSkipCount();
		}
		Assert.assertEquals(1, skipCount);
	}
}
