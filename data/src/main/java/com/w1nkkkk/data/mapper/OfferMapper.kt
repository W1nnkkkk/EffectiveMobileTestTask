package com.w1nkkkk.data.mapper

import com.w1nkkkk.data.entity.OfferDtoModel
import com.w1nkkkk.domain.Offer
import com.w1nkkkk.domain.OfferIconType

class OfferMapper {
    fun map(offerDtoModel: OfferDtoModel) : Offer {
        return Offer(
            id = if(offerDtoModel.id != null) OfferIconType.valueOf(offerDtoModel.id).icon else null,
            title = offerDtoModel.title,
            link = offerDtoModel.link,
            buttonText = offerDtoModel.button?.get("text").toString()
        )
    }
}