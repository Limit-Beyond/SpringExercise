package com.example.beaninject.processor;

import com.example.beaninject.Utils.BeanUtils;
import com.example.beaninject.bean.CalculateServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomizeBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        BeanUtils.printTrack("execute postProcessBeanDefinitionRegistry");
        BeanDefinitionBuilder calculateserviceimpl = BeanDefinitionBuilder.genericBeanDefinition(
                CalculateServiceImpl.class);
        calculateserviceimpl.setAutowireMode(AutowireCapableBeanFactory.AUTOWIRE_BY_NAME);
        beanDefinitionRegistry.registerBeanDefinition("calculateService", calculateserviceimpl.getBeanDefinition());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanUtils.printTrack("execute postProcessBeanFactory");
    }
}
