/*
 * Copyright 2012-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.bootstrap;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A marker interface used as a key in <code>META-INF/spring.factories</code>. Entries in
 * the factories file are used to create the bootstrap application context.
 *
 * @author Dave Syer
 *
 */

//会通过下面的代码加载到spring bootstrap容器里面:
/**
 * public String[] selectImports(AnnotationMetadata annotationMetadata) {
 * 		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
 * 		// Use names and ensure unique to protect against duplicates
 * 		List<String> names = new ArrayList<>(SpringFactoriesLoader
 * 				.loadFactoryNames(BootstrapConfiguration.class, classLoader));
  */

/**
 * 比如eureka-client.jar中的spring.factories中如下配置：
 * org.springframework.cloud.bootstrap.BootstrapConfiguration=\
 * org.springframework.cloud.netflix.eureka.config.EurekaDiscoveryClientConfigServiceBootstrapConfiguration
 * 这样就可以把EurekaDiscoveryClientConfigServiceBootstrapConfiguration组件加载到bootstrap容器，模拟的是 @EnableDiscoveryClient
 * 区别就是EurekaDiscoveryClientConfigServiceBootstrapConfiguration 引入的相关组件会被注册到bootstrap容器中
 * @EnableDiscoveryClient引入的相关组件会被注册到 应用上下文(主上下文)中
 * 不过bootstrap容器是 主容器的父容器， 所以这两种方式没什么差别，都可以
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BootstrapConfiguration {

	/**
	 * Excludes specific auto-configuration classes such that they will never be applied.
	 * @return classes to exclude
	 */
	Class<?>[] exclude() default {};

}
