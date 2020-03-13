package com.zufe.oams.service;

import java.util.List;
import java.util.Map;

public interface StudentSearchService {
    List<Map<String, Object>> getSearchPapers(String keyword);
}
