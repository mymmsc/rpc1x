/**
 * Copyright (C) 2017 Newland Group Holding Limited
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.newlandframework.rpc.event;

import org.hotwheel.rpc1x.event.AbstractInvokeEventBus;

import javax.management.AttributeChangeNotification;
import javax.management.Notification;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author tangjie<https://github.com/tang-jie>
 * @filename:InvokeEvent.java
 * @description:InvokeEvent功能模块
 * @blogs http://www.cnblogs.com/jietang/
 * @since 2017/10/12
 */
public class InvokeEvent extends AbstractInvokeEventBus {
    private AtomicLong sequenceInvokeNumber = new AtomicLong(0L);

    public InvokeEvent() {
        super();
    }

    public InvokeEvent(String moduleName, String methodName) {
        super(moduleName, methodName);
    }

    @Override
    public Notification buildNotification(Object oldValue, Object newValue) {
        return new AttributeChangeNotification(this, sequenceInvokeNumber.incrementAndGet(), System.currentTimeMillis(),
                super.moduleName, super.methodName, ModuleEvent.INVOKE_EVENT.toString(), oldValue, newValue);
    }
}

