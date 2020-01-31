package com.varenia.kenante_chat.core

import androidx.annotation.NonNull
import com.varenia.kenante_chat.enums.KenanteChatMessageAction

class KenanteChatMessage(
    val roomId: Int,
    val senderId: Int,
    val receiverId: Int,
    val message: String,
    val action: KenanteChatMessageAction,
    val mediaUrl: String
) {
    // In UTC
    var timestamp: String = ""
    var channel: String = ""
}