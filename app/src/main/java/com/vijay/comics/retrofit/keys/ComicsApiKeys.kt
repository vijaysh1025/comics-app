package com.vijay.comics.retrofit.keys

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
data class ComicsApiKeys(

	@Json(name="apiPublicKey")
	val apiPublicKey: String,

	@Json(name="apiPrivateKey")
	val apiPrivateKey: String
)
