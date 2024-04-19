package com.vijay.comics.features.home.model

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
data class ComicsResponse(

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
data class ItemsItem(

	@Json(name="role")
	val role: String? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="resourceURI")
	val resourceURI: String? = null,

	@Json(name="type")
	val type: String? = null
)

@JsonClass(generateAdapter = true)
data class Characters(

	@Json(name="collectionURI")
	val collectionURI: String? = null,

	@Json(name="available")
	val available: Int? = null,

	@Json(name="returned")
	val returned: Int? = null,

	@Json(name="items")
	val items: List<Any?>? = null
)

@JsonClass(generateAdapter = true)
data class Creators(

	@Json(name="collectionURI")
	val collectionURI: String? = null,

	@Json(name="available")
	val available: Int? = null,

	@Json(name="returned")
	val returned: Int? = null,

	@Json(name="items")
	val items: List<ItemsItem?>? = null
)

@JsonClass(generateAdapter = true)
data class Events(

	@Json(name="collectionURI")
	val collectionURI: String? = null,

	@Json(name="available")
	val available: Int? = null,

	@Json(name="returned")
	val returned: Int? = null,

	@Json(name="items")
	val items: List<Any?>? = null
)

@JsonClass(generateAdapter = true)
data class DatesItem(

	@Json(name="date")
	val date: String? = null,

	@Json(name="type")
	val type: String? = null
)

@JsonClass(generateAdapter = true)
data class UrlsItem(

	@Json(name="type")
	val type: String? = null,

	@Json(name="url")
	val url: String? = null
)

@JsonClass(generateAdapter = true)
data class TextObjectsItem(

	@Json(name="language")
	val language: String? = null,

	@Json(name="text")
	val text: String? = null,

	@Json(name="type")
	val type: String? = null
)

@JsonClass(generateAdapter = true)
data class Series(

	@Json(name="name")
	val name: String? = null,

	@Json(name="resourceURI")
	val resourceURI: String? = null
)

@JsonClass(generateAdapter = true)
data class ResultsItem(

	@Json(name="creators")
	val creators: Creators? = null,

	@Json(name="issueNumber")
	val issueNumber: Int? = null,

	@Json(name="isbn")
	val isbn: String? = null,

	@Json(name="description")
	val description: String? = null,

	@Json(name="variants")
	val variants: List<VariantsItem?>? = null,

	@Json(name="title")
	val title: String? = null,

	@Json(name="diamondCode")
	val diamondCode: String? = null,

	@Json(name="characters")
	val characters: Characters? = null,

	@Json(name="urls")
	val urls: List<UrlsItem?>? = null,

	@Json(name="ean")
	val ean: String? = null,

	@Json(name="collections")
	val collections: List<Any?>? = null,

	@Json(name="modified")
	val modified: String? = null,

	@Json(name="id")
	val id: Int,

	@Json(name="prices")
	val prices: List<PricesItem?>? = null,

	@Json(name="events")
	val events: Events? = null,

	@Json(name="collectedIssues")
	val collectedIssues: List<Any?>? = null,

	@Json(name="pageCount")
	val pageCount: Int? = null,

	@Json(name="thumbnail")
	val thumbnail: Thumbnail? = null,

	@Json(name="images")
	val images: List<Any?>? = null,

	@Json(name="stories")
	val stories: Stories? = null,

	@Json(name="textObjects")
	val textObjects: List<Any?>? = null,

	@Json(name="digitalId")
	val digitalId: Int? = null,

	@Json(name="format")
	val format: String? = null,

	@Json(name="upc")
	val upc: String? = null,

	@Json(name="dates")
	val dates: List<DatesItem?>? = null,

	@Json(name="resourceURI")
	val resourceURI: String? = null,

	@Json(name="variantDescription")
	val variantDescription: String? = null,

	@Json(name="issn")
	val issn: String? = null,

	@Json(name="series")
	val series: Series? = null
)

@JsonClass(generateAdapter = true)
data class ImagesItem(

	@Json(name="path")
	val path: String? = null,

	@Json(name="extension")
	val extension: String? = null
)

@JsonClass(generateAdapter = true)
data class Data(

	@Json(name="total")
	val total: Int? = null,

	@Json(name="offset")
	val offset: Int? = null,

	@Json(name="limit")
	val limit: Int? = null,

	@Json(name="count")
	val count: Int? = null,

	@Json(name="results")
	val results: List<ResultsItem?>? = null
)

@JsonClass(generateAdapter = true)
data class Thumbnail(

	@Json(name="path")
	val path: String? = null,

	@Json(name="extension")
	val extension: String? = null,

	var url:String = ""
)

@JsonClass(generateAdapter = true)
data class PricesItem(

	@Json(name="price")
	val price: Float? = null,

	@Json(name="type")
	val type: String? = null
)

@JsonClass(generateAdapter = true)
data class Stories(

	@Json(name="collectionURI")
	val collectionURI: String? = null,

	@Json(name="available")
	val available: Int? = null,

	@Json(name="returned")
	val returned: Int? = null,

	@Json(name="items")
	val items: List<ItemsItem?>? = null
)
