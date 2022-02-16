package com.example.leaf.biz;


import com.example.leaf.common.Result;

public interface IDGen {
    Result get(String key);
    boolean init();
}