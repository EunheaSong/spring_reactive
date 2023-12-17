package com.example.reactive.post.infrastructure.mapper

import com.example.reactive.post.domain.AudioBook
import com.example.reactive.post.domain.Book
import com.example.reactive.post.infrastructure.AudioFilePathOnly
import com.example.reactive.post.web.dto.AuctionSaveInfo
import com.example.reactive.post.web.dto.AudioBookDetailInfo
import org.springframework.stereotype.Component

@Component
class AudioMapper {
    fun mapToAudioBookDetailInfo(
        audioBook: AudioBook,
//        audioFilePath: List<AudioFilePathOnly>
    ): AudioBookDetailInfo {
        return AudioBookDetailInfo(
            id = audioBook.id,
            createDateTime = audioBook.createDateTime,
            updateDateTime = audioBook.updateDateTime,
            registrantId = audioBook.registrantId,
            title = audioBook.title,
            contents = audioBook.contents,
//            audioFilePath = audioFilePath
        )
    }

    fun mapToEntity(audioInfo: AuctionSaveInfo, book: Book): AudioBook{
        return AudioBook(
            book = book,
            registrantId = audioInfo.registrantId,
            title = audioInfo.title,
            contents = audioInfo.contents
        )
    }

}