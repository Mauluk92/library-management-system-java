package it.mauluk92.lms.query.builder.impl;

import it.mauluk92.lms.query.builder.QueryBuilder;
import it.mauluk92.lms.query.builder.filter.FilterQueryBuilder;
import it.mauluk92.lms.query.builder.filter.OnGoingFilterQueryBuilder;
import it.mauluk92.lms.query.builder.group.GroupByQueryBuilder;
import it.mauluk92.lms.query.builder.instrunction.InstructionQueryBuilder;
import it.mauluk92.lms.query.builder.order.OrderByQueryBuilder;

public class StringQueryBuilder implements QueryBuilder, InstructionQueryBuilder, FilterQueryBuilder, OnGoingFilterQueryBuilder, OrderByQueryBuilder, GroupByQueryBuilder {

    private final StringBuilder query = new StringBuilder();
    private final static String AND_CONDITION = " AND ";
    private final static String OR_CONDITION = " OR ";
    private final static String WHERE_CONDITION = " WHERE ";
    private final static String ORDER_BY_CLAUSE = " ORDER BY ";
    private final static String GROUP_BY_CLAUSE = " GROUP BY ";


    @Override
    public InstructionQueryBuilder insertInstruction(String instruction) {
        query.append(instruction);
        return this;
    }

    @Override
    public OnGoingFilterQueryBuilder addAndCondition() {
        query.append(AND_CONDITION);
        return this;
    }

    @Override
    public OnGoingFilterQueryBuilder addOrCondition() {
        query.append(OR_CONDITION);
        return this;
    }

    @Override
    public OrderByQueryBuilder addOrderBy() {
        query.append(ORDER_BY_CLAUSE);
        return this;
    }

    @Override
    public GroupByQueryBuilder addGroupBy() {
        query.append(GROUP_BY_CLAUSE);
        return this;
    }

    @Override
    public FilterQueryBuilder addFilter(String whereCondition) {
        query.append(whereCondition);
        return this;
    }

    @Override
    public GroupByQueryBuilder addGroupBy(String groupBy) {
        query.append(groupBy);
        return this;
    }

    @Override
    public OnGoingFilterQueryBuilder addFilter() {
        this.query.append(WHERE_CONDITION);
        return this;
    }

    @Override
    public String build() {
        return this.query.toString();
    }

    @Override
    public OrderByQueryBuilder addOrderCondition(String orderByCondition) {
        query.append(orderByCondition);
        return this;
    }
}
