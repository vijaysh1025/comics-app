package com.vijay.comics.retrofit

import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

/**
 * Adapts API calls and returns [Result]s.
 */
class ApiResultAdapter(
    private val type: Type
) : CallAdapter<Type, Call<Result<Type>>> {

    override fun responseType() = type
    override fun adapt(call: Call<Type>): Call<Result<Type>> = APIResultCall(call)

}