package com.junkfoood.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pagination {
    private int page;
    private int pageSize;
    private int totalPage;
    private long totalItem;
}
