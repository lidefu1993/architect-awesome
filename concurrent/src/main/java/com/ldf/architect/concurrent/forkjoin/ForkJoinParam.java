package com.ldf.architect.concurrent.forkjoin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ldf
 * @date 2020/12/6 14:14
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForkJoinParam {
    private int threshold = 2;
    private MockListDataService mockListDataService;

}
