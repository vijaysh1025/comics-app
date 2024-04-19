package com.vijay.comics.features.home.model

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
data class ComicInfoResponse(

	@Json(name="copyright")
	val copyright: String? = null,

	@Json(name="code")
	val code: Int? = null,

	@Json(name="data")
	val data: Data? = null,

	@Json(name="attributionHTML")
	val attributionHTML: String? = null,

	@Json(name="attributionText")
	val attributionText: String? = null,

	@Json(name="etag")
	val etag: String? = null,

	@Json(name="status")
	val status: String? = null
)

@JsonClass(generateAdapter = true)
data class VariantsItem(

	@Json(name="name")
	val name: String? = null,

	@Json(name="resourceURI")
	val resourceURI: String? = null
)


