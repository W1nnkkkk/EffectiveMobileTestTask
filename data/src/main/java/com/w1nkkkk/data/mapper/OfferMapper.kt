package com.w1nkkkk.data.mapper

import com.w1nkkkk.data.entity.OfferDtoModel
import com.w1nkkkk.domain.Offer

class OfferMapper {
    fun map(offerDtoModel: OfferDtoModel) : Offer {
        return Offer(
            id = offerDtoModel.id,
            title = offerDtoModel.title,
            link = offerDtoModel.link,
            buttonText = offerDtoModel.button?.text
        )
    }
}