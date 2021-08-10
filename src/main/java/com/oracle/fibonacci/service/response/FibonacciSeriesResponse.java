package com.oracle.fibonacci.service.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class FibonacciSeriesResponse {
    @JsonProperty
    private int memberCount;
    @JsonProperty
    private ArrayList<Integer> sequence;
    @JsonProperty
    private int total;

    public FibonacciSeriesResponse() {
    }

    public FibonacciSeriesResponse(int memberCount, ArrayList<Integer> sequence, int total) {
        this.memberCount = memberCount;
        this.sequence = sequence;
        this.total = total;
    }

}
