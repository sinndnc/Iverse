package com.iverse.core

import com.iverse.core.domain.model.Message
import com.iverse.core.domain.model.fake.fakeMessageList
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.Assert.*


@RunWith(JUnit4::class)
class ChatRoomMessagesTest {

    private lateinit var list: List<Message>

    @Before
    fun init() {
        list = fakeMessageList
    }

    @Test
    fun `check next id and current id is equal`() {
        repeat(list.size) { index ->
            val nextIndex = list.checkNextIndex(index)
            val isEqual = list.isEqualToSenderId(index, nextIndex)
            assert(list[nextIndex].senderId != null)
        }
    }


    /**
     * @return if has next index of List<[Message]> otherwise return last index
     */
    fun List<Message>.checkNextIndex(currentIndex: Int): Int {
        return when (currentIndex) {
            this.size - 1 -> this.size - 1
            else -> currentIndex + 1
        }
    }

    fun List<Message>.isEqualToSenderId(currentIndex: Int, nextIndex: Int): Boolean {
        if (currentIndex == nextIndex) {
            return false
        }
        return this[currentIndex].senderId == this[nextIndex].senderId
    }
}