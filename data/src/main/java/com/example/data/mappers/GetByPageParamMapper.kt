package com.example.data.mappers

import com.example.data.models.GetByPageParam
import com.example.data.utils.dataGetParam
import com.example.data.utils.domainGetParam

internal object GetByPageParamMapper{
    fun mapToData(type: domainGetParam): dataGetParam {
        return dataGetParam(
            limit = type.limit,
            page = type.page
        )
    }
}