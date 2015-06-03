/**
 * 
 */
package org.springframework.batch.admin.sample;

import org.springframework.batch.item.ItemProcessor;

/**
 * @author shaun.mcbride
 *
 */
public class ExampleItemProcessor implements ItemProcessor<String, String> {

	public String process(String item) throws Exception {
		// TODO Auto-generated method stub
		return item.toUpperCase();
	}

	
}
