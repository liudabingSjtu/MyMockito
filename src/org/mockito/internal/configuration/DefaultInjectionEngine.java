/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.internal.configuration;

import org.mockito.internal.configuration.injection.MockInjection;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * Inject mock/spies dependencies for fields annotated with &#064;InjectMocks
 *
 * 为注解为InjectMocks的对象注入mock和spy依赖
 * <p/>
 * See {@link org.mockito.MockitoAnnotations}
 */
public class DefaultInjectionEngine {

    public void injectMocksOnFields(Set<Field> needingInjection, Set<Object> mocks, Object testClassInstance) {
        MockInjection.onFields(needingInjection, testClassInstance)//初始化对象和需要Inject的List
                .withMocks(mocks)//把MOCK对象也注入List中
                .tryConstructorInjection()
                .tryPropertyOrFieldInjection()
                .handleSpyAnnotation()
                .apply();
    }

}
