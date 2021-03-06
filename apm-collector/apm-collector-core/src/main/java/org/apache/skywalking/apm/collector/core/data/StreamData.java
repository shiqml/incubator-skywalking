/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.apache.skywalking.apm.collector.core.data;

import org.apache.skywalking.apm.collector.core.data.column.*;
import org.apache.skywalking.apm.collector.core.queue.EndOfBatchContext;

/**
 * @author peng-yongsheng
 */
public abstract class StreamData extends AbstractData implements QueueData {

    private EndOfBatchContext endOfBatchContext;

    @Override public final EndOfBatchContext getEndOfBatchContext() {
        return this.endOfBatchContext;
    }

    @Override public final void setEndOfBatchContext(EndOfBatchContext context) {
        this.endOfBatchContext = context;
    }

    public StreamData(StringColumn[] stringColumns, LongColumn[] longColumns,
        IntegerColumn[] integerColumns,
        DoubleColumn[] doubleColumns, StringListColumn[] stringListColumns,
        LongListColumn[] longListColumns,
        IntegerListColumn[] integerListColumns, DoubleListColumn[] doubleListColumns) {
        super(stringColumns, longColumns, integerColumns, doubleColumns, new ByteColumn[0], stringListColumns, longListColumns, integerListColumns, doubleListColumns);
    }

    public StreamData(StringColumn[] stringColumns, LongColumn[] longColumns,
        IntegerColumn[] integerColumns, DoubleColumn[] doubleColumns) {
        super(stringColumns, longColumns, integerColumns, doubleColumns, new ByteColumn[0], new StringListColumn[0], new LongListColumn[0], new IntegerListColumn[0], new DoubleListColumn[0]);
    }

    public StreamData(StringColumn[] stringColumns, LongColumn[] longColumns,
        IntegerColumn[] integerColumns, DoubleColumn[] doubleColumns,
        ByteColumn[] byteColumns) {
        super(stringColumns, longColumns, integerColumns, doubleColumns, byteColumns, new StringListColumn[0], new LongListColumn[0], new IntegerListColumn[0], new DoubleListColumn[0]);
    }

    @Override public final String selectKey() {
        return getMetricId();
    }

    public abstract String getId();

    public abstract void setId(String id);

    public abstract String getMetricId();

    public abstract void setMetricId(String metricId);
}
