package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * @author derekyi
 * @date 2020/11/22
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

	/**
	 * 实现BeanFactory接口的getBean方法
	 * @param name
	 * @return
	 * @throws BeansException
	 */
	@Override
	public Object getBean(String name) throws BeansException {
		// 继承DefaultSingletonBeanRegistry的getSingleton方法
		// 直接去拿singleton，有则就直接返回
		Object bean = getSingleton(name);
		if (bean != null) {
			return bean;
		}
		// 拿beanDefinition
		BeanDefinition beanDefinition = getBeanDefinition(name);
		// 根据beanDefinition创建具体的bean
		return createBean(name, beanDefinition);
	}

	protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

	protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
