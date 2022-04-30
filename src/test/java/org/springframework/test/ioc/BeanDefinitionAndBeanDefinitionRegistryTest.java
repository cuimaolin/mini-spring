package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author derekyi
 * @date 2020/11/24
 */
public class BeanDefinitionAndBeanDefinitionRegistryTest {

	@Test
	public void testBeanFactory() throws Exception {
		// new一个bean工厂
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		// 定义一个bean，并用HelloService.class进行初始化
		// 实际上BeanDefinition并不存储实例化的类，只存储类的相关信息
		BeanDefinition beanDefinition = new BeanDefinition(HelloService.class);
		// 对beanDefinition注册对应的beanName
		beanFactory.registerBeanDefinition("helloService", beanDefinition);

		// 根据beanName去拿真正的bean实例
		HelloService helloService = (HelloService) beanFactory.getBean("helloService");
		helloService.sayHello();
	}
}
