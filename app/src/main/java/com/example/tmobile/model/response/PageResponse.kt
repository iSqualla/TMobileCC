package com.example.tmobile.model.response

import com.squareup.moshi.Json

data class PageResponse(

	@Json(name="page")
	val page: Page? = null
)

data class CardsItem(

	@Json(name="card_type")
	val cardType: String? = null,

	@Json(name="card")
	val card: Card? = null
)

data class Font(

	@Json(name="size")
	val size: Int? = null
)

data class Description(

	@Json(name="attributes")
	val attributes: Attributes? = null,

	@Json(name="value")
	val value: String? = null
)

data class Size(

	@Json(name="width")
	val width: Int? = null,

	@Json(name="height")
	val height: Int? = null
)

data class Image(

	@Json(name="size")
	val size: Size? = null,

	@Json(name="url")
	val url: String? = null
)

data class Page(

	@Json(name="cards")
	val cards: List<CardsItem?>? = null
)

data class Card(

	@Json(name="description")
	val description: Description? = null,

	@Json(name="title")
	val title: Title? = null,

	@Json(name="image")
	val image: Image? = null,

	@Json(name="attributes")
	val attributes: Attributes? = null,

	@Json(name="value")
	val value: String? = null
)

data class Attributes(

	@Json(name="text_color")
	val textColor: String? = null,

	@Json(name="font")
	val font: Font? = null
)

data class Title(

	@Json(name="attributes")
	val attributes: Attributes? = null,

	@Json(name="value")
	val value: String? = null
)
