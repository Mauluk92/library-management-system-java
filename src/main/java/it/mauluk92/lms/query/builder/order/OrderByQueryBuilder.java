package it.mauluk92.lms.query.builder.order;

public interface OrderByQueryBuilder {

    OrderByQueryBuilder addOrderCondition(String orderByCondition);
    String build();
}
