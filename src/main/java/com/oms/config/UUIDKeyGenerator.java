package com.oms.config;

import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import org.springframework.stereotype.Component;

@Component
public class UUIDKeyGenerator implements IKeyGenerator {
    @Override
    public String executeSql(String incrementerName) {
        return "select uuid()";
    }
}
