/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License
 * 2.0; you may not use this file except in compliance with the Elastic License
 * 2.0.
 */
package org.elasticsearch.xpack.sql.expression.function.scalar.datetime;

import org.elasticsearch.xpack.ql.expression.Expression;
import org.elasticsearch.xpack.ql.tree.NodeInfo.NodeCtor2;
import org.elasticsearch.xpack.ql.tree.Source;
import org.elasticsearch.xpack.sql.expression.function.scalar.datetime.DateTimeProcessor.DateTimeExtractor;

import java.time.ZoneId;

/**
 * Extract the day of the week (following the ISO standard) from a datetime. 1 is Monday, 2 is Tuesday, etc.
 */
public class IsoDayOfWeek extends DateTimeFunction {
    public IsoDayOfWeek(Source source, Expression field, ZoneId zoneId) {
        super(source, field, zoneId, DateTimeExtractor.ISO_DAY_OF_WEEK);
    }

    @Override
    protected NodeCtor2<Expression, ZoneId, BaseDateTimeFunction> ctorForInfo() {
        return IsoDayOfWeek::new;
    }

    @Override
    protected IsoDayOfWeek replaceChild(Expression newChild) {
        return new IsoDayOfWeek(source(), newChild, zoneId());
    }

}
