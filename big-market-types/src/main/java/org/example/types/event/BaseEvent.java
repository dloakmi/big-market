package org.example.types.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: 机智的赛尔
 * @Description： 基础事件
 * @DateTime： 2025/3/27 11:29
 **/

@Data
public abstract class BaseEvent<T> {

    public abstract EventMessage<T> buildEventMessage(T sku);

    public abstract String topic();

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class EventMessage<T> {
        private String id;
        private Date timestamp;
        private T data;
    }

}

