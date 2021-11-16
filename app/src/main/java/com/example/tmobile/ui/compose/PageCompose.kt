package com.example.tmobile.ui.compose

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.tmobile.R
import com.example.tmobile.model.response.*

private const val TAG = "Compose"


/*******
 *JetPack Compose TODOS:
 * Link it to Main Activity
 *
 * Display Hierarchy
 * Dynamic Value Population
 ******/

class PageCompose {

    @ExperimentalUnitApi
    @Composable
    fun ListCards(cardState: List<CardsItem>) {
        LazyColumn(
            state = rememberLazyListState(),
            modifier = Modifier.padding(4.dp)
        ) {

            items(
                count = cardState.size
            ) { index ->
                when (cardState[index].cardType) {
                    CardTypes.TEXT.value -> {
                        ViewCardTitle(
                            cardTitle = cardState[index].card?.value!!,
                            cardAttribute = cardState[index].card?.attributes!!
                        )
                    }
                    CardTypes.TITLE_DESCRIPTION.value -> {
                        ViewCardTitleDescription(
                            cardTitle = cardState[index].card?.title!!,
                            cardDescription = cardState[index].card?.description!!
                        )
                    }
                    CardTypes.IMAGE_TITLE.value -> {
                        Log.d(TAG, "ListCards: ${cardState[index].card}")
                        CardTitleDescriptionImage(
                            cardImage = cardState[index].card?.image!!,
                            cardTitle = cardState[index].card?.title!!,
                            cardDescription = cardState[index].card?.description!!
                        )
                    }
                }
            }
        }
    }

    @ExperimentalUnitApi
    @Composable
    fun ViewCardTitle(cardTitle: String, cardAttribute: Attributes) {
        val color: Int = android.graphics.Color.parseColor(cardAttribute.textColor)
        Card(
            shape = RoundedCornerShape(8.dp),
            elevation = 15.dp
        ) {
            Text(
                text = cardTitle,
                color = Color(color),
                fontSize = cardAttribute.font?.size?.sp ?: 12.sp
            )
        }
    }

    @Composable
    fun ViewCardTitleDescription(cardTitle: Title, cardDescription: Description) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = cardTitle.value!!,
                color = Color(android.graphics.Color.parseColor(cardTitle.attributes?.textColor)),
                fontSize = cardTitle.attributes?.font?.size?.sp ?: 12.sp,
            )
            Text(
                text = cardDescription.value!!,
                color = Color(android.graphics.Color.parseColor(cardDescription.attributes?.textColor)),
                fontSize = cardDescription.attributes?.font?.size?.sp ?: 12.sp
            )
        }
    }

    @Composable
    fun CardTitleDescriptionImage(
        cardImage: Image,
        cardTitle: Title,
        cardDescription: Description
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            elevation = 15.dp
        ) {

            Image(
                painter = rememberImagePainter(data = cardImage.url,
                    builder = {
                        crossfade(true)
                    }),
                contentDescription = stringResource(id = R.string.image_description),
                Modifier.size(cardImage.size?.width!!.dp)//, height = cardImage.size.height.dp)
            )
            ViewCardTitleDescription(cardTitle = cardTitle, cardDescription = cardDescription)
        }
    }
}