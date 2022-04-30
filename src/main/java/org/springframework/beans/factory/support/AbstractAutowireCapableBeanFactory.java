package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * @author derekyi
 * @date 2020/11/22
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

	/**
	 * 覆写AbstractBeanFactory抽象类的createBean方法
	 * @param beanName
	 * @param beanDefinition
	 * @return
	 * @throws BeansException
	 */
	@Override
	protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
		return doCreateBean(beanName, beanDefinition);
	}

	protected Object doCreateBean(String beanName, BeanDefinition beanDefinition) {
		// 根据beanDefinition创建具体的bean
		Class beanClass = beanDefinition.getBeanClass();
		Object bean = null;
		try {
			bean = beanClass.newInstance();
		} catch (Exception e) {
			throw new BeansException("Instantiation of bean failed", e);
		}
		// 将bean加入到singleton中
		addSingleton(beanName, bean);
		// 返回bean
		return bean;
	}
}
