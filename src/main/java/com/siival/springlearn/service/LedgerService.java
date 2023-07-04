package com.siival.springlearn.service;
/**
 * @time 2023年6月14日15:15:32
 * @author mark acrossxwall@gmail.com
 * @className LedgerService
 */
import java.util.List;

import org.springframework.web.service.annotation.GetExchange;

import com.siival.springlearn.res.BaseResp;
import com.siival.springlearn.res.CategoryInfo;

public interface LedgerService {

	@GetExchange("/category/info")
	BaseResp<List<CategoryInfo>> getAllCategoryInfo();
}
