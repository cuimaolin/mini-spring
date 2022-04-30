package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @author derekyi
 * @date 2020/11/22
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

	private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

	/**
	 * 实现BeanDefinitionRegistry接口，
	 * 建立beanName与对应beanDefinition的映射
	 * @param beanName
	 * @param beanDefinition
	 */
	@Override
	public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
		beanDefinitionMap.put(beanName, beanDefinition);
	}

	/**
	 * 复写AbstractAutowireCapableBeanFactory抽象类的getBeanDefinition方法
	 * @param beanName
	 * @return
	 * @throws BeansException
	 */
	@Override
	protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
		BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
		if (beanDefinition == null) {
			throw new BeansException("No bean named '" + beanName + "' is defined");
		}

		return beanDefinition;
	}
}
