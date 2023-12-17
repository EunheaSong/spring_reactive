package com.example.reactive.post.infrastructure

import com.example.reactive.common.NotFoundResourceException
import com.example.reactive.post.application.AudioReadPort
import com.example.reactive.post.application.AudioUpdatePort
import com.example.reactive.post.application.dto.AudioFileInfo
import com.example.reactive.post.domain.AudioBook
import com.example.reactive.post.infrastructure.mapper.AudioFileMapper
import com.example.reactive.post.infrastructure.mapper.AudioMapper
import com.example.reactive.post.infrastructure.repository.AudioBookRepository
import com.example.reactive.post.infrastructure.repository.AudioFileRepository
import com.example.reactive.post.infrastructure.repository.BookRepository
import com.example.reactive.post.web.dto.AuctionSaveInfo
import com.example.reactive.post.web.dto.AudioBookDetailInfo
import com.example.reactive.post.web.dto.AudioBookInfo
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile

@Component
class AudioPersistenceAdapter(
    private val audioMapper: AudioMapper,
    private val audioBookRepository: AudioBookRepository,
    private val audioFileRepository: AudioFileRepository,
    private val bookPersistenceAdapter: BookPersistenceAdapter,
    private val audioFileMapper: AudioFileMapper
): AudioReadPort, AudioUpdatePort {

    override fun getAudioInfoById(id: String): AudioBookInfo {
        val audioBook = audioBookRepository.findByIdAndIsDeletedFalse(id)
            ?: throw NotFoundResourceException("id 와 일치하는 오디오북이 없습니다.")
        return AudioBookInfo(
            audioMapper.mapToAudioBookDetailInfo(audioBook),
            audioFileRepository.findAllByAudioBook(audioBook)
        )
    }

    override fun saveAudioBookAndFile(audioInfo: AuctionSaveInfo, audioFileInfo: AudioFileInfo) {
        val audioBook = saveAudioBook(audioInfo)
        saveAudioFile(audioFileInfo, audioBook)
    }

    fun saveAudioBook(audioInfo: AuctionSaveInfo): AudioBook {
        return audioBookRepository.save(
            audioMapper.mapToEntity(
                audioInfo,
                bookPersistenceAdapter.getBookById(audioInfo.bookId)
            )
        )
    }

    fun saveAudioFile(audioFileInfo: AudioFileInfo, audioBook: AudioBook) {
        audioFileRepository.save(
            audioFileMapper.mapToEntity(audioFileInfo, audioBook)
        )
    }

}